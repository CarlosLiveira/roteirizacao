package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class RegiaoFilialPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "regiao")
	private Regiao regiao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "filial")
	private Filial filial;

	public RegiaoFilialPk() {
	}

	public RegiaoFilialPk(Regiao regiao, Filial filial) {
		this.regiao = regiao;
		this.filial = filial;
	}

	public RegiaoFilialPk(Long codigo) {
		codigo = regiao.getCodigo();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filial, regiao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoFilialPk other = (RegiaoFilialPk) obj;
		return Objects.equals(filial, other.filial) && Objects.equals(regiao, other.regiao);
	}

}
