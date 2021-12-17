package serviciosImpl;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Viaje;
import modelo.Usuario;
import servicios.ServiciosViaje;
import utils.DAOFactory;

public class ServiciosViajeImpl implements ServiciosViaje {
	DAOFactory daos = DAOFactory.getDAOs();

	public boolean crearViaje(Viaje v) {
		// TODO Auto-generated method stub
		return false;
	}

	public void eliminarViaje(Viaje v) {
		// TODO Auto-generated method stub

	}

	public boolean modificarViaje(Viaje v) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verDetallesViaje(Viaje v) {
		// TODO Auto-generated method stub

	}

	public Viaje findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Viaje> mostrarViajes() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Viaje> mostrarViajesPorFecha(LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Viaje> mostrarViajesDeUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Viaje> mostrarViajesDeUsuarioEntreFechas(Usuario u, LocalDate fechaini, LocalDate fechafin) {
		// Realizar por JDBC nativo
		return daos.getViajeDAO_JDBC().buscarViajesDeUsuarioEntreFechas(u, fechaini.atStartOfDay(), (fechafin.plusDays(1)).atStartOfDay());
	}

}
