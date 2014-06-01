package message.decoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.xml.bind.DatatypeConverter;
import message.MessageInterface;
import message.MessageNewUser;

public class MessageDecoder extends MessageDecoderAbstract
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
		
		if(message.getClass() == MessageNewUser.class)
		{
			fireNewUserReceived((MessageNewUser) message);
		}
	}
}
