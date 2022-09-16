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

import com.app.web.entidad.Cliente;

public interface ClienteServicio {

	public List<Cliente> listarTodosLosCliente();
	
	public Cliente guardarCliente(Cliente solicitud);
	
	public Cliente obtenerClientePorId(Long id);
	
	public Cliente actualizarCliente(Cliente solicitud);
	
	public void eliminarCliente(Long id);
}
