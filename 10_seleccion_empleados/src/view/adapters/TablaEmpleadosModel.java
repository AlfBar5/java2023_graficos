package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Empleado;
import service.EmpleadosService;

public class TablaEmpleadosModel extends AbstractTableModel {

	List<Empleado> empleados;
	
	
	//definimos el número de columnas como constante
	final int COLS=3;
	private int column;
	
	
	//Constructor
	public TablaEmpleadosModel() {
		empleados= new EmpleadosService().empleados();
	}

	//constructor sobrecargado con un parámetro
	//carga los empleados por departamento
	public TablaEmpleadosModel(String dep) {
		empleados= new EmpleadosService().empleadosPorDepartamento(dep);
	}
	
	
	//para que salgan los métodos de abajo
	///Botón derecho sobre el código
	//source/override/implement methods
	
	
	
	
	//Número de filas, igual al size de la lista empleados
	@Override
	public int getRowCount() {
		
		return empleados.size();
	}
	

	//Número de las columnas
	@Override
	public int getColumnCount() {
		// Le decimos el numero de columnas. en este caso 4
		return COLS;
	}
	
	
	//Nombres de las columnas
	@Override
	public String getColumnName(int column) {
		//funciona en java 17
		return switch(column) {
		case 0->"Nombre";
		case 1->"Email";
		case 2->"Salario";
		default->"Indeterminada";
		};
		
		
		////para java 8
		/*
		 * 
		 switch(column){
		 case 0:
		 	return "Nombre";
		 case 1:
		 	return "Email";
		 case 2:
		 	return "Salario";
		 case 3:
		 	return "Departamento";
		 default:
		 	return "Indeterminada";
		 }
		 
		 */

	}
	
	
	//Coje los valores que tienen que pintarse en cada fila/columna
	@Override
	public Object getValueAt(int row, int column) {

		switch(column){
		 case 0:
		 	return empleados.get(row).getNombre();
		 case 1:
		 	return empleados.get(row).getEmail();
		 case 2:
		 	return empleados.get(row).getSalario();
		 default:
		 	return null;
		 }
		
	}
	

	
	// le damos el índice de cada columna y nos devuelve el tipo de lo que hay dentro de la columna
	// <?> puede ser un class de cualquier tipo
	//la clase Class son metadatos, es información sobre la propia clase.
	@Override
	public Class<?> getColumnClass(int columnIndex) {

		switch(column){
		 case 0:
		 	return String.class;
		 case 1:
		 	return String.class;
		 case 2:
		 	return Double.class;
		 default:
		 	return null;
		 }

		
	}
	
	
}
