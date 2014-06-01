package message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.xml.bind.DatatypeConverter;

public abstract class MessageAbstract implements Serializable, MessageInterface
{		
	public String serialize()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
		
        try
		{
			oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
	        oos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
        
        return DatatypeConverter.printBase64Binary(baos.toByteArray()).toString();
    }
}
