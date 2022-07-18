package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.List;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.TipoTransporte;

public class RegiaoTipoTransporteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Regiao regiao;
	private TipoTransporte tipoTransporte;

	public RegiaoTipoTransporteDto() {
	}

	public RegiaoTipoTransporteDto(Regiao regiao, TipoTransporte tipoTransporte) {
		this.regiao = regiao;
		this.tipoTransporte = tipoTransporte;
	}

	public RegiaoTipoTransporteDto(RegiaoDto regiaoDto, List<RegiaoTipoTransporteDto> regiaoTipoTransporteDto) {
		regiaoDto.setCodigo(regiao.getCodigo());
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

}
