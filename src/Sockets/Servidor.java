package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public ServerSocket servidor = null;
	
	public Socket sc = null;
	
	public DataInputStream in;
	public DataOutputStream out;
	
	int puerto = 1002;
	
	public void iniciar()
	{
		try {
		
			servidor = new ServerSocket(puerto);
			System.out.println("Inicia servidor");
			
			sc = servidor.accept();
			System.out.println("Cliente conectado");
			
			while(true)
			{				
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				
				if(mensaje.equals("exit"))
				{
					sc.close();
				}
				
				out.writeUTF("Llego el mensaje gracias.");
			}
			
			
		
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
