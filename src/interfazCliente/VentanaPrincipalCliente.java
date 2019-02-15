package interfazCliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import Sockets.Cliente;

public class VentanaPrincipalCliente extends JFrame {

	
	private PanelCalculadora panelCalculadora; 
	
	private Cliente socketCliente;

	public VentanaPrincipalCliente() {
		
		panelCalculadora = new PanelCalculadora(this);
		add(panelCalculadora, BorderLayout.CENTER);
		
		socketCliente = new Cliente();
		socketCliente.Iniciar();
		
	}
	
	public void enviarMensajeServidor(String pMensaje)
	{
		socketCliente.enviarYRecibirMensajes(pMensaje);
	}
	

	public static void main(String[] args) {
		VentanaPrincipalCliente ven = new VentanaPrincipalCliente();
		ven.setVisible(true);
		ven.setSize(new Dimension(500, 500));
		ven.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ven.setResizable(false);
	}

}
