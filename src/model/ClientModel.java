package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import controller.ClientController;

import user.User;
import user.UserManager;
import view.client.ClientMessageFrame;
import network.client.Client;
import network.client.event.ClientListener;
import network.client.event.DisconnectionEvent;
import network.client.event.MessageEvent;
import network.message.MessageConversationOpened;
import network.message.MessageConversationUpdated;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
import network.message.decoder.MessageDecoder;
import network.message.event.MessageListener;

public class ClientModel extends AbstractModel
{
	private Client client;
	private UserManager users;
	private MessageDecoder decoder;
	private ClientController clientController;

	public ClientModel() 
	{
		// Client
		client = new Client();
		client.addClientListener(new ClientModelListener());

		// User
		users = new UserManager();

		// Decoder
		decoder = new MessageDecoder();
		decoder.addMessageListener(new ClientMessageListener());
	}

	public Client getClient()
	{
		return client;
	}

	public MessageDecoder getMessageDecoder()
	{
		return decoder;
	}

	public UserManager getUserManager()
	{
		return users;
	}

	public void getUserName() throws IOException
	{

		String userName = users.getMe().getUsername() ;

		//Opening the file
		PrintWriter file = null;
		try
		{
			file = new PrintWriter(new FileWriter("UserNameSaved.txt"));
		}
		catch(Exception e)
		{
			Error(e,1);	
		}


		//writing in the file
		try
		{
			file.println(userName);
		}
		catch(Exception e)
		{
			Error(e, 3);
		}

		//closing file
		try
		{
			file.close();
		}
		catch(Exception e)
		{
			Error(e, 2);
		}


		//reading in file
		BufferedReader input = new BufferedReader(new FileReader("\nUserNameSaved.txt"));
		String line;

		do{
			line = input.readLine();
			if(line !=null)
			{
				System.out.println(line);

			}
		}
		while(line !=null);
		{
			input.close();
			System.out.println("End of file list");
		}


	}

	public static void Error(Exception e, int code)
	{
		System.err.println("Erreur : " + e);
		System.exit(code);
	}

	public void readingFile(int id) throws IOException
	{
		try {
			BufferedReader input = new BufferedReader(new FileReader("UserNameSaved.txt"));
			String line;

			do{
				line = input.readLine();
				if(line !=null)
				{
					System.out.println(line);

				}
			}
			while(line !=null);
			{
				input.close();
				System.out.println("End of file list");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class ClientModelListener implements ClientListener
	{
		@Override
		public void messageReceived(MessageEvent e)
		{
			decoder.decode(e.getMessage());
		}

		@Override
		public void connexionEstablished()
		{
			// Not used
		}

		@Override
		public void disconnectionOccured(DisconnectionEvent e)
		{
			// TODO Auto-generated method stub	
		}
	}

	private class ClientMessageListener implements MessageListener
	{
		@Override
		public void idAssigned(MessageIdAssigned message)
		{
			User me = users.getMe();
			me.setId(message.getId());

			MessageUserChanged messageUserChanged = new MessageUserChanged(me);
			client.send(messageUserChanged.serialize());
		}

		@Override
		public void userChanged(MessageUserChanged message)
		{
			users.updateUser(message.getUser());
		}

		@Override
		public void userDisconnected(MessageUserDisconnected message)
		{
			// Not used
		}

		@Override
		public void conversationOpened(MessageConversationOpened message)
		{
			// Not used

		}

		@Override
		public void conversationUpdated(MessageConversationUpdated message)
		{
			// TODO Auto-generated method stub
		}

	}
}
