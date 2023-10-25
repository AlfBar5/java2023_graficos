package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtNumero1;
	private JTextField jtNumero2;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
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
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlNumero1 = new JLabel("NÚMERO 1:");
		jlNumero1.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
		jlNumero1.setBounds(30, 35, 79, 21);
		contentPane.add(jlNumero1);
		
		JLabel jlNumero2 = new JLabel("NÚMERO 2:");
		jlNumero2.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
		jlNumero2.setBounds(30, 95, 79, 21);
		contentPane.add(jlNumero2);
		
		jtNumero1 = new JTextField();
		jtNumero1.setFont(new Font("Verdana Pro", Font.PLAIN, 14));
		jtNumero1.setBounds(140, 37, 86, 20);
		contentPane.add(jtNumero1);
		jtNumero1.setColumns(10);
		
		jtNumero2 = new JTextField();
		jtNumero2.setFont(new Font("Verdana Pro", Font.PLAIN, 14));
		jtNumero2.setColumns(10);
		jtNumero2.setBounds(140, 95, 86, 20);
		contentPane.add(jtNumero2);
		
		
		JLabel jlResultado = new JLabel("");
		
		//EVENTO BOTÓN SUMAR
		JButton jbSumar = new JButton("SUMAR");
		jbSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlResultado.setText(
								Integer.parseInt(jtNumero1.getText())
								+
								Integer.parseInt(jtNumero2.getText())+"");
				
			}
		});
		
		
		jbSumar.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		jbSumar.setBounds(30, 180, 89, 23);
		contentPane.add(jbSumar);
		
		JButton jbMultiplicar = new JButton("MULTIPLICAR");
		jbMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jlResultado.setText(
						Integer.parseInt(jtNumero1.getText())
						*
						Integer.parseInt(jtNumero2.getText())+"");
				
			}
		});
		
		jbMultiplicar.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		jbMultiplicar.setBounds(137, 180, 127, 23);
		contentPane.add(jbMultiplicar);
		
		//Cambiar this por JCalculadora.this
		JButton jbSalir = new JButton("SALIR");
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp=JOptionPane.showConfirmDialog(JCalculadora.this, "¿Desea salir?", "Alerta", JOptionPane.YES_NO_OPTION);
				if(resp==JOptionPane.YES_OPTION) {
					 JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR EL PROGRAMA");
					 JCalculadora.this.dispose();
				        
				}else{
					//si dice que no, no hago nada
				}
				
								
			}
		});
		
		
		jbSalir.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		jbSalir.setBounds(282, 180, 89, 23);
		contentPane.add(jbSalir);
		
		
		jlResultado.setFont(new Font("Verdana Pro", Font.BOLD, 14));
		jlResultado.setBounds(263, 68, 70, 30);
		contentPane.add(jlResultado);
	}
}
