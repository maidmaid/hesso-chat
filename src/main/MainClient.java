package main;

import model.ClientModel;
import controller.ClientController;

public class MainClient
{
	public static void main(String[] args)
	{
		ClientModel model = new ClientModel();
		ClientController controller = new ClientController(model);
	}
}
