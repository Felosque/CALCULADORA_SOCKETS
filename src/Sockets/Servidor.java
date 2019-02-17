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
			interfazMensajes.mostrarMensajePorInterfaz("El servidor ha iniciado correctamente con el puerto: " + puerto);
			
			sc = servidor.accept();
			interfazMensajes.mostrarMensajePorInterfaz("Un cliente se ha conectado el servidor.");
			
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
					
					double[] numeros = darNumeros(mensaje, operador);
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
	
	
	public double[] darNumeros(String pCadena, String pOperacion)
	{
		double[] numeros = new double[2];
		try {
			
		String[] parts = pCadena.split(pOperacion);
		System.out.println(parts[0] + " - " + parts[1]);
		numeros[0] = Double.parseDouble(parts[0]);
		numeros[1] = Double.parseDouble(parts[1]);
		System.out.println("NUMEROS: "+numeros[0] + " -  " + numeros[1] );
		
		return numeros;
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return numeros;
	}
	
	public double realizarResta(double pNumero1, double pNumero2)
	{
		return pNumero1 - pNumero2;
	}
	
	public double realizarSuma(double pNumero1, double pNumero2)
	{
		return pNumero1 + pNumero2;
	}
	
	public double realizarMultiplicacion(double pNumero1, double pNumero2)
	{
		return pNumero1 * pNumero2;
	}
	
	public double realizarDivision(double pNumero1, double pNumero2)
	{
		return pNumero1 / pNumero2;
	}
	

}
