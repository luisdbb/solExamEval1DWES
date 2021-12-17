package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.LineaParada.Id;

@Entity
@Table(name = "viajeparadas")
public class ViajeParada {
	@SuppressWarnings("serial")
	@Embeddable
	public static class Id implements Serializable {

		@Column(name = "idviaje")
		private int idviaje;

		@Column(name = "idparada")
		private int idparada;

		public Id() {
		}

		public Id(int idviaje, int idparada) {
			this.idviaje = idviaje;
			this.idparada = idparada;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idviaje;
			result = prime * result + idparada;
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
			if (idviaje != other.idviaje)
				return false;
			if (idparada != other.idparada)
				return false;
			return true;
		}

	}

	@EmbeddedId
	private Id id = new Id();

	@ManyToOne
	@JoinColumn(name = "idviaje", insertable = false, updatable = false)
	private Viaje viaje;

	@ManyToOne
	@JoinColumn(name = "idparada", insertable = false, updatable = false)
	private Parada parada;

	public ViajeParada() {

	}

	public ViajeParada(Viaje viaje, Parada parada) {
		this.viaje= viaje;
		this.parada = parada;
		this.id.idviaje = viaje.getId();
		this.id.idparada = parada.getId();
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje v) {
		this.viaje = v;
	}

	public Parada getParada() {
		return parada;
	}

	public void setParada(Parada p) {
		this.parada = p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((viaje == null) ? 0 : viaje.hashCode());
		result = prime * result + ((parada == null) ? 0 : parada.hashCode());
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
		ViajeParada other = (ViajeParada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (viaje == null) {
			if (other.viaje != null)
				return false;
		} else if (!viaje.equals(other.viaje))
			return false;
		if (parada == null) {
			if (other.parada != null)
				return false;
		} else if (!parada.equals(other.parada))
			return false;
		return true;
	}

}
