/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Siebel;
import com.app.web.repositorio.SiebelRepositorio;

@Service
public class SiebelServicioImpl implements SiebelServicio {
      
	@Autowired
	private SiebelRepositorio repositorio;

	@Override
	public List<Siebel> listarTodosLosSiebel() {
		return repositorio.findAll();
	}

	@Override
	public Siebel guardarSiebel(Siebel solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public Siebel obtenerSiebelPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Siebel actualizarSiebel(Siebel solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public void eliminarSiebel(Long id) {
		repositorio.deleteById(id);

	}
                
        @Override
	public  boolean BuscarListaNegra(String tipodocumento, String documento, String tiposolicitud)
        {
          List<Siebel> lista=  repositorio.BuscarListaNegra(tipodocumento,documento );
          
          if ( lista.isEmpty() )  //no esta reportado a datacredito
              return false;
          
          return true;         
   
	}           
}
