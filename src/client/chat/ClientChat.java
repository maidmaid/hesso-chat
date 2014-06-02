package client.chat;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import client.network.Client;

public class ClientChat
{
	private Client client;
	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String message;
	
	public ClientChat()
	{
		Client c = new Client(null);
		c.send(message);
	}
}
