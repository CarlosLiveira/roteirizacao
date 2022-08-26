package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbFilial")
public class Filial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cnpj")
	private String cnpj;

	private String descricao;

	public Filial() {
	}

	public Filial(String cnpj, String descricao) {
		this.cnpj = cnpj;
		this.descricao = descricao;
	}

	public Filial(Filial form) {
		this.cnpj = form.getCnpj();
		this.descricao = form.getDescricao();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filial other = (Filial) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

}
