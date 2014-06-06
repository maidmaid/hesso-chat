package view.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import user.User;
import user.UserManager;
import view.client.table.UsersModelTable;

import network.client.event.DisconnectionEvent;
import network.client.event.MessageEvent;
import network.message.MessageConversationOpened;
import network.message.MessageConversationUpdated;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
import controller.AbstractController;

public class ClientConnexionPanel extends AbstractClientView implements ActionListener
{
	private JPanel pnlContainer;
	private JTextField txtIp;
	private JLabel lblIp;
	private JPanel pnlIp;
	private JButton btEnter;
	private String ipAdress;
	private String errorMessage;
	private JTextArea areError;
	private JPanel pnlError;
	private JLabel lblError;
	private JTextField fldUserNameChange;
	private JLabel lblUserNameChange;
	private JPanel pnlUserNameChange;
	private UserManager userManager;
	private String username;

	/**
	 *CHOICE ELEMENT'S PREFIXING :
	 * 
	 * JPanel		:	pnl
	 * JTextField	:	fld
	 * JLabel		:	lbl
	 * JButton 		:	btn
	 * JTextArea	:	are
	 * */

	public ClientConnexionPanel(AbstractController controller)
	{
		super(controller);

		pnlContainer = new JPanel();

		// Initialization of the ip's JLabel
		lblError = new JLabel("Error Message");

		//Initialization of the errorText
		areError = new JTextArea(" ");
		Font policeError = new Font("Ds-digital", Font.TYPE1_FONT,15);
		areError.setFont(policeError);
		areError.setForeground(Color.red);
		pnlContainer.add(new JScrollPane(areError));

		areError.setEditable(false);
		areError.setSize(280, 50);

		pnlError = new JPanel();
		pnlError.setPreferredSize(new Dimension (360,80));
		pnlError.setBackground(Color.white);

		pnlError.add(lblError);
		pnlError.add(areError);
		pnlError.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		pnlError.setVisible(false);
		pnlContainer.add(pnlError, BorderLayout.CENTER);

		// Initialization of username s'change
		lblUserNameChange = new JLabel("Type your userName");
		pnlContainer.add(this.lblUserNameChange, BorderLayout.NORTH);

		//Initialization of the JTextField ipText
		fldUserNameChange = new JTextField();
		Font police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		fldUserNameChange.setFont(police);
		fldUserNameChange.setHorizontalAlignment(JTextField.CENTER);
		fldUserNameChange.setPreferredSize(new Dimension(280,30));
		fldUserNameChange.setMargin(null);           
		fldUserNameChange.setBorder(BorderFactory.createEmptyBorder());

		//Initialization of the ipText's panel
		pnlUserNameChange = new JPanel();
		pnlUserNameChange.setPreferredSize(new Dimension(360,50));
		pnlUserNameChange.setBackground(Color.white);
		pnlUserNameChange.add(fldUserNameChange);
		pnlUserNameChange.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		pnlContainer.add(pnlUserNameChange, BorderLayout.CENTER);

		// Initialization of the ip's JLabel
		lblIp = new JLabel("Type your IP Address");
		pnlContainer.add(this.lblIp, BorderLayout.NORTH);

		//Initialization of the JTextField username's change
		txtIp = new JTextField("127.0.0.1");
		police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		txtIp.setFont(police);
		txtIp.setHorizontalAlignment(JTextField.CENTER);
		txtIp.setPreferredSize(new Dimension(280,30));
		txtIp.setMargin(null);           
		txtIp.setBorder(BorderFactory.createEmptyBorder());

		//Initialization of the username's change panel
		pnlIp = new JPanel();
		pnlIp.setPreferredSize(new Dimension(360,50));
		pnlIp.setBackground(Color.white);
		pnlIp.add(txtIp);
		pnlIp.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		pnlContainer.add(pnlIp, BorderLayout.CENTER);

		//Initialization of the Enter button
		btEnter = new JButton("Enter");
		pnlContainer.add(btEnter, BorderLayout.SOUTH);
		btEnter.setPreferredSize(new Dimension(360,60));
		btEnter.addActionListener(this);
	}	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btEnter)
		{
			//put the value of fldUserNameChange in the variable username
			username = fldUserNameChange.getText();
			//set the username
			getController().getModel().getUserManager().getMe().setUsername(username);

			pnlError.setVisible(false);

			ipAdress = txtIp.getText();

			try
			{
				getController().getModel().getClient().connect(ipAdress);

			} catch (IOException exception) {
				errorMessage = ("ERREUR " + exception.getMessage());
				System.out.println(errorMessage);
				areError.setText(exception.getMessage());
				areError.revalidate();
				pnlError.setVisible(true);
			}

		}

	}

	public String changeUsername()
	{
		userManager.getMe().setUsername(username);
		return username;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public JPanel getContainer()
	{
		return pnlContainer;
	}

	@Override
	public void messageReceived(MessageEvent e)
	{

	}

	@Override
	public void connexionEstablished() {
		// TODO Auto-generated method stub
	}

	@Override
	public void idAssigned(MessageIdAssigned message) {
		// TODO Auto-generated method stub
	}

	@Override
	public void userChanged(MessageUserChanged message) {
		// TODO Auto-generated method stub
	}

	@Override
	public void disconnectionOccured(DisconnectionEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void userDisconnected(MessageUserDisconnected message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void conversationOpened(MessageConversationOpened message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void conversationUpdated(MessageConversationUpdated message) {
		// TODO Auto-generated method stub
		
	}
}

