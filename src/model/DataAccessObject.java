package model;

import java.sql.Connection;
import java.util.List;

public abstract class DataAccessObject<T>
{
	protected Connection connection = null;

	public DataAccessObject(Connection connection)
	{
		this.connection = connection;
	}

	//Creation METHOD
	public abstract boolean create(T obj);

	//DELETE METHOD
	public abstract boolean delete(T obj);

	//UPDATE METHOD
	public abstract boolean update(T obj);

	//SEARCH METHOD
	public abstract T find(String ref);

	public abstract List<T> all();

	public abstract List<T> available();

	public void finalize() throws Throwable
	{

	}

}
