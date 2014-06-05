package view.client.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import user.User;
import user.UserManager;

public class UsersModelTable extends AbstractTableModel
{
	private String[] headers = {"ID", "Username"};
	private UserManager users;

	public UsersModelTable ()
	{
		super();
		this.users = new UserManager();
	}

	public int getRowCount() {
		return users.size();
	}

	public int getColumnCount() {
		return headers.length;
	}
	
	public UserManager getUserManager()
	{
		return users;
	}

	@Override
	public String getColumnName(int column)
	{
		return headers[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		switch(columnIndex)
		{
		case 0:
			return users.get(rowIndex).getId();
		case 1:
			return users.get(rowIndex).getUsername();
		default:    
			return null;
		}
	}
}
