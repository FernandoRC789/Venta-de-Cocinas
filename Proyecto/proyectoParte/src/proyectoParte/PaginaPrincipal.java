package proyectoParte;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaginaPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1675293076168019982L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal frame = new PaginaPrincipal();
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
	public PaginaPrincipal() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 323);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mArchivo = new JMenu("Archivo");
		menuBar.add(mArchivo);
		
		JMenuItem oSalir = new JMenuItem("SALIR");
		oSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mArchivo.add(oSalir);
		
		JMenu mMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mMantenimiento);
		
		mntmConsultarCocina = new JMenuItem("Consulta Cocina");
		mntmConsultarCocina.addActionListener(this);
		mMantenimiento.add(mntmConsultarCocina);
		
		mntmModificarCocina = new JMenuItem("Modificar Cocina");
		mntmModificarCocina.addActionListener(this);
		mMantenimiento.add(mntmModificarCocina);
		
		mntmListarCocina = new JMenuItem("Listar Cocina");
		mntmListarCocina.addActionListener(this);
		mMantenimiento.add(mntmListarCocina);
		
		JMenu mVentas = new JMenu("Ventas");
		menuBar.add(mVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mVentas.add(mntmGenerarReportes);
		
		JMenu mConfiguracion = new JMenu("Configuraci\u00F3n");
		menuBar.add(mConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfObsequios = new JMenuItem("Configurar obsequios");
		mntmConfObsequios.addActionListener(this);
		mConfiguracion.add(mntmConfObsequios);
		
		mntmConfCantidadOptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfCantidadOptima.addActionListener(this);
		mConfiguracion.add(mntmConfCantidadOptima);
		
		mntmConfCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfCuotaDiaria.addActionListener(this);
		mConfiguracion.add(mntmConfCuotaDiaria);
		
		JMenu mAyuda = new JMenu("Ayuda");
		menuBar.add(mAyuda);
		
		JMenuItem oTienda = new JMenuItem("Acerca de Tienda");
		oTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDeTienda d= new acercaDeTienda();
				//d.setLocationReservationTo(this);
				d.setVisible(true);
			}
		});
		mAyuda.add(oTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	// Datos mínimos de la primera cocina
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	// Datos mínimos de la segunda cocina
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	// Datos mínimos de la tercera cocina
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	// Datos mínimos de la cuarta cocina
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	// Datos mínimos de la quinta cocina
	public static String modelo4 = "Reco Dakota";
	public static double precio4 = 849.0;
	public static double ancho4 = 75.4;
	public static double alto4 = 94.5;
	public static double fondo4 = 66.0;
	public static int quemadores4 = 5;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 10;
	// Cuota diaria
	public static double cuotaDiaria = 75000;
	private JMenuItem mntmConfCuotaDiaria;
	private JMenuItem mntmConsultarCocina;
	private JMenuItem mntmModificarCocina;
	private JMenuItem mntmListarCocina;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfObsequios;
	private JMenuItem mntmConfCantidadOptima;
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmConfCantidadOptima) {
			actionPerformedMntmConfCantidadOptima(e);
		}
		if (e.getSource() == mntmConfObsequios) {
			actionPerformedMntmConfObsequios(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmNewMenuItem_6(e);
		}
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmNewMenuItem_5(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmNewMenuItem_4(e);
		}
		if (e.getSource() == mntmListarCocina) {
			actionPerformedMntmNewMenuItem_3(e);
		}
		if (e.getSource() == mntmModificarCocina) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmConsultarCocina) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntmConfCuotaDiaria) {
			actionPerformedMntmNewMenuItem_9(e);
		}
	}
	protected void actionPerformedMntmNewMenuItem_9(ActionEvent e) {
		ConfigurarCuotaDiaria d= new ConfigurarCuotaDiaria();
		//d.setLocationReservationTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		consultarCocina d= new consultarCocina();
		//d.setLocationReservationTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		ModificarCocina d= new ModificarCocina();
		d.setVisible(true);
		
	}
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent e) {
		listadoDeCocina d= new listadoDeCocina();
		d.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_4(ActionEvent e) {
		Vender d= new Vender();
		d.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_5(ActionEvent e) {
		GenerarReportes d= new GenerarReportes();
		d.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_6(ActionEvent e) {
		ConfigurarPorcentajesDeDescuento d= new ConfigurarPorcentajesDeDescuento();
		d.setVisible(true);
	}
	protected void actionPerformedMntmConfObsequios(ActionEvent e) {
		ConfigurarObsequios d= new ConfigurarObsequios();
		d.setVisible(true);
	}
	protected void actionPerformedMntmConfCantidadOptima(ActionEvent e) {
		ConfigurarCantidadOptima d= new ConfigurarCantidadOptima();
		d.setVisible(true);
	}
}

