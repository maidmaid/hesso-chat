package message.event;

import message.MessageNewUser;

public interface MessageListener
{
	public void newUserReceived(MessageNewUser message);
}