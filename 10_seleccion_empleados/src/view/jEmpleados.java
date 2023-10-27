package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adapters.ListaDepartamentosModel;
import view.adapters.TablaEmpleadosModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;


public class jEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbEmpleados;
	private JTable cbDepartamentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jEmpleados frame = new jEmpleados();
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
	public jEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 94, 404, 156);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		
		JLabel lblNewLabel = new JLabel("EMPLEADOS:");
		lblNewLabel.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 61, 135, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblSeleccionarDepartamento = new JLabel("SELECC. DEPARTAMENTO:");
		lblSeleccionarDepartamento.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		lblSeleccionarDepartamento.setBounds(20, 11, 179, 22);
		contentPane.add(lblSeleccionarDepartamento);
		
		
		//COMBOBOX
		JComboBox cbDepartamentos = new JComboBox();
		
		//capturar un evento del combo para saber qué item pinchamos (EN DISEÑO: PROPERTIIES: item/stateChanged y doble click)
		cbDepartamentos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbDepartamentos.getSelectedIndex()==0) {
					tbEmpleados.setModel(new TablaEmpleadosModel());
				}else {
					//llama a todos los empleados de un departamento, constructor sobrecargaro con un parámetro:
					tbEmpleados.setModel(new TablaEmpleadosModel(cbDepartamentos.getSelectedItem().toString()));
				}
				
			}
		});
		cbDepartamentos.setBounds(218, 12, 179, 22);
		contentPane.add(cbDepartamentos);
		cbDepartamentos.setModel(new ListaDepartamentosModel());
		
		
		
	}
}
