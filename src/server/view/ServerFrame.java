package server.view;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import server.controller.ServerController;
import server.log.ServerLogger;
import server.network.Server;
import server.network.event.ChangeEvent;
import server.network.event.ServerListener;

/**
 * ServerApp est l'application chat côté serveur
 * @author DM
 */
public class ServerFrame extends JFrame implements ServerListener
{
	private Logger logger;
	private JTextArea areaLog;
	
	/**
	 * Construit l'application chat côté serveur
	 */
	public ServerFrame()
	{	
		// Paramètre la zone d'affichage des logs
		areaLog = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(areaLog); 
		areaLog.setEditable(false);
		add(areaLog);
		
		// Logger
		logger = ServerLogger.getLogger(areaLog);
		
		// Paramètre la JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setTitle("Serveur de chat");
		setVisible(true);
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
}
