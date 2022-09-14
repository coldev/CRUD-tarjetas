/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.SolicitudProducto;
import com.app.web.repositorio.SolicitudProductoRepositorio;

@Service
public class SolicitudProductoServicioImpl implements SolicitudProductoServicio {

	@Autowired
	private SolicitudProductoRepositorio repositorio;

	@Override
	public List<SolicitudProducto> listarTodosLosSolicitudProducto() {
		return repositorio.findAll();
	}

	@Override
	public SolicitudProducto guardarSolicitudProducto(SolicitudProducto solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public SolicitudProducto obtenerSolicitudProductoPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public SolicitudProducto actualizarSolicitudProducto(SolicitudProducto solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public void eliminarSolicitudProducto(Long id) {
		repositorio.deleteById(id);

	}

}
