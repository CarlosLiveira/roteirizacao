package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.asap.roteirizacao.entities.Sku;

public class RegiaoSkuDtoOutput implements Serializable {

	private static final long serialVersionUID = 1L;

	private RegiaoDto regiaoDto;
	private List<Sku> sku = new ArrayList<>();

	public RegiaoSkuDtoOutput() {
	}

	public RegiaoSkuDtoOutput(RegiaoDto regiaoDto, List<Sku> sku) {
		this.regiaoDto = regiaoDto;
		this.sku = sku;
	}

	public RegiaoDto getRegiaoDto() {
		return regiaoDto;
	}

	public void setRegiaoDto(RegiaoDto regiaoDto) {
		this.regiaoDto = regiaoDto;
	}

	public List<Sku> getSku() {
		return sku;
	}

	public void setSku(List<Sku> sku) {
		this.sku = sku;
	}

}
