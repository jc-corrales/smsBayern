package rest;

import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import tm.RotondAndesTM;
import vos.Zona;


/**
 * Clase que administra el Rest de la clase Zona.
 * @author ASUS
 *
 */
@Path("zonas")
@Produces("application/json")
@Consumes("application/json")
public class ZonasResource
{
	/**
	 * Clase que contiene la informaci�n del cuerpo de entrada.
	 * @author ASUS
	 *
	 */
	@XmlRootElement
	public static class RequestBody {
	    @XmlElement Long id;
	    @XmlElement String nombre;
	    @XmlElement Boolean esEspacioAbierto;
	    @XmlElement Integer capacidad;
	    @XmlElement Boolean esIncluyente;
	    @XmlElement List<String> condiciones;
	}
	
	/**
	 * Atributo que contiene el contexto.
	 */
	@Context
	private ServletContext context;
	/**
	 * M�todo que obtiene el path.
	 * @return
	 */
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	/**
	 * M�todo que imrpime mensajes de error.
	 * @param e
	 * @return
	 */
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	/**
	 * M�todo que obtiene una Zona.
	 * @param idZona Long, ID de la zona a obtener.
	 * @return Response, toda la informaci�n de la Zona.
	 */
	@GET
	@Path("{idZona: \\d+}")
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getZona(@PathParam("idZona") Long idZona) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Zona zona = tm.darZona(idZona);
			return Response.status( 200 ).entity( zona ).build( );		
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	/**
	 * M�todo que registra una nueva Zona.
	 * @param zona Zona, datos de la Zona.
	 * @return Response, Zona con toda la informaci�n proporcionada.
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response agregarZona(Zona zona) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			
			Zona res = tm.agregarZona(zona);
			return Response.status( 200 ).entity( res ).build();	
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	
}
