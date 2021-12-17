package DAO;

import java.time.LocalDateTime;
import java.util.ArrayList;

import modelo.Usuario;
import modelo.Viaje;

public interface ViajeDAO {
	public ArrayList<Viaje> buscarViajesDeUsuarioEntreFechas(Usuario u, LocalDateTime fechaini, LocalDateTime fechafin);
}
