/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jorge
 */
public class Usuario extends Persona {
    private String password;
    private String usuario;
    private int estatura;
    private String telefono;
    private int codigo;
    private boolean entrenador;

    public Usuario(int id, String nombre, String apellido, Date fecha_nac, 
                    String sexo, String correo) {
        super(id,nombre, apellido, fecha_nac, sexo, correo);
    }

    public Usuario() 
    {}


    public Usuario(String password, String usuario, int estatura, 
                    String telefono, boolean entrenador, String nombre, 
                    String apellido, Date fecha_nac, String sexo, String correo) {
        super(nombre, apellido, fecha_nac, sexo, correo);
        this.password = password;
        this.usuario = usuario;
        this.estatura = estatura;
        this.telefono = telefono;
        this.entrenador = entrenador;
    }

    public Usuario(String password, String usuario, int estatura, 
                    String telefono, int codigo, boolean entrenador, 
                    int id, String nombre, String apellido, Date fecha_nac, 
                    String sexo, String correo) {
        super(id, nombre, apellido, fecha_nac, sexo, correo);
        this.password = password;
        this.usuario = usuario;
        this.estatura = estatura;
        this.telefono = telefono;
        this.codigo = codigo;
        this.entrenador = entrenador;
    }
    
    public Usuario(int id, String usuario, String nombre, String apellido){
        super(nombre, apellido, id);
        this.usuario = usuario;
    }

    public Usuario(String password, String usuario, int estatura, 
                    String telefono, int codigo, boolean entrenador) {
        this.password = password;
        this.usuario = usuario;
        this.estatura = estatura;
        this.telefono = telefono;
        this.codigo = codigo;
        this.entrenador = entrenador;
    }

    public Usuario(String password, String usuario, int estatura, 
                    String telefono, int codigo, boolean entrenador, 
                    String nombre, String apellido, Date fecha_nac, 
                    String sexo, String correo) {
        super(nombre, apellido, fecha_nac, sexo, correo);
        this.password = password;
        this.usuario = usuario;
        this.estatura = estatura;
        this.telefono = telefono;
        this.codigo = codigo;
        this.entrenador = entrenador;
    }

    public boolean isEntrenador() {
        return entrenador;
    }

    public void setEntrenador(boolean entrenador) {
        this.entrenador = entrenador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

   /**
     * Funcion que recibe como parámetro el correo 
     * para mandar el email con el codigo.
     * @param correo
     * @return Devuelve el codigo o 0 si salio mal algo
     */
   public int recuperarContrasena( String correo)
   {
    int codigo =  randInt(100000,900000);
    boolean envio = sendEmail(correo,codigo);
    if (envio==true)
    {
        return codigo;
    }
    else
    {
        return 0;
    }
   }
   
   /**
     * Funcion que recibe como parámetro el correo y el codigo de recuperacion de contrasena del cliente,
     * para mandar el email con el codigo.
     * @param correo
     * @param codigo
     * @return Devuelve verdadero si todo salio bien
     */
    public boolean sendEmail( String correo, int codigo )
    {
        final String username = "jorgepintomendes22@gmail.com";
        final String password = "mkkdalgddbbocrvt";
        try{
            Properties p = new Properties();
            p.put("mail.smtp.host","smtp.gmail.com");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", correo);
            p.put("mail.smtp.auth", "true");
            
            Session session = Session.getInstance(p, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
            try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));

			// recipients email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));

			// add the Subject of email
			message.setSubject("Recuperacion de contrasena GYM ucab");

			// message body
			message.setText("Su codigo es: "+codigo);// message

			Transport.send(message);

			System.out.println("Email Sent Successfully");
                        return true;

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
            
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    
    /**
     * Funcion que recibe como parámetro el valor minimo y el valor maximo 
     * que se desee que tenga el codigo
     * @param min
     * @param max
     * @return Devuelve el codigo aleatorio en cuestion
     */
    public static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
}
}
