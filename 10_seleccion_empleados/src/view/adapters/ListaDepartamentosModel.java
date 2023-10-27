package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.EmpleadosService;

public class ListaDepartamentosModel extends DefaultComboBoxModel<String> {
	
	// List<String> departamentos;
	ArrayList<String> departamentos;
	
	public ListaDepartamentosModel() {
		
		//instanciamos pedidos service
		//Convertimos List a ArrayList (este funciona con Collect(Collector) y con toList()
		departamentos=new ArrayList<>(new EmpleadosService().verDepartamentos());
		//añadimos al combobox el todos para que muestre todos los departamentos
		departamentos.add(0, "-TODOS-");
	}

	@Override
	public int getSize() {
		return departamentos.size();
	}

	@Override
	public String getElementAt(int index) {
		return departamentos.get(index);
	}
	
	
	

}
