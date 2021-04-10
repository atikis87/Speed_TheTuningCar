package model;

import java.sql.Connection;

public class DAOFactory
{
	private static final Connection connection = DBConnection.getInstance();

	private DAOFactory()
	{
		/**/
	}

	public static DataAccessObject getClientDAO()
	{
		return new ClientDataAccessPbject(connection);
	}

	public static DataAccessObject getCarDAO()
	{
		return new CarDataAccessObject(connection);
	}

	public static DataAccessObject getRantingDAO()
	{
		return new RentingDataAccessObject(connection);
	}

	public void finalize() throws Throwable
	{

	}

}