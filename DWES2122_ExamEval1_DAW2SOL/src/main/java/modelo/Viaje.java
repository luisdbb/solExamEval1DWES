package modelo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "viajes")
public class Viaje {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private Date fecha;
	private int duracion = 0;
	@ManyToOne()
	@JoinColumn(name = "idusuario")
	private Usuario usuario;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "lineaviajes", joinColumns = { @JoinColumn(name = "idviaje") }, inverseJoinColumns = {
			@JoinColumn(name = "idlinea") })
	private Set<Linea> lineas = new HashSet<Linea>();

	@ManyToOne()
	@JoinColumn(name = "idpentrada")
	private Parada entrada;
	@ManyToOne()
	@JoinColumn(name = "idpsalida")
	private Parada salida = null;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "viajeparadas", joinColumns = { @JoinColumn(name = "idviaje") }, inverseJoinColumns = {
			@JoinColumn(name = "idparada") })
	private Set<Parada> paradas = new HashSet<Parada>();

	public Viaje() {
	}

	public Viaje(int id, Date fecha, int duracion, Usuario usuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.duracion = duracion;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(Set<Linea> lineas) {
		this.lineas = lineas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracion;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((lineas == null) ? 0 : lineas.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Viaje other = (Viaje) obj;
		if (duracion != other.duracion)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (lineas == null) {
			if (other.lineas != null)
				return false;
		} else if (!lineas.equals(other.lineas))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Viaje id=" + id + "a fecha=" + fecha + "de " + duracion + "mins. efectuado por " + usuario.getNombre()
				+ " por las lineas:" + lineas + " y las paradas: " + paradas;
	}

}
