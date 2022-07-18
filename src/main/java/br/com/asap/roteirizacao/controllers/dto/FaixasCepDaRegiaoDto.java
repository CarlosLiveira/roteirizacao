package br.com.asap.roteirizacao.controllers.dto;

import java.util.List;

public class FaixasCepDaRegiaoDto {
	
	private RegiaoDto regiaoDto;
	
	private List<FaixaCep> lista;

	public FaixasCepDaRegiaoDto() {
	}

	public FaixasCepDaRegiaoDto(RegiaoDto regiaoDto, List<FaixaCep> lista) {
		this.regiaoDto = regiaoDto;
		this.lista = lista;
	}

	public RegiaoDto getRegiaoDto() {
		return regiaoDto;
	}

	public void setRegiaoDto(RegiaoDto regiaoDto) {
		this.regiaoDto = regiaoDto;
	}

	public List<FaixaCep> getLista() {
		return lista;
	}

	public void setLista(List<FaixaCep> lista) {
		this.lista = lista;
	}
	
}
