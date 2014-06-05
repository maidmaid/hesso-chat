package network.message.event;

import network.message.MessageIdAssigned;
import network.message.MessageNewUser;

public interface MessageListener
{
	public void newUserReceived(MessageNewUser message);
	
	public void idAssigned(MessageIdAssigned message);
}