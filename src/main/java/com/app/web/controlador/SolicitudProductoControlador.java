package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.SolicitudProducto;
import com.app.web.entidad.InicioSesion;
import com.app.web.repositorio.DatacreditoRepositorio;

import com.app.web.servicio.SolicitudProductoServicio;
import com.app.web.servicio.ClienteServicio;
import com.app.web.servicio.DatacreditoServicio;

@Controller
public class SolicitudProductoControlador {

	@Autowired
	private SolicitudProductoServicio servicio;
        
        @Autowired
        private ClienteServicio serviciocliente;

        
        @Autowired
        private DatacreditoServicio serviciodatacredito;
       
	 
        @GetMapping({ "/index", "/" })
	public String paginaIndex(Model modelo) {				 
                return "credito";
	}
        
        
        @GetMapping({ "/login", "/login" })
	public String paginaLogin(Model modelo) {            
             InicioSesion solicitud = new InicioSesion();
		modelo.addAttribute("iniciosesion", solicitud);
                return "inicio_sesion";
	}
        
        @PostMapping("/login")
	public String guardarLogin(@ModelAttribute("iniciosesion") InicioSesion solicitud) {
		
             if (solicitud.getUsuario().equalsIgnoreCase( "admin") &&
                    solicitud.getClave().equalsIgnoreCase( "123")    )                
		return "redirect:/menu";
             else
                return "redirect:/login";
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
	public String guardartarjetacredito(@ModelAttribute("solicitudproducto") SolicitudProducto solicitud)
        {      
             //se verifica en datacredito los datos del cliente 
            String tipodocumento=solicitud.getTipo_documento();
            String documento= solicitud.getDocumento(); 
             
                           
            if ( serviciodatacredito.BuscarListaNegra(tipodocumento,documento) )                 
              return "redirect:/resultado?mensaje=solicitud+rechazada"; //error 

            
	    servicio.guardarSolicitudProducto(solicitud);                                                
            return "redirect:/resultado?mensaje=pendiente+de+aprobaci%C3%B3n"; //exitoso   		
	}
        
        @GetMapping({ "/resultado", "/resultado" })
	public String paginaResultado(Model modelo ) {
              
                return "resultado";
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
        
         @GetMapping({ "/menu", "/menu" })
	public String paginaMenu(Model modelo) {				 
                return "menu";
	}
        
         
        
         @GetMapping({ "/menulistado", "/menulistado" })
	public String paginaMenuListado(Model modelo) {	
            modelo.addAttribute("solicitudproductos", servicio.listarTodosLosSolicitudProducto());
            return "menulistado";
	}
        
        @GetMapping({ "/menulistadoclientes", "/menulistadoclientes" })
	public String paginaMenuListadoCliente(Model modelo) {	
            modelo.addAttribute("clientes", serviciocliente.listarTodosLosCliente());
            return "menulistadoclientes";
	}
        
        @GetMapping({ "/menulistadodatacredito", "/menulistadodatacredito" })
	public String paginamenulistadodatacredito(Model modelo) {	
            modelo.addAttribute("datacreditos", serviciodatacredito.listarTodosLosDatacredito());
            return "menulistadodatacredito";
	}
        
        
}
