package proyectoParte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import proyectoParte.Vender; para usar en el reporte  los datos de las otras variables
public class GenerarReportes extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7120476291400489316L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox<?> cboModelo;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarReportes frame = new GenerarReportes();
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
	public GenerarReportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de Reporte");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 39, 138, 35);
		contentPane.add(lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Ventas en relaci\u00F3n a la venta \u00F3ptima", "Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores"}));
		cboModelo.setBounds(170, 39, 246, 35);
		contentPane.add(cboModelo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Constantia", Font.BOLD, 16));
		btnCerrar.setBackground(Color.CYAN);
		btnCerrar.setBounds(604, 10, 150, 33);
		contentPane.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 704, 408);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedComboBox(e);
		}
	}
	protected void actionPerformedComboBox(ActionEvent e) {
		//declarando variables
		int modelo;
		//entrada de datos
		modelo=cboModelo.getSelectedIndex();
		//proceso de calculo
		txtS.setText("");
		switch(modelo) {
		case 0:
		mostrarReporte(PaginaPrincipal.modelo0,	Vender.contPorMod,Vender.canVen0,Vender.ipagTot0,Vender.porCuotaDiaria+ "\n\n");
		mostrarReporte(PaginaPrincipal.modelo1,	Vender.contPorMod,Vender.canVen1,Vender.ipagTot1,Vender.porCuotaDiaria+"\n\n");
		mostrarReporte(PaginaPrincipal.modelo2,	Vender.contPorMod,Vender.canVen2,Vender.ipagTot2,Vender.porCuotaDiaria+"\n\n");
		mostrarReporte(PaginaPrincipal.modelo3,	Vender.contPorMod,Vender.canVen3,Vender.ipagTot3,Vender.porCuotaDiaria+"\n\n");
		mostrarReporte(PaginaPrincipal.modelo4,	Vender.contPorMod,Vender.canVen4,Vender.ipagTot4,Vender.porCuotaDiaria+"\n\n");break;
		case 1:
			mostrarCantidadOptima(PaginaPrincipal.modelo0, Vender.canVen0,"\n");
			mostrarCantidadOptima(PaginaPrincipal.modelo1, Vender.canVen1,"\n");
			mostrarCantidadOptima(PaginaPrincipal.modelo2,Vender.canVen2,"\n");
			mostrarCantidadOptima(PaginaPrincipal.modelo3,Vender.canVen3,"\n");
			mostrarCantidadOptima(PaginaPrincipal.modelo4, Vender.canVen4,"\n");break;
		case 2: 
			txtS.append("PRECIOS EN RELACIÓN AL PRECIO PROMEDIO"+"\n\n");
			mostrarPreciopromedio(PaginaPrincipal.modelo0,PaginaPrincipal.precio0);
			mostrarPreciopromedio(PaginaPrincipal.modelo1,PaginaPrincipal.precio1);
			mostrarPreciopromedio(PaginaPrincipal.modelo2,PaginaPrincipal.precio2);
			mostrarPreciopromedio(PaginaPrincipal.modelo3,PaginaPrincipal.precio3);
			mostrarPreciopromedio(PaginaPrincipal.modelo4,PaginaPrincipal.precio4);
		default:
			txtS.append("PROMEDIOS, MENORES Y MAYORES"+"\n\n");
			txtS.append("Precio promedio : " + mostrarPromedio()+"\n");
			txtS.append("Precio menor : " + minPre+"\n");
			txtS.append("Precio mayor : " + maxPre + "\n\n");
			promedio("Ancho ",PaginaPrincipal.precio0,PaginaPrincipal.precio1,PaginaPrincipal.precio2,PaginaPrincipal.precio3,PaginaPrincipal.precio4);
			txtS.append("Ancho menor : " + minAnc+"\n");
			txtS.append("Precio mayor : " + maxAnc + "\n\n");
			promedio("Alto",PaginaPrincipal.alto0,PaginaPrincipal.alto1,PaginaPrincipal.alto2,PaginaPrincipal.alto3,PaginaPrincipal.alto4);
			txtS.append("Alto menor : " + minAlt+"\n");
			txtS.append("Alto mayor : " + maxAlt + "\n\n");
			promedio("Fondo / Profundidad" , PaginaPrincipal.fondo0,PaginaPrincipal.fondo1,PaginaPrincipal.fondo2,PaginaPrincipal.fondo3,PaginaPrincipal.fondo4);
			txtS.append("Fondo menor : " + minFnd+"\n");
			txtS.append("Fondo mayor : " + maxFnd + "\n\n");	
		}

			
	}
	// promedio para todo formula
	void promedio(String name, double v0,double v1,double v2,double v3,double v4) {
		 double prom = (+v0+v1+ v2+v3+v4)/5;
		 txtS.append(name +" promedio : " +prom+"\n");
	}
	double minFnd = Math.min(Math.min(Math.min(PaginaPrincipal.fondo0, PaginaPrincipal.fondo1), Math.min(PaginaPrincipal.fondo2, PaginaPrincipal.fondo3)), PaginaPrincipal.fondo4); 
	double maxFnd = Math.max(Math.max(Math.max(PaginaPrincipal.fondo0, PaginaPrincipal.fondo1), Math.max(PaginaPrincipal.fondo2, PaginaPrincipal.fondo3)), PaginaPrincipal.fondo4); 

	double minAlt = Math.min(Math.min(Math.min(PaginaPrincipal.alto0, PaginaPrincipal.alto1), Math.min(PaginaPrincipal.alto2, PaginaPrincipal.alto3)), PaginaPrincipal.alto4); 
	double maxAlt = Math.max(Math.max(Math.max(PaginaPrincipal.alto0, PaginaPrincipal.alto1), Math.max(PaginaPrincipal.alto2, PaginaPrincipal.alto3)), PaginaPrincipal.alto4); 


	double minAnc = Math.min(Math.min(Math.min(PaginaPrincipal.ancho0, PaginaPrincipal.ancho1), Math.min(PaginaPrincipal.ancho2, PaginaPrincipal.ancho3)), PaginaPrincipal.ancho4); 
    double maxAnc = Math.max(Math.max(Math.max(PaginaPrincipal.ancho0, PaginaPrincipal.ancho1), Math.max(PaginaPrincipal.ancho2, PaginaPrincipal.ancho3)), PaginaPrincipal.ancho4); 

    double minPre = Math.min(Math.min(Math.min(PaginaPrincipal.precio0, PaginaPrincipal.precio1), Math.min(PaginaPrincipal.precio2, PaginaPrincipal.precio3)), PaginaPrincipal.precio4); 
    double maxPre = Math.max(Math.max(Math.max(PaginaPrincipal.precio0, PaginaPrincipal.precio1), Math.max(PaginaPrincipal.precio2, PaginaPrincipal.precio3)), PaginaPrincipal.precio4); 

    //utlizando metodos de promedio
	void mostrarPreciopromedio( String mod,double pre) {
		txtS.append("Modelo: "+ mod + "\n");
		if (pre > mostrarPromedio())
			txtS.append("Precio: " + pre+ "Mayor al promedio"+"\n\n");
		else if (pre < mostrarPromedio())
			txtS.append("Precio: " + pre+ "Menor al promedio"+"\n\n");
		else
			txtS.append("Precio: " + pre+ "Igual al promedio"+"\n\n");
	}
	//metodo para calcular promedios
	double mostrarPromedio() {
		double result = 0;
		double p = PaginaPrincipal.precio0 + PaginaPrincipal.precio1+PaginaPrincipal.precio2+PaginaPrincipal.precio3+PaginaPrincipal.precio4;
		//txtS.append("Modelo: "+ mod + "\n");
		//calculando promedio
		return result = p / 5;
		
	}
	// Metodo para calcular venta optima
	void mostrarCantidadOptima(String modelo, int cantVendida,String n) {
		//utilizando el Math max y min para que me salga el resultado positivo sin el signo -
	    int result = Math.max(PaginaPrincipal.cantidadOptima,cantVendida) - Math.min(PaginaPrincipal.cantidadOptima,cantVendida);
    		txtS.append("Modelo: "+ modelo + "\n");
    		//proceso de calculo del metodo
	    if (cantVendida < PaginaPrincipal.cantidadOptima )
	    	txtS.append("Cantidad de Unidades Vendidas: " + cantVendida + "(" + result + " menos que la cantidad óptima)" +"\n\n");
	    else if  ( cantVendida > PaginaPrincipal.cantidadOptima)
			txtS.append("Cantidad de Unidades Vendidas: " + cantVendida + "(" + result + " más que la cantidad óptima)"+"\n\n" );
	    else  
	    	txtS.append("Cantidad de Unidades Vendidas: " + cantVendida + " es igual a la cantidad óptima"+"\n\n");
	}
	
	void mostrarReporte(String mod,int cant,int cantven,double itv,String n) {
		imprimir("Modelo:	" + mod);
		imprimir("Cantidad de Ventas:	" + cant);
		imprimir("Cantidad de unidades Vendidas:	" + cantven);
		imprimir("Importe total Vendido:	" + itv);
		imprimir("\n");		
	}

	void imprimir(String cad) {
		txtS.append(cad+"\n");
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}