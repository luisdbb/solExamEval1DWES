package serviciosImpl;

import java.util.ArrayList;

import modelo.Linea;
import modelo.Usuario;
import servicios.ServiciosLinea;
import utils.DAOFactory;

public class ServiciosLineaImpl implements ServiciosLinea {
	DAOFactory daos = DAOFactory.getDAOs();

	public boolean crearLinea(Linea l) {
		// TODO Auto-generated method stub
		return false;
	}

	public void eliminarViaje(Linea l) {
		// TODO Auto-generated method stub

	}

	public boolean modificarLinea(Linea l) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verDetallesLinea(Linea l) {
		// TODO Auto-generated method stub

	}

	public Linea findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Linea> mostrarLineas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Linea> mostrarLineasDeUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Linea> buscarLineasPorNombre(String nombre) {
		return daos.getLineaDAO_JDBC().buscarLineasPorNombre(nombre);
	}

}
