package br.com.asap.roteirizacao.controllers.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.asap.roteirizacao.entities.Categoria;
import br.com.asap.roteirizacao.entities.Sku;
import br.com.asap.roteirizacao.entities.TipoTransporte;

public class SkuDto {

	private Long codigo;
	
	@NotNull @NotEmpty
	private String descricao;
	
	private Categoria codigoCategoria;
	private TipoTransporte codigoTipoTransporte;
	
	public SkuDto() {
	}

	public SkuDto(Long codigo, @NotNull @NotEmpty String descricao, Categoria codigoCategoria,
			TipoTransporte codigoTipoTransporte) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.codigoCategoria = codigoCategoria;
		this.codigoTipoTransporte = codigoTipoTransporte;
	}

	public SkuDto(Sku sku) {
		codigo = sku.getCodigo();
		descricao = sku.getDescricao();
		codigoCategoria = sku.getCodigoCategoria();
		codigoTipoTransporte = sku.getCodigoTipoTransporte();
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
	
	//converte entity para dto
	public static SkuDto toSkuDto(Sku sku) {
		SkuDto skuDto = new SkuDto(sku);
		return skuDto;
	}
	
	//converte dto para entity
	public Sku toSku() {
		Sku sku = new Sku(this.codigo, this.descricao, this.codigoCategoria, this.codigoTipoTransporte);
		return sku;
	}

}
