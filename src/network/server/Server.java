package network.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import network.client.Client;


/**
 * Server manages the network's communication with clients
 * @author DM
 */
public class Server extends ServerAbstract
{
	private ArrayList<Client> clients;
	private ArrayList<Socket> sockets;
	private ServerSocket server;
	private Thread trdConnection;
	
	/**
	 * Builds server's chat
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
			setState(State.DISABLE, e.getMessage());
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
					//sockets.add(socket);
					fireClientConnected();
	    		}
			}
	    	catch (IOException e)
			{
				e.printStackTrace();
			}
	    }
	}
}
