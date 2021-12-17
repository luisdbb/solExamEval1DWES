package modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paradas")
public class Parada {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false, unique = true)
	private String nombre;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "lineaparadas", joinColumns = { @JoinColumn(name = "idparada") }, inverseJoinColumns = {
			@JoinColumn(name = "idlinea") })
	private Set<Linea> lineas = new HashSet<Linea>();
	
	
	private Set<Viaje> viajes = new HashSet<Viaje>();

	public Parada() {
	}

	public Parada(int id, String nombre) {
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


	@Override
	public String toString() {
		return "Parada " + id + "[\"" + nombre + "\"]";
	}

}
