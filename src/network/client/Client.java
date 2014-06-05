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
		this.setSocket(socket);
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
		out = new PrintWriter(getSocket().getOutputStream());
		in = new BufferedReader(new InputStreamReader(getSocket().getInputStream())); 
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
			try
			{
				while(true)
				{
					String message = in.readLine();
					fireMessageReceived(message);
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void connect(String ip) throws IOException, IOException
	{
		threadRead.interrupt();
		
		setSocket(new Socket(ip, 1234));
		
		fireConnexionEstablished();
		initSocket();
		
		threadRead.start();
	}

	private Socket getSocket() {
		return socket;
	}

	private void setSocket(Socket socket) {
		this.socket = socket;
	}
}
