package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class RegiaoTipoTransportePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "regiao")
	private Regiao regiao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tipoTransporte")
	private TipoTransporte tipoTransporte;

	public RegiaoTipoTransportePK() {
	}

	public RegiaoTipoTransportePK(Regiao regiao, TipoTransporte tipoTransporte) {
		this.regiao = regiao;
		this.tipoTransporte = tipoTransporte;
	}

	public RegiaoTipoTransportePK(Long codigo) {
		codigo = regiao.getCodigo();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regiao, tipoTransporte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoTipoTransportePK other = (RegiaoTipoTransportePK) obj;
		return Objects.equals(regiao, other.regiao) && Objects.equals(tipoTransporte, other.tipoTransporte);
	}

}
