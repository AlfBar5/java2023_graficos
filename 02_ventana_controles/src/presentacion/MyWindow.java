package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;



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
		this.setBounds(10, 10, 500, 300);
		
		///////////CONTROLES. 
		//Normalmente se llama a un método que carga los controles
		initComponents();
		
		
		//hacer visible la ventana
		this.setVisible(true);
		
		
		
		
	}
	
	
	//Método private donde vamos a crear los controles de la ventana
	private void initComponents() {
		
		//Eliminar gestor de organización por defecto: 
		this.setLayout(null);
		
		// creamos un botón
		//creamos objeto JButton
		JButton jb1=new JButton("Pulsar aquí");
		jb1.setBounds(100, 50, 150, 40); //tamaño y posición
		this.add(jb1);  //añadir el botón al contenedor;
	}
	
	
	
	
	
	
	
	
	
}
