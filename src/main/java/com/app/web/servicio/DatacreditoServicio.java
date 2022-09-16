/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;

/**
 *
 * @author  
 */
import java.util.List;

import com.app.web.entidad.Datacredito;

public interface DatacreditoServicio {

	public List<Datacredito> listarTodosLosDatacredito();
	
	public Datacredito guardarDatacredito(Datacredito solicitud);
	
	public Datacredito obtenerDatacreditoPorId(Long id);
	
	public Datacredito actualizarDatacredito(Datacredito solicitud);
	
	public void eliminarDatacredito(Long id);
        
        public  boolean BuscarListaNegra(String tipodocumento, String documento);
}
