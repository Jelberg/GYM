/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO1;

import AccesoDatosLayer.FO1.IDaoUsuario;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Usuario;
import LogicaLayer.Comando;
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
 * @author Miguel
 */
public class ComandoActualizarCodigo extends Comando{
    private Usuario _usuario;
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public ComandoActualizarCodigo(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    

     /**
     * Funcion que recibe como parámetro el correo 
     * para mandar el email con el codigo.
     * @param correo
     * @return Devuelve el codigo o 0 si salio mal algo
     */
    public int recuperarContrasena( String correo){
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
    public boolean sendEmail( String correo, int codigo ){
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
			return false;
		}
            
        }
        catch (Exception e){
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
    
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre)FabricaAbstracta.getFabrica(1);
        IDaoUsuario dao = fab.getDaoUsuario();
        _usuario.setCodigo(recuperarContrasena(_usuario.getCorreo()));
        if(_usuario.getCodigo()!=0)
            setResultado( dao.updateCodigo(_usuario));
        else
            resultado = "Problema enviando el codigo, por favor intente mas tarde";
    }
}
