package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.event.ActionEvent;

import controlador.Controlador;
import modelo.VideojuegoItem;

@ManagedBean(name = "BeanJuego")
@SessionScoped
public class BeanJuego implements Serializable {

	private static final long serialVersionUID = 50L;

	private List<VideojuegoItem> juegos;
	private VideojuegoItem juegoSelected;
	private String nombre;
	private String generoPrincipal;
	private String generoSecundario;
	private String descripcion;
	private String nota;
	private String fechaLanzamiento;
	private String urlFoto;
	private String urlFicha;
	private String plataformas;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public List<VideojuegoItem> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<VideojuegoItem> juegos) {
		this.juegos = juegos;
	}
	
	public VideojuegoItem getJuegoSelected() {
		return juegoSelected;
	}

	public void setJuegoSelected(VideojuegoItem juegoSelected) {
		this.juegoSelected = juegoSelected;
		nombre= juegoSelected.getNombre();
		generoPrincipal = juegoSelected.getGeneroPrincipal();
		generoSecundario = juegoSelected.getGeneroSecundario();
		descripcion = juegoSelected.getDescripcion();
		nota = juegoSelected.getNota();
		fechaLanzamiento = sdf.format(juegoSelected.getFechaLanzamiento());
		urlFoto = juegoSelected.getUrlFoto();
		urlFicha = juegoSelected.getUrlFicha();
		plataformas = juegoSelected.getPlataformas().stream().map(p->p.getNombre()).collect(Collectors.joining(","));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGeneroPrincipal() {
		return generoPrincipal;
	}

	public void setGeneroPrincipal(String generoPrincipal) {
		this.generoPrincipal = generoPrincipal;
	}

	public String getGeneroSecundario() {
		return generoSecundario;
	}

	public void setGeneroSecundario(String generoSecundario) {
		this.generoSecundario = generoSecundario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(String fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getUrlFicha() {
		return urlFicha;
	}

	public void setUrlFicha(String urlFicha) {
		this.urlFicha = urlFicha;
	}

	public String getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(String plataformas) {
		this.plataformas = plataformas;
	}

	public void seleccionarJuego(ActionEvent event){
		HtmlCommandButton bottom = (HtmlCommandButton) event.getComponent();
		UIParameter parametro = (UIParameter) bottom.findComponent("id_juego");
		String idJuego = (String) parametro.getValue();
		Controlador.getInstance().setJuegoActivo(idJuego);
		setJuegoSelected(Controlador.getInstance().getJuego(idJuego));
	}
	
	public void borrarJuego(ActionEvent event){
		HtmlCommandButton bottom = (HtmlCommandButton) event.getComponent();
		UIParameter parametro = (UIParameter) bottom.findComponent("id_juego");
		String idJuego = (String) parametro.getValue();
		Controlador.getInstance().eliminarJuego(idJuego);
		juegos.removeIf(j->j.getId().equals(idJuego));
		
	}
	
	
	
	
	
}
