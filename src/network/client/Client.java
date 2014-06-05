package network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client extends AbstractClient
{
	private Socket socket;
	Thread threadRead;
	BufferedReader in;
	PrintWriter out;
	String ip;

	public Client()
	{
		init();
	}

	public Client(Socket socket)
	{
		this.socket = socket;
		init();
		
		try
		{
			initSocket();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void init()
	{
		threadRead = new Thread(new Read());
	}
	
	private void initSocket() throws IOException
	{
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		threadRead.start();
	}

	public void send(String message)
	{
		out.println(message);
		out.flush();
	}

	public class Read implements Runnable
	{		
		@Override
		public void run()
		{
			boolean connected = true;
			
			try
			{
				while(connected)
				{
					String message = in.readLine();
					fireMessageReceived(message);
				}
			}
			catch(IOException e)
			{
				connected = false;
				fireDisconnectionOccured(e.getMessage());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void connect(String ip) throws IOException, IOException
	{
		threadRead.interrupt();
		
		socket = new Socket(ip, 1234);
		
		initSocket();
		fireConnexionEstablished();
	}
}
