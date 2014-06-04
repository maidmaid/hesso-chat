package model;

import network.client.Client;

public class ClientModel
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
