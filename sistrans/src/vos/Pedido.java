package vos;

import java.util.Date;
import org.codehaus.jackson.annotate.*;

public class Pedido {
	/**
	 * Atributo que contiene el ID de este pedido.
	 */
	@JsonProperty(value = "id")
	private Long id;
//	/**
//	 * Atributo que contiene el cliente due�o de este pedido.
//	 */
//	@JsonProperty(value = "cliente")
//	private Cliente cliente;
	/**
	 * Atributo que contiene el producto pedido.
	 */
	@JsonProperty(value = "producto")
	private ProductoLocal producto; 
	/**
	 * Atributo que contiene la fecha de este pedido.
	 */
	@JsonProperty(value = "fecha")
	private Date fecha;
	
	/**
	 * Atributo que contiene si este pedido ya ha sido servido o no.
	 */
	@JsonProperty(value = "servido")
	private Boolean servido;
	/**
	 * Atributo que contiene el ID del Restaurante al que est� asignado el Pedido.
	 */
	@JsonProperty(value = "restaurante")
	private Long idRestaurante;

	/**
	 * M�todo constructor de la clase Pedido.
	 * @param id Long, ID del pedido.
	 * @param cliente Cliente, Cliente due�o del pedido.
	 * @param producto Producto, producto ordenado.
	 * @param fecha LocalDateTime, fecha en que se hizo el pedido.
	 * @param servido Boolean, Booleano que determina si el pedido ya ha sido entregado o no.
	 * @param restaurante Restaurante, restaurante due�o del pedido.
	 */
	public Pedido(@JsonProperty(value = "id") Long id, 
//			@JsonProperty(value = "cliente") Cliente cliente, 
			@JsonProperty(value = "producto") ProductoLocal producto,
			@JsonProperty(value = "fecha") Date fecha,
			@JsonProperty(value = "servido") Boolean servido,
			@JsonProperty(value = "idRestaurante") Long idRestaurante
			) {
		this.id = id;
//		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha; 
		this.servido = servido;
		this.idRestaurante = idRestaurante;
	}
	/**
	 * M�todo que contruye un Pedido a partir de la informaci�n del Pedido conexi�n.
	 * @param pedidoConexion PedidoConexion, informaci�n del mensaje.
	 */
	public Pedido(PedidoConexion pedidoConexion)
	{
		this.id = pedidoConexion.getId();
		this.producto = new ProductoLocal(pedidoConexion.getIdProducto(), pedidoConexion.getNombreProducto(), pedidoConexion.getDescripcionEspaniol(), pedidoConexion.getDescripcionIngles(), pedidoConexion.getCostoProduccion(), null, pedidoConexion.getPrecio(), null, pedidoConexion.getCategoria(), null, null);
		this.fecha = pedidoConexion.getFecha();
		this.servido = pedidoConexion.getServido();
		this.idRestaurante = pedidoConexion.getIdRestaurante();
	}
	/**
	 * M�todo que convierte un Pedido local a un PedidoConexi�n.
	 * Se requiere de informaci�n adicional.
	 * @param nombreRestaurante String, nombre del Restaurante.
	 * @param idCliente Long, ID del Cliente.
	 * @param nombreCliente String, nombre del Cliente.
	 * @param idOrden Long, ID de la Orden.
	 * @param idMesa Long, ID de la Mesa.
	 * @Param origenPedido String, campo que determina la base de datos de origen de este Pedido.
	 * @return PedidoConexion, informaci�n apta para enviar como mensaje.
	 */
	public PedidoConexion toPedidoConexion(String nombreRestaurante, Long idCliente, String nombreCliente, Long idOrden, Long idMesa, Integer origenPedido)
	{
		Long idProducto = producto.getId();
		String nombreProducto = producto.getNombre();
		String descripcionEspaniol = producto.getDescripcionEspaniol();
		String descripcionIngles = producto.getDescripcionIngles();
		String categoria = producto.getCategoria();
		Double costoProduccion = producto.getCostoDeProduccion();
		Double precio = producto.getPrecio();
		Integer cantidadDisponible = producto.getCantidad();
		return new PedidoConexion(id, fecha, idProducto, nombreProducto, idRestaurante, nombreRestaurante, idCliente, nombreCliente, idOrden, servido, null, null, idMesa, costoProduccion, precio, categoria, descripcionEspaniol, descripcionIngles, origenPedido);
	}
	/**
	 * M�todo que obtiene el ID del pedido.
	 * @return
	 */
	public Long getId() {
		return this.id;
	}
	/**
	 * M�todo que establece el ID del pedido.
	 * @param id Long, nuevo ID del pedido.
	 */
	public void setId(Long id) {
		this.id = id;
	}
//	/**
//	 * M�todo que obtiene el cliente due�o de este pedido.
//	 * @return Cliente, cliente del Pedido.
//	 */
//	public Cliente getCliente() {
//		return this.cliente;
//	}
	/**
	 * M�todo que obtiene el Producto pedido en este Pedido.
	 * @return Producto, producto del pedido.
	 */
	public ProductoLocal getProducto() {
		return this.producto;
	}
	/**
	 * M�todo que obtiene la fecha de este Pedido.
	 * @return LocalDateTime, fecha del Pedido.
	 */
	public Date getFecha() {
		return this.fecha;
	}
	/**
	 * M�todo que obtiene un booleano que determina si el pedido ha sido entregado o no.
	 * @return Boolean, booleano que determina si el pedido ha sido entregado o no.
	 */
	public Boolean getServido() {
		return this.servido;
	}
//	/**
//	 * M�todo que establece el Cliente de este Pedido.
//	 * @param cliente Cliente, nuevo cliente due�o de este Pedido.
//	 */
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente; 
//	}
	/**
	 * M�todo que establece el Producto en este Pedido.
	 * @param producto Producto, nuevo Producto del Pedido.
	 */
	public void setProducto(ProductoLocal producto) {
		this.producto = producto; 
	}
	/**
	 * M�todo que establece la fecha de este Pedido.
	 * @param fecha LocalDateTime, nueva fecha de este Pedido.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha; 
	}
	/**
	 * M�todo que establece si este pedido ha sido servido o no.
	 * @param servido Boolean, 
	 */
	public void setServido(Boolean servido) {
		this.servido = servido; 
	}
	/**
	 * M�todo que entrega el ID del Restaurante Due�o de este Pedido.
	 * @return Long, ID del Restaurante due�o de este Pedido.
	 */
	public Long getIdRestaurante()
	{
		return this.idRestaurante;
	}
	/**
	 * M�todo que establece el ID del Restaurante due�o de este Pedido.
	 * @param idRestaurante Long, ID del Restaurante due�o de este Pedido.
	 */
	public void setIdRestaurante(Long idRestaurante)
	{
		this.idRestaurante = idRestaurante;
	}
}
