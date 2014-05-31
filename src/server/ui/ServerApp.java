package server.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import server.chat.ServerChat;
import server.network.Server;
import server.network.event.ChangeEvent;
import server.network.event.ChangeListener;

/**
 * ServerApp est l'application chat côté serveur
 * @author DM
 */
public class ServerApp extends JFrame
{
	private ServerChat chat;
	private JTextArea areaLog;
	
	/**
	 * Construit l'application chat côté serveur
	 */
	public ServerApp()
	{	
		// Paramètre la zone d'affichage des logs
		areaLog = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(areaLog); 
		areaLog.setEditable(false);
		add(areaLog);
		
		// Instancie le server de chat
		chat = new ServerChat();
		chat.getServer().addChangeListener(new ServerChangeListener());
		chat.getServer().start();
		
		// Paramètre la JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setTitle("Serveur de chat");
		setVisible(true);
	}
	
	/**
	 * Listener change server
	 * @author DM
	 */
	public class ServerChangeListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
			Server server = (Server)e.getSource();
			
			switch (server.getState())
			{
				case ENABLE:
					areaLog.append("Serveur actif \n");
					break;
				case DISABLE:
					areaLog.append("Serveur inactif \n");
					break;
				case PENDING:
					areaLog.append("Serveur en attente... \n");
					break;
				default:
					break;
			}
		}
	}
}
