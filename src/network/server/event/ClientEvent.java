package network.server.event;

import java.util.EventObject;

import network.client.Client;

/**
 * Event which indicates that an client connected occured.
 * @author DM
 */
public class ClientEvent extends EventObject
{
	private Client client;
	
	/**
	 * Constructs an ClientEvent object.
	 */
	public ClientEvent(Object source, Client client)
	{
		super(source);
		this.client = client;
	}
	
	public Client getClient()
	{
		return client;
	}
}
