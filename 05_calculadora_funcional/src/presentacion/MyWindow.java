package presentacion;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class MyWindow extends JFrame {
	
	
	//CONSTRUCTOR
	public MyWindow(){
		//configuración ventana personalizada
		//usamos el constructor de la superclase
		
		//título de la ventana
		super("Primera ventana");
		
		//Comportamiento del botón de cierre
		//Provoca que la ventana se cierre al pulsar el botón de cierre. 
		//Si no hay ninguna otra ventana abierta, también se cerrará el programa
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//tamaño y posición de la ventana. Llamamos a un método heredado setBounds
		//cuatro parámetros: x, y, ancho, alto
		this.setBounds(100, 100, 500, 300);
		
		///////////CONTROLES. 
		//Normalmente se llama a un método que carga los controles
		initComponents();
		
		
		//hacer visible la ventana
		this.setVisible(true);
		
		
		
		
	}
	
	
	//Método private donde vamos a crear los controles de la ventana
	private void initComponents() {
		
		//Eliminar gestor de organización: 
		this.setLayout(null);
		
		
		
		
		// creamos un botón
		//creamos objeto JButton
		JButton jbSumar=new JButton("SUMAR");
		jbSumar.setBounds(20, 175, 110, 30); //tamaño y posición
		this.add(jbSumar);  //añadir el botón al contenedor;
		
		//creamos objeto JButton
		JButton jbMultiplicar=new JButton("MULTIPLICAR");
		jbMultiplicar.setBounds(160, 175, 120, 30); //tamaño y posición
		this.add(jbMultiplicar);  //añadir el botón al contenedor;
		
		JLabel jlNumero1 = new JLabel("NÚMERO 1");
		jlNumero1.setBounds(60, 50, 150, 30);
		this.add(jlNumero1);
				
		JLabel jlNumero2 = new JLabel("NÚMERO 2");
		jlNumero2.setBounds(60, 100, 150, 30);
		this.add(jlNumero2);
		
		JLabel jlResultado = new JLabel();
		jlResultado.setBounds(280, 50, 150, 30);
		this.add(jlResultado);
		
		
		JTextField jtNumero1 = new JTextField();
		jtNumero1.setBounds(150, 50, 80, 30);
		this.add(jtNumero1);
		
		JTextField jtNumero2 = new JTextField();
		jtNumero2.setBounds(150, 100, 80, 30);
		this.add(jtNumero2);
		
		//Botón de SALIR
		JButton jbSalir= new JButton("SALIR");
		jbSalir.setBounds(300, 175, 110, 30);
		this.add(jbSalir);
		
		
		
		/******* EVENTOS ********/
		
		jbSumar.addActionListener(a->{
		try{
			jlResultado.setText(
				Integer.parseInt(jtNumero1.getText())
				+
				Integer.parseInt(jtNumero2.getText())+"");
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "De ser un número entero");
		}
			
		});
		
		jbMultiplicar.addActionListener(a->{
			try{
				jlResultado.setText(
				Integer.parseInt(jtNumero1.getText())
				*
				Integer.parseInt(jtNumero2.getText())+"");
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "De ser un número entero");
		}
			
		});
		
		
		//para limpiar el foco de input text cuando pinchemos en el input text
		//LAS EXPRESIONES LAMBDA VALEN PARA INTERFACES QUE TIENEN UN ÚNICO MÉTODO
		//la alternativa es crear una clase anónima. Poner new FocusLinstener y
		//Ayuda CONTROL + Espacio ---> anonimous inner type (y se crean los override
		jtNumero1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				jtNumero1.setText(""); //borra caja de texto 1
			}
		});
		
		
		jtNumero2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				jtNumero2.setText(""); //borra caja de texto 2
			}
		});
		
		
		//Evento salir CERRAR VENTANA con ventana de diálogo. this -->la propia ventana que genera este código
		jbSalir.addActionListener(a->{
			int resp=JOptionPane.showConfirmDialog(this, "¿Desea salir?", "Alerta", JOptionPane.YES_NO_OPTION);
			if(resp==JOptionPane.YES_OPTION) {
				 JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR EL PROGRAMA");
			        this.dispose();
			        
			}else{
				//si dice que no, no hago nada
			}
			});
		
		
	}
	
	
	
	
	
	
	
	
	
}
