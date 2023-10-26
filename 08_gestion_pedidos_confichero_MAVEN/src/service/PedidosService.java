package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import model.Pedido;

public class PedidosService {
	
	//arrayList que guarda objetos Pedido
	//ArrayList<Pedido> pedidos=new ArrayList<>();
	
	//ruta del fichero donde guardamos pedidos
	String dir="c:\\temp\\pedidosdos.txt";
	
	//creamos path  para no tener que llemarla
	Path path;
	
	//Aprovechamos el constructor de la clase
	//que es lo primero que se ejecuta para hacer comprobaciones
	//podemos crear el fichero txt si no existe, por ejemplo para evitar errores
	
	
	
	
	
	
		
	
	//CONSTRUCTOR
	public PedidosService() {
		//Creamos objeto File
		File fichero = new File(dir);
		if(!fichero.exists()) {
			//si no existe lo creamos. Dando a sounrround con try catch, nos lo crea
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//Crear interfaz Path, para poder acceder a sus métodos
		path=Path.of(dir);
		
		
	}
	
	
	
	
	
	//método getPedidos() de uso interno de esta clase para reducir código
		//este código se repetía en tres últimos métodos y lo hemos puesto en un método private
		private Stream<Pedido> getPedidos(){
				try {
					return 
						Files.lines(path) //Stream<String>
						.map(s->new Pedido(s.split(",")[0],
							LocalDate.parse(s.split(",")[1]),
							Double.parseDouble(s.split(",")[2]))); //Stream<Pedido>
			
				} catch (IOException e) {
						e.printStackTrace();
						return Stream.empty(); //devolvemos un stream vacío si hay excepcion
				} 
			
		}
	
	
	
	
	public void guardarPedido(String producto, LocalDate fechaPedido,double precio) {
		
		String linea=producto+","+fechaPedido+","+precio;
					
		//añade un nuevo producto al txt
		//el modo predeterminado es sobreescritura, perdemos lo anterior
		//para añadir hay que poner la opción (constante): ,StandardOpenOption.APPEND
		//el separador de líneas se hace con lineSeparator()
		try {
			Files.writeString(path,linea+System.lineSeparator(),StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	public Pedido pedidoMasReciente() {
		
		
		// new Pedido(datos[0],LocalDate.parse(datos[1],Double.parseDouble(datos[2])));
			
			return getPedidos() //stream de objetos pedido usando el método private getPedidos
				
				.max((a,b)->a.getFechaPedido().compareTo(b.getFechaPedido())) //comparamos fecha
				//retornamos un pedido o nada
				.orElse(null); //por si viene vacio
		
		
	
						
	}

	
	
	
	//método para mostrar pedido por precio máximo.
	//Mostramos los productos cuyo precio sea menor al introducido por pantalla
	public List<Pedido> pedidosPrecio(double precioMax) {
		
				
			return getPedidos()  //stream de objetos pedido usando el método private getPedidos
				 
				.filter(p->p.getPrecio()<=precioMax) //Stream<Pedido> filtrado
				.toList();
				
		
		
		
	}
	
	
	
	
	
	public List<Pedido> anteriores(int meses){
		
		
		LocalDate referencia=LocalDate.now().minusMonths(meses);

		return getPedidos()  //stream de objetos pedido usando el método private getPedidos
				
				.filter(p->p.getFechaPedido().isBefore(referencia)) //Stream<Pedido> filtrado
				.toList(); //devolvemos una lista de pedidos
		
		
	}
	
	
	
	
	//Mostrar todos los pedidos
	public List<Pedido> todos(){
		return getPedidos() //Stream<Pedido>
				.toList();
	}
	
	
}
