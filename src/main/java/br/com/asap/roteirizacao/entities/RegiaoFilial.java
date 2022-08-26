package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbRegiaoFilial")
public class RegiaoFilial implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegiaoFilialPk regiaoFilialPk = new RegiaoFilialPk();

	private Long ordem;

	public RegiaoFilial() {
	}

	public RegiaoFilial(Regiao regiao, Filial filial) {
		this.regiaoFilialPk.setRegiao(regiao);
		this.regiaoFilialPk.setFilial(filial);
	}

	public RegiaoFilial(RegiaoFilialPk regiaoFilialPk, Long ordem) {
		this.regiaoFilialPk = regiaoFilialPk;
		this.ordem = ordem;
	}

	public RegiaoFilialPk getRegiaoFilialPk() {
		return regiaoFilialPk;
	}

	public void setRegiaoFilialPk(RegiaoFilialPk regiaoFilialPk) {
		this.regiaoFilialPk = regiaoFilialPk;
	}

	public Long getOrdem() {
		return ordem;
	}

	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regiaoFilialPk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoFilial other = (RegiaoFilial) obj;
		return Objects.equals(regiaoFilialPk, other.regiaoFilialPk);
	}

}
