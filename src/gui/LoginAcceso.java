package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Font;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.awt.Component;

public class LoginAcceso extends JFrame  {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField jPass;
    private JLabel lblHora;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginAcceso frame = new LoginAcceso();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null); // Centrar ventana
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginAcceso() {
    	setUndecorated(true);
    	setBackground(new Color(0, 0, 0));
    	setVisible(true);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LoginAcceso.class.getResource("/recursos/icons8-lock-48.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 512);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblUsuario = new JLabel("USUARIO");
        lblUsuario.setForeground(new Color(255, 255, 255));
        lblUsuario.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        lblUsuario.setBounds(70, 171, 116, 25);
        contentPane.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBackground(new Color(202, 242, 247));
        txtUsuario.setBounds(231, 165, 207, 31);
        contentPane.add(txtUsuario);
        txtUsuario.setColumns(10);

        JLabel lblClave = new JLabel("CONTRASEÑA");
        lblClave.setForeground(new Color(255, 255, 255));
        lblClave.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        lblClave.setBounds(70, 231, 151, 25);
        contentPane.add(lblClave);

        jPass = new JPasswordField();
        jPass.setBackground(new Color(202, 242, 247));
        jPass.setBounds(231, 225, 207, 31);
        contentPane.add(jPass);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBorderPainted(false);
        btnIngresar.setBackground(new Color(64, 64, 64));
        btnIngresar.setForeground(new Color(255, 255, 255));
        btnIngresar.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
        btnIngresar.addActionListener(new ActionListener() {
        	//metodo de usuario y contraseña
        	public void actionPerformed(ActionEvent e) {
        		
        	    String user = getUsuario();
        	    String clave = getClave();

        	    //Usuarios y contraseñas permitidos 
        	    String[] usuarios = {"luisEspinoza", "luisAtalaya", "danielMilla"};
        	    String[] claves = {"970163", "984198", "940281"};

        	    boolean acceso = false;
        	    String nombreUsuario = "";

        	    //Verificar si el usuario y la clave coinciden
        	    for (int i = 0; i < usuarios.length; i++) {
        	        if (user.equals(usuarios[i]) && clave.equals(claves[i])) {
        	            acceso = true;
        	            nombreUsuario = usuarios[i];
        	            break;
        	        }
        	    }
        	    if (acceso) {
        	        //Formatear el nombre del usuario
        	        nombreUsuario = formatearNombre(nombreUsuario);

        	        JOptionPane.showMessageDialog(LoginAcceso.this,
        	            "¡Acceso coincidido a: " + nombreUsuario + "!");

        	        FrmPrincipal frm = new FrmPrincipal();
        	        frm.setVisible(true);
        	        frm.setLocationRelativeTo(null);
        	        dispose();
        	    } else {
        	        mensajeError("¡Acceso denegado!");
        	        txtUsuario.setText("");
        	        jPass.setText("");
        	        txtUsuario.requestFocus();
        	    }
        	}

        	//Método para formatear el nombre
        	
        	private String formatearNombre(String usuario) {
        	    
        		//Convetir "luisEspinoza" a "Luis Espinoza"
        	    StringBuilder sb = new StringBuilder();
        	    for (int i = 0; i < usuario.length(); i++) {
        	        char c = usuario.charAt(i);
        	        if (i > 0 && Character.isUpperCase(c)) {
        	            sb.append(" ");
        	        }
        	        sb.append(c);
        	    }

        	    String[] partes = sb.toString().split(" ");
        	    StringBuilder nombreFormateado = new StringBuilder();
        	    for (String parte : partes) {
        	        if (!parte.isEmpty()) {
        	            nombreFormateado.append(Character.toUpperCase(parte.charAt(0)))
        	                            .append(parte.substring(1).toLowerCase())
        	                            .append(" ");
        	        }
        	    }
        	    return nombreFormateado.toString().trim();
        	}});

        btnIngresar.setBounds(70, 281, 368, 40);
        contentPane.add(btnIngresar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setBackground(new Color(64, 64, 64));
        btnCancelar.setForeground(new Color(255, 255, 255));
        btnCancelar.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
        btnCancelar.setBounds(70, 346, 368, 40);
        btnCancelar.addActionListener(e -> System.exit(0));
        contentPane.add(btnCancelar);
        
        JLabel lblBienvenido = new JLabel("Ingrese Datos\r\n");
        lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenido.setForeground(new Color(255, 255, 255));
        lblBienvenido.setFont(new Font("Arial Black", Font.PLAIN, 35));
        lblBienvenido.setBounds(10, 39, 492, 40);
        contentPane.add(lblBienvenido);
        
        lblHora = new JLabel("");
        lblHora.setHorizontalAlignment(SwingConstants.CENTER);
        lblHora.setBackground(new Color(202, 242, 247));
        lblHora.setFont(new Font("Arial Black", Font.PLAIN, 60));
        lblHora.setForeground(new Color(255, 255, 255));
        lblHora.setBounds(10, 397, 492, 85);
        contentPane.add(lblHora);
        
      //Visualizar hora en tiempo real
        Timer timer = new Timer(1000, e -> actualizarHora());
        timer.start();
        
        JButton btnSalir = new JButton("  X  ");
        btnSalir.setVerticalAlignment(SwingConstants.TOP);
        btnSalir.setFont(new Font("Arial Black", Font.PLAIN, 12));
        btnSalir.setBorder(null);
        btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSalir.setBackground(new Color(225, 0, 0));
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.setBounds(477, 9, 25, 18);
        contentPane.add(btnSalir);
        
        //boton Salir
        btnSalir.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Quiere salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                	
                	// Cierrar la aplicación
                    System.exit(0);
                }
            }
        });
        
        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(LoginAcceso.class.getResource("/recursos/luilogin.gif")));
        lblFondo.setBounds(0, -12, 512, 535);
        contentPane.add(lblFondo);
    }

    private String getClave() {
        String pass = null;
        if (jPass.getPassword().length == 0) {
            mensajeError("Ingresar Clave");
            jPass.setText("");
            jPass.requestFocus();
        } else {
            pass = String.valueOf(jPass.getPassword());
        }
        return pass;
    }

    private String getUsuario() {
        String u = null;
        if (txtUsuario.getText().trim().length() == 0) {
            mensajeError("Ingresar Usuario");
            txtUsuario.setText("");
            txtUsuario.requestFocus();
        } else {
            u = txtUsuario.getText();
        }
        return u;
    }

    private void mensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    //metodo de Actualizar hora
    public void actualizarHora() {
        Date hora = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        lblHora.setText(formatoHora.format(hora));
    }
}