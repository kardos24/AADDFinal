package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.event.ActionEvent;

import controlador.Controlador;
import modelo.Catalogo;

@ManagedBean(name = "BeanCatalogos")
@SessionScoped
public class BeanCatalogos implements Serializable {

	private static final long serialVersionUID = 20L;

	private List<Catalogo> catalogos;
	private Catalogo catalogoSelected;

	private String[] selectedCategorys;
	private List<String> categorias;
	private String nombreCatalogo;

	@PostConstruct
	public void init() {
		categorias = new ArrayList<String>();
		catalogos = Controlador.getInstance().recuperarCatalogosUsuarioActivo();
	}

	public List<Catalogo> getCatalogos() {
		return catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public Catalogo getCatalogoSelected() {
		return catalogoSelected;
	}

	public void setCatalogoSelected(Catalogo catalogoSelected) {
		this.catalogoSelected = catalogoSelected;
	}

	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}

	public String[] getSelectedCategorys() {
		return selectedCategorys;
	}

	public void setSelectedCategorys(String[] selectedCategorys) {
		this.selectedCategorys = selectedCategorys;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void seleccionarCatalogo(ActionEvent evento) {
		HtmlCommandButton bottom = (HtmlCommandButton) evento.getComponent();
		UIParameter parametro = (UIParameter) bottom.findComponent("id_catalogo");
		String nombreCat = (String) parametro.getValue();
		catalogoSelected = catalogos.stream().filter(c -> c.getNombre().equals(nombreCat)).findFirst().get();
		Controlador.getInstance().setCatalogoActivo(nombreCat);
	}

	public void borrarCatalogo(ActionEvent evento) {
		HtmlCommandButton bottom = (HtmlCommandButton) evento.getComponent();
		UIParameter parametro = (UIParameter) bottom.findComponent("id_catalogo");
		String nombreCat = (String) parametro.getValue();
		Controlador.getInstance().eliminarCatalogo(nombreCat);
		catalogos.removeIf(c -> c.getNombre().equals(nombreCat));
	}

	public void crearCatalogo(ActionEvent event) {
		Controlador.getInstance().registrarCatalogo(nombreCatalogo, selectedCategorys);
		Catalogo catNew = Controlador.getInstance().getCatalogo(nombreCatalogo);
		catalogos.add(catNew);
	}

	public void addCategoriCatalogo(ActionEvent event) {
		Controlador.getInstance().establecerCategoriasCatalogo(selectedCategorys);
	}
	
	public String verDetalleCatalogo(){
		return "faceletsCatalogo";
	}

}
