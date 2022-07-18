package br.com.asap.roteirizacao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbRegiaoSku")
public class RegiaoSku {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name = "codigoRegiao")
	private Regiao codigoRegiao;
	
	@ManyToOne
	@JoinColumn(name = "codigoSku")
	private Sku codigoSku;
	
	public RegiaoSku() {
	}

	public RegiaoSku(Regiao codigoRegiao, Sku codigoSku) {
		this.codigoRegiao = codigoRegiao;
		this.codigoSku = codigoSku;
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

	public Sku getCodigoSku() {
		return codigoSku;
	}

	public void setCodigoSku(Sku codigoSku) {
		this.codigoSku = codigoSku;
	}
	
}
