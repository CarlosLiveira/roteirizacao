package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbRegiaoSku")
public class RegiaoSku implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegiaoSkuPk regiaoSkuPk = new RegiaoSkuPk();

	public RegiaoSku() {
	}

	public RegiaoSku(RegiaoSkuPk regiaoSkuPk) {
		this.regiaoSkuPk = regiaoSkuPk;
	}

	public RegiaoSku(Regiao regiao, Sku sku) {
		this.regiaoSkuPk.setRegiao(regiao);
		this.regiaoSkuPk.setSku(sku);
	}

	public RegiaoSkuPk getRegiaoSkuPk() {
		return regiaoSkuPk;
	}

	public void setRegiaoSkuPk(RegiaoSkuPk regiaoSkuPk) {
		this.regiaoSkuPk = regiaoSkuPk;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regiaoSkuPk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoSku other = (RegiaoSku) obj;
		return Objects.equals(regiaoSkuPk, other.regiaoSkuPk);
	}

}
