package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.List;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.Sku;

public class RegiaoSkuDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Regiao regiao;
	private Sku sku;

	public RegiaoSkuDto() {
	}

	public RegiaoSkuDto(Regiao regiao, Sku sku) {
		this.regiao = regiao;
		this.sku = sku;
	}

	public RegiaoSkuDto(RegiaoDto regiaoDto, List<RegiaoSkuDto> regiaoSkuDto) {
		regiaoDto.setCodigo(regiao.getCodigo());
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public Sku getSku() {
		return sku;
	}

}
