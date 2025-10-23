package gui;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.*;

import java.awt.Toolkit;
import java.awt.Font;

//tiempo
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;

public class FrmPrincipal extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JMenuBar menuBar;
    private JMenu mnMantenimiento, mnRegistro, mnConsulta, mnReporte;
    private JMenuItem mntmMantPaciente, mntmMantTratamiento, mntmRegInternamiento, mntmRegAlta;
    private JMenuItem mntmConsPaciente, mntmConsTratamiento, mntmConsInternamiento, mntmConsAlta;
    private JMenuItem mntmPacInterPendiente, mntmPacInterVigente, mntmPacInterTratam;
    private JLabel lbBienvenidos;
    private JLabel lblNombre1;
    private JLabel lblNombre2;
    private JLabel lblNombre3;
    private JLabel lblMinisterioSalud;
    private JLabel lbllogo;
    private JLabel lblFe;
    private JLabel lblHor;
    private JLabel lblreloL;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrmPrincipal frame = new FrmPrincipal();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FrmPrincipal() {
    	setTitle("Sistema de Registro e Internamiento de Pacientes");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/recursos/icons8-life-cycle-48.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 918, 683);

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(84, 163, 188));
        setJMenuBar(menuBar);
        menuBar.setPreferredSize(new Dimension(0, 40));

        
        mnMantenimiento = new JMenu("Mantenimiento");
        mnMantenimiento.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
        mnMantenimiento.setForeground(new Color(255, 255, 255));
        mnMantenimiento.setFont(new Font("Arial Black", Font.PLAIN, 15));
        mnMantenimiento.setMnemonic('M');
        menuBar.add(mnMantenimiento);

        mntmMantPaciente = new JMenuItem("Paciente");
        mntmMantPaciente.setBackground(new Color(242, 242, 242));
        mntmMantPaciente.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmMantPaciente.addActionListener(this);
        mnMantenimiento.add(mntmMantPaciente);

        mntmMantTratamiento = new JMenuItem("Tratamiento");
        mntmMantTratamiento.setBackground(new Color(242, 242, 242));
        mntmMantTratamiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmMantTratamiento.addActionListener(this);
        mnMantenimiento.add(mntmMantTratamiento);

        
        mnRegistro = new JMenu("Registro");
        mnRegistro.setForeground(new Color(255, 255, 255));
        mnRegistro.setFont(new Font("Arial Black", Font.PLAIN, 15));
        mnRegistro.setMnemonic('R');
        menuBar.add(mnRegistro);

        mntmRegInternamiento = new JMenuItem("Internamiento");
        mntmRegInternamiento.setBackground(new Color(242, 242, 242));
        mntmRegInternamiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmRegInternamiento.addActionListener(this);
        mnRegistro.add(mntmRegInternamiento);

        mntmRegAlta = new JMenuItem("Alta");
        mntmRegAlta.setBackground(new Color(242, 242, 242));
        mntmRegAlta.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmRegAlta.addActionListener(this);
        mnRegistro.add(mntmRegAlta);


        mnConsulta = new JMenu("Consulta");
        mnConsulta.setForeground(new Color(255, 255, 255));
        mnConsulta.setFont(new Font("Arial Black", Font.PLAIN, 15));
        mnConsulta.setMnemonic('C');
        menuBar.add(mnConsulta);

        mntmConsPaciente = new JMenuItem("Paciente");
        mntmConsPaciente.setBackground(new Color(242, 242, 242));
        mntmConsPaciente.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmConsPaciente.addActionListener(this);
        mnConsulta.add(mntmConsPaciente);

        mntmConsTratamiento = new JMenuItem("Tratamiento");
        mntmConsTratamiento.setBackground(new Color(242, 242, 242));
        mntmConsTratamiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmConsTratamiento.addActionListener(this);
        mnConsulta.add(mntmConsTratamiento);

        mntmConsInternamiento = new JMenuItem("Internamiento");
        mntmConsInternamiento.setBackground(new Color(242, 242, 242));
        mntmConsInternamiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmConsInternamiento.addActionListener(this);
        mnConsulta.add(mntmConsInternamiento);

        mntmConsAlta = new JMenuItem("Alta");
        mntmConsAlta.setBackground(new Color(242, 242, 242));
        mntmConsAlta.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmConsAlta.addActionListener(this);
        mnConsulta.add(mntmConsAlta);

        
        mnReporte = new JMenu("Reporte");
        mnReporte.setForeground(new Color(255, 255, 255));
        mnReporte.setFont(new Font("Arial Black", Font.PLAIN, 15));
        mnReporte.setMnemonic('P');
        menuBar.add(mnReporte);

        mntmPacInterPendiente = new JMenuItem("Pacientes con internamiento pendiente");
        mntmPacInterPendiente.setBackground(new Color(242, 242, 242));
        mntmPacInterPendiente.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmPacInterPendiente.addActionListener(this);
        mnReporte.add(mntmPacInterPendiente);

        mntmPacInterVigente = new JMenuItem("Pacientes con internamiento vigente");
        mntmPacInterVigente.setBackground(new Color(242, 242, 242));
        mntmPacInterVigente.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmPacInterVigente.addActionListener(this);
        mnReporte.add(mntmPacInterVigente);

        mntmPacInterTratam = new JMenuItem("Pacientes internados por tratamiento");
        mntmPacInterTratam.setBackground(new Color(242, 242, 242));
        mntmPacInterTratam.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        mntmPacInterTratam.addActionListener(this);
        mnReporte.add(mntmPacInterTratam);

        ImageIcon fondo = new ImageIcon(getClass().getResource("/recursos/Prin.png"));
        JPanel contentPane = new JPanel() {
            private static final long serialVersionUID = 1L;
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        lbBienvenidos = new JLabel("Bienvenidos al Sistema");
        lbBienvenidos.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
        lbBienvenidos.setBounds(57, 375, 338, 65);
        contentPane.add(lbBienvenidos);
        
        lblNombre1 = new JLabel("- Luis Alfredo Espinoza Zapata (administrador)");
        lblNombre1.setFont(new Font("Sylfaen", Font.PLAIN, 15));
        lblNombre1.setBounds(57, 498, 289, 23);
        contentPane.add(lblNombre1);
        
        lblNombre2 = new JLabel("- Luis Antony Atalaya Benites (coordinador)");
        lblNombre2.setFont(new Font("Sylfaen", Font.PLAIN, 15));
        lblNombre2.setBounds(57, 522, 289, 17);
        contentPane.add(lblNombre2);
        
        lblNombre3 = new JLabel("- Daniel Edwin Milla Mamani (gerente general)");
        lblNombre3.setFont(new Font("Sylfaen", Font.PLAIN, 15));
        lblNombre3.setBounds(57, 541, 289, 23);
        contentPane.add(lblNombre3);
        
        lblMinisterioSalud = new JLabel("Aprobado por el Ministerio de Salud");
        lblMinisterioSalud.setBounds(590, 570, 205, 23);
        contentPane.add(lblMinisterioSalud);
        
        lbllogo = new JLabel("");
        lbllogo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/Salud.png")));
        lbllogo.setBounds(801, 570, 92, 23);
        contentPane.add(lbllogo);
        
        lblFe = new JLabel();
        lblFe.setForeground(new Color(24, 58, 41));
        lblFe.setFont(new Font("Arial Black", Font.BOLD, 20));
        lblFe.setBounds(669, 11, 224, 23);
        contentPane.add(lblFe);
        
        lblHor = new JLabel();
        lblHor.setForeground(new Color(83, 41, 0));
        lblHor.setFont(new Font("Arial Black", Font.BOLD, 55));
        lblHor.setBounds(580, 343, 289, 78);
        contentPane.add(lblHor);
        
        lblreloL = new JLabel("");
        lblreloL.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/reloj2.png")));
        lblreloL.setBounds(527, 363, 43, 42);
        contentPane.add(lblreloL);
        
        // Iniciar reloj para actualizar fecha y hora en tiempo real
        Timer timer = new Timer(1000, e -> actualizarFechaHora());
        timer.start();
        
    }
   public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == mntmPacInterTratam) abrirDlg(new DlgReportePacientesPorTratamiento());
        else if (src == mntmPacInterVigente) abrirDlg(new DlgReporteInternamientosVigentes());
        else if (src == mntmPacInterPendiente) abrirDlg(new DlgReporteInternamientosPendientes());
        else if (src == mntmConsAlta) abrirDlg(new DlgConsultaAlta());
        else if (src == mntmConsInternamiento) abrirDlg(new DlgConsultaInternamiento());
        else if (src == mntmConsTratamiento) abrirDlg(new DlgConsultaTratamiento());
        else if (src == mntmConsPaciente) abrirDlg(new DlgConsultaPaciente());
        else if (src == mntmRegAlta) abrirDlg(new DlgRegAlta());
        else if (src == mntmRegInternamiento) abrirDlg(new DlgRegInternamiento());
        else if (src == mntmMantTratamiento) abrirDlg(new DlgMantTratamiento());
        else if (src == mntmMantPaciente) abrirDlg(new DlgMantPaciente());
    }

    
    private void abrirDlg(JDialog dlg) {
        dlg.setModal(true);
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true);
    }
    //metodo de Fecha y hora
    private void actualizarFechaHora() {
        Date ahora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        lblFe.setText("Fecha: " + formatoFecha.format(ahora));
        lblHor.setText("" + formatoHora.format(ahora));
    }
}
