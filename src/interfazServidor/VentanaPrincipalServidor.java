package interfazServidor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Sockets.Servidor;

public class VentanaPrincipalServidor extends JFrame {


	private PanelCentral panelCentral;
	
	private Servidor socketServidor;
	
	public VentanaPrincipalServidor() {
		
		panelCentral = new PanelCentral(this);
		add(panelCentral, BorderLayout.CENTER);
		
		socketServidor = new Servidor(this);
		//iniciarServidor();
	}
	
	public void iniciarServidor()
	{
		socketServidor.iniciar();
		mostrarMensajePorInterfaz("El servidor se ha iniciado correctamente en el puerto 1001.");
	}
	
	public void mostrarMensajePorInterfaz(String pMensaje)
	{
		panelCentral.agregarTexto(pMensaje);
	}
	

	public static void main(String[] args) {
		
		VentanaPrincipalServidor ven = new VentanaPrincipalServidor();
		ven.setVisible(true);
		ven.setSize(new Dimension(400, 400));
		ven.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ven.setResizable(false);
		
	}

}
