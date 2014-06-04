package view.client;

import controller.AbstractController;
import controller.ClientController;
import view.AbstractView;

public class AbstractClientView extends AbstractView
{
	public AbstractClientView(AbstractController controller)
	{
		super(controller);
	}

	@Override
	public ClientController getController()
	{
		return (ClientController) super.getController();
	}
}
