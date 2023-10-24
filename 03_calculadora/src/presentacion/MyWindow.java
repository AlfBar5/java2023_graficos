package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		jbSumar.setBounds(50, 175, 130, 30); //tamaño y posición
		this.add(jbSumar);  //añadir el botón al contenedor;
		
		//creamos objeto JButton
		JButton jbMultiplicar=new JButton("MULTIPLICAR");
		jbMultiplicar.setBounds(250, 175, 130, 30); //tamaño y posición
		this.add(jbMultiplicar);  //añadir el botón al contenedor;
		
		JLabel jlNumero1 = new JLabel("NÚMERO 1");
		jlNumero1.setBounds(60, 50, 150, 30);
		this.add(jlNumero1);
				
		JLabel jlNumero2 = new JLabel("NÚMERO 2");
		jlNumero2.setBounds(60, 100, 150, 30);
		this.add(jlNumero2);
		
		JTextField jtNumero1 = new JTextField();
		jtNumero1.setBounds(150, 50, 80, 30);
		this.add(jtNumero1);
		
		JTextField jtNumero2 = new JTextField();
		jtNumero2.setBounds(150, 100, 80, 30);
		this.add(jtNumero2);
		
	}
	
	
	
	
	
	
	
	
	
}
