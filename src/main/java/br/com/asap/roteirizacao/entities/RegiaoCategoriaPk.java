package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class RegiaoCategoriaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "codigoRegiao")
	private Regiao regiao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "codigoCategoria")
	private Categoria categoria;

	public RegiaoCategoriaPk() {
	}

	public RegiaoCategoriaPk(Regiao regiao, Categoria categoria) {
		this.regiao = regiao;
		this.categoria = categoria;
	}
	
	public RegiaoCategoriaPk(Long codigo) {
		codigo = regiao.getCodigo();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, regiao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoCategoriaPk other = (RegiaoCategoriaPk) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(regiao, other.regiao);
	}

}
