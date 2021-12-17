package modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false, unique = true)
	private String nombre;
	@Column(nullable = false)
	private int edad;
	@OneToOne
	@JoinColumn(name = "idbono", unique = true)
	private Bono bono;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Viaje> viajes = new HashSet<Viaje>();

	public Usuario() {
	}

	public Usuario(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Bono getBono() {
		return bono;
	}

	public void setBono(Bono bono) {
		this.bono = bono;
	}

	public Set<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Set<Viaje> viajes) {
		this.viajes = viajes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bono == null) ? 0 : bono.hashCode());
		result = prime * result + edad;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((viajes == null) ? 0 : viajes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (bono == null) {
			if (other.bono != null)
				return false;
		} else if (!bono.equals(other.bono))
			return false;
		if (edad != other.edad)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (viajes == null) {
			if (other.viajes != null)
				return false;
		} else if (!viajes.equals(other.viajes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", IDbono=" + bono.getId() + " catBono="
				+ bono.getCategoria() +" con saldo: " + bono.getSaldo()+"euros.";
	}

}
