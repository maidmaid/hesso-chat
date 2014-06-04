package network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import view.client.ClientConnexionPanel;
import view.client.ClientMessagePanel;


public class Client extends ClientAbstract
{
	private ClientMessagePanel clientMessage;
	private ClientConnexionPanel clientConnexion;
	Socket socket;
	Thread threadRead;
	BufferedReader in;
	PrintWriter out;
	String ip;

	public Client()
	{
		try
		{
			
			//socket = new Socket(ip,1234);
			socket = new Socket();
			//connectToServer(socket);
			//ip = clientConnexion.getIpAdress();
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
	
	public String getIP(String ip)
	{
		ip = clientConnexion.getIpAdress();
		return ip;
	}
	
//	public void connectToServer(Socket socket) throws IOException, IOException
//	{
//		System.out.println("\nWaiting for connection");
//		//socket = new Socket(getIP(ip),1234);
//		System.out.println("Je suis passé par là");
//		System.out.println("\nValeur de la Socket " + socket);
//		System.out.println("\nConnected to : " + socket.getInetAddress().getHostName());
//	}
	
	public void connect(String ip) throws IOException, IOException
	{
		socket = new Socket(ip, 1234);
	}
}
