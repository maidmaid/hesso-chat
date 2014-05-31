package archives.network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Console du serveur");
		ServerSocket server = null;
		try
		{
			server = new ServerSocket(4500);
			System.out.println("En attente d'un client");
			
			Socket client = server.accept();
			System.out.println("Client connecté");
			
			// Facteur
			OutputStream outputStream = client.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream);
			
			// Apprenti
			InputStream inputStream = client.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader in = new BufferedReader(inputStreamReader);
			
			// Secretaire qui tappe la lettre
			InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 4500);
			String hostname = inetSocketAddress.getHostName();
			String ip = server.getInetAddress().toString();
			
			// Le facteur qui va poster la lettre
			out.println("Mon nom c'est " + hostname + " et mon ip c'est " + ip);
			out.flush();
			
			// L'apprenti récupère le courrier
			String message = in.readLine();
			System.out.println("Message du client: " + message);
			
			server.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
