package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import tm.RotondAndesTM;
import vos.ClienteFrecuente;
@Path("clientesFrecuentes")
public class ClienteFrecuenteResource {


	@XmlRootElement
	public static class RequestBody {
		@XmlElement String password;
		@XmlElement Long idProd;
		@XmlElement Long idProdPasado;
	}

	@Context
	private ServletContext context;

	/**
	 * M�todo que registra la preferencia de un Cliente Frecuente registrado.
	 * @param id Long, ID del cliente.
	 * @param idProd Long, ID del producto a registrar como preferido.
	 * @param password String, contrase�a del Cliente.
	 * @return Response.
	 */
	@POST
	@Path("{ClienteId: \\d+}/preferencias")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces( { MediaType.APPLICATION_JSON  } )
	public Response setPreferenciaCliente(@PathParam("ClienteId") Long id, RequestBody request){
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			ClienteFrecuente rt = tm.agregarPreferenciaClienteFrecuente(id, request.password, request.idProd);
			return Response.status(200).entity(rt).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	/**
	 * M�todo para borrar un Producto de las preferencias de un Cliente Frecuente Registrado.
	 * @param id Long, ID del Cliente Frecuente registrado.
	 * @param idProd Long, ID del Producto a remover de Preferidos.
	 * @param password String, contrase�a del Cliente Frecuente registrado.
	 * @return Response.
	 */
	@DELETE
	@Path("{ClienteId: \\d+}/preferencias")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response deletePreferenciaCliente(@PathParam("ClienteId") Long id,  @QueryParam("idProd") Long idProd, @HeaderParam("password") String password) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.borrarPreferenciaClienteFrecuente(id, password, idProd);
			String rt = new String("{ \"RESPUESTA\": \" preferencia borrada con �xito \"}");
			return Response.status(200).entity(rt).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@PUT
	@Path("{ClienteId: \\d+}/preferencias")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response modifyPreferenciaCliente(@PathParam("ClienteId") Long id, @QueryParam("idProdPasado") Long idProdPasado, @QueryParam("idProd") Long idProd, @HeaderParam("password") String password) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.borrarPreferenciaClienteFrecuente(id, password, idProdPasado);
			ClienteFrecuente rt = tm.agregarPreferenciaClienteFrecuente(id, password, idProd);
			return Response.status(200).entity(rt).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}

	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}";
	}



}
