package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pedido;

import javax.swing.JLabel;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import javax.swing.JButton;

import service.PedidosService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jReciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jReciente frame = new jReciente();
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
	public jReciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("PRODUCTO:");
		lblProducto.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lblProducto.setBounds(32, 38, 127, 27);
		contentPane.add(lblProducto);
		
		JLabel lblFecha = new JLabel("FECHA:");
		lblFecha.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lblFecha.setBounds(32, 97, 127, 27);
		contentPane.add(lblFecha);
		
		JLabel lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lblPrecio.setBounds(32, 155, 127, 27);
		contentPane.add(lblPrecio);
		
		JLabel lblProducto2 = new JLabel("");
		lblProducto2.setForeground(new Color(128, 0, 0));
		lblProducto2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProducto2.setBounds(169, 35, 215, 34);
		contentPane.add(lblProducto2);
		
		JLabel lblFecha2 = new JLabel("");
		lblFecha2.setForeground(new Color(128, 0, 0));
		lblFecha2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha2.setBounds(169, 90, 215, 34);
		contentPane.add(lblFecha2);
		
		JLabel lblPrecio2 = new JLabel("");
		lblPrecio2.setForeground(new Color(128, 0, 0));
		lblPrecio2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio2.setBounds(169, 148, 215, 34);
		contentPane.add(lblPrecio2);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cerrar esta ventana jNuevo
				jReciente.this.dispose();
			}
		});
		btnSalir.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		btnSalir.setBounds(161, 215, 113, 35);
		contentPane.add(btnSalir);
		
		
		
		PedidosService pedidosService=new PedidosService();
		
		Pedido pedido=pedidosService.pedidoMasReciente();
							
		lblProducto2.setText(pedido.getProducto());
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaComoCadena = pedido.getFechaPedido().format(formato);
		lblFecha2.setText(fechaComoCadena);
		
		//otra forma de pasar fecha a string
		//lblFecha2.setText(pedido.getFechaPedido().toString());
		
		//pasar a string añadiendo +""
		lblPrecio2.setText(pedido.getPrecio()+"");
		
		//ponemos visible la ventana
		this.setVisible(true);
		
	}

}
