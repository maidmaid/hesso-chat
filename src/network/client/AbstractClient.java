package network.client;

import java.util.ArrayList;

import network.client.event.ClientListener;
import network.client.event.MessageEvent;

public abstract class AbstractClient
{
	private ArrayList<ClientListener> listeners;
	
	public AbstractClient()
	{
		listeners = new ArrayList<ClientListener>();
	}
	
	public void addClientListener(ClientListener l)
	{
		listeners.add(l);
	}
	
	public void removeClientListener(ClientListener l)
	{
		listeners.remove(l);
	}
	
	public ArrayList<ClientListener> getClientListeners()
	{
		return listeners;
	}
	
	public void fireMessageReceived(String message)
	{
		for (ClientListener l : listeners)
		{
			MessageEvent e =  new MessageEvent(this, message);
			l.messageReceived(e);
		}
	}
	
	public void fireConnexionEstablished()
	{
		for (ClientListener l : listeners)
		{
			l.connexionEstablished();
		}
	}
}
