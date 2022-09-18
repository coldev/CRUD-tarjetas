package com.app.web.controlador;

import com.app.web.entidad.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.SolicitudProducto;
import com.app.web.entidad.InicioSesion;
import com.app.web.repositorio.ClienteRepositorio;
import com.app.web.repositorio.SolicitudProductoRepositorio;

import com.app.web.servicio.SolicitudProductoServicio;
import com.app.web.servicio.ClienteServicio;
import com.app.web.servicio.CorreoServicio;
import com.app.web.servicio.DatacreditoServicio;
import com.app.web.servicio.SiebelServicio;
 
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SolicitudProductoControlador {

        //servicios 
    
	@Autowired
	private SolicitudProductoServicio servicio;
        
        @Autowired
        private ClienteServicio serviciocliente;
        
        @Autowired
        private DatacreditoServicio serviciodatacredito;
        
        @Autowired
        private SiebelServicio serviciosiebel;
        
        @Autowired
        private CorreoServicio serviciocorreo;
        
        //repositorios
        
        @Autowired
	private SolicitudProductoRepositorio Solicitudrepositorio;
       
        @Autowired
	private ClienteRepositorio clienterepositorio;
	 
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
		
            //se implementa un inicio de sesion simple 
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
           return ValidarCentralesdeRiesgo(solicitud)  ;                    
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
	public String guardartarjetaconsumo(@ModelAttribute("solicitudproducto") SolicitudProducto solicitud) 
        {
		return ValidarCentralesdeRiesgo(solicitud)  ; 
	}
        
        
        
        @GetMapping({ "/producto", "/producto" })
	public String paginaProducto(Model modelo) {	
             SolicitudProducto solicitud = new SolicitudProducto();
		modelo.addAttribute("solicitudproducto", solicitud);
                return "producto";
	}
        
        @PostMapping("/producto")
	public String guardarProducto(@ModelAttribute("solicitudproducto") SolicitudProducto solicitud) {
		return ValidarCentralesdeRiesgo(solicitud)  ;  
	}
        
         @GetMapping({ "/menu", "/menu" })
	public String paginaMenu(Model modelo) {				 
                return "menu";
	}
        
         
        
         @GetMapping({ "/menulistado", "/menulistado" })
	public String paginaMenuListado(Model modelo) {	
            modelo.addAttribute("solicitudproductos", Solicitudrepositorio.ListarSolicitudesPendientes());
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
        
        @GetMapping({ "/menulistadosiebel", "/menulistadosiebel" })
	public String paginamenulistadomenulistadosiebel(Model modelo) {	
            modelo.addAttribute("siebels", serviciosiebel.listarTodosLosSiebel());
            return "menulistadosiebel";
	}
        
        @GetMapping({ "/menuhistorico", "/menuhistorico" })
	public String paginamenumenuhistorico(Model modelo) {	
            modelo.addAttribute("solicitudproductos", Solicitudrepositorio.ListarHistoricoSolicitudes());
            return "menuhistorico";
	}
        
        
        @GetMapping("/menulistado/{aprobado}/{id}")
	public String menuaprobarsolicitudes(@PathVariable String aprobado,@PathVariable Long id) 
        {                
		SolicitudProducto solicitud=  servicio.obtenerSolicitudProductoPorId(id);
                
                if (solicitud != null &&
                        (aprobado.equalsIgnoreCase("S") || aprobado.equalsIgnoreCase("N"))
                    )
                {
                   solicitud.setAprobado(aprobado);
                   String resultado= EnviarCorreos( solicitud);       
                   
                   GrabarAprobacionProducto(solicitud, aprobado);                                      
                }                                  
                
		return "redirect:/menulistado";
	}

        
        @GetMapping("/menulistadoproductos/{tipodocumento}/{documento}")         
	public String paginamenumenuhistorico(@PathVariable String tipodocumento,@PathVariable String documento, Model modelo ) 
        {	
            modelo.addAttribute("solicitudproductos", Solicitudrepositorio.ListarProductosCliente(tipodocumento , documento) ) ;
            modelo.addAttribute("clientes", clienterepositorio.BuscarCliente(tipodocumento , documento) ) ;            
            return "menulistadoproductos";
	}
        
        
        
        
        
        //---------------------------------  metodos privados
        
        private String ValidarCentralesdeRiesgo(SolicitudProducto solicitud )  
        {
            //se verifica en datacredito los datos del cliente 
            String tipodocumento=solicitud.getTipo_documento();
            String documento= solicitud.getDocumento();          
            String tiposolicitud= solicitud.getTipo_solicitud();
            
            if (tiposolicitud.equalsIgnoreCase("TC") || tiposolicitud.equalsIgnoreCase("TM") ) //es credito o consumo
            {
              boolean reportado=false;  
                
               //valida centrales de riesgo datacredito
              reportado=  serviciodatacredito.BuscarListaNegra(tipodocumento,documento,tiposolicitud );                                 
              
              if (!reportado){
               //valida centrales de riesgo siebel
              reportado= serviciosiebel.BuscarListaNegra(tipodocumento,documento,tiposolicitud );                                             
              }
              
              if (reportado)
              {
                 solicitud.setAprobado("N");
                 String resultado= EnviarCorreos( solicitud);                  
                 
                 return "redirect:/resultado?mensaje=solicitud+rechazada+"+ resultado; //error    
              }
              
            }
                           
            
	    servicio.guardarSolicitudProducto(solicitud);                                                
            return "redirect:/resultado?mensaje=pendiente+de+aprobaci%C3%B3n"; //exitoso             
        }
         
        
        private void GrabarAprobacionProducto(SolicitudProducto solicitud, String Aprobado)
        {   
                   solicitud.setAprobado(Aprobado );  // aprobado de la solicitud
                   solicitud.GenerarNumeroProducto(); //genera el numero del producto
                   servicio.actualizarSolicitudProducto(solicitud); //actualiza datos 
                   
                   if (Aprobado.equalsIgnoreCase("S")) //si es aprobado crea el cliente
                   {
                      CrearCliente(solicitud);
                   }
        }
        
        
        
        private void CrearCliente(SolicitudProducto solicitud)
        {    
            List<Cliente> lista= clienterepositorio
                    .BuscarCliente(solicitud.getTipo_documento(), solicitud.getDocumento());
            Cliente cliente= new Cliente();
            
            
            if (! lista.isEmpty()) //cliente ya existe
            {
               cliente= lista.get(0);               
            }
            
            cliente.setTipo_documento(solicitud.getTipo_documento());
            cliente.setDocumento(solicitud.getDocumento());
            
            cliente.setNombre(solicitud.getNombre());
            cliente.setDireccion(solicitud.getDireccion());
            cliente.setEmail(solicitud.getEmail());
            cliente.setEstado_civil(solicitud.getEstado_civil());
            cliente.setFecha_nacimiento(solicitud.getFecha_nacimiento());
            cliente.setCelular(solicitud.getCelular());
            cliente.setSexo(solicitud.getSexo());                        
            
            serviciocliente.actualizarCliente(cliente); //crea o actualiza el cliente
        }
        
        
        private String EnviarCorreos(SolicitudProducto solicitud)
        {
            String Aprobado= solicitud.getAprobado();
            
            String MsgAprobado= " Aprobación rechazada.";
            if (Aprobado.equalsIgnoreCase("S"))
                MsgAprobado=" Aprobación Exitosa.";
            
            String Mensaje = solicitud.getTipo_documento()+" "+solicitud.getDocumento()+
                         " ( Producto: " + solicitud.ObtenerNombreProducto() +                         
                         MsgAprobado + " )";
            String resultado= serviciocorreo.EnviarCorreo( solicitud.getEmail(), Mensaje);    
            
            return  resultado;
            
        }
        
        
}
