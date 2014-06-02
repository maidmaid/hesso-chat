package client.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import client.ui.ClientMessage;

public class Client
{
	private ClientMessage clientMessage;
	Socket socket;
	Thread threadRead;
	BufferedReader in;
	PrintWriter out;

	public Client(ClientMessage clientMessage)
	{
		this.clientMessage = new ClientMessage();
		
		try
		{
			socket = new Socket(/*InetAddress.getLocalHost()*/"127.0.0.1",1234);
			out = new PrintWriter(socket.getOutputStream());
			threadRead = new Thread(new Read()); 
			threadRead.start();
			Scanner scan = new Scanner(System.in);
			out = new PrintWriter(socket.getOutputStream());		
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
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
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String message = in.readLine();
					System.out.println(message);
					// clientMessage.
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
