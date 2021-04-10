package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class RentingDataAccessObject extends DataAccessObject<RentACar>
{

	public RentingDataAccessObject(Connection connection)
	{
		super(connection);
	}

	@Override
	public boolean create(RentACar obj)
	{

		try
		{
			String query = "INSERT INTO rentingcar (registrationNumber, CIN, isReturned, rentalDate, returnDate)" +
							"VALUES (?, ?, ?, ?, ?)";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getCar().getRegistrationNumber());
			state.setString(2, obj.getClient().getClientNumb());
			state.setBoolean(3, obj.isReturned());
			state.setDate(4, obj.getRentalDate());
			state.setDate(5,obj.getReturnDate());
			state.executeUpdate();
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(RentACar obj)
	{

		try
		{
			String query = "DELETE FROM rentingcar WHERE rentID = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setInt(1, obj.getRentIdentifier());
			state.executeUpdate();
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(RentACar obj)
	{

		try
		{
			String query = "UPDATE rentingcar SET isReturned = ?, rentalDate = ?, returnDate = ?, registrationNumber = ?, CIN = ? WHERE rentID = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setBoolean(1, obj.isReturned());
			state.setDate(2, obj.getRentalDate());
			state.setDate(3,obj.getReturnDate());
			state.setString(4, obj.getCar().getRegistrationNumber());
			state.setString(5, obj.getClient().getClientNumb());
			state.setInt(6, obj.getRentIdentifier());
			state.executeUpdate();
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public RentACar find(String ref)
	{

		try
		{
			String query = "SELECT * FROM rentingcar WHERE rentID = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			state.setInt(1, Integer.parseInt(ref));
			ResultSet result = state.executeQuery();

			if(result.first())
			{
				RentACar newR = new RentACar( result.getInt("rentID"),
						(new CarDataAccessObject(this.connection)).find(result.getString("registrationNumber")),
						(new ClientDataAccessPbject(this.connection)).find(result.getString("CIN")),
						 result.getBoolean("isReturned"),
						 result.getDate("rentalDate"),
						 result.getDate("returnDate"));
				return newR;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RentACar> all()
	{
		Vector<RentACar> rantings = new Vector<>();
		try
		{
			String query = "SELECT * FROM rentingcar";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next())
			{
				rantings.add(new RentACar(result.getInt("rentID"),
						(new CarDataAccessObject(this.connection)).find(result.getString("registrationNumber")),
						(new ClientDataAccessPbject(this.connection)).find(result.getString("CIN")),
						result.getBoolean("isReturned"),
						result.getDate("rentalDate"),
						result.getDate("returnDate"))
				);
			}
			return rantings;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rantings;
	}

	@Override
	public List<RentACar> available()
	{
		return null;
	}

	public List<RentACar> all(String ref)
	{
		return null;
	}

	public void finalize() throws Throwable
	{
		super.finalize();
	}

}