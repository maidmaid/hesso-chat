package controller;

import model.AbstractModel;

public abstract class AbstractController
{
	private AbstractModel model;
	
	public AbstractController(AbstractModel model)
	{
		this.model = model;
	}
	
	public AbstractModel getModel()
	{
		return model;
	}
}
