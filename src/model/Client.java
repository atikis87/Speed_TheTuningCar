package model;

public class Client
{

	private String CIN;
	private String firstName;
	private String lastName;

	public Client(String cin, String firstName, String lastName)
	{
		this.CIN = cin;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getClientNumb()
	{
		return CIN;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void finalize() throws Throwable
	{

	}

}
