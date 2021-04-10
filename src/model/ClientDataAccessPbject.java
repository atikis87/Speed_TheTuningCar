package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ClientDataAccessPbject extends DataAccessObject<Client>
{

	public ClientDataAccessPbject(Connection connection)
	{
		super(connection);
	}

	@Override
	public boolean create(Client obj)
	{

		try
		{
			String query = "INSERT INTO client VALUES (?, ?, ?)";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getClientNumb());
			state.setString(2, obj.getFirstName());
			state.setString(3, obj.getLastName());
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
	public boolean delete(Client obj)
	{
		try
		{
			String query = "DELETE FROM client WHERE CIN = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getClientNumb());
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
	public boolean update(Client obj)
	{

		try
		{
			String query = "UPDATE client SET firstName = ?, lastName = ? WHERE CIN = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getFirstName());
			state.setString(2, obj.getLastName());
			state.setString(3, obj.getClientNumb());
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
	public Client find(String ref)
	{

		try
		{
			String query = "SELECT * FROM client WHERE CIN = ?";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			state.setString(1, ref);
			ResultSet result = state.executeQuery();
			if(result.first()){
				Client newC = new Client(ref,result.getString("firstName"),result.getString("lastName"));
				return newC;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> all()
	{
		Vector<Client> clients = new Vector<>();
		try
		{
			String query = "SELECT * FROM client";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next())
			{
				clients.add(new Client(result.getString("CIN"),result.getString("firstName"),result.getString("lastName")));
			}
			return clients;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return clients;
	}

	public List<Client> available()
	{
		Vector<Client> clients = new Vector<>();
		try
		{
			String query = "SELECT * FROM client " + "WHERE cin NOT IN " + "(SELECT cin FROM rentingcar)";
			PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next())
			{
				clients.add(new Client(result.getString("CIN"),result.getString("firstName"),result.getString("lastName")));
			}
			return clients;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return clients;
	}


	public List<Client> search(ClientCriterionInter criterion)
	{
		if(!criterion.getCriterions().isEmpty())
		{
			String query = "SELECT * FROM client WHERE ";
			if(criterion.getCriterions().firstElement() instanceof CINCriterion)
			{
					query += " CIN = \""+((CINCriterion)(criterion.getCriterions().firstElement())).getClientNumber() + "\"";
			}
			else if(criterion.getCriterions().firstElement() instanceof FirstNameCriterion)
			{
				query += " firstName = \""+((FirstNameCriterion)(criterion.getCriterions().firstElement())).getFirstName() + "\"";
			}
			else if(criterion.getCriterions().firstElement() instanceof LastNameCriterion)
			{
				query += " lastName = \""+((LastNameCriterion)(criterion.getCriterions().firstElement())).getLname() + "\"";
			}

			for(Criterion<Client> item : criterion.getCriterions())
			{
				if(item instanceof CINCriterion)
				{
					query += " AND CIN = \""+((CINCriterion)item).getClientNumber() + "\"";
				}
				else if(item instanceof FirstNameCriterion)
				{
					query += " AND firstName = \""+((FirstNameCriterion)item).getFirstName() + "\"";
				}
				else if(item instanceof LastNameCriterion)
				{
					query += " AND lastName = \""+((LastNameCriterion)item).getLname() + "\"";
				}
			}
			query += " ;";
			Vector<Client> clients = new Vector<>();
			try
			{
				PreparedStatement state = this.connection.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
				ResultSet result = state.executeQuery();
				while(result.next())
				{
					clients.add(new Client(result.getString("CIN"),result.getString("firstName"),result.getString("lastName"))
					);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

			return clients;
		}
		return null;
	}

	public void finalize() throws Throwable
	{
		super.finalize();
	}
}

