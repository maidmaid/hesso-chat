package network.message.decoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.bind.DatatypeConverter;

import network.message.MessageIdAssigned;
import network.message.MessageInterface;
import network.message.MessageUserChanged;

public class MessageDecoder extends AbstractMessageDecoder
{	
	public void decode(String messageSerialized)
	{
		byte b[] = DatatypeConverter.parseBase64Binary(messageSerialized);
		ByteArrayInputStream bi = new ByteArrayInputStream(b);
		ObjectInputStream si;
		MessageInterface message = null;
		
		try
		{
			si = new ObjectInputStream(bi);
			message = (MessageInterface) si.readObject();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		if(message.getClass() == MessageIdAssigned.class)
		{
			fireIdAssigned((MessageIdAssigned) message);
		}
		else if(message.getClass() == MessageUserChanged.class)
		{
			fireUserChanged((MessageUserChanged) message);
		}
	}
}
