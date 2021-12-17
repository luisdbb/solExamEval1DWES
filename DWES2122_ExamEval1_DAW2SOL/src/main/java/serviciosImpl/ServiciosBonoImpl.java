package serviciosImpl;

import java.util.ArrayList;

import modelo.Bono;
import modelo.Usuario;
import servicios.ServiciosBono;
import utils.DAOFactory;

public class ServiciosBonoImpl implements ServiciosBono {
	DAOFactory daos = DAOFactory.getDAOs();

	public boolean crearBono(Bono b) {
		// TODO Auto-generated method stub
		return false;
	}

	public void eliminarBono(Bono b) {
		// TODO Auto-generated method stub

	}

	public boolean modificarBono(Bono b) {
		// A través de JDBC
		try {
			daos.getBonoDAO_JDBC().modificarBono(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void verDetallesBono(Bono b) {
		// TODO Auto-generated method stub

	}

	public Bono findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Bono> mostrarBonos() {
		return daos.getBonoDAO_JDBC().todosBonos();
	}

	public ArrayList<Bono> mostrarBonosPorCategoria(char c) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario mostrarBonoPorUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean actualizarBonosMayores50() {
		try {
			daos.getBonoDAO_JDBC().actualizarBonosMayores50();
			return true;
		} catch (Exception e) {
			System.out.println("Se ha producido una excepcion:" + e.getMessage());
			return false;
		}
	}

}
