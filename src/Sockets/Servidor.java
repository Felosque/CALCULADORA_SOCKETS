package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import interfazCliente.VentanaPrincipalCliente;
import interfazServidor.VentanaPrincipalServidor;

public class Servidor {
	
	public ServerSocket servidor = null;
	
	public Socket sc = null;
	
	public DataInputStream in;
	public DataOutputStream out;
	
	int puerto = 1002;
	
	public VentanaPrincipalServidor interfazMensajes;
	
	public Servidor(VentanaPrincipalServidor pInterfaz)
	{
		interfazMensajes = pInterfaz;
	}
	
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
				interfazMensajes.mostrarMensajePorInterfaz(mensaje);
				String mensajeSalida = "";
				
				if(mensaje.equals("exit"))
				{
					sc.close();
				}else {
					 
					String operador = mensaje.substring(mensaje.length() - 1, mensaje.length());
					
					int[] numeros = darNumeros(mensaje, operador);
					if(operador.equals("r"))
					{
						mensajeSalida =  String.valueOf( realizarResta(numeros[0], numeros[1]) );
					}else if(operador.equals("s"))
					{
						mensajeSalida = String.valueOf( realizarSuma(numeros[0], numeros[1]) );
					}else if(operador.equals("d"))
					{
						mensajeSalida = String.valueOf( realizarDivision(numeros[0], numeros[1]) );
					}else if(operador.equals("m"))
					{
						mensajeSalida = String.valueOf( realizarMultiplicacion(numeros[0], numeros[1]) );
					}
					
				}
				
				out.writeUTF(mensajeSalida);
			}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public int[] darNumeros(String pCadena, String pOperacion)
	{
		try {
			
		int[] numeros = new int[2];
		String[] parts = pCadena.split(pOperacion);
		System.out.println(parts[0] + "" + parts[1]);
		numeros[0] = Integer.parseInt(parts[0]);
		numeros[1] = Integer.parseInt(parts[1]);
		System.out.println("NUMEROS: "+numeros[0] + " -  " + numeros[1] );
		
		return numeros;
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public int realizarResta(int pNumero1, int pNumero2)
	{
		return pNumero1 - pNumero2;
	}
	
	public int realizarSuma(int pNumero1, int pNumero2)
	{
		return pNumero1 + pNumero2;
	}
	
	public int realizarMultiplicacion(int pNumero1, int pNumero2)
	{
		return pNumero1 * pNumero2;
	}
	
	public int realizarDivision(int pNumero1, int pNumero2)
	{
		return pNumero1 / pNumero2;
	}
	

}
