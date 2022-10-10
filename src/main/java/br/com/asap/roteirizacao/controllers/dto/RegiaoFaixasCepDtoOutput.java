package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.asap.roteirizacao.entities.RegiaoFaixasCep;

public class RegiaoFaixasCepDtoOutput implements Serializable {
	private static final long serialVersionUID = 1L;

	private RegiaoDto regiaoDto;
	private List<RegiaoFaixasCep> regiaoFaixasCep = new ArrayList<RegiaoFaixasCep>();
	

	public RegiaoFaixasCepDtoOutput() {
	}

	public RegiaoFaixasCepDtoOutput(RegiaoDto regiaoDto, List<RegiaoFaixasCep> regiaoFaixasCep) {
		this.regiaoDto = regiaoDto;
		this.regiaoFaixasCep = regiaoFaixasCep;
	}

	public RegiaoDto getRegiaoDto() {
		return regiaoDto;
	}

	public void setRegiaoDto(RegiaoDto regiaoDto) {
		this.regiaoDto = regiaoDto;
	}

	public List<RegiaoFaixasCep> getRegiaoFaixasCep() {
		return regiaoFaixasCep;
	}

	public void setRegiaoFaixasCep(List<RegiaoFaixasCep> regiaoFaixasCep) {
		this.regiaoFaixasCep = regiaoFaixasCep;
	}

}
