package model;

public class BrandCriterion implements Criterion<Car>
{
	private String brand;

	public BrandCriterion(String brand)
	{
		this.brand = brand;
	}

	public void finalize() throws Throwable
	{

	}

	@Override
	public boolean isSatisfiedBy(Car c)
	{
		return c.getBrand().equals(this.brand);
	}

	public String getBrand()
	{
		return brand;
	}
}