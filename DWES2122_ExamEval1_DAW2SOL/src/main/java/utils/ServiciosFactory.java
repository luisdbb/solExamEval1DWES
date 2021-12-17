package utils;

import servicios.*;
import serviciosImpl.*;

public class ServiciosFactory {
	public static ServiciosFactory servicios;

	public static ServiciosFactory getServicios() {
		if (servicios == null)
			servicios = new ServiciosFactory();
		return servicios;
	}

	public ServiciosBono getServiciosBonos() {
		return new ServiciosBonoImpl();
	}

	public ServiciosUsuario getServiciosUsuarios() {
		return new ServiciosUsuariompl();
	}

	public ServiciosLinea getServiciosLineas() {
		return new ServiciosLineaImpl();
	}

	public ServiciosViaje getServiciosViajes() {
		return new ServiciosViajeImpl();
	}

}
