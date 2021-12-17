package principal;

import java.util.Scanner;

import fachada.*;

public class Principal {

	public static void main(String[] args) {
		Fachada portal = Fachada.getPortal();
		Scanner in = new Scanner(System.in);

		int opcion = 0;
		do {
			System.out.println("Programa de gestion de transportes");
			portal.mostrarMenuSeleccionRol();
			opcion = in.nextInt();
			if (opcion < 0 || opcion > 2) {
				System.out.println("Opcion incorrecta.\n");
				continue;
			}
			int subopcion = -1;
			switch (opcion) {
			case 1:
				do {
					portal.mostrarMenuPrincipalUsuario();
					subopcion = in.nextInt();
					if (subopcion < 1 || subopcion > 9) {
						System.out.println("Opcion incorrecta.\n");
						continue;
					}
					//Aquí ya se tiene la subopción del menú para un usuario del servicio de transportes
					FachadaUsuario portalusuario = new FachadaUsuario(subopcion);
					if (subopcion == 9) {
						System.out.println("Saliendo...");
						return;
					}
				} while (subopcion != 9);
				break;
			case 2:
				do {
					portal.mostrarMenuPrincipalAdministrador();
					subopcion = in.nextInt();
					if (subopcion < 1 || subopcion > 3) {
						System.out.println("Opcion incorrecta.\n");
						continue;
					}
					//Aquí ya se tiene la subopción del menú para un administrador de la red de transportes
					FachadaAdministrativa portaladmin = new FachadaAdministrativa(subopcion);
					if (subopcion == 3) {
						System.out.println("Saliendo...");
						return;
					}
				} while (subopcion != 3);
				
				break;
			default:
				System.out.println("Saliendo...");
				break;
			}
		} while (opcion != 0);

		System.out.println("GRACIAS por su visita.");
	}

}
