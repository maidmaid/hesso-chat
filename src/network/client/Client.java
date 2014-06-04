package network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import archives.ClientAbstract;
import view.client.ClientConnexionPanel;
import view.client.ClientMessagePanel;


public class Client extends ClientAbstract
{
	Socket socket;
	Thread threadRead;
	BufferedReader in;
	PrintWriter out;
	String ip;

	public Client()
	{
		threadRead = new Thread(new Read());
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
		
		socket = new Socket(ip, 1234);
		
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		
		threadRead.start();
	}
}
