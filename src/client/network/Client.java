package client.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import client.ui.ClientApp;
import server.network.*;

public class Client
{
	Socket socket;
	Thread threadRead;
	BufferedReader in;
	PrintWriter out;

	public Client()
	{
		try
		{
			socket = new Socket(/*InetAddress.getLocalHost()*/"127.0.0.1",1234);
			threadRead = new Thread(new Read(socket)); 
			threadRead.start();
			Scanner scan = new Scanner(System.in);
			out = new PrintWriter(socket.getOutputStream());

			while(true)
			{
				System.out.println("Please, write your message : ");
				String Clientmessage = scan.nextLine();
				out.println(Clientmessage);
				out.flush();
			}
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

	public static void main(String[] args)
	{
		Client client = new Client();
	}

	public class Read implements Runnable
	{
		private Socket socket;

		public Read(Socket socket)
		{
			this.socket = socket;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String message = in.readLine();
				System.out.println(message);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
