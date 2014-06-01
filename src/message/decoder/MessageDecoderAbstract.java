package message.decoder;

import java.util.ArrayList;
import message.MessageNewUser;
import message.event.MessageListener;

public class MessageDecoderAbstract
{
	protected ArrayList<MessageListener> listeners;
	
	public MessageDecoderAbstract()
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
}
