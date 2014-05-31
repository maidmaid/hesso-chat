package server.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import client.network.Client;

/**
 * Server gère la communication réseau avec des clients
 * @author DM
 */
public class Server extends ServerAbstract
{
	private ArrayList<Client> clients;
	private ArrayList<Socket> sockets;
	private ServerSocket server;
	private Thread trdConnection;
	
	/**
	 * Constuit le serveur de chat
	 */
	public Server()
	{
		super();
		
		try
		{
			server = new ServerSocket();
			trdConnection = new Thread(new Connection());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Start the server
	 */
	public void start()
	{		
		setState(State.PENDING);
		
		try
		{
			InetAddress bindAddr = null;
			server.bind(new InetSocketAddress(bindAddr, 1234));
			trdConnection.start();
			setState(State.ENABLE);
		}
		catch(IOException e)
		{
			setState(State.DISABLE);
			e.printStackTrace();
		}
	}
	
	/**
	 * Runnable implementation to accept news clients
	 * @author DM
	 */
	public class Connection implements Runnable
	{
		/**
		 * Accepte news clients
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
