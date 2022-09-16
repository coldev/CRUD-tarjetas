package com.app.web.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datacreditos")
public class Datacredito   {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
        @Column(name = "tipodocumento",nullable = false,length = 2)
	private String tipo_documento;
	        
	@Column(name = "documento",nullable = false,length = 30)
	private String documento;
	
        
	
	public Datacredito() {
		
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


   
   
}
