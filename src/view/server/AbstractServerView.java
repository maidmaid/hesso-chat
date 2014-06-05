package view.server;

import controller.AbstractController;
import network.message.event.MessageListener;
import network.server.event.ServerListener;
import view.AbstractView;

public abstract class AbstractServerView extends AbstractView implements ServerListener, MessageListener
{
	public AbstractServerView(AbstractController controller)
	{
		super(controller);
	}
}
