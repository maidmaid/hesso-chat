package message.event;

import message.MessageIdAssigned;
import message.MessageNewUser;

public interface MessageListener
{
	public void newUserReceived(MessageNewUser message);
	
	public void idAssigned(MessageIdAssigned message);
}