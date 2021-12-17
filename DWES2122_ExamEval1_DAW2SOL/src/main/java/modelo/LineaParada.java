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
@Table(name = "lineaparadas")
public class LineaParada {

	@SuppressWarnings("serial")
	@Embeddable
	public static class Id implements Serializable {

		@Column(name = "idlinea")
		private int idlinea;

		@Column(name = "idparada")
		private int idparada;

		public Id() {
		}

		public Id(int idlinea, int idparada) {
			this.idlinea = idlinea;
			this.idparada = idparada;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idlinea;
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
			if (idlinea != other.idlinea)
				return false;
			if (idparada != other.idparada)
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
	@JoinColumn(name = "idparada", insertable = false, updatable = false)
	private Parada parada;

	public LineaParada() {

	}

	public LineaParada(Linea linea, Parada parada) {
		this.linea = linea;
		this.parada = parada;
		this.id.idlinea = linea.getId();
		this.id.idparada = parada.getId();
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
		result = prime * result + ((linea == null) ? 0 : linea.hashCode());
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
		LineaParada other = (LineaParada) obj;
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
		if (parada == null) {
			if (other.parada != null)
				return false;
		} else if (!parada.equals(other.parada))
			return false;
		return true;
	}

}
