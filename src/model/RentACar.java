package model;

public class RentACar
{

	private int rentIdentifier;
	private Car car;
	private Client client;
	private boolean isReturned;
	private java.sql.Date rentalDate;
	private java.sql.Date returnDate;

	// Constructor
	public RentACar(int aRentIdentifier, Car car, Client client, boolean isReturned, java.sql.Date rentalDate, java.sql.Date returnDate)
	{
		this.rentIdentifier = aRentIdentifier;
		this.car = car;
		this.client = client;
		this.isReturned = isReturned;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}
	
	// Constructor
	public RentACar(Car car, Client client, boolean isReturned, java.sql.Date rentalDate, java.sql.Date returnDate)
	{
		
		this.car = car;
		this.client = client;
		this.isReturned = isReturned;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}

	public Car getCar()
	{
		return car;
	}

	public Client getClient()
	{
		return client;
	}

	public boolean isReturned()
	{
		return isReturned;
	}

	public java.sql.Date getRentalDate()
	{
		return rentalDate;
	}

	public java.sql.Date getReturnDate()
	{
		return returnDate;
	}

	public int getRentIdentifier()
	{
		return rentIdentifier;
	}

	public void finalize() throws Throwable
	{

	}
}