package serviciosImpl;

import java.util.ArrayList;

import modelo.Usuario;
import modelo.Viaje;
import servicios.ServiciosUsuario;
import utils.DAOFactory;

public class ServiciosUsuariompl implements ServiciosUsuario {
	DAOFactory daos = DAOFactory.getDAOs();

	public boolean crearUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	public void eliminarUsuario(Usuario u) {
		// TODO Auto-generated method stub

	}

	public boolean modificarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verDetallesUsuario(Usuario u) {
		// TODO Auto-generated method stub

	}

	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Usuario> mostrarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Usuario> mostrarUsuariosPorEdad(int edad) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario buscarUsuarioPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean recargarSaldoBono(float f) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean subirCategoria() {
		// TODO Auto-generated method stub
		return false;
	}

	public void entrar() {
		// TODO Auto-generated method stub

	}

	public void salir() {
		// TODO Auto-generated method stub

	}

	public Viaje getViajeActual(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

}
