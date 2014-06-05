package view.server;

import controller.AbstractController;
import network.server.event.ServerListener;
import view.AbstractView;

public abstract class AbstractServerView extends AbstractView implements ServerListener
{
	public AbstractServerView(AbstractController controller)
	{
		super(controller);
	}
}
