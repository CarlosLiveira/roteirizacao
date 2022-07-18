package br.com.asap.roteirizacao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbFilial")
public class Filial {
	
	@Id
	private String cnpj;
	
	private String descricao;
	
	public Filial() {
	}
	
	public Filial(String cnpj, String descricao) {
		this.cnpj = cnpj;
		this.descricao = descricao;
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
}

