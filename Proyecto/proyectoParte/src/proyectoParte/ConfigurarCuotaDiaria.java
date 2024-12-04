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
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class ConfigurarCuotaDiaria extends JFrame implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6833004818158422983L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField txtCuota;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarCuotaDiaria frame = new ConfigurarCuotaDiaria();
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
	public ConfigurarCuotaDiaria() {
		addWindowListener(this);
		setTitle("Configurar Cuota Diaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
		lblNewLabel.setBounds(29, 59, 285, 45);
		contentPane.add(lblNewLabel);
		
		txtCuota = new JTextField();
		txtCuota.setBounds(348, 62, 224, 45);
		contentPane.add(txtCuota);
		txtCuota.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBackground(Color.CYAN);
		btnAceptar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnAceptar.setBounds(746, 23, 150, 33);
		contentPane.add(btnAceptar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnCerrar.setBackground(Color.CYAN);
		btnCerrar.setBounds(746, 71, 150, 33);
		contentPane.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		PaginaPrincipal.cuotaDiaria = Double.parseDouble(txtCuota.getText());
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
		txtCuota.setText(Double.toString(PaginaPrincipal.cuotaDiaria));
	}
}
