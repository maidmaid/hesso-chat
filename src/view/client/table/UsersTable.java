package view.client.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import user.User;
import user.UserManager;
import view.client.AbstractClientView;
import view.client.ClientMessageFrame;
import view.client.ClientView;
import network.client.event.DisconnectionEvent;
import network.client.event.MessageEvent;
import network.message.MessageConversationOpened;
import network.message.MessageConversationUpdated;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
import controller.AbstractController;

public class UsersTable extends AbstractClientView implements ActionListener
{
	private JPanel pnlUsers = null;
	private JScrollPane spnTable = null;
	private JTable tblUsers = null;
	private JButton btnAdd = null;
	private Hashtable<Integer, String> hteUsers = null;
	private ClientView client;
	
	public UsersTable(AbstractController controller) {
		super(controller);

		//JPanel's initialization
		pnlUsers = new JPanel();
		pnlUsers.setVisible(true);

		pnlUsers.setLayout(new BorderLayout());
		pnlUsers.setSize(400, 500);
		pnlUsers.setPreferredSize(new Dimension(400,600));

		//JScrollPane's initialization
		spnTable = new JScrollPane();
		spnTable.setViewportView(tblUsers);
		pnlUsers.add(spnTable, BorderLayout.NORTH);

		//JTable's initialization
		tblUsers = new JTable();
		UsersModelTable model = new UsersModelTable();
		tblUsers.setModel(model);
		tblUsers.createDefaultColumnsFromModel();
		pnlUsers.add(tblUsers, BorderLayout.NORTH);
		tblUsers.getSelectionModel().addListSelectionListener(new ListSelectionUsers());

		// JButton's intitialization
		btnAdd = new JButton();
		btnAdd.setPreferredSize(new Dimension(360,50));
		//btnAdd.addActionListener((ActionListener) this);
		pnlUsers.add(btnAdd, BorderLayout.SOUTH);
	}

	private class ListSelectionUsers implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent e)
		{
			int index = e.getFirstIndex();
			int id = (Integer) tblUsers.getModel().getValueAt(index, 0);
			getController().conversationOpened(id);			
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAdd)
		{

		}
	}

	public Container getContainer() 
	{
		return pnlUsers;	
	}

	@Override
	public void messageReceived(MessageEvent e) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void connexionEstablished() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void idAssigned(MessageIdAssigned message) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void userChanged(MessageUserChanged message)
	{
		User user = message.getUser();
		
		// All users without me
		if(getController().getModel().getUserManager().getMe().getId() != user.getId())
		{
			UsersModelTable model = (UsersModelTable) tblUsers.getModel();
			model.getUserManager().updateUser(user);
			model.fireTableDataChanged();
		}
	}

	@Override
	public void disconnectionOccured(DisconnectionEvent e)
	{
		
	}

	@Override
	public void userDisconnected(MessageUserDisconnected message)
	{
		User user = message.getUser();
		UsersModelTable model = (UsersModelTable) tblUsers.getModel();
		model.getUserManager().remove(user);
		tblUsers.setModel(model);
		model.fireTableDataChanged();
	}

	@Override
	public void conversationOpened(MessageConversationOpened message)
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void conversationUpdated(MessageConversationUpdated message)
	{
		// TODO Auto-generated method stub
	}
}
