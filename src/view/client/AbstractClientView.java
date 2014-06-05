package view.client;

import network.client.event.ClientListener;
import network.message.event.MessageListener;
import controller.AbstractController;
import controller.ClientController;
import view.AbstractView;

abstract public class AbstractClientView extends AbstractView implements ClientListener, MessageListener
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
