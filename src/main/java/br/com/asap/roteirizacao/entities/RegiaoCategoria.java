package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbRegiaoCategoria")
public class RegiaoCategoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegiaoCategoriaPk regiaoCategoriaPk = new RegiaoCategoriaPk();

	public RegiaoCategoria() {
	}

	public RegiaoCategoria(Regiao regiao, Categoria categoria) {
		this.regiaoCategoriaPk.setRegiao(regiao);
		this.regiaoCategoriaPk.setCategoria(categoria);
	}

	public RegiaoCategoriaPk getRegiaoCategoriaPk() {
		return regiaoCategoriaPk;
	}

	public void setRegiaoCategoriaPk(RegiaoCategoriaPk regiaoCategoriaPk) {
		this.regiaoCategoriaPk = regiaoCategoriaPk;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regiaoCategoriaPk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoCategoria other = (RegiaoCategoria) obj;
		return Objects.equals(regiaoCategoriaPk, other.regiaoCategoriaPk);
	}

}
