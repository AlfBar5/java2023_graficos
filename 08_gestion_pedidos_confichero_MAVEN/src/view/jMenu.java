package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidosService;
import view.adapters.ListaPedidosModel;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

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
		
		//Subir el Jlist arriba si da error
		JList<Pedido> lstPedidos = new JList<>();
		
		//método para hacer algo cuando selecciono un elemento en la lista
		lstPedidos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				//recogida del pedido seleccionado
				Pedido pedido=lstPedidos.getSelectedValue();
				JOptionPane.showMessageDialog(jMenu.this, "Pedido seleccionado"+pedido.getProducto()+" - "+pedido.getFechaPedido()+" - "+pedido.getPrecio());
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 70, 215, 313);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(lstPedidos);
		
		
		//Botón Mostrar todos
		JButton btnMostrarTodos = new JButton("MOSTRAR TODOS");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//instanciamos modelo de datos y se lo asignamos al jList
				ListaPedidosModel model=new ListaPedidosModel();
				lstPedidos.setModel(model);
				
				
				/*
				///Con un textArea
				//creamos la instancia de PedidosService
				PedidosService service = new PedidosService();
				
				//limpiamos la lista antes
				textAreaPedidos.setText("");
				
				//Lista de objetos pedidos textAreaPedidos
				List<Pedido> pedidos=service.todos();
				for(Pedido pedido:pedidos) {
					textAreaPedidos.setText(textAreaPedidos.getText()+pedido.getProducto()+"   --   "+pedido.getFechaPedido()+"   --   "+pedido.getPrecio()+" €"+System.lineSeparator());
				}
				
				*/
				
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
		
		
		
		JLabel lblNewLabel = new JLabel("PEDIDOS:");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		lblNewLabel.setBounds(267, 35, 105, 23);
		contentPane.add(lblNewLabel);
		
		
		//ELIMINA PEDIDO DEL JLIST
		JButton btnEliminarPedido = new JButton("ELIMINAR PEDIDO");
		btnEliminarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				
				//Recoger el pedido seleccionado en el jList
				Pedido pedido= lstPedidos.getSelectedValue();
				
				//llamar al método eliminarPedido() de PedidosService
				PedidosService service= new PedidosService();
				service.eliminarPedido(pedido);
				
				//para actualizar la lista
				lstPedidos.setModel(new ListaPedidosModel());
		
				
			}
			
			
		});
		btnEliminarPedido.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		btnEliminarPedido.setBounds(333, 394, 149, 30);
		contentPane.add(btnEliminarPedido);
		
		
		
		
		
		
		
		this.setVisible(true);
	}
}
