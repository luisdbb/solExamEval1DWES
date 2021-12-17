package servicios;

import java.util.ArrayList;

import modelo.Bono;
import modelo.Usuario;

public interface ServiciosBono {

	public boolean crearBono(Bono b);

	public void eliminarBono(Bono b);

	public boolean modificarBono(Bono b);

	public boolean actualizarBonosMayores50();
	
	public void verDetallesBono(Bono b);

	public Bono findById(int id);

	public ArrayList<Bono> mostrarBonos();

	public ArrayList<Bono> mostrarBonosPorCategoria(char c);

	public Usuario mostrarBonoPorUsuario(Usuario u);
	

}
