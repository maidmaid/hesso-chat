package archives.network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Console du client");
		
		for(int port = 4499; port < 4505; port++)
		{
			try
			{
				System.out.println("Je recherche le serveur");
				Socket client = new Socket("127.0.0.1", port);
				
				// Facteur
				OutputStream outputStream = client.getOutputStream();
				PrintWriter out = new PrintWriter(outputStream);
				
				// Apprenti
				InputStream inputStream = client.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader in = new BufferedReader(inputStreamReader);
				
				// L'apprenti récupère le courrier
				String message = in.readLine();
				System.out.println("Message du serveur: " + message);
				
				// Secretaire qui tappe la lettre
				InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 4500);
				String hostname = inetSocketAddress.getHostName();
				String ip = client.getInetAddress().toString();
				
				// Le facteur qui va poster la lettre
				out.println("Mon nom c'est " + hostname + " et mon ip c'est " + ip);
				out.flush();
				
				client.close();
				System.out.println("J'ai trouvé et mouru un petit peu");
				
				break;
			}
			catch(UnknownHostException e)
			{
				System.out.println("pas trouvé");
			}
			catch(IOException e)
			{
				System.out.println("erreur cheloue");
			}			
		}
	}
}
