/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Datacredito;
import com.app.web.repositorio.DatacreditoRepositorio;
import javax.persistence.EntityManager;

@Service
public class DatacreditoServicioImpl implements DatacreditoServicio {

	@Autowired
	private DatacreditoRepositorio repositorio;

	@Override
	public List<Datacredito> listarTodosLosDatacredito() {
		return repositorio.findAll();
	}

	@Override
	public Datacredito guardarDatacredito(Datacredito solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public Datacredito obtenerDatacreditoPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Datacredito actualizarDatacredito(Datacredito solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public void eliminarDatacredito(Long id) {
		repositorio.deleteById(id);

	}
                
        @Override
	public  boolean BuscarListaNegra(String tipodocumento, String documento) {
              
            List<Datacredito> lista= listarTodosLosDatacredito();
            
            for (int i = 0; i < lista.size(); i++) {
                 Datacredito data= lista.get(i);
                 
                 if (data.getTipo_documento().equalsIgnoreCase(tipodocumento) &&
                         data.getDocumento().equalsIgnoreCase(documento)
                         )    
                  return true;   
            }
            
	    return false;
	}            
}
