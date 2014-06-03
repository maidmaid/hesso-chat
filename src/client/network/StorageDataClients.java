package client.network;

import java.util.Hashtable;

public class StorageDataClients 
{
	private Hashtable<Integer,Client>clientsData;
	
	public StorageDataClients()
	{
		clientsData = new Hashtable<Integer,Client>();
	}
	
	public void addDataClient(Client client)
	{
	int id = client.getId();
	clientsData.put(id,client);
	}
	
	public Client getDataClient(int id)
	{
		if(ClientsDataExists(id)==true)
		{
			return clientsData.get(id);
		}
		else
		{
			System.out.println("Cet utilisateur n'existe pas.");
			return null;
		}
		
	}
	
	public void deleteData(int id)
	{
		if(ClientsDataExists(id)==true)
		{
			clientsData.remove(id);
		}
		else
		{
			System.out.println("Ce contact n'existe pas");
		}
	}
	
	private boolean ClientsDataExists(int id)
	{
		return clientsData.containsKey(id);
	}
}
