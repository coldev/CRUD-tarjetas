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

import com.app.web.entidad.Datacredito;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DatacreditoRepositorio extends JpaRepository<Datacredito, Long>
{
    
   @Query("SELECT t FROM datacreditos t WHERE t.tipo_documento=?1 AND t.documento=?2")
   List<Datacredito> BuscarListaNegra(String tipodocumento, String documento);  
   
  
}

 