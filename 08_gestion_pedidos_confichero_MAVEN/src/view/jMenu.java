package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidosService;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class jMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jMenu frame = new jMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textAreaPedidos = new JTextArea();
		textAreaPedidos.setBounds(214, 35, 270, 389);
		contentPane.add(textAreaPedidos);
		
		//Boton Nuevo pedido
		JButton btnNuevoPedido = new JButton("NUEVO PEDIDO");
		btnNuevoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new jNuevo();
			}
		});
		
		
		
		btnNuevoPedido.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNuevoPedido.setBounds(20, 35, 178, 36);
		contentPane.add(btnNuevoPedido);
		
		
		
		//Botón Pedido reciente
		JButton btnPedidoReciente = new JButton("PEDIDO RECIENTE");
		btnPedidoReciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new jReciente();
			}
		});
		btnPedidoReciente.setFont(new Font("Verdana", Font.BOLD, 13));
		btnPedidoReciente.setBounds(20, 107, 178, 36);
		contentPane.add(btnPedidoReciente);
		
		
		
		//Botón Mostrar todos
		JButton btnMostrarTodos = new JButton("MOSTRAR TODOS");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//creamos la instancia de PedidosService
				PedidosService service = new PedidosService();
				
				//limpiamos la lista antes
				textAreaPedidos.setText("");
				
				//Lista de objetos pedidos textAreaPedidos
				List<Pedido> pedidos=service.todos();
				for(Pedido pedido:pedidos) {
					textAreaPedidos.setText(textAreaPedidos.getText()+pedido.getProducto()+"   --   "+pedido.getFechaPedido()+"   --   "+pedido.getPrecio()+" €"+System.lineSeparator());
				}
				
			}
		});
		btnMostrarTodos.setFont(new Font("Verdana", Font.BOLD, 13));
		btnMostrarTodos.setBounds(20, 192, 178, 36);
		contentPane.add(btnMostrarTodos);
		
		
		
		//Botón SALIR
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp=JOptionPane.showConfirmDialog(jMenu.this, "¿Desea salir?", "Alerta", JOptionPane.YES_NO_OPTION);
				if(resp==JOptionPane.YES_OPTION) {
					 JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR EL PROGRAMA");
					 jMenu.this.dispose();
				        
				}else{
					//si dice que no, no hago nada
				}
				
			}
		});
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 13));
		btnSalir.setBounds(20, 388, 178, 36);
		contentPane.add(btnSalir);
		
		this.setVisible(true);
	}

}
