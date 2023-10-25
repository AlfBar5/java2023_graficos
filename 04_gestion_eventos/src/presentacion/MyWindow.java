package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



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
		
		
		//creamos objetos
		JButton jb1=new JButton("Pulsar aquí");
		JLabel jl1 = new JLabel();
		
		jb1.setBounds(100, 50, 150, 40); //tamaño y posición
		jl1.setBounds(120, 120, 300, 30);
		
		this.add(jb1);  //añadir el botón al contenedor;
		this.add(jl1);
		
		
		/******* EVENTOS ********/
		//implementacion de la interfaz funcional
		//ActionListener l = a->jl1.setText("se ha pulsado el botón");
		//asociamos objeto manejador al origen del evento
		//jb1.addActionListener(l);
		
		//la expresión lambda contiene la definición de la clase y la creación del objeto
		//Las lambdas son implementaciones de interfaces funcionales
		//esto es lo que se ejecuta cuando se pulsa el botón jb1 // aparece la label jl1
		jb1.addActionListener(a->jl1.setText("se ha pulsado el botón"));
		
		//setText - muestra texto
		//getTest - coje texto
		
		
	}
	
	
	
	
	
	
	
	
	
}
