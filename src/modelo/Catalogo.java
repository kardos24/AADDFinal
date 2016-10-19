package modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Catalogo {

	private String nombre;
	private Date fecha;
	private String web;
	private String url;
	
	private List<Categoria> categorias;
	private Usuario usuario;
	
	public Catalogo(String nombre, Date fecha, String web, String url, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.web = web;
		this.url = url;
		this.categorias = new LinkedList<Categoria>();
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
	

}
