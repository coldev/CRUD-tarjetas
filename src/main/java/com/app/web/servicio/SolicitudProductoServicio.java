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

import com.app.web.entidad.SolicitudProducto;

public interface SolicitudProductoServicio {

	public List<SolicitudProducto> listarTodosLosSolicitudProducto();
	
	public SolicitudProducto guardarSolicitudProducto(SolicitudProducto solicitud);
	
	public SolicitudProducto obtenerSolicitudProductoPorId(Long id);
	
	public SolicitudProducto actualizarSolicitudProducto(SolicitudProducto solicitud);
	
	public void eliminarSolicitudProducto(Long id);
}
