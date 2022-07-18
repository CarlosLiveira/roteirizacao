package br.com.asap.roteirizacao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbRegiaoCategoria")
public class RegiaoCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "codigoRegiao")
	private Regiao codigoRegiao;

	@ManyToOne
	@JoinColumn(name = "codigoCategoria")
	private Categoria codigoCategoria;

	public RegiaoCategoria() {
	}

	public RegiaoCategoria(Long codigo, Regiao codigoRegiao, Categoria codigoCategoria) {
		this.codigo = codigo;
		this.codigoRegiao = codigoRegiao;
		this.codigoCategoria = codigoCategoria;
	}

	public RegiaoCategoria(Regiao codigoRegiao, Categoria codigoCategoria) {
		this.codigoRegiao = codigoRegiao;
		this.codigoCategoria = codigoCategoria;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Regiao getCodigoRegiao() {
		return codigoRegiao;
	}

	public void setCodigoRegiao(Regiao codigoRegiao) {
		this.codigoRegiao = codigoRegiao;
	}

	public Categoria getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Categoria codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

}
