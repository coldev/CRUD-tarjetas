/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

  
@Service
public class CorreoServicioImpl implements CorreoServicio {
     
    @Autowired private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") private String sender;
 
   
    @Override 
    public String EnviarCorreo(  String CorreoDestino, String Mensaje)
    {
 
        // Try block to check for exceptions
        try {
 
            // Creating a simple mail message
            SimpleMailMessage correo
                = new SimpleMailMessage();
 
           
            String Cuerpo=Mensaje;
            String Titulo="Comunicado Entidad Financiera - Remington GOLD";
            
            // Setting up necessary details
            correo.setFrom(sender);
            correo.setTo(CorreoDestino);
            correo.setText(Cuerpo);
            correo.setSubject(Titulo);
 
            // Sending the mail
            javaMailSender.send(correo);
            
            String mensaje=URLEncoder.encode(" (Correo enviado correctamente.)", StandardCharsets.UTF_8.toString());
            
            return mensaje;
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            try {
                String mensaje=URLEncoder.encode(" (Error al enviar el correo.) "/*+e.getMessage()*/, StandardCharsets.UTF_8.toString());
                return mensaje;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(CorreoServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
                return "correo+no+enviado";
            }
        }
    }
    
    
    

}
