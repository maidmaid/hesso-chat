package server.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import client.network.Client;

/**
 * Server gère la communication réseau avec des clients
 * @author DM
 */
public class Server
{
	private ArrayList<Client> clients;
	private ArrayList<Socket> sockets;
	private ServerSocket server;
	private Thread trdConnection;
	
	/**
	 * Constuit le serveur de chat
	 * @throws IOException
	 */
	public Server() throws IOException
	{
		server = new ServerSocket(1234);
		trdConnection = new Thread(new Connection());
		trdConnection.start();
	}
	
	/**
	 * Connection est une implémentation Runnable permettant d'accepter des nouveaux clients
	 * @author DM
	 */
	public class Connection implements Runnable
	{
		/**
		 * Accepte des nouveaux clients
		 */
	    public void run()
	    {
	    	try
	    	{
	    		while(true)
	    		{
					Socket socket = server.accept();
					sockets.add(socket);
	    		}
			}
	    	catch (IOException e)
			{
				e.printStackTrace();
			}
	    }
	}
}
