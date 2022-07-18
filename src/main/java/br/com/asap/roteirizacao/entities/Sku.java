package br.com.asap.roteirizacao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbSku")
public class Sku {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "codigoCategoria")
	private Categoria codigoCategoria;
	
	@ManyToOne
	@JoinColumn(name = "codigoTipoTransporte")
	private TipoTransporte codigoTipoTransporte;
	
	public Sku() {
	}

	public Sku(Long codigo, String descricao, Categoria codigoCategoria, TipoTransporte codigoTipoTransporte) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.codigoCategoria = codigoCategoria;
		this.codigoTipoTransporte = codigoTipoTransporte;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Categoria getCodigoCategoria() {
		return codigoCategoria;				
	}
	
	public void setCodigoCategoria(Categoria codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public TipoTransporte getCodigoTipoTransporte() {
		return codigoTipoTransporte;
	}

	public void setCodigoTipoTransporte(TipoTransporte codigoTipoTransporte) {
		this.codigoTipoTransporte = codigoTipoTransporte;
	}
	
}
