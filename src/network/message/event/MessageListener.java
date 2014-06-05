package network.message.event;

import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;

public interface MessageListener
{
	public void idAssigned(MessageIdAssigned message);
	public void userChanged(MessageUserChanged message);
}