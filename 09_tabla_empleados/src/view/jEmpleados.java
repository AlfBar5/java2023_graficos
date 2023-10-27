package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.adapters.TablaEmpleadosModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbEmpleados;

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
		scrollPane.setBounds(20, 44, 404, 165);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		
		JLabel lblNewLabel = new JLabel("EMPLEADOS:");
		lblNewLabel.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 135, 22);
		contentPane.add(lblNewLabel);
		
		
		
		JButton btEmpleados = new JButton("EMPLEADOS");
		btEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//en tabla empleados, cargamos el nuevo objeto TablaEmpleadosModel
				tbEmpleados.setModel(new TablaEmpleadosModel());
			}
		});
		btEmpleados.setBounds(177, 227, 110, 23);
		contentPane.add(btEmpleados);
	}
}
