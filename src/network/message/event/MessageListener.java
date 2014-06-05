package network.message.event;

import network.message.MessageIdAssigned;

public interface MessageListener
{
	public void idAssigned(MessageIdAssigned message);
}