package presentacion;

import javax.swing.JFrame;



public class MyWindow extends JFrame {
	
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
		
		//hacer visible la ventana
		this.setVisible(true);
		
	}
}
