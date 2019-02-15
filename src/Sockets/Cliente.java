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
	
	private String operador;
	
	public void Iniciar()
	{
		
		try {
			
			sc = new Socket(HOST, PUERTO);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			operador = null;
			
			mensaje = "";
		}catch (Exception e) {
			
		}
		
	}
	
	public String enviarYRecibirMensajes(String pMensaje)
	{
		try {
			
			out.writeUTF(darFormatoServidor(operador, pMensaje));
			mensaje = in.readUTF();
			System.out.println(mensaje);
			return mensaje;
		}catch (Exception e) {
			
		}
		return mensaje;
		
	}
	
	public void cambiarOperador(String pOperador)
	{
		operador = pOperador;
	}
	
	public String darOperador()
	{
		return operador;
	}
	
	//Recibe el operador y el mensaje para dar el formato que necesita el servidor
	public String darFormatoServidor(String pOperador, String pMensaje)
	{
		String msg = null;
		String[] partesMensaje = null;
		
		if(pOperador.equals("r"))
		{
			partesMensaje = pMensaje.split("-");
			msg = partesMensaje[0] + "r" + partesMensaje[1] + "r";
		}else if(pOperador.equals("s"))
		{
			partesMensaje = pMensaje.split("\\+");
			msg = partesMensaje[0] + "s" + partesMensaje[1] + "s";
		}else if(pOperador.equals("m"))
		{
			partesMensaje = pMensaje.split("\\*");
			msg = partesMensaje[0] + "m" + partesMensaje[1] + "m";
		}else if(pOperador.equals("d"))
		{
			partesMensaje = pMensaje.split("\\/");
			msg = partesMensaje[0] + "d" + partesMensaje[1] + "d";
		}
		
		return msg;
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
