package proyectoParte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarCocina extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470222201988954352L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JComboBox<?> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCocina frame = new ModificarCocina();
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
	public ModificarCocina() {
		setTitle("Modificar Cocina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(41, 31, 87, 28);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(41, 85, 70, 19);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ancho(cm)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(44, 130, 84, 28);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Alto(cm)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(41, 186, 71, 19);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Fondo (cm)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(41, 233, 100, 28);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Quemadores");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(41, 283, 100, 28);
		contentPane.add(lblNewLabel_5);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(196, 31, 133, 32);
		contentPane.add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(196, 87, 109, 21);
		contentPane.add(txtPrecio);
		
		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(196, 137, 109, 21);
		contentPane.add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(196, 188, 109, 21);
		contentPane.add(txtAlto);
		
		txtFondo = new JTextField();
		txtFondo.setColumns(10);
		txtFondo.setBounds(196, 240, 109, 21);
		contentPane.add(txtFondo);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setColumns(10);
		txtQuemadores.setBounds(196, 290, 109, 21);
		contentPane.add(txtQuemadores);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnCerrar.setBackground(Color.CYAN);
		btnCerrar.setBounds(524, 71, 150, 33);
		contentPane.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnGrabar.setBackground(Color.CYAN);
		btnGrabar.setBounds(524, 165, 150, 33);
		contentPane.add(btnGrabar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
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
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		int modelo = cboModelo.getSelectedIndex();
	    switch(modelo) {
	        case 0:
	            PaginaPrincipal.precio0 = Double.parseDouble(txtPrecio.getText());
	            PaginaPrincipal.ancho0 = Double.parseDouble(txtAncho.getText());
	            PaginaPrincipal.alto0 = Double.parseDouble(txtAlto.getText());
	            PaginaPrincipal.fondo0 = Double.parseDouble(txtFondo.getText());
	            PaginaPrincipal.quemadores0 = Integer.parseInt(txtQuemadores.getText());
	            break;
	        case 1:
	        	PaginaPrincipal.precio1 = Double.parseDouble(txtPrecio.getText());
	        	PaginaPrincipal.ancho1 = Double.parseDouble(txtAncho.getText());
	        	PaginaPrincipal.alto1 = Double.parseDouble(txtAlto.getText());
	        	PaginaPrincipal.fondo1 = Double.parseDouble(txtFondo.getText());
	        	PaginaPrincipal.quemadores1 = Integer.parseInt(txtQuemadores.getText());
	            break;
	        case 2:
	        	PaginaPrincipal.precio2 = Double.parseDouble(txtPrecio.getText());
	        	PaginaPrincipal.ancho2 = Double.parseDouble(txtAncho.getText());
	        	PaginaPrincipal.alto2 = Double.parseDouble(txtAlto.getText());
	        	PaginaPrincipal.fondo2 = Double.parseDouble(txtFondo.getText());
	        	PaginaPrincipal.quemadores2 = Integer.parseInt(txtQuemadores.getText());
	            break;
	        case 3:
	        	PaginaPrincipal.precio3 = Double.parseDouble(txtPrecio.getText());
	        	PaginaPrincipal.ancho3 = Double.parseDouble(txtAncho.getText());
	        	PaginaPrincipal.alto3 = Double.parseDouble(txtAlto.getText());
	        	PaginaPrincipal.fondo3 = Double.parseDouble(txtFondo.getText());
	        	PaginaPrincipal.quemadores3 = Integer.parseInt(txtQuemadores.getText());
	            break;
	        default:
	        	PaginaPrincipal.precio4 = Double.parseDouble(txtPrecio.getText());
	        	PaginaPrincipal.ancho4 = Double.parseDouble(txtAncho.getText());
	        	PaginaPrincipal.alto4 = Double.parseDouble(txtAlto.getText());
	        	PaginaPrincipal.fondo4 = Double.parseDouble(txtFondo.getText());
	        	PaginaPrincipal.quemadores4 = Integer.parseInt(txtQuemadores.getText());
	    }
	}
}
