package proyectoParte;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ConfigurarPorcentajesDeDescuento extends JFrame implements ActionListener, WindowStateListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7578855891119240219L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtPrimero;
	private JTextField txtSegundo;
	private JTextField txtTercero;
	private JTextField txtCuarto;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnCerrar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarPorcentajesDeDescuento frame = new ConfigurarPorcentajesDeDescuento();
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
	public ConfigurarPorcentajesDeDescuento() {
		addWindowListener(this);
		addWindowStateListener(this);
		setTitle("Configurar porcentajes de tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 37, 145, 28);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("6 a 10 unidades");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 78, 125, 32);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("11 a 15 unidades");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 120, 125, 28);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("m\u00E1s de 15 unidades");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(22, 162, 145, 28);
		contentPane.add(lblNewLabel_3);
		
		txtPrimero = new JTextField();
		txtPrimero.addActionListener(this);
		txtPrimero.setBounds(191, 37, 118, 21);
		contentPane.add(txtPrimero);
		txtPrimero.setColumns(10);
		
		txtSegundo = new JTextField();
		txtSegundo.setColumns(10);
		txtSegundo.setBounds(191, 80, 115, 21);
		contentPane.add(txtSegundo);
		
		txtTercero = new JTextField();
		txtTercero.setColumns(10);
		txtTercero.setBounds(191, 120, 115, 21);
		contentPane.add(txtTercero);
		
		txtCuarto = new JTextField();
		txtCuarto.setColumns(10);
		txtCuarto.setBounds(191, 169, 118, 21);
		contentPane.add(txtCuarto);
		
		lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(357, 47, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(357, 84, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("%");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(357, 124, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("%");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(357, 172, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnCerrar.setBackground(Color.CYAN);
		btnCerrar.setBounds(545, 86, 150, 33);
		contentPane.add(btnCerrar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnAceptar.setBackground(Color.CYAN);
		btnAceptar.setBounds(545, 22, 150, 33);
		contentPane.add(btnAceptar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtPrimero) {
			actionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		PaginaPrincipal.porcentaje1 = Double.parseDouble(txtPrimero.getText());
		PaginaPrincipal.porcentaje2 = Double.parseDouble(txtSegundo.getText());
		PaginaPrincipal.porcentaje3 = Double.parseDouble(txtTercero.getText());
		PaginaPrincipal.porcentaje4 = Double.parseDouble(txtCuarto.getText());
	}

	public void windowActivated(WindowEvent e) {
		if (e.getSource() == this) {
			windowActivatedThis(e);
		}
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
	}
	protected void windowActivatedThis(WindowEvent e) {
		txtPrimero.setText(Double.toString(PaginaPrincipal.porcentaje1)); 
		txtSegundo.setText(Double.toString(PaginaPrincipal.porcentaje2));
		txtTercero.setText(Double.toString(PaginaPrincipal.porcentaje3));
		txtCuarto.setText(Double.toString(PaginaPrincipal.porcentaje4));
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}