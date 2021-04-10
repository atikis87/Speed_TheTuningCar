package view;

import model.RantalsTableModel;
import javafx.beans.Observable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

public class RentalsPanel extends JPanel implements Observer
{

    public RantalsTableModel getModel()
    {
        return model;
    }

    private RantalsTableModel model;
    private JTable table;
    private JButton exportButton;

    public JButton getDeleteButton()
    {
        return deleteButton;
    }

    public JButton getUpdateButton()
    {
        return updateButton;
    }

    private JButton deleteButton;
    private JButton updateButton;

    public RentalsPanel()
    {
        
        this.setLayout(new BorderLayout());
        this.model = new RantalsTableModel();
        this.table = new JTable(model);
        //font and color
        Font f = new Font("Times New Roman", Font.PLAIN, 15);
        Font ff = new Font("Calibri", Font.PLAIN, 25);
        Color cc = new Color(66, 134, 244);
        Color white = Color.white;

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
        ImageIcon deleteI = new ImageIcon("src/images/delete.PNG");
        this.deleteButton.setIcon(deleteI);
        ImageIcon updateI = new ImageIcon("src/images/update.PNG");
        this.updateButton.setIcon(updateI);
        ImageIcon exportI = new ImageIcon("src/images/export.PNG");
        this.exportButton.setIcon(exportI);

        JPanel bottomPanel = new JPanel(new FlowLayout());


        bottomPanel.add(exportButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);

        //add borders to panels
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(cc),"Browse rentals list"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(cc);
        this.setBackground(Color.BLACK);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

    }

    public JTable getTable()
    {
        return table;
    }


    public JButton getExportButton()
    {
        return exportButton;
    }

    @Override
    public void update(java.util.Observable o, Object arg)
    {
        this.model.initData();
    }
}
