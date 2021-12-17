package DAO;

import java.util.ArrayList;

import modelo.Linea;

public interface LineaDAO {
	public ArrayList<Linea> buscarLineasPorNombre(String nombre);
}
