package model;

public class FirstNameCriterion implements Criterion<Client>
{
    private String FirstName;

    public FirstNameCriterion(String Fname)
    {
        this.FirstName = Fname;
    }

    public void finalize() throws Throwable
    {

    }

    @Override
    public boolean isSatisfiedBy(Client c)
    {
        return c.getFirstName().equals(this.FirstName);
    }

    public String getFirstName()
    {
        return FirstName;
    }
}

