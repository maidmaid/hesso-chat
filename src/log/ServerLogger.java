package log;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.swing.JTextArea;

public class ServerLogger
{
	static ServerFormatter formatter;
	
	public static Logger getLogger(JTextArea textArea)
	{
		Logger logger = Logger.getLogger("ServerLogger");
		ServerFormatter formatter = new ServerFormatter();
		
		JTextAreaHandler textAreaHandlder = new JTextAreaHandler(textArea);
		textAreaHandlder.setFormatter(formatter);
		logger.addHandler(textAreaHandlder);
		
		try
		{
			FileHandler fileHandler = new FileHandler(".\\server.txt", true);         
			fileHandler.setFormatter(formatter);
			logger.addHandler(fileHandler);
		}
		catch(SecurityException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return logger;
	}

	public static class ServerFormatter extends Formatter
	{
		public String format(LogRecord record)
		{
			StringBuffer sb = new StringBuffer();

			// Date
			Date date = new Date(record.getMillis());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			sb.append(simpleDateFormat.format(date));
			sb.append(" ");

			// Level
			sb.append(record.getLevel().getName());
			sb.append(" : ");

			// Message
			sb.append(formatMessage(record));
			sb.append("\r\n");

			return sb.toString();
		}
	}
}
