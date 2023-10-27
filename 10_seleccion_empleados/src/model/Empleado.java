package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class Empleado {
	
	
	private String nombre;
	private String email;
	private double salario;
	private String departamento;
	

}

//// objeto empleado
// Empleado emp=new Empleado("Víctor","aa@ee.rd"",33.0,"ventas")