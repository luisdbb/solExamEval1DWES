package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lineaviajes")
public class LineaViaje {

	@SuppressWarnings("serial")
	@Embeddable
	public static class Id implements Serializable {

		@Column(name = "idlinea")
		private int idlinea;

		@Column(name = "idviaje")
		private int idviaje;

		public Id() {
		}

		public Id(int idlinea, int idviaje) {
			this.idlinea = idlinea;
			this.idviaje = idviaje;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idlinea;
			result = prime * result + idviaje;
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
			Id other = (Id) obj;
			if (idlinea != other.idlinea)
				return false;
			if (idviaje != other.idviaje)
				return false;
			return true;
		}

	}

	@EmbeddedId
	private Id id = new Id();

	@ManyToOne
	@JoinColumn(name = "idlinea", insertable = false, updatable = false)
	private Linea linea;

	@ManyToOne
	@JoinColumn(name = "idviaje", insertable = false, updatable = false)
	private Viaje viaje;

	public LineaViaje() {

	}

	public LineaViaje(Linea linea, Viaje viaje) {
		this.linea = linea;
		this.viaje = viaje;
		this.id.idlinea = linea.getId();
		this.id.idviaje = viaje.getId();
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linea == null) ? 0 : linea.hashCode());
		result = prime * result + ((viaje == null) ? 0 : viaje.hashCode());
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
		LineaViaje other = (LineaViaje) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linea == null) {
			if (other.linea != null)
				return false;
		} else if (!linea.equals(other.linea))
			return false;
		if (viaje == null) {
			if (other.viaje != null)
				return false;
		} else if (!viaje.equals(other.viaje))
			return false;
		return true;
	}

}
