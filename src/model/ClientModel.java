package model;

import network.client.Client;

public class ClientModel extends AbstractModel
{
	private Client client;
	
	public ClientModel() 
	{
		client = new Client();
	}
	
	public Client getClient()
	{
		return client;
	}
}
