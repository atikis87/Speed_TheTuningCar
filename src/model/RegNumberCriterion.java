package model;

public class RegNumberCriterion implements Criterion<Car>
{
	   private String registrationNumber;
	    public RegNumberCriterion(String registrationNumber)
	    {
	        this.registrationNumber = registrationNumber;
	    }
	    @Override
	    public boolean isSatisfiedBy(Car c)
	    {
	    	return c.getRegistrationNumber().equals(this.registrationNumber);
	    }

	    public String getRegistrationNumber()
	    {
	        return registrationNumber;
	    }
	}
