package fachada;

import utils.*;
import servicios.*;

public class Fachada {
	private static Fachada portal;
	//DAOFactory factoriaDAO = DAOFactory.getDAOs();
	ServiciosFactory factoriaServicios = ServiciosFactory.getServicios();

	ServiciosBono servBonos = factoriaServicios.getServiciosBonos();
	ServiciosUsuario servUsuarios = factoriaServicios.getServiciosUsuarios();
	ServiciosViaje servViajes = factoriaServicios.getServiciosViajes();
	ServiciosLinea servLineas = factoriaServicios.getServiciosLineas();

	public static Fachada getPortal() {
		if (portal == null)
			portal = new Fachada();
		return portal;
	}
	
	public void mostrarMenuSeleccionRol() {
		System.out.println("Seleccione su rol:");
		System.out.println("1.  Usuario de transportes.");
		System.out.println("2.  Administrador.");
		System.out.println("3.  Salir");
	}

	public void mostrarMenuPrincipalUsuario() {
		System.out.println("Seleccione la opcion:");
		System.out.println("1.  Registrarse");
		System.out.println("2.  Buscar líneas por nombre");
		System.out.println("3.  Ver/Recargar saldo de bono");
		System.out.println("4.  Subir de categoria");
		System.out.println("5.  Embarcar en viaje (nuevo)");
		System.out.println("6.  Trasbordo en viaje (cambio de linea)");
		System.out.println("7.  Salir del viaje");
		System.out.println("8.  Visualizar viajes efectuados");
		System.out.println("9.  Salir");
	}
	
	public void mostrarMenuPrincipalAdministrador() {
		System.out.println("Seleccione la opcion:");
		System.out.println("1.  VISUALIZAR VIAJES EFECTUADOS por un USUARIO entre FECHAS");
		System.out.println("2.  ACTUALIZAR BONOS de MAYORES");
		System.out.println("3.  Salir");
	}
}
	