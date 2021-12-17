package modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lineas")
public class Linea {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false, unique = true)
	private String nombre;

	@ManyToMany(mappedBy = "viajes")
	private Set<Viaje> viajes = new HashSet<Viaje>();
	
	@ManyToMany(mappedBy = "paradas")
	private Set<Parada> paradas = new HashSet<Parada>();


	public Linea() {
	}

	public Linea(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Set<Viaje> viajes) {
		this.viajes = viajes;
	}

	@Override
	public String toString() {
		return "Linea " + id + "[\"" + nombre + "\"]";
	}

}
