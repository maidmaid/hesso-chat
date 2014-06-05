package view.client.table;

import javax.swing.table.AbstractTableModel;

import user.User;

public class UsersModelTable extends AbstractTableModel
{
	private String[] headers = {"ID", "Username"};
	private User[] users;

	public UsersModelTable ()
	{
		super();

		users = new User[]{
				new User(),
				new User()
		};
	}

	public int getRowCount() {
		return users.length;
	}

	public int getColumnCount() {
		return headers.length;
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
			return users[rowIndex].getId();
		case 1:
			return users[rowIndex].getUsername();
		default:    
			return null;
		}
	}
}
