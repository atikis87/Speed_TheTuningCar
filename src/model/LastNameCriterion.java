package model;

public class LastNameCriterion implements Criterion<Client>
{
    private String LastName;

    public LastNameCriterion(String LastName)
    {
        this.LastName = LastName;
    }

    public void finalize() throws Throwable
    {

    }

    @Override
    public boolean isSatisfiedBy(Client client)
    { 
    	return client.getLastName().equals(this.LastName);
    }

    public String getLname() 
    {
        return LastName;
    }
}
