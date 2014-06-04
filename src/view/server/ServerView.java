package view.server;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.AbstractView;
import network.server.Server;
import network.server.event.ChangeEvent;
import network.server.event.ClientEvent;
import network.server.event.ServerListener;
import log.ServerLogger;
import controller.AbstractController;
import controller.ServerController;


/**
 * ServerApp est l'application chat côté serveur
 * @author DM
 */
public class ServerView extends AbstractView implements ServerListener
{
	private JFrame frame;
	private Logger logger;
	private JTextArea areaLog;
	
	public ServerView(AbstractController controller)
	{
		super(controller);
		
		// Frame
		frame = new JFrame();
		 
		// Paramètre la zone d'affichage des logs
		areaLog = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(areaLog); 
		areaLog.setEditable(false);
		frame.add(areaLog);
		
		// Logger
		logger = ServerLogger.getLogger(areaLog);
		
		// Paramètre la JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 600);
		frame.setTitle("Serveur de chat");
		frame.setVisible(true);
	}
	
	public ServerController getController()
	{
		return (ServerController) super.getController(); 
	}

	public void stateChanged(ChangeEvent e)
	{
		Server server = (Server)e.getSource();
		switch (server.getState())
		{
			case ENABLE:
				logger.info("Serveur actif. " + server.getStateMessage());
				break;
			case DISABLE:
				logger.warning("Serveur inactif. " + server.getStateMessage());
				break;
			case PENDING:
				logger.info("Serveur en attente... " + server.getStateMessage() );
				break;
			default:
				break;
		}	
	}

	public void clientConnected(ClientEvent e)
	{
		logger.info("Nouveau client");
	}
}
