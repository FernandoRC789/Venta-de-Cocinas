package proyectoParte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import proyectoParte.Vender;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import proyectoParte.Vender;
import javax.swing.JButton;
import java.awt.event.WindowListener;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class avanceDeVentas extends JFrame implements WindowStateListener, WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8076529481208055591L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					avanceDeVentas frame = new avanceDeVentas();
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
	public avanceDeVentas() {
		addWindowListener(this);
		addWindowStateListener(this);
		setTitle("Avance de Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 579, 238);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Georgia", Font.BOLD, 20));
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(110, 259, 259, 43);
		contentPane.add(btnAceptar);
	}

	public void windowStateChanged(WindowEvent e) {
		if (e.getSource() == this) {
			windowStateChangedThis(e);
		}
	}
	protected void windowStateChangedThis(WindowEvent e) {

		
	}
	
	
	public void windowActivated(WindowEvent e) {
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
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}
	protected void windowOpenedThis(WindowEvent e) {
		
		double total;
    	total = Vender.ipagarTotal;
    	txtS.setText("Venta "+ Vender.contadorVentas+"\n\n");
    	txtS.append("Importe Total General Acumulado: " + total+"\n");
    	double porcentajeCuotaDiaria = (total / PaginaPrincipal.cuotaDiaria) * 100;
    	txtS.append("Porcentaje de la cuota Diaria: "+porcentajeCuotaDiaria+"\n");
    	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		dispose();
	}
}