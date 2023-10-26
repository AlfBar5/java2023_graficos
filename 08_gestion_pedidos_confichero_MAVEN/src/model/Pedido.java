package model;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter



/*
Aplicación de pedidos

Un pedido se caracteriza por: producto,fechaPedido,precio

1.- Alta pedido
2.- Pedido más reciente
3.- Pedidos por precio inferior
4.- Se solicita una cantidad de meses y el programa nos muestra los pedidos anteriores a ese número de meses introducidos
4.- Salir

*/

public class Pedido {
	private String producto;
	private LocalDate fechaPedido;
	private double precio;
	
	
}
