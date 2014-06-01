package message;

import java.io.IOException;
import message.decoder.MessageDecoder;
import message.event.MessageListener;

public class MessageTest
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		// Client
		MessageNewUser message = new MessageNewUser("lol");
		System.out.println(message.getUsername());
		String messageSer = message.serialize();
		System.out.println(messageSer);
		
		
		// Seveur
		MessageDecoder messageD = new MessageDecoder();
		messageD.addMessageListener(new MessageListener()
		{	
			public void newUserReceived(MessageNewUser message)
			{
				System.out.println(message.getUsername());
			}
		});
		messageD.decode(messageSer);	
	}
}
