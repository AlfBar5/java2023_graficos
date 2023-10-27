package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Empleado;

public class EmpleadosService {
	
	//Código común para leer el json
	private Stream<Empleado> getEmpleados(){
		String ruta="c:\\temp\\empleados.json";
		Gson gson=new Gson();
		try(FileReader reader=new FileReader(ruta);){
			Empleado[] empleados=gson.fromJson(reader, Empleado[].class);
			return Arrays.stream(empleados);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	
	//Método ver todos los empleados
	public List<Empleado> empleados(){
		return getEmpleados() //Stream<Empleado>
				.collect(Collectors.toList());
	}
	
	
	
	//Método ver departamentos para rellenar el combobox
	public List<String> verDepartamentos(){
		return getEmpleados() //Stream<Empleado>
				.map(r->r.getDepartamento())
				.distinct()
				.collect(Collectors.toList());
	}
	
	
	//ver empleados por departamento
	public List<Empleado> empleadosPorDepartamento(String depart){
		return
				getEmpleados()
				.filter(e->e.getDepartamento().equals(depart)) //Stream<Empleado>
				.collect(Collectors.toList());
		
	}
	
	
}
