package view;

import model.CarTableModel;

import javax.swing.*;
import java.awt.*;

public class CarsPanel extends JPanel
{
    private CarTableModel model;
    private JTable table;
    private JLabel numLabel;
    private JLabel modelLabel;
    private JLabel brandLabel;
    private JLabel priceLabel;
    private JTextField numField;
    private JTextField modelField;
    private JTextField brandField;
    private JTextField priceField;
    private JButton addButton;
    private JButton resetButton;
    private JButton exportButton;
    private JButton deleteButton;
    private JButton updateButton;

    public CarsPanel()
    {
        this.setLayout(new BorderLayout());
        this.model = new CarTableModel();
        this.table = new JTable(model);
        
        //font and color
        Font f = new Font("Times New Roman", Font.PLAIN, 15);
        Color c = new Color (193, 73, 13);
        Font ff = new Font("Calibri", Font.PLAIN, 25);
        Color cc = new Color(66, 134, 244);
        Color white = Color.white;

        this.numLabel = new JLabel("R.NUMBER: ");
        this.numLabel.setFont(f);
        this.numLabel.setForeground(c);

        this.modelLabel = new JLabel("Model: ");
        this.modelLabel.setFont(f);
        this.modelLabel.setForeground(c);

        this.brandLabel = new JLabel("Brand: ");
        this.brandLabel.setFont(f);
        this.brandLabel.setForeground(c);

        this.priceLabel = new JLabel("Price: ");
        this.priceLabel.setFont(f);
        this.priceLabel.setForeground(c);


        this.numField = new JTextField(8);
        this.modelField = new JTextField(12);
        this.brandField = new JTextField(12);
        this.priceField = new JTextField(8);

        this.addButton = new JButton("Add");
        this.addButton.setFont(f);
        this.addButton.setForeground(cc);
        this.addButton.setBackground(white);

        this.resetButton = new JButton("Reset");
        this.resetButton.setFont(f);
        this.resetButton.setForeground(cc);
        this.resetButton.setBackground(white);

        this.exportButton = new JButton("Export");
        this.exportButton.setFont(f);
        this.exportButton.setForeground(cc);
        this.exportButton.setBackground(white);

        this.deleteButton = new JButton("Delete");
        this.deleteButton.setFont(f);
        this.deleteButton.setForeground(cc);
        this.deleteButton.setBackground(white);

        this.updateButton = new JButton("Update");
        this.updateButton.setFont(f);
        this.updateButton.setForeground(cc);
        this.updateButton.setBackground(white);

        //button icons
        ImageIcon addI = new ImageIcon("src/images/add.PNG");
        this.addButton.setIcon(addI);
        ImageIcon deleteI = new ImageIcon("src/images/delete.PNG");
        this.deleteButton.setIcon(deleteI);
        ImageIcon resetI = new ImageIcon("src/images/reset.PNG");
        this.resetButton.setIcon(resetI);
        ImageIcon updateI = new ImageIcon("src/images/update.PNG");
        this.updateButton.setIcon(updateI);
        ImageIcon exportI = new ImageIcon("src/images/export.PNG");
        this.exportButton.setIcon(exportI);

        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());

        topPanel.add(numLabel);
        topPanel.add(numField);
        topPanel.add(modelLabel);
        topPanel.add(modelField);
        topPanel.add(brandLabel);
        topPanel.add(brandField);
        topPanel.add(priceLabel);
        topPanel.add(priceField);
        topPanel.add(addButton);
        topPanel.add(resetButton);

        bottomPanel.add(exportButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);


        //add borders to panels
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(cc),"Browse cars list"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(cc);
        this.setBackground(Color.BLACK);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

    }

    public JTable getTable()
    {
        return table;
    }

    public JLabel getNumLabel()
    {
        return numLabel;
    }

    public JLabel getModelLabel()
    {
        return modelLabel;
    }

    public JLabel getBrandLabel()
    {
        return brandLabel;
    }

    public JLabel getPriceLabel()
    {
        return priceLabel;
    }

    public JTextField getNumField()
    {
        return numField;
    }

    public JTextField getModelField()
    {
        return modelField;
    }

    public JTextField getBrandField()
    {
        return brandField;
    }

    public JTextField getPriceField()
    {
        return priceField;
    }

    public JButton getAddButton()
    {
        return addButton;
    }

    public JButton getResetButton()
    {
        return resetButton;
    }

    public JButton getExportButton()
    {
        return exportButton;
    }

    public JButton getDeleteButton()
    {
        return deleteButton;
    }

    public JButton getUpdateButton()
    {
        return updateButton;
    }

    public CarTableModel getModel()
    {
        return model;
    }

    public void setModel(CarTableModel model)
    {
        this.model = model;
    }
}
