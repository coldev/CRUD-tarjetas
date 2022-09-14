package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.SolicitudProducto;
import com.app.web.servicio.SolicitudProductoServicio;

@Controller
public class SolicitudProductoControlador {

	@Autowired
	private SolicitudProductoServicio servicio;


                
	 
        @GetMapping({ "/index", "/" })
	public String paginaIndex(Model modelo) {				 
                return "credito";
	}
        
        
        @GetMapping({ "/login", "/login" })
	public String paginaLogin(Model modelo) {				 
                return "inicio_sesion";
	}
  
        @GetMapping({ "/contacto", "/contacto" })
	public String paginaContacto(Model modelo) {				 
                return "contacto";
	}
                
        @GetMapping({ "/nosotros", "/nosotros" })
	public String paginaNosotros(Model modelo) {				 
                return "nosotros";
	}
        
        
        @GetMapping({ "/tarjetacredito", "/tarjetacredito" })
	public String paginaTarjetaCredito(Model modelo) {	
            SolicitudProducto solicitud = new SolicitudProducto();
		modelo.addAttribute("solicitudproducto", solicitud);
                return "tarjetacredito";
	}
        
        @PostMapping("/tarjetacredito")
	public String guardartarjetacredito(@ModelAttribute("solicitudproducto") SolicitudProducto solicitud) {
		servicio.guardarSolicitudProducto(solicitud);
		return "redirect:/index";
	}
        
        
        @GetMapping({ "/tarjetaconsumo", "/tarjetaconsumo" })
	public String paginaTarjetaConsumo(Model modelo) {
             SolicitudProducto solicitud = new SolicitudProducto();
		modelo.addAttribute("solicitudproducto", solicitud);
                return "tarjetaconsumo";
	}
        
         @PostMapping("/tarjetaconsumo")
	public String guardartarjetaconsumo(@ModelAttribute("solicitudproducto") SolicitudProducto solicitud) {
		servicio.guardarSolicitudProducto(solicitud);
		return "redirect:/index";
	}
        
        
        
        @GetMapping({ "/producto", "/producto" })
	public String paginaProducto(Model modelo) {	
             SolicitudProducto solicitud = new SolicitudProducto();
		modelo.addAttribute("solicitudproducto", solicitud);
                return "producto";
	}
        
        @PostMapping("/producto")
	public String guardarProducto(@ModelAttribute("solicitudproducto") SolicitudProducto solicitud) {
		servicio.guardarSolicitudProducto(solicitud);
		return "redirect:/index";
	}
        
       
}
