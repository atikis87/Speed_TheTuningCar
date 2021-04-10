package view;

import model.CarTableModel;
import model.ClientTableModel;
import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AddRentACarPanel extends JPanel
{
	
	//TABLES TO SEARCH
    private ClientTableModel clientModel;
    private CarTableModel carModel;
    private JTable clientsTable;
    private JTable carsTable;
    
    //LABELS
    private JLabel selectedCarLabel;
    private JLabel selectedClientLabel;
    private JLabel rentalDateLabel;
    private JLabel returnDateLabel;
    
    //SELECTED CLIENT AND CAR CONTENT
    private JTextField selectedCar;
    private JTextField selectedClient;
    
    //ADD RENTING FIELD
    private JTextField rentalDateField;
    private JTextField returnDateField;
    
    //SEARCH CLIENT TABLE
    private JLabel cinLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    
    //SEARCH CLIENT FIELD
    private JTextField cinField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    
    //SEARCH CAR LABEL
    private JLabel numLabel;
    private JLabel modelLabel;
    private JLabel brandLabel;
    private JLabel priceLabel;
    
    //SEARCH CAR FIELD
    private JTextField numField;
    private JTextField modelField;
    private JTextField brandField;
    private JTextField priceField;
    
    //BUTTONS
    private JButton clientSearchButton;
    private JButton carSearchButton;
    private JButton addRentingButton;
    private JButton resetRentingButton;

    // CONSTRUCTOR
    public AddRentACarPanel()
    {
        this.setLayout(new BorderLayout());
        
        //get data from DB
        clientModel = new ClientTableModel();
        clientModel.availables();
        carModel = new CarTableModel();
        carModel.availables();
        this.clientsTable = new JTable(clientModel);
        this.carsTable = new JTable(carModel);
        
        //FONTS AND COLORS
        Font f = new Font("Times New Roman", Font.PLAIN, 15);
        Color c = new Color (193, 73, 13);
        Font ff = new Font("Calibri", Font.PLAIN, 25);
        Color cc = new Color(66, 134, 244);
        Color white = Color.white;

        //ADD RENTING LABELS
        this.selectedCarLabel = new JLabel("Selected car N°:", SwingConstants.LEFT);
        this.selectedCarLabel.setFont(f);
        this.selectedCarLabel.setForeground(c);

        this.selectedClientLabel = new JLabel("Selected client CIN:", SwingConstants.LEFT);
        this.selectedClientLabel.setFont(f);
        this.selectedClientLabel.setForeground(c);

        this.rentalDateLabel = new JLabel("Rental date:(Y-M-D)", SwingConstants.LEFT);
        this.rentalDateLabel.setFont(f);
        this.rentalDateLabel.setForeground(c);

        this.returnDateLabel = new JLabel("Return date:(Y-M-D)", SwingConstants.LEFT);
        this.returnDateLabel.setFont(f);
        this.returnDateLabel.setForeground(c);

        JLabel addLabel = new JLabel("");
        JLabel resetLabel = new JLabel("");
        
        //ADD RENTING CONTENT
        this.selectedCar = new JTextField(SwingConstants.LEFT);
        this.selectedClient= new JTextField(SwingConstants.LEFT);
        this.selectedClient.setEditable(false);
        this.selectedCar.setEditable(false);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        //JFORMATED TEXTFIELD
        this.rentalDateField =  new JFormattedTextField(dateFormat);
        this.returnDateField =  new JFormattedTextField(dateFormat);

        this.addRentingButton = new JButton("Add");
        this.addRentingButton.setFont(f);
        this.addRentingButton.setForeground(cc);
        this.addRentingButton.setBackground(white);

        this.resetRentingButton = new JButton("Reset");
        this.resetRentingButton.setFont(f);
        this.resetRentingButton.setForeground(cc);
        this.resetRentingButton.setBackground(white);

        //search : cars
        //labels
        this.numLabel = new JLabel("R.NUMBER: ", SwingConstants.LEFT);
        this.numLabel.setFont(f);
        this.numLabel.setForeground(c);

        this.modelLabel = new JLabel("Model: ", SwingConstants.LEFT);
        this.modelLabel.setFont(f);
        this.modelLabel.setForeground(c);

        this.brandLabel = new JLabel("Brand: ", SwingConstants.LEFT);
        this.brandLabel.setFont(f);
        this.brandLabel.setForeground(c);

        this.priceLabel = new JLabel("Price: ", SwingConstants.LEFT);
        this.priceLabel.setFont(f);
        this.priceLabel.setForeground(c);

        JLabel carsL = new JLabel("");
        
        //fields
        this.numField = new JTextField(8);
        this.modelField = new JTextField(8);
        this.brandField = new JTextField(8);
        this.priceField = new JTextField(8);
        
        //button
        this.carSearchButton = new JButton("search");
        this.carSearchButton.setFont(f);
        this.carSearchButton.setForeground(cc);
        this.carSearchButton.setBackground(white);
        
        //SEARCH CLIENTS
        //LABELS
        this.cinLabel = new JLabel("      CIN: ", SwingConstants.LEFT);
        this.cinLabel.setFont(f);
        this.cinLabel.setForeground(c);

        this.firstNameLabel = new JLabel("First name: ", SwingConstants.LEFT);
        this.firstNameLabel.setFont(f);
        this.firstNameLabel.setForeground(c);

        this.lastNameLabel = new JLabel("   Last name: ", SwingConstants.LEFT);
        this.lastNameLabel.setFont(f);
        this.lastNameLabel.setForeground(c);

        JLabel clientsL = new JLabel("");
        
        //FIELDS
        this.cinField = new JTextField(8);
        this.firstNameField = new JTextField(8);
        this.lastNameField = new JTextField(8);
        
        //BUTTON
        this.clientSearchButton = new JButton("search");
        this.clientSearchButton.setFont(f);
        this.clientSearchButton.setForeground(cc);
        this.clientSearchButton.setBackground(white);

        ImageIcon addI = new ImageIcon("src/images/add.PNG");
        this.addRentingButton.setIcon(addI);
        ImageIcon resetI = new ImageIcon("src/images/reset.PNG");
        this.resetRentingButton.setIcon(resetI);
        ImageIcon searchCarI = new ImageIcon("src/images/search.PNG");
        this.carSearchButton.setIcon(searchCarI);
        ImageIcon searchClientI = new ImageIcon("src/images/search.PNG");
        this.clientSearchButton.setIcon(searchClientI);


        //PANELS
        //ADD RENTING
        JPanel topPanel = new JPanel(new GridLayout(2, 6));
        topPanel.setBackground(Color.BLACK);
        
        //for search cars
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setLayout(new BoxLayout (leftPanel, BoxLayout.Y_AXIS));
        JPanel leftPanelTop = new JPanel(new GridLayout(2, 5));
        JPanel leftPanelBottom = new JPanel(new FlowLayout());
        
        // SEARCH CLIENTS
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setLayout(new BoxLayout (rightPanel, BoxLayout.Y_AXIS));
        JPanel rightPanelTop = new JPanel(new GridLayout(2, 4));
        JPanel rightPanelBottom = new JPanel(new FlowLayout());

        // ADD COMPONENT TO PANEL
        // ADD RENTING
        
        //ROW ONE
        topPanel.add(this.selectedCarLabel);
        topPanel.add(this.selectedClientLabel);
        topPanel.add(this.rentalDateLabel);
        topPanel.add(this.returnDateLabel);
        topPanel.add(addLabel);
        topPanel.add(resetLabel);
        
        //ROW TWOs
        topPanel.add(this.selectedCar);
        topPanel.add(this.selectedClient);
        topPanel.add(this.rentalDateField);
        topPanel.add(this.returnDateField);
        topPanel.add(this.addRentingButton);
        topPanel.add(this.resetRentingButton);
        
        //add search
        //car : top
        //row 1
        leftPanelTop.add(this.numLabel);
        leftPanelTop.add(this.modelLabel);
        leftPanelTop.add(this.brandLabel);
        leftPanelTop.add(this.priceLabel);
        leftPanelTop.add(carsL);
        
        //row 2
        leftPanelTop.add(this.numField);
        leftPanelTop.add(this.modelField);
        leftPanelTop.add(this.brandField);
        leftPanelTop.add(this.priceField);
        leftPanelTop.add(carSearchButton);
        
        //car bottom
        leftPanelBottom.add(new JScrollPane(this.carsTable), BorderLayout.CENTER);
        leftPanel.add(leftPanelTop);
        leftPanel.add(leftPanelBottom);

        //client : top
        //row 1
        rightPanelTop.add(this.cinLabel);
        rightPanelTop.add(this.firstNameLabel);
        rightPanelTop.add(this.lastNameLabel);
        rightPanelTop.add(clientsL);
        
        //row 2
        rightPanelTop.add(this.cinField);
        rightPanelTop.add(this.firstNameField);
        rightPanelTop.add(this.lastNameField);
        rightPanelTop.add(clientSearchButton);
        
        //client : bottom
        rightPanelBottom.add(new JScrollPane(clientsTable), BorderLayout.CENTER);
        rightPanel.add(rightPanelTop);
        rightPanel.add(rightPanelBottom);

        //ADD BORDERS TO PANEL
        topPanel.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Add a new rental"));
        ((javax.swing.border.TitledBorder) topPanel.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) topPanel.getBorder()).setTitleColor(cc);

        rightPanel.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Search for a client"));
        ((javax.swing.border.TitledBorder) rightPanel.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) rightPanel.getBorder()).setTitleColor(cc);

        leftPanel.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Search for a car"));
        ((javax.swing.border.TitledBorder) leftPanel.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) leftPanel.getBorder()).setTitleColor(cc);


        //add panels to renting panel
        this.add(topPanel, BorderLayout.NORTH);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(leftPanel, BorderLayout.CENTER);



    }
    public void paintComponent(Graphics g){}
    
	//Getter ======================================================================================
	
	public ClientTableModel getClientModel(){return clientModel;}
	
	public CarTableModel getCarModel(){return carModel;}
	
	public JTable getClientsTable(){return clientsTable;}
	
	public JTable getCarsTable(){return carsTable;}
	
	public JLabel getSelectedCarLabel(){return selectedCarLabel;}
	
	public JLabel getSelectedClientLabel(){return selectedClientLabel;}
	
	public JLabel getRentalDateLabel(){return rentalDateLabel;}
	
	public JLabel getReturnDateLabel(){return returnDateLabel;}
	
	public JTextField getSelectedCar(){return selectedCar;}
	
	public JTextField getSelectedClient(){return selectedClient;}
	
	public JTextField getRentalDateField(){return rentalDateField;}
	
	public JTextField getReturnDateField(){return returnDateField;}
	
	public JLabel getCinLabel(){return cinLabel;}
	
	public JLabel getFnameLabel(){return firstNameLabel;}
	
	public JLabel getLnameLabel(){return lastNameLabel;}
	
	public JTextField getCinField(){return cinField;}
	
	public JTextField getFnameField(){return firstNameField;}
	
	public JTextField getLnameField(){return lastNameField;}
	
	public JLabel getNumLabel(){return numLabel;}
	
	public JLabel getModelLabel(){return modelLabel;}
	
	public JLabel getBrandLabel(){return brandLabel;}
	
	public JLabel getPriceLabel(){return priceLabel;}
	
	public JTextField getNumField(){return numField;}
	
	public JTextField getModelField(){return modelField;}
	
	public JTextField getBrandField(){return brandField;}
	
	public JTextField getPriceField(){return priceField;}
	
	public JButton getClientSearchButton(){return clientSearchButton;}
	
	public JButton getCarSearchButton(){return carSearchButton;}
	
	public JButton getAddRantingButton(){return addRentingButton;}
	
	public JButton getResetRantingButton(){return resetRentingButton;}
	
	//setter ====================================================================================
	
	public void setClientModel(ClientTableModel clientModel){this.clientModel = clientModel;}
	
	public void setCarModel(CarTableModel carModel){this.carModel = carModel;}
}
