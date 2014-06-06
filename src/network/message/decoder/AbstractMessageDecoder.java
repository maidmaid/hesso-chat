package network.message.decoder;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import network.message.MessageConversationOpened;
import network.message.MessageConversationUpdated;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
import network.message.event.MessageListener;

public class AbstractMessageDecoder
{
	protected CopyOnWriteArrayList<MessageListener> listeners;
	
	public AbstractMessageDecoder()
	{
		listeners = new CopyOnWriteArrayList<MessageListener>();
	}
	
	public void addMessageListener(MessageListener l)
	{
		listeners.add(l);
	}
	
	public void removeMessageListener(MessageListener l)
	{
		listeners.remove(l);
	}
	
	public CopyOnWriteArrayList<MessageListener> getMessageListeners()
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
	
	public void fireUserDisconnected(MessageUserDisconnected message)
	{
		for(MessageListener l : listeners)
		{
			l.userDisconnected(message);
		}
	}
	
	public void fireConversationOpened(MessageConversationOpened message)
	{
		for(MessageListener l : listeners)
		{
			l.conversationOpened(message);
		}
	}
	
	public void fireConversationUpdated(MessageConversationUpdated message)
	{
		for(MessageListener l : listeners)
		{
			l.conversationUpdated(message);
		}
	}
}
