package view.server;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import user.User;
import log.ServerLogger;
import network.message.MessageConversationOpened;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
import network.server.Server;
import network.server.event.ChangeEvent;
import network.server.event.ClientEvent;
import controller.AbstractController;
import controller.ServerController;


/**
 * ServerApp est l'application chat côté serveur
 * @author DM
 */
public class ServerView extends AbstractServerView
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

	@Override
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

	@Override
	public void clientConnected(ClientEvent e)
	{
		logger.info("Nouveau client");
	}

	@Override
	public void idAssigned(MessageIdAssigned message)
	{
		// Not used
	}

	@Override
	public void userChanged(MessageUserChanged message)
	{
		User user = message.getUser();
		logger.info(user.getUsername() + " (" + user.getId() + ") a modifié ses informations utilisateur.");
	}

	@Override
	public void userDisconnected(MessageUserDisconnected message)
	{
		User user = message.getUser();
		logger.info(user.getUsername() + " (" + user.getId() + ") s'est déconnecté.");
	}

	@Override
	public void conversationOpened(MessageConversationOpened message) 
	{
		String users = "";
		
		for (User user : message.getUsers())
		{
			users += user.getUsername() + " (" + user.getId() + ") et ";
		}
		
		users.substring(0, users.length() - 4);
		
		logger.info("Nouvelle discussion entre " + users);
	}
}
