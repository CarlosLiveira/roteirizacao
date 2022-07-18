package br.com.asap.roteirizacao.controllers.dto;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoSku;
import br.com.asap.roteirizacao.entities.Sku;

public class RegiaoSkuDto {
	
	private Regiao codigoRegiao;
	private Sku codigoSku;
	
	public RegiaoSkuDto() {
	}

	public RegiaoSkuDto(Regiao codigoRegiao, Sku codigoSku) {
		this.codigoRegiao = codigoRegiao;
		this.codigoSku = codigoSku;
	}
	
	public RegiaoSkuDto(RegiaoSku regiaoSku) {
		codigoRegiao = regiaoSku.getCodigoRegiao();
		codigoSku = regiaoSku.getCodigoSku();
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
	
	public static RegiaoSkuDto toDto(RegiaoSku regiaoSku) {
		RegiaoSkuDto regiaoSkuDto = new RegiaoSkuDto(regiaoSku);
		return regiaoSkuDto;
	}
	
	public RegiaoSku toEntity() {
		RegiaoSku regiaoSku = new RegiaoSku(this.codigoRegiao, this.codigoSku);
		return regiaoSku;
	}
	
}
