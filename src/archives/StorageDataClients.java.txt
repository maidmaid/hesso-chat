package archives;

import java.util.Hashtable;

import network.client.Client;

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
		client.setRegistred(true);
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
			System.out.println("This Client does not exist!");
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
			System.out.println("This Client does not exist!");
		}
	}

	private boolean ClientsDataExists(int id)
	{
		return clientsData.containsKey(id);
	}
}
