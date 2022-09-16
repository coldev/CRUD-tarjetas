/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.repositorio;

/**
 *
 *  
 */
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}