package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.PedidosService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class jNuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProducto;
	private JTextField txtFecha;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jNuevo frame = new jNuevo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/

	/**
	 * Create the frame.
	 */
	public jNuevo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("PRODUCTO:");
		lblProducto.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lblProducto.setBounds(24, 38, 120, 31);
		contentPane.add(lblProducto);
		
		JLabel lblFecha = new JLabel("FECHA:");
		lblFecha.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lblFecha.setBounds(24, 93, 120, 31);
		contentPane.add(lblFecha);
		
		JLabel lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lblPrecio.setBounds(24, 150, 120, 31);
		contentPane.add(lblPrecio);
		
		txtProducto = new JTextField();
		txtProducto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//dejamos todo el texto seleccionado
				txtProducto.selectAll();
			}
		});
		txtProducto.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		txtProducto.setBounds(143, 40, 174, 31);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//dejamos todo el texto seleccionado
				txtFecha.selectAll();
			}
		});
		txtFecha.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		txtFecha.setColumns(10);
		txtFecha.setBounds(143, 93, 174, 31);
		contentPane.add(txtFecha);
		
		txtPrecio = new JTextField();
		txtPrecio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//dejamos todo el texto seleccionado
				txtPrecio.selectAll();
			}
		});
		txtPrecio.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(143, 151, 174, 31);
		contentPane.add(txtPrecio);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//creamos la instancia //var es una forma de ahorrar poner el tipo (lo deduce del código del new) sustituye a PedidosService
				var service = new PedidosService();
				
				service.guardarPedido(txtProducto.getText(),
									LocalDate.parse(txtFecha.getText()),
									Double.parseDouble(txtPrecio.getText())
									);
				
				//después de guardar llevamos el cursos al input text de producto
				txtProducto.requestFocus(); //manda el foco a un input text
				
			}
		});
		btnGuardar.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		btnGuardar.setBounds(293, 208, 112, 31);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cerrar esta ventana jNuevo
				jNuevo.this.dispose();
				
			}
		});
		btnSalir.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		btnSalir.setBounds(24, 208, 112, 31);
		contentPane.add(btnSalir);
		
		//ponemos visible la ventana
		this.setVisible(true);
	}

}
