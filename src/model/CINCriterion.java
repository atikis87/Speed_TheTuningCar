package model;

public class CINCriterion implements Criterion<Client>
{
    private String ClientNumber;
    public CINCriterion(String CIN){ this.ClientNumber = CIN;}

    @Override
    public boolean isSatisfiedBy(Client client)
    {
        return client.getClientNumb().equals(this.ClientNumber);
    }

    public String getClientNumber()
    {
        return ClientNumber;
    }
}