package model;

public class ModelCriterion implements Criterion<Car>
{
	private String model;

	public ModelCriterion(String model)
	{
		this.model = model;
	}

	public void finalize() throws Throwable
	{

	}

	@Override
	public boolean isSatisfiedBy(Car c)
	{
		return c.getModel().equals(this.model);
	}

	public String getModel()
	{
		return model;
	}
}
