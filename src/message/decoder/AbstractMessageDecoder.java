package message.decoder;

import java.util.ArrayList;

import message.MessageIdAssigned;
import message.MessageNewUser;
import message.event.MessageListener;

public class AbstractMessageDecoder
{
	protected ArrayList<MessageListener> listeners;
	
	public AbstractMessageDecoder()
	{
		listeners = new ArrayList<MessageListener>();
	}
	
	public void addMessageListener(MessageListener l)
	{
		listeners.add(l);
	}
	
	public void removeMessageListener(MessageListener l)
	{
		listeners.remove(l);
	}
	
	public ArrayList<MessageListener> getMessageListeners()
	{
		return listeners;
	}
	
	public void fireNewUserReceived(MessageNewUser message)
	{
		for(MessageListener l : listeners)
		{
			l.newUserReceived(message);
		}
	}
	
	public void fireIdAssigned(MessageIdAssigned message)
	{
		for(MessageListener l : listeners)
		{
			l.idAssigned(message);
		}
	}
}
