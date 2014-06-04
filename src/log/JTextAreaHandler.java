package log;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import javax.swing.JTextArea;

public class JTextAreaHandler extends Handler
{
	private JTextArea textArea;
	
	public JTextAreaHandler(JTextArea textArea)
	{
		super();
		this.textArea = textArea;
	}
	
	@Override
	public void publish(LogRecord record)
	{
		textArea.append(getFormatter().format(record));
	}

	@Override
	public void flush()
	{
		
	}

	public void close() throws SecurityException
	{
		
	}
}
