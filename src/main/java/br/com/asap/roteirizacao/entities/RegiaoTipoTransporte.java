package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbRegiaoTipoTransporte")
public class RegiaoTipoTransporte implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegiaoTipoTransportePK regiaoTipoTransportePK = new RegiaoTipoTransportePK();

	public RegiaoTipoTransporte() {
	}

	public RegiaoTipoTransporte(Regiao regiao, TipoTransporte tipoTransporte) {
		this.regiaoTipoTransportePK.setRegiao(regiao);
		this.regiaoTipoTransportePK.setTipoTransporte(tipoTransporte);
	}

	public RegiaoTipoTransportePK getRegiaoTipoTransportePK() {
		return regiaoTipoTransportePK;
	}

	public void setRegiaoTipoTransportePK(RegiaoTipoTransportePK regiaoTipoTransportePK) {
		this.regiaoTipoTransportePK = regiaoTipoTransportePK;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regiaoTipoTransportePK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoTipoTransporte other = (RegiaoTipoTransporte) obj;
		return Objects.equals(regiaoTipoTransportePK, other.regiaoTipoTransportePK);
	}

}
