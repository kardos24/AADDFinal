package controlador;

public class Controlador {
	
	private static Controlador unicaInstancia = null;
	
	private Controlador(){
		
	}
	
	public static Controlador getInstance(){
		if(unicaInstancia == null){
			unicaInstancia = new Controlador();
		}
		return unicaInstancia;
	}
	
	public boolean login(String usuario, String clave){
		
		
		
		
		return true;
	}

}
