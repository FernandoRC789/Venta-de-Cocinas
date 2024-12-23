package proyectoParte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class consultarCocina extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7797310676272662837L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox<?> cboModelo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnCerrar;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultarCocina frame = new consultarCocina();
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
	public consultarCocina() {
		setTitle("Consultar Cocina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 20, 74, 24);
		contentPane.add(lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(114, 18, 150, 33);
		contentPane.add(cboModelo);
		
		lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 91, 76, 24);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ancho(cm)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 128, 76, 24);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Alto(cm)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 168, 76, 24);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Fondo (cm)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 211, 76, 24);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Quemadores");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(20, 259, 86, 24);
		contentPane.add(lblNewLabel_5);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnCerrar.setBackground(Color.CYAN);
		btnCerrar.setBounds(490, 26, 150, 33);
		contentPane.add(btnCerrar);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(114, 94, 109, 21);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(114, 131, 109, 21);
		contentPane.add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setColumns(10);
		txtAlto.setBounds(116, 171, 109, 21);
		contentPane.add(txtAlto);
		
		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setColumns(10);
		txtFondo.setBounds(114, 215, 109, 21);
		contentPane.add(txtFondo);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setEditable(false);
		txtQuemadores.setColumns(10);
		txtQuemadores.setBounds(114, 262, 109, 21);
		contentPane.add(txtQuemadores);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		int modelo;
		modelo = leerModelo();
		mostrarResultados(modelo);
	}
	private int leerModelo() {
		return cboModelo.getSelectedIndex();	}

	private void mostrarResultados(int m) {
		switch(m) {
		case 0: mostrarResultados(PaginaPrincipal.precio0,PaginaPrincipal.ancho0,PaginaPrincipal.alto0,PaginaPrincipal.fondo0,PaginaPrincipal.quemadores0);break;
		case 1: mostrarResultados(PaginaPrincipal.precio1,PaginaPrincipal.ancho1,PaginaPrincipal.alto1,PaginaPrincipal.fondo1,PaginaPrincipal.quemadores1);break;
		case 2: mostrarResultados(PaginaPrincipal.precio2,PaginaPrincipal.ancho2,PaginaPrincipal.alto2,PaginaPrincipal.fondo2,PaginaPrincipal.quemadores2);break;
		case 3: mostrarResultados(PaginaPrincipal.precio3,PaginaPrincipal.ancho3,PaginaPrincipal.alto3,PaginaPrincipal.fondo3,PaginaPrincipal.quemadores3);break;
		default: mostrarResultados(PaginaPrincipal.precio4,PaginaPrincipal.ancho4,PaginaPrincipal.alto4,PaginaPrincipal.fondo4,PaginaPrincipal.quemadores4);break;
		} 
	}
	
	void mostrarResultados(double pre,double an, double al, double fo, int que) {
		txtPrecio.setText(""+pre);
		txtAncho.setText(""+an);
		txtAlto.setText(""+al);
		txtFondo.setText(""+fo);
		txtQuemadores.setText(""+que);
	}
	
}