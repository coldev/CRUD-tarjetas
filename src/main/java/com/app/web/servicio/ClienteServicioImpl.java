/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Cliente;
import com.app.web.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteRepositorio repositorio;

	@Override
	public List<Cliente> listarTodosLosCliente() {
		return repositorio.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public Cliente obtenerClientePorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Cliente actualizarCliente(Cliente solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public void eliminarCliente(Long id) {
		repositorio.deleteById(id);

	}

}
