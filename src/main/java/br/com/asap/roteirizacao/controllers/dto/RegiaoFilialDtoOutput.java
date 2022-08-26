package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegiaoFilialDtoOutput implements Serializable {

	private static final long serialVersionUID = 1L;

	private RegiaoDto regiaoDto;
	private List<RegiaoFilialDtoOutputList> filiais = new ArrayList<>();

	public RegiaoFilialDtoOutput() {
	}

	public RegiaoFilialDtoOutput(RegiaoDto regiaoDto, List<RegiaoFilialDtoOutputList> filiais) {
		this.regiaoDto = regiaoDto;
		this.filiais = filiais;
	}

	public RegiaoDto getRegiaoDto() {
		return regiaoDto;
	}

	public void setRegiaoDto(RegiaoDto regiaoDto) {
		this.regiaoDto = regiaoDto;
	}

	public List<RegiaoFilialDtoOutputList> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<RegiaoFilialDtoOutputList> filiais) {
		this.filiais = filiais;
	}

}
