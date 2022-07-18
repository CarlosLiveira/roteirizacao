package br.com.asap.roteirizacao.controllers.dto;

import java.util.List;

public class TiposTransporteDaRegiaoDto {

	private RegiaoDto regiaoDto;

	private List<RegiaoTipoTransporteDto> lista;

	public TiposTransporteDaRegiaoDto() {
	}

	public TiposTransporteDaRegiaoDto(RegiaoDto regiaoDto, List<RegiaoTipoTransporteDto> lista) {
		this.regiaoDto = regiaoDto;
		this.lista = lista;
	}

	public TiposTransporteDaRegiaoDto(RegiaoDto regiaoDto) {
		this.regiaoDto = regiaoDto;
	}

	public TiposTransporteDaRegiaoDto(List<RegiaoTipoTransporteDto> regiaoTipoTransporteDto) {
		this.lista = regiaoTipoTransporteDto;
	}

	public RegiaoDto getRegiaoDto() {
		return regiaoDto;
	}

	public void setRegiaoDto(RegiaoDto regiaoDto) {
		this.regiaoDto = regiaoDto;
	}

	public List<RegiaoTipoTransporteDto> getLista() {
		return lista;
	}

	public void setLista(List<RegiaoTipoTransporteDto> lista) {
		this.lista = lista;
	}

}
