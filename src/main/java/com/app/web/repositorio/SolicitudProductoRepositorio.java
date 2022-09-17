/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.repositorio;

/**
 *
 *  
 */
 
import com.app.web.entidad.Datacredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.SolicitudProducto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SolicitudProductoRepositorio extends JpaRepository<SolicitudProducto, Long>
{
    
    
   @Query("SELECT t FROM solicitudproductos t WHERE t.aprobado='S' OR  t.aprobado='N' ")
   List<SolicitudProducto> ListarHistoricoSolicitudes( );  
      
   @Query("SELECT t FROM solicitudproductos t WHERE t.aprobado NOT IN ('S' , 'N') ")
   List<SolicitudProducto> ListarSolicitudesPendientes( );  
      
   @Query("SELECT t FROM solicitudproductos t WHERE t.aprobado='S' AND t.tipo_documento=?1 AND t.documento=?2  ")
   List<SolicitudProducto> ListarProductosCliente(String tipodocumento, String documento);  
    
  
}