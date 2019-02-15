package interfazServidor;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelCentral extends JPanel implements ActionListener{


	private VentanaPrincipalServidor interfaz;
	
	private JButton btIniciar;
	
	private TextArea jtInfo;
	
	public PanelCentral(VentanaPrincipalServidor pInterfaz) {
		
		setLayout(new GridLayout(2, 1));
		
		interfaz = pInterfaz;
		
		jtInfo = new TextArea(); 
		add(jtInfo);
		
		btIniciar = new JButton("Iniciar servidor");
		btIniciar.setActionCommand("INICIAR");
		btIniciar.addActionListener(this);
		add(btIniciar);
	}

	public void agregarTexto(String pTexto)
	{
		jtInfo.setText(jtInfo.getText()+ "\n" + pTexto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("INICIAR"))
		{
			interfaz.iniciarServidor();
		}
	}

}
