package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.asap.roteirizacao.entities.TipoTransporte;

public class RegiaoTipoTransporteDtoOutput implements Serializable {

	private static final long serialVersionUID = 1L;

	private RegiaoDto regiaoDto;
	private List<TipoTransporte> tipoTransporte = new ArrayList<TipoTransporte>();

	public RegiaoTipoTransporteDtoOutput() {
	}

	public RegiaoTipoTransporteDtoOutput(RegiaoDto regiaoDto, List<TipoTransporte> tipoTransporte) {
		this.regiaoDto = regiaoDto;
		this.tipoTransporte = tipoTransporte;
	}

	public RegiaoDto getRegiao() {
		return regiaoDto;
	}

	public List<TipoTransporte> getTipoTransporte() {
		return tipoTransporte;
	}

}
