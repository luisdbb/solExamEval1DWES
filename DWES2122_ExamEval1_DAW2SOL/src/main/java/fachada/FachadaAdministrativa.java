package fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.*;
import utils.ServiciosFactory;
import utils.Utilidades;

public class FachadaAdministrativa {
	public static ServiciosFactory servicios = ServiciosFactory.getServicios();
	Scanner in = new Scanner(System.in);

	public FachadaAdministrativa(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("Opcion VISUALIZAR VIAJES EFECTUADOS por un USUARIO entre FECHAS mediante JDBC");
			System.out.println("Introduzca el NIF del usuario:");
			String nif = in.nextLine();
			Usuario usuario = servicios.getServiciosUsuarios().buscarUsuarioPorNombre(nif);
			if (usuario != null) {
				LocalDate fechaIni, fechaFin;
				System.out.println("Introduzca la primera fecha:");
				fechaIni = Utilidades.leerFecha();
				System.out.println("Introduzca la segunda fecha:");
				fechaFin = Utilidades.leerFecha();
				ArrayList<Viaje> viajesusuario = servicios.getServiciosViajes()
						.mostrarViajesDeUsuarioEntreFechas(usuario, fechaIni, fechaFin);
				if (viajesusuario.size() > 0) {
					System.out.println("El usuario de NIF:" + usuario.getNombre()
							+ " ha realizado los siguientes viajes entre el " + fechaIni.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + " y el  " + fechaFin.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + ":");
					for (Viaje v : viajesusuario) {
						System.out.println("Viaje ID:" + v.getId() + " comenzó el " + v.getFecha().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss")) + " de duración "
								+ v.getDuracion() + " mins. Pasó por las líneas:");
						for (Linea l : v.getLineas())
							System.out.print(l.getId() + "--> Linea " + l.getNombre() + ",\t");
					}
				} else
					System.out.println("No se han encontrado viajes del usuario de NIF:" + usuario.getNombre()
							+ " efectuados entre el " + fechaIni + " y el " + fechaFin);
			} else
				System.out.println("EROR: No se ha encontrado un usuario con ese NIF.");
			break;
		case 2:
			System.out.println("Opcion ACTUALIZAR BONOS");
			System.out.println(
					"Se van a actualizar todos los bonos de mayores de 50 años a la categoria C mediante JDBC.");
			
			servicios.getServiciosBonos().actualizarBonosMayores50();
			ArrayList<Bono> todosbonos = servicios.getServiciosBonos().mostrarBonos();
			for (Bono b : todosbonos) {
				System.out.println("Bono de ID:" + b.getId()+" de categoria: "+ b.getCategoria());
			}
			break;
		case 3:
			System.out.println("SALIR");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}

	}
}
