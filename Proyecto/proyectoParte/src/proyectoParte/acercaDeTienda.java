package proyectoParte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class acercaDeTienda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8856099028397978785L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acercaDeTienda frame = new acercaDeTienda();
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
	public acercaDeTienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tienda 1.0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 30));
		lblNewLabel.setBounds(169, 10, 169, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(196, 79, 100, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rodriguez Contreras Nick Fernando");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(107, 124, 351, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCerrarAyuda = new JButton("Cerrar");
		btnCerrarAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrarAyuda.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		btnCerrarAyuda.setBounds(136, 245, 202, 42);
		contentPane.add(btnCerrarAyuda);
	}
}
