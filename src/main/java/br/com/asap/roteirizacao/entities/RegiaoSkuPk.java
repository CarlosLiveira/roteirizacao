package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class RegiaoSkuPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "regiao")
	private Regiao regiao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "sku")
	private Sku sku;

	public RegiaoSkuPk() {
	}

	public RegiaoSkuPk(Regiao regiao, Sku sku) {
		this.regiao = regiao;
		this.sku = sku;
	}
	
	public RegiaoSkuPk(Long codigo) {
		codigo = regiao.getCodigo();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regiao, sku);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoSkuPk other = (RegiaoSkuPk) obj;
		return Objects.equals(regiao, other.regiao) && Objects.equals(sku, other.sku);
	}

}
