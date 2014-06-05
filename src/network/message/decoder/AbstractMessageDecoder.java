package network.message.decoder;

import java.util.ArrayList;

import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.event.MessageListener;

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
	
	public void fireIdAssigned(MessageIdAssigned message)
	{
		for(MessageListener l : listeners)
		{
			l.idAssigned(message);
		}
	}
	
	public void fireUserChanged(MessageUserChanged message)
	{
		for(MessageListener l : listeners)
		{
			l.userChanged(message);
		}
	}
}
