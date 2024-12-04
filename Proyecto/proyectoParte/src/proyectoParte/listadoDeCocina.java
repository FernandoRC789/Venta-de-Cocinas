package proyectoParte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listadoDeCocina extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6194797605871545228L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listadoDeCocina frame = new listadoDeCocina();
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
	public listadoDeCocina() {
		setTitle("Listado de Cocinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 690, 416);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Lucida Fax", Font.BOLD, 17));
		scrollPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnCerrar.setBackground(Color.CYAN);
		btnCerrar.setBounds(37, 449, 150, 33);
		contentPane.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnListar.setBackground(Color.CYAN);
		btnListar.setBounds(476, 449, 150, 33);
		contentPane.add(btnListar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("LISTADO DE COCINAS"+"\n\n");
		//
		mostrarCocina(PaginaPrincipal.modelo0,PaginaPrincipal.precio0,PaginaPrincipal.fondo0,PaginaPrincipal.ancho0,PaginaPrincipal.alto0,PaginaPrincipal.quemadores0);
		mostrarCocina(PaginaPrincipal.modelo1,PaginaPrincipal.precio1,PaginaPrincipal.fondo1,PaginaPrincipal.ancho1,PaginaPrincipal.alto1,PaginaPrincipal.quemadores1);
		mostrarCocina(PaginaPrincipal.modelo2,PaginaPrincipal.precio2,PaginaPrincipal.fondo2,PaginaPrincipal.ancho2,PaginaPrincipal.alto2,PaginaPrincipal.quemadores2);
		mostrarCocina(PaginaPrincipal.modelo3,PaginaPrincipal.precio3,PaginaPrincipal.fondo3,PaginaPrincipal.ancho3,PaginaPrincipal.alto3,PaginaPrincipal.quemadores3);
		mostrarCocina(PaginaPrincipal.modelo4,PaginaPrincipal.precio4,PaginaPrincipal.fondo4,PaginaPrincipal.ancho4,PaginaPrincipal.alto4,PaginaPrincipal.quemadores4);
	}
	
	void mostrarCocina(String mod,double pre,double pro,double an,double al,int que) {
		imprimir("Modelo:	" + mod);
		imprimir("Precio:	" + pre);
		imprimir("Profundidad:	" + pro);
		imprimir("Ancho:	" + an);
		imprimir("Alto:	" + al);
		imprimir("Quemdores:	" + que+"\n\n");
		
	}
	
	void imprimir(String cad) {
		txtS.append(cad+"\n");
	}
}
