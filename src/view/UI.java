package view;

import java.awt.Color;
import javax.swing.*;
import controller.AddRentACar_Controller;
import controller.CarController;
import controller.ClientController;
import controller.ExitController;
import controller.RentingController;

public class UI extends JFrame
{
	//TABBED PANE
    private JTabbedPane menu;
    
    // PANELS
    private ClientsPanel clientsPanel;
    private CarsPanel carsPanel;
    private RentalsPanel rentalsPanel;
    private AddRentACarPanel addRentingPanel;
    private HomePanel home;
    private ExitPanel close;
    
    // CONTROLLERS
    public ClientController clientController;
    public CarController carController;
    public RentingController rentingController;
    public AddRentACar_Controller addRentingController;
    public ExitController exitController;
    
    //COLOR
	Color tab = new Color(31,109,228);

	//CONSTRUCTOR
	public UI()
	{
		this.home = new HomePanel();
		
		this.clientsPanel = new ClientsPanel();
		this.clientController = new ClientController(clientsPanel);
		
		this.carsPanel = new CarsPanel();
		this.carController = new CarController(carsPanel);
		
		this.addRentingPanel = new AddRentACarPanel();
		this.addRentingController = new AddRentACar_Controller(addRentingPanel);
		
		this.rentalsPanel = new RentalsPanel();
		this.rentingController = new RentingController(rentalsPanel, addRentingPanel);
		
		this.close = new ExitPanel();
		this.exitController = new ExitController(close);
		
        UserInterface(clientsPanel, carsPanel, rentalsPanel, addRentingPanel, home, close);
	}

	//FUNCTION WITH ALL JTABBEDPANE PARAMETER
    public void UserInterface(ClientsPanel clients, CarsPanel cars, RentalsPanel rentals, AddRentACarPanel AddRenting, HomePanel home, ExitPanel close)
    {	
        //ICONS FOR MENU ======================================================
        ImageIcon homeIcon = new ImageIcon("src/images/home.PNG");
        ImageIcon clientIcon = new ImageIcon("src/images/client.PNG");
        ImageIcon carIcon = new ImageIcon("src/images/car.PNG");
        ImageIcon rantingIcon = new ImageIcon("src/images/rented_cars.PNG");
        ImageIcon addRantIcon = new ImageIcon("src/images/bag.PNG");
        ImageIcon closeIcon = new ImageIcon("src/images/exit.PNG");
    	
        // TABBED PANE MENU LOCATION ==========================================
        menu = new JTabbedPane(JTabbedPane.LEFT);
        
        // TABBED PANE TITLE WITH PANEL =======================================
        menu.add("Home", home);
        menu.add("Clients", clients);
        menu.add("Cars", cars);
        menu.add("Rentals", rentals);
        menu.add("Add Renting", AddRenting);
        menu.add("Exit", close);

        // SET COLOR BACKROUND ================================================    
        menu.setBackgroundAt(0, tab);
        menu.setBackgroundAt(1, tab);
        menu.setBackgroundAt(2, tab);
        menu.setBackgroundAt(3, tab);
        menu.setBackgroundAt(4, tab);
        menu.setBackgroundAt(5, tab);

        // TABBED PANE SEQUENCE WITH ICONS ====================================
        menu.setIconAt(0, homeIcon);
        menu.setIconAt(1, clientIcon);
        menu.setIconAt(2, carIcon);
        menu.setIconAt(3, rantingIcon);
        menu.setIconAt(4, addRantIcon);
        menu.setIconAt(5, closeIcon);

        // SET CONENT =========================================================
        this.getContentPane().add(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Speed The Tuning Car");
        this.setSize(1300, 700);
        ImageIcon img = new ImageIcon("src/images/favico.png");
        this.setIconImage(img.getImage());
        //this.setUndecorated(true);
        this.setResizable(false);
    }
}