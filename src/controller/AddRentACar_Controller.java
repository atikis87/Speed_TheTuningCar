package controller;

import model.*;
import view.AddRentACarPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Observable;

public class AddRentACar_Controller implements ActionListener
{
    AddRentACarPanel rentACarPanel;
    private DataAccessObject<RentACar> rentingDAO;
    
    //CONSTCUKTOR
    public AddRentACar_Controller(final AddRentACarPanel rantingPanel)
    {
        this.rentACarPanel = rantingPanel;
        this.rentingDAO = DAOFactory.getRantingDAO();

        this.rentACarPanel.getCarSearchButton().addActionListener(this);
        this.rentACarPanel.getClientSearchButton().addActionListener(this);
        this.rentACarPanel.getAddRantingButton().addActionListener(this);
        this.rentACarPanel.getResetRantingButton().addActionListener(this);


        final ListSelectionModel lsm = this.rentACarPanel.getClientsTable().getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if(! lsm.isSelectionEmpty())
                {
                    int selectedRow = lsm.getMinSelectionIndex();
                    //System.out.println(selectedRow);
                    rantingPanel.getSelectedClient().setText(rantingPanel.getClientsTable().getValueAt(selectedRow, 0).toString());
                }
            }
        });

        final ListSelectionModel lsm2 = this.rentACarPanel.getCarsTable().getSelectionModel();
        lsm2.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if(! lsm2.isSelectionEmpty())
                {
                    int selectedRow = lsm2.getMinSelectionIndex();
                    //System.out.println(selectedRow);
                    rantingPanel.getSelectedCar().setText(rantingPanel.getCarsTable().getValueAt(selectedRow, 0).toString());
                }
            }
        });

    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
       if(event.getSource() == this.rentACarPanel.getClientSearchButton())
       {
			if (this.rentACarPanel.getCinField().getText().equals("")
                    && this.rentACarPanel.getFnameField().getText().equals("")
                    && this.rentACarPanel.getLnameField().getText().equals(""))
			{
                this.rentACarPanel.getClientModel().initData();
            } else
            {
                ClientCriterionInter criterionInter = new ClientCriterionInter();
                if (!this.rentACarPanel.getCinField().getText().equals(""))
                {
                    criterionInter.addCriterion(new CINCriterion(this.rentACarPanel.getCinField().getText()));
                }
                if(!this.rentACarPanel.getFnameField().getText().equals(""))
                {
                    criterionInter.addCriterion(new FirstNameCriterion(this.rentACarPanel.getFnameField().getText()));
                }
                if(!this.rentACarPanel.getLnameField().getText().equals(""))
                {
                    criterionInter.addCriterion(new LastNameCriterion(this.rentACarPanel.getLnameField().getText()));
                }
                ClientDataAccessPbject clientDAO = new ClientDataAccessPbject(DBConnection.getInstance());
                this.rentACarPanel.getClientModel().loadData(clientDAO.search(criterionInter));
            }
       }
       else if (event.getSource() == this.rentACarPanel.getCarSearchButton())
       {
           if (this.rentACarPanel.getNumField().getText().equals("")
                   && this.rentACarPanel.getModelField().getText().equals("")
                   && this.rentACarPanel.getBrandField().getText().equals("")
                   && this.rentACarPanel.getPriceField().getText().equals(""))
           {
               this.rentACarPanel.getCarModel().initData();

           }
           else
           {
               CarCriterionInter criterionInter = new CarCriterionInter();
               if (!this.rentACarPanel.getNumField().getText().equals(""))
               {
                   criterionInter.addCriterion(new RegNumberCriterion(this.rentACarPanel.getNumField().getText()));
               }
               if (!this.rentACarPanel.getModelField().getText().equals(""))
               {
                   criterionInter.addCriterion(new ModelCriterion(this.rentACarPanel.getModelField().getText()));
               }
               if (!this.rentACarPanel.getBrandField().getText().equals(""))
               {
                   criterionInter.addCriterion(new BrandCriterion(this.rentACarPanel.getBrandField().getText()));
               }
               if(!this.rentACarPanel.getPriceField().getText().equals(""))
               {
                   criterionInter.addCriterion(new PriceCriterion(Double.parseDouble(this.rentACarPanel.getPriceField().getText())));
               }
               CarDataAccessObject carDAO = new CarDataAccessObject(DBConnection.getInstance());
               this.rentACarPanel.getCarModel().loadData(carDAO.search(criterionInter));
           }
       }
       if (event.getSource() == this.rentACarPanel.getAddRantingButton())
       {
           if(!this.rentACarPanel.getSelectedCar().getText().equals("") &&
              !this.rentACarPanel.getSelectedClient().getText().equals("") &&
              !this.rentACarPanel.getRentalDateField().getText().equals("") &&
              !this.rentACarPanel.getReturnDateField().getText().equals("")
              ){
               rentingDAO.create(new RentACar(0,new Car(this.rentACarPanel.getSelectedCar().getText(), "", "", 0.0),
                       			 new Client(this.rentACarPanel.getSelectedClient().getText(), "", ""),false,
                       			 java.sql.Date.valueOf(this.rentACarPanel.getRentalDateField().getText()),
                       			 java.sql.Date.valueOf(this.rentACarPanel.getReturnDateField().getText())
               ));
               this.rentACarPanel.getClientModel().removeRow(this.rentACarPanel.getClientsTable().getSelectedRow());
               this.rentACarPanel.getCarModel().removeRow(this.rentACarPanel.getCarsTable().getSelectedRow());
               JOptionPane.showMessageDialog (null, "This renting has been added !","Information", JOptionPane.INFORMATION_MESSAGE);
           }
           
           else
           {
               JOptionPane.showMessageDialog (null, "There is an empty field!","Error", JOptionPane.ERROR_MESSAGE);
           }
           

       }
       if (event.getSource() == this.rentACarPanel.getResetRantingButton())
       {
           this.rentACarPanel.getSelectedClient().setText("");
           this.rentACarPanel.getSelectedCar().setText("");
           this.rentACarPanel.getRentalDateField().setText("");
           this.rentACarPanel.getReturnDateField().setText("");

           this.rentACarPanel.getNumField().setText("");
           this.rentACarPanel.getModelField().setText("");
           this.rentACarPanel.getBrandField().setText("");
           this.rentACarPanel.getPriceField().setText("");

           this.rentACarPanel.getCinField().setText("");
           this.rentACarPanel.getLnameField().setText("");
           this.rentACarPanel.getFnameField().setText("");
        }
    }
}
