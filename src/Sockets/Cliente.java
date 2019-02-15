package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
	
	final String HOST = "127.0.0.1";
	final int PUERTO = 1002;
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket sc;
	
	private String mensaje;
	
	public void Iniciar()
	{
		
		try {
			
			sc = new Socket(HOST, PUERTO);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			mensaje = "";
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public String enviarYRecibirMensajes(String pMensaje)
	{
		try {
			
			out.writeUTF(pMensaje);
			mensaje = in.readUTF();
			System.out.println(mensaje);
			return mensaje;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return mensaje;
		
	}
	
	public void cerrarComunicacion()
	{
		try {
			sc.close();	
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
