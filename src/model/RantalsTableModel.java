package model;


import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class RantalsTableModel extends AbstractTableModel
{
	
    public String[] getTitles()
    {
        return titles;
    }

    public Vector<String[]> getData()
    {
        return data;
    }

    private String[] titles = {"Rent Num", "Car's Num", "Client CIN", "Is returned", "Rental Date", "Return Date"};
    private Vector<String[]> data ;

    public RantalsTableModel()
    {
        initData();
    }

    public void loadData(List<RentACar> rentals)
    {
        this.data = new Vector<String[]>();
        for(RentACar c: rentals)
        {
            String returned;
            if(c.isReturned()) returned = "YES";
            else                returned = "NO";
            String[] str = {String.valueOf(c.getRentIdentifier()), c.getCar().getRegistrationNumber(), c.getClient().getClientNumb(), returned, c.getRentalDate().toString(), c.getReturnDate().toString()};
            data.add (str);
        }
        fireTableChanged(null);
    }

    public void initData()
    {
        this.loadData(DAOFactory.getRantingDAO().all());
    }

    public int getRowCount()
    {
        return this.data.size();
    }

    public int getColumnCount()
    {
        return this.titles.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return this.data.get(rowIndex)[columnIndex];
    }

    public String getColumnName(int col)
    {
        return this.titles[col];
    }

    public void removeRow(int i)
    {
        this.data.remove(i);
        fireTableChanged(null);
    }

    public void setRow(int i, String[] str)
    {
        this.data.set(i, str);
        fireTableChanged(null);
    }

    public void addRow(String[] str)
    {
        this.data.add(str);
        fireTableChanged(null);
    }
}
