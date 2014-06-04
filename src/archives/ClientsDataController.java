package archives;

import network.client.Client;

public class ClientsDataController
{
	private int idCnt;
	private StorageDataClients dataClients;
	
	public ClientsDataController() {
		dataClients = new StorageDataClients();
		idCnt = 0;
	}
	
	public void removeClient(int id)
	{
		dataClients.deleteData(id);
	}
	
	public String[] getClientInfo(int id)
	{
		Client tempClient = dataClients.getDataClient(id);
		String tempFirstname = tempClient.getFirstName();
		String tempLastname = tempClient.getLastName(); 
		
		String[]clientTab = new String[2];
		clientTab[0]= tempFirstname;
		clientTab[1]= tempLastname;
		return clientTab;
	}
	
	private int generateId()
	{
		idCnt++;
		return idCnt;
	}
}
