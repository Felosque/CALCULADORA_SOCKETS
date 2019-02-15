package interfazCliente;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PanelCalculadora extends JPanel implements ActionListener{

	private JTextField operaciones;
	
	private JButton bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	
	private JButton btMultiplicar, btDividir, btRestar, btSumar;
	
	private JButton btAtras, btBorrar, btIgual;
	
	private JLabel titulo;
	
	private VentanaPrincipalCliente interfaz;
	
	public static final Color COLOR_BOTONES = new Color(23, 65, 72);
	
	public static final Color COLOR_LETRAS = new Color(139, 200, 129);
	
	public static final Font LETRA = new Font("Arial", Font.BOLD, 25);
	
	
	public PanelCalculadora(VentanaPrincipalCliente pInterfaz) {
		
		interfaz = pInterfaz;
		
		setLayout(new GridLayout(2, 1));
		
		JPanel contenedorVisual = new JPanel();
		contenedorVisual.setLayout(new GridLayout(2,1));
		
		operaciones = new JTextField();
		operaciones.setEditable(false);
		operaciones.setForeground(COLOR_LETRAS);
		operaciones.setBackground(COLOR_BOTONES);
		operaciones.setFont(LETRA);
		
		titulo = new JLabel("CALCULADORA DE DOS NUMEROS");
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("TAHOMA", Font.BOLD, 20));
		
		contenedorVisual.add(titulo);
		contenedorVisual.add(operaciones);
		add(contenedorVisual);
		
		
		JPanel contenedorBotones = new JPanel();
		contenedorBotones.setLayout(new GridLayout(1, 3));
		
		JPanel contenedorBtNumeros = new JPanel();
		contenedorBtNumeros.setLayout(new GridLayout(4, 3));
		Border bordejpanel2 = new TitledBorder(new EtchedBorder(), "Numeros");
		contenedorBtNumeros.setBorder(bordejpanel2); 
		
		bt7 = new JButton("7");
		bt7.addActionListener(this);
		bt7.setActionCommand("bt7");
		bt7.setBackground(COLOR_BOTONES);
		bt7.setForeground(COLOR_LETRAS);
		bt7.setFont(LETRA);
		contenedorBtNumeros.add(bt7);
		
		bt8 = new JButton("8");
		bt8.addActionListener(this);
		bt8.setActionCommand("bt8");
		bt8.setBackground(COLOR_BOTONES);
		bt8.setForeground(COLOR_LETRAS);
		bt8.setFont(LETRA);
		contenedorBtNumeros.add(bt8);
		
		bt9 = new JButton("9");
		bt9.addActionListener(this);
		bt9.setActionCommand("bt9");
		bt9.setBackground(COLOR_BOTONES);
		bt9.setForeground(COLOR_LETRAS);
		bt9.setFont(LETRA);
		contenedorBtNumeros.add(bt9);
		
		bt4 = new JButton("4");
		bt4.addActionListener(this);
		bt4.setActionCommand("bt4");
		bt4.setBackground(COLOR_BOTONES);
		bt4.setForeground(COLOR_LETRAS);
		bt4.setFont(LETRA);
		contenedorBtNumeros.add(bt4);
		
		bt5 = new JButton("5");
		bt5.addActionListener(this);
		bt5.setActionCommand("bt5");
		bt5.setBackground(COLOR_BOTONES);
		bt5.setForeground(COLOR_LETRAS);
		bt5.setFont(LETRA);
		contenedorBtNumeros.add(bt5);
		
		bt6 = new JButton("6");
		bt6.addActionListener(this);
		bt6.setActionCommand("bt6");
		bt6.setBackground(COLOR_BOTONES);
		bt6.setForeground(COLOR_LETRAS);
		bt6.setFont(LETRA);
		contenedorBtNumeros.add(bt6);
		
		bt1 = new JButton("1");
		bt1.addActionListener(this);
		bt1.setActionCommand("bt1");
		bt1.setBackground(COLOR_BOTONES);
		bt1.setForeground(COLOR_LETRAS);
		bt1.setFont(LETRA);
		contenedorBtNumeros.add(bt1);
		
		bt2 = new JButton("2");
		bt2.addActionListener(this);
		bt2.setActionCommand("bt2");
		bt2.setBackground(COLOR_BOTONES);
		bt2.setForeground(COLOR_LETRAS);
		bt2.setFont(LETRA);
		contenedorBtNumeros.add(bt2);
		
		bt3 = new JButton("3");
		bt3.addActionListener(this);
		bt3.setActionCommand("bt3");
		bt3.setBackground(COLOR_BOTONES);
		bt3.setForeground(COLOR_LETRAS);
		bt3.setFont(LETRA);
		contenedorBtNumeros.add(bt3);
		
		bt0 = new JButton("0");
		bt0.addActionListener(this);
		bt0.setActionCommand("bt0");
		bt0.setBackground(COLOR_BOTONES);
		bt0.setForeground(COLOR_LETRAS);
		bt0.setFont(LETRA);
		contenedorBtNumeros.add(bt0);
		
		contenedorBotones.add(contenedorBtNumeros);
		
		
		JPanel contenedorOperaciones = new JPanel();
		contenedorOperaciones.setLayout(new GridLayout(2, 2));
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Operaciones");
        contenedorOperaciones.setBorder(bordejpanel); 
		
		btMultiplicar = new JButton("*");
		btMultiplicar.addActionListener(this);
		btMultiplicar.setActionCommand("btMultiplicar");
		btMultiplicar.setBackground(COLOR_BOTONES);
		btMultiplicar.setForeground(COLOR_LETRAS);
		btMultiplicar.setFont(LETRA);
		contenedorOperaciones.add(btMultiplicar);
		
		btDividir = new JButton("/");
		btDividir.addActionListener(this);
		btDividir.setActionCommand("btDividir");
		btDividir.setBackground(COLOR_BOTONES);
		btDividir.setForeground(COLOR_LETRAS);
		btDividir.setFont(LETRA);
		contenedorOperaciones.add(btDividir);
		
		btRestar = new JButton("-");
		btRestar.addActionListener(this);
		btRestar.setActionCommand("btRestar");
		btRestar.setBackground(COLOR_BOTONES);
		btRestar.setForeground(COLOR_LETRAS);
		btRestar.setFont(LETRA);
		contenedorOperaciones.add(btRestar);
		
		btSumar = new JButton("+");
		btSumar.addActionListener(this);
		btSumar.setActionCommand("btSumar");
		btSumar.setBackground(COLOR_BOTONES);
		btSumar.setForeground(COLOR_LETRAS);
		btSumar.setFont(LETRA);
		contenedorOperaciones.add(btSumar);
		
		contenedorBotones.add(contenedorOperaciones);
		
		//Contenedor botones guia
		
		JPanel contenedorBtGuia01 = new JPanel();
		contenedorBtGuia01.setLayout(new GridLayout(2, 1));
		Border bordejpanel3 = new TitledBorder(new EtchedBorder(), "Modificaciones");
		contenedorBtGuia01.setBorder(bordejpanel3); 
		
		JPanel contenedorBtGuia02 = new JPanel();
		contenedorBtGuia02.setLayout(new GridLayout(1, 2));
		
		btAtras = new JButton("<-");
		btAtras.addActionListener(this);
		btAtras.setActionCommand("btAtras");
		btAtras.setBackground(COLOR_BOTONES);
		btAtras.setForeground(COLOR_LETRAS);
		btAtras.setFont(LETRA);
		contenedorBtGuia02.add(btAtras);
		
		btBorrar = new JButton("C");
		btBorrar.addActionListener(this);
		btBorrar.setActionCommand("btBorrar");
		btBorrar.setBackground(COLOR_BOTONES);
		btBorrar.setForeground(COLOR_LETRAS);
		btBorrar.setFont(LETRA);
		contenedorBtGuia02.add(btBorrar);
		
		contenedorBtGuia01.add(contenedorBtGuia02);
		
		btIgual = new JButton("=");
		btIgual.addActionListener(this);
		btIgual.setActionCommand("btIgual");
		btIgual.setBackground(COLOR_BOTONES);
		btIgual.setForeground(COLOR_LETRAS);
		btIgual.setFont(LETRA);
		contenedorBtGuia01.add(btIgual);
		
		contenedorBotones.add(contenedorBtGuia01);
		
		add(contenedorBotones);
	}


	public void deshabilitarBotones(boolean pP)
	{
		if(pP == true)
		{
			btSumar.setEnabled(false);
			btRestar.setEnabled(false);
			btMultiplicar.setEnabled(false);
			btDividir.setEnabled(false);
		}else
		{
			btSumar.setEnabled(true);
			btRestar.setEnabled(true);
			btMultiplicar.setEnabled(true);
			btDividir.setEnabled(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("bt0"))
		{
			operaciones.setText(operaciones.getText() + "0");
		} else if(comando.equals("bt1"))
		{
			operaciones.setText(operaciones.getText() + "1");
		}else if(comando.equals("bt2"))
		{
			operaciones.setText(operaciones.getText() + "2");
		}else if(comando.equals("bt3"))
		{
			operaciones.setText(operaciones.getText() + "3");
		}else if(comando.equals("bt4"))
		{
			operaciones.setText(operaciones.getText() + "4");
		}else if(comando.equals("bt5"))
		{
			operaciones.setText(operaciones.getText() + "5");
		}else if(comando.equals("bt6"))
		{
			operaciones.setText(operaciones.getText() + "6");
		}else if(comando.equals("bt7"))
		{
			operaciones.setText(operaciones.getText() + "7");
		}else if(comando.equals("bt8"))
		{
			operaciones.setText(operaciones.getText() + "8");
		}else if(comando.equals("bt9"))
		{
			operaciones.setText(operaciones.getText() + "9");
		}
		else if(comando.equals("btMultiplicar"))
		{
			operaciones.setText(operaciones.getText() + "*");
			deshabilitarBotones(true);
		}
		else if(comando.equals("btDividir"))
		{
			operaciones.setText(operaciones.getText() + "/");
			deshabilitarBotones(true);
		}
		else if(comando.equals("btSumar"))
		{
			operaciones.setText(operaciones.getText() + "+");
			deshabilitarBotones(true);
		}
		else if(comando.equals("btRestar"))
		{
			operaciones.setText(operaciones.getText() + "-");
			deshabilitarBotones(true);
		}
		else if(comando.equals("btBorrar"))
		{
			if(operaciones.getText().equals(""))
			{}else
			{
				operaciones.setText("");
			deshabilitarBotones(false);
			}
		}else if(comando.equals("btIgual"))
		{
			interfaz.enviarMensajeServidor(operaciones.getText());
		}
		else if(comando.equals("btAtras"))
		{
			if(operaciones.getText().equals("")){
			}else
			{
				String caracter = operaciones.getText().substring(operaciones.getText().length() - 1, operaciones.getText().length());
				if(caracter.equals("*") || caracter.equals("/") || caracter.equals("+") || caracter.equals("-")) {
					deshabilitarBotones(false);
				}
				operaciones.setText( operaciones.getText().substring(0, operaciones.getText().length() - 1));
			}
		}
	}


}
