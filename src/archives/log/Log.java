package log;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger("KikokLog");
		
		FileHandler fileHandler = null;
		try
		{
			fileHandler = new FileHandler("c:/temp/log.xml");
		}
		catch(SecurityException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		logger.addHandler(fileHandler);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Level : ");
		int level = scan.nextInt();
		
		System.out.println("Message : ");
		String message = scan.next();
		
		switch (level)
		{
			case 1:
				logger.info(message);
				break;
			
			case 2:
				logger.warning(message);
				break;

			default:
				break;
		}
	}

}
