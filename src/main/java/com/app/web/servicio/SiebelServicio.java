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

 
import com.app.web.entidad.Siebel;

public interface SiebelServicio {

	public List<Siebel> listarTodosLosSiebel();
	
	public Siebel guardarSiebel(Siebel solicitud);
	
	public Siebel obtenerSiebelPorId(Long id);
	
	public Siebel actualizarSiebel(Siebel solicitud);
	
	public void eliminarSiebel(Long id);
        
        public  boolean BuscarListaNegra(String tipodocumento, String documento, String tiposolicitud);
}
