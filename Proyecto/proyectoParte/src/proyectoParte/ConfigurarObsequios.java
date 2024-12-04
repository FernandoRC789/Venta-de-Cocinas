package proyectoParte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class ConfigurarObsequios extends JFrame implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3432724218255780329L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtPrimero;
	private JTextField txtSegundo;
	private JTextField txtTercero;
	private JButton btnAceptar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarObsequios frame = new ConfigurarObsequios();
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
	public ConfigurarObsequios() {
		addWindowListener(this);
		setTitle("Configurar obsequios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("1 unidad");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 11, 98, 19);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("2 a 5 unidades");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 58, 109, 19);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("6 a m\u00E1s unidades");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 112, 124, 19);
		contentPane.add(lblNewLabel_2);
		
		txtPrimero = new JTextField();
		txtPrimero.setBounds(171, 10, 143, 26);
		contentPane.add(txtPrimero);
		txtPrimero.setColumns(10);
		
		txtSegundo = new JTextField();
		txtSegundo.setColumns(10);
		txtSegundo.setBounds(171, 57, 143, 26);
		contentPane.add(txtSegundo);
		
		txtTercero = new JTextField();
		txtTercero.setColumns(10);
		txtTercero.setBounds(171, 111, 143, 26);
		contentPane.add(txtTercero);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnAceptar.setBackground(Color.CYAN);
		btnAceptar.setBounds(542, 12, 150, 33);
		contentPane.add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnCerrar.setBackground(Color.CYAN);
		btnCerrar.setBounds(542, 82, 150, 33);
		contentPane.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent e) {
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
		txtPrimero.setText(PaginaPrincipal.obsequio1); 
		txtSegundo.setText(PaginaPrincipal.obsequio2);
		txtTercero.setText(PaginaPrincipal.obsequio3);
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		PaginaPrincipal.obsequio1 = txtPrimero.getText();
		PaginaPrincipal.obsequio2 = txtSegundo.getText();
		PaginaPrincipal.obsequio3 = txtTercero.getText();
	}
}