package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


public class CarDataAccessObject extends DataAccessObject<Car>
{

	public CarDataAccessObject(Connection connection)
	{
		super(connection);
	}

	@Override
	public boolean create(Car obj)
	{
		try
		{
			String query = "INSERT INTO tuningcar VALUES (?, ?, ?, ?)";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getRegistrationNumber());
			state.setString(2, obj.getBrand());
			state.setString(3, obj.getModel());
			state.setDouble(4, obj.getPrice());
			state.executeUpdate();
			return true;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Car obj)
	{
		try
		{
			String query = "DELETE FROM tuningcar WHERE registrationNumber = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getRegistrationNumber());
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
	public boolean update(Car obj)
	{
		try
		{
			String query = "UPDATE tuningcar SET brand = ?, model = ?, price = ? WHERE registrationNumber = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getBrand());
			state.setString(2, obj.getModel());
			state.setDouble(3, obj.getPrice());
			state.setString(4, obj.getRegistrationNumber());
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
	public Car find(String ref)
	{
		try
		{
			String query = "SELECT * FROM tuningcar WHERE registrationNumber = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			state.setString(1, ref);
			ResultSet result = state.executeQuery();
			if(result.first())
			{
				Car newC = new Car(ref,result.getString("model"),result.getString("brand"),result.getDouble("price"));
				return newC;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Car> all()
	{
		Vector<Car> cars = new Vector<>();
		try
		{
			String query = "SELECT * FROM tuningcar";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next())
			{
				Car newC = new Car(result.getString("registrationNumber"),result.getString("model"),result.getString("brand"),result.getDouble("price"));
				cars.add(newC);
			}
			return cars;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return cars;
	}

	public List<Car> available()
	{
		Vector<Car> cars = new Vector<>();
		try
		{
			String query = "SELECT * FROM tuningcar " + "WHERE registrationNumber NOT IN " + "(SELECT registrationNumber FROM rentingcar)";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next())
			{
				Car newC = new Car(result.getString("registrationNumber"),result.getString("model"),result.getString("brand"),result.getDouble("price"));
				cars.add(newC);
			}
		return cars;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return cars;
	}

	public List<Car> search(CarCriterionInter criterion)
	{
		if(!criterion.getCriterions().isEmpty())
		{
			String query = " SELECT * FROM tuningcar WHERE ";
			if(criterion.getCriterions().firstElement() instanceof ModelCriterion)
			{
				query += " model = \""+((ModelCriterion)(criterion.getCriterions().firstElement())).getModel() + "\"";
			}
			else if(criterion.getCriterions().firstElement() instanceof BrandCriterion)
			{
				query += " brand = \""+((BrandCriterion)(criterion.getCriterions().firstElement())).getBrand() + "\"";
			}
			else if(criterion.getCriterions().firstElement() instanceof RegNumberCriterion)
			{
				query += " registrationNumber = \""+((RegNumberCriterion)(criterion.getCriterions().firstElement())).getRegistrationNumber() + "\"";
			}
			else if(criterion.getCriterions().firstElement() instanceof PriceCriterion)
			{
				query+= " price <= "+((PriceCriterion)(criterion.getCriterions().firstElement())).getPrice();
			}

			for(Criterion<Car> item : criterion.getCriterions())
			{
				if(item instanceof ModelCriterion)
				{
					query += " AND model = \""+((ModelCriterion)item).getModel() + "\"";
				}else if(item instanceof BrandCriterion)
				{
					query += " AND brand = \""+((BrandCriterion)item).getBrand() + "\"";
				}else if(item instanceof RegNumberCriterion)
				{
					query += " AND registrationNumber = \""+((RegNumberCriterion)item).getRegistrationNumber() + "\"";
				}else if(item instanceof PriceCriterion)
				{
					query += " AND price <= "+((PriceCriterion)item).getPrice();
				}
			}
			query += " ;";
			Vector<Car> cars = new Vector<>();
			try
			{
				PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
				ResultSet result = state.executeQuery();
				while(result.next())
				{
					cars.add(new Car(result.getString("registrationNumber"),
									 result.getString("model"),
									 result.getString("brand"),
									 result.getDouble("price"))
					);
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

			return cars;
		}
		return null;
	}

	public void finalize() throws Throwable
	{
		super.finalize();
	}
}
