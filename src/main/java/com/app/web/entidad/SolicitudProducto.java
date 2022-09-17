package com.app.web.entidad;

import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="solicitudproductos")
@Table(name = "solicitudproductos")
public class SolicitudProducto   {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
        @Column(name = "tipodocumento",nullable = false,length = 2)
	private String tipo_documento;
	        
	@Column(name = "documento",nullable = false,length = 30)
	private String documento;
	
	@Column(name = "nombre",nullable = false,length = 100)
	private String nombre;
        
        @Column(name = "direccion",nullable = false,length = 100)
	private String direccion;
	
	@Column(name = "email",nullable = false,length = 50)                
	private String email;
        
        @Column(name = "estadocivil",nullable = false,length = 1 )                
	private String estado_civil;
        
        @Column(name = "fechanacimiento",nullable = false,length = 12 )
	private String fecha_nacimiento;
        
        @Column(name = "celular",nullable = false,length = 30 )
	private String celular;
        
        @Column(name = "sexo",nullable = false,length = 1 )                
	private String sexo;
        
        @Column(name = "tiposolicitud",nullable = false,length = 2 )                
	private String tipo_solicitud;
        
        @Column(name = "fechasolicitud",nullable = false,length = 12 )                
	private String fecha_solicitud;
        
        @Column(name = "aprobado",nullable = false,length = 1 )                
	private String aprobado;
      
        @Column(name = "numero",nullable = true,length = 15 )                
	private String numero;
        
	
	public SolicitudProducto() {
		
	}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getTipo_documento() {
        return tipo_documento;
    }
    
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getEstado_civil() {
        return estado_civil;
    }
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }


    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }


    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }


    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getTipo_solicitud() {
        return tipo_solicitud;
    }
    public void setTipo_solicitud(String tipo_solicitud) {
        this.tipo_solicitud = tipo_solicitud;
    }


    public String getFecha_solicitud() {
        return fecha_solicitud;
    }
    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }
    
    
    public String getAprobado() {
        return aprobado;
    }
    
    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public void GenerarNumeroProducto()
    {
        //genera un numero aleatorio para el producto
        String Codigo= GenerarCadenaAleatoria(15,false,true);
        this.setNumero(Codigo);
    }
    
    
    private String GenerarCadenaAleatoria(int Limite, boolean usarletras, boolean usarnumeros)
    {       
        int n= Limite; 
       // chose a Character random from this String
        String AlphaNumericString = "";
        
        if (usarletras)
            AlphaNumericString+="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        
        if (usarnumeros)
                AlphaNumericString += "0123456789";
                                      
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
    
}
