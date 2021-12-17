package servicios;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Usuario;
import modelo.Viaje;

public interface ServiciosViaje {
	
	public boolean crearViaje(Viaje v);

	public void eliminarViaje(Viaje v);

	public boolean modificarViaje(Viaje v);

	public void verDetallesViaje(Viaje v);

	public Viaje findById(int id);

	public ArrayList<Viaje> mostrarViajes();

	public ArrayList<Viaje> mostrarViajesPorFecha(LocalDate fecha);
	
	public ArrayList<Viaje> mostrarViajesDeUsuario(Usuario u);
	
	public ArrayList<Viaje> mostrarViajesDeUsuarioEntreFechas(Usuario u, LocalDate fechaini, LocalDate fechafin);
}
