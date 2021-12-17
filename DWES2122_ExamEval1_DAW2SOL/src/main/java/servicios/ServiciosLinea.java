package servicios;

import java.util.ArrayList;

import modelo.Usuario;
import modelo.Linea;

public interface ServiciosLinea {
	
	public boolean crearLinea(Linea l);

	public void eliminarViaje(Linea l);

	public boolean modificarLinea(Linea l);

	public void verDetallesLinea(Linea l);

	public Linea findById(int id);

	public ArrayList<Linea> mostrarLineas();

	public ArrayList<Linea> buscarLineasPorNombre(String nombre);
	
	public ArrayList<Linea> mostrarLineasDeUsuario(Usuario u);
}
