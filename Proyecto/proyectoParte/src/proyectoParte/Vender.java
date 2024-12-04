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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Vender extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 709234680493959064L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblNewLabel_1;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnVender;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
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
	public Vender() {
		setTitle("Vender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 46, 74, 30);
		contentPane.add(lblNewLabel);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio.setBounds(27, 97, 74, 30);
		contentPane.add(lblPrecio);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 149, 88, 30);
		contentPane.add(lblNewLabel_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(133, 149, 130, 30);
		contentPane.add(txtCantidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 216, 639, 221);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Garamond", Font.BOLD, 16));
		scrollPane.setViewportView(txtS);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setFont(new Font("Constantia", Font.BOLD, 16));
		btnVender.setBackground(Color.CYAN);
		btnVender.setBounds(495, 43, 150, 33);
		contentPane.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnCerrar.setBackground(Color.CYAN);
		btnCerrar.setBounds(495, 105, 150, 33);
		contentPane.add(btnCerrar);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(133, 95, 128, 32);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(135, 46, 161, 33);
		contentPane.add(cboModelo);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}

	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	//declarando variables globales
public static int contadorVentas = 0, contPorMod=0;
public static int canVen0,canVen1,canVen2,canVen3,canVen4,no=1 ;
public static double ipagTot0,ipagTot1,ipagTot2,ipagTot3,ipagTot4,icomTot0,icomTot1,icomTot2,icomTot3,icomTot4,idescTot0,idescTot1,idescTot2,idescTot3,idescTot4,preTot0,preTot1,preTot2,preTot3,preTot4;
public static double ipagarTotal,porCuotaDiaria;

	private JTextField txtPrecio;
	private JComboBox cboModelo;
		//BOTON VENDER
	protected void actionPerformedBtnVender(ActionEvent e) {
		//declarando variables
		int mod,cant;
		double icom,idesc,precio,ipag;
		String obs= "";
		//nombrando metodos
		cant = leerCant();
		mod = leerModelo();
		precio = leerPrecio(mod);
		icom = CalcularIcompra(precio,cant);
		idesc = calcularIDescuento(cant,icom);
		ipag = calcularIpagar(icom,idesc);
		obs = CalculandoObsequios(cant);
		efectuarIncrementos(mod,precio,cant,icom,idesc,ipag,no);
		salidaResultados(obs,mod);
		
		
	}
	int leerModelo() {
		return cboModelo.getSelectedIndex();	
		}
	
	int leerCant() {
		return Integer.parseInt(txtCantidad.getText());
	}

	double leerPrecio(int m) {
		return 	Double.parseDouble(txtPrecio.getText());
	}
	
	double CalcularIcompra(double p,int c) {
		return p*c;
	}

	double calcularIDescuento(int c,double ic) {
		if(c<5) return ic * PaginaPrincipal.porcentaje1 ;
		else if (c<=10) return ic * PaginaPrincipal.porcentaje2 ;
		else if(c<=15) return ic * PaginaPrincipal.porcentaje3;
		else return ic * PaginaPrincipal.porcentaje4;
	}

	double calcularIpagar(double icom,double idesc) {
		return icom - idesc;
	}

	String CalculandoObsequios(int c) {
		if (c == 1) return PaginaPrincipal.obsequio1;
		else if(c <=5) return PaginaPrincipal.obsequio2;
		else return PaginaPrincipal.obsequio3;
	}
	void efectuarIncrementos(int m,double pre,int c, double ic,double id,double ip,int no ) {
		switch(m) {
		case 0: preTot0 +=pre; canVen0+=c; icomTot0 +=ic; idescTot0 +=id;ipagTot0+=ip;break;
		case 1: preTot1 +=pre; canVen1+=c; icomTot1 +=ic; idescTot1 +=id;ipagTot1+=ip;break;
		case 2: preTot2 +=pre; canVen2+=c; icomTot2 +=ic; idescTot2 +=id;ipagTot2+=ip;break;
		case 3: preTot3 +=pre; canVen3+=c; icomTot3 +=ic; idescTot3 +=id;ipagTot3+=ip;break;
		default: preTot4 +=pre; canVen4+=c; icomTot4 +=ic; idescTot4 +=id;ipagTot4+=ip;
		}
		
	}

	void salidaResultados(String obs,int mod) {
		txtS.setText("BOLETA DE VENTA" + "\n\n");
		switch(mod) {
		case 0: 
			txtS.append("MODELO : "+ PaginaPrincipal.modelo0+"\n");
			txtS.append("Precio                        : " +"S/ . " + preTot0 + "\n");
			txtS.append("Cantidad                   : " + "S/ . " + canVen0 + "\n");
			txtS.append("Importe Compra       : " + "S/ . " + icomTot0 + "\n");
			txtS.append("Importe descuento   : " + "S/ . " + idescTot0 + "\n");
			txtS.append("importe pagar          : " + "S/ . " + ipagTot0 + "\n");
			txtS.append("Obsequio                  : " + no + obs + "\n");
			contPorMod++;
			porCuotaDiaria = (ipagTot0/PaginaPrincipal.cuotaDiaria) * 100;break;

		case 1:
			txtS.append("MODELO : "+PaginaPrincipal.modelo1+"\n");
			txtS.append("Precio                        : " +"S/ . " + preTot1 + "\n");
			txtS.append("Cantidad                   : " + "S/ . " + canVen1 + "\n");
			txtS.append("Importe Compra       : " + "S/ . " + icomTot1 + "\n");
			txtS.append("Importe descuento   : " + "S/ . " + idescTot1 + "\n");
			txtS.append("importe pagar          : " + "S/ . " + ipagTot1 + "\n");
			txtS.append("Obsequio                  : " + no + obs + "\n");
			contPorMod++;
			porCuotaDiaria = (ipagTot1/PaginaPrincipal.cuotaDiaria) * 100;break;

		case 2: 
			txtS.append("MODELO : "+PaginaPrincipal.modelo2+"\n");
			txtS.append("Precio                        : " +"S/ . " + preTot2 + "\n");
			txtS.append("Cantidad                   : " + "S/ . " + canVen2 + "\n");
			txtS.append("Importe Compra       : " + "S/ . " + icomTot2 + "\n");
			txtS.append("Importe descuento   : " + "S/ . " + idescTot2 + "\n");
			txtS.append("importe pagar          : " + "S/ . " + ipagTot2 + "\n");
			txtS.append("Obsequio                  : " + no + obs + "\n");
			contPorMod++;
			porCuotaDiaria = (ipagTot2/PaginaPrincipal.cuotaDiaria) * 100;break;

		case 3: 
			txtS.append("MODELO : "+PaginaPrincipal.modelo3+"\n");
			txtS.append("Precio                        : " +"S/ . " + preTot3 + "\n");
			txtS.append("Cantidad                   : " + "S/ . " + canVen3 + "\n");
			txtS.append("Importe Compra       : " + "S/ . " + icomTot3 + "\n");
			txtS.append("Importe descuento   : " + "S/ . " + idescTot3 + "\n");
			txtS.append("importe pagar          : " + "S/ . " + ipagTot3 + "\n");
			txtS.append("Obsequio                  : " + no + obs + "\n");
			contPorMod++;
			porCuotaDiaria = (ipagTot3/PaginaPrincipal.cuotaDiaria) * 100;break;

		default: 
			txtS.append("MODELO : "+PaginaPrincipal.modelo4+"\n");
			txtS.append("Precio                        : " +"S/ . " + preTot4 + "\n");
			txtS.append("Cantidad                   : " + "S/ . " + canVen4  + "\n");
			txtS.append("Importe Compra       : " + "S/ . " + icomTot4 + "\n");
			txtS.append("Importe descuento   : " + "S/ . " + idescTot4 + "\n");
			txtS.append("importe pagar          : " + "S/ . " + ipagTot4 + "\n");
			txtS.append("Obsequio                  : " + no + obs + "\n");
			contPorMod++;
			porCuotaDiaria = (ipagTot4/PaginaPrincipal.cuotaDiaria) * 100;break;
		}
		
		ipagarTotal = ipagTot0+ipagTot1+ipagTot2+ipagTot3+ipagTot4;
		contadorVentas++;
        if (contadorVentas%5==0 ) {
            // Abre la ventana de alerta
            avanceDeVentas ventana = new avanceDeVentas();
            ventana.setVisible(true);
            }
         
	}
	protected void actionPerformedComboBox(ActionEvent e) {
		int modelo;
		modelo = leerModelo();
		
		switch(modelo) {
		case 0: mostrarResultados(PaginaPrincipal.precio0);break;
		case 1: mostrarResultados(PaginaPrincipal.precio1);break;
		case 2: mostrarResultados(PaginaPrincipal.precio2);break;
		case 3: mostrarResultados(PaginaPrincipal.precio3);break;
		default: mostrarResultados(PaginaPrincipal.precio4);
		
		}
	}
	void mostrarResultados(double pre) {
		txtPrecio.setText(pre+"");
	}
}