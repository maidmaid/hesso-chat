package view;

import controller.AbstractController;

public abstract class AbstractView
{
	private AbstractController controller;
	
	public AbstractView(AbstractController controller)
	{
		this.controller = controller;
	}
	
	public AbstractController getController()
	{
		return controller;
	}
}
