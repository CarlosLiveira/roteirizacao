package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.List;

import br.com.asap.roteirizacao.entities.Filial;
import br.com.asap.roteirizacao.entities.Regiao;

public class RegiaoFilialDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Regiao regiao;
	private Filial filial;
	private Long ordem;

	public RegiaoFilialDto() {
	}

	public RegiaoFilialDto(Regiao regiao, Filial filial, Long ordem) {
		this.regiao = regiao;
		this.filial = filial;
		this.ordem = ordem;
	}

	public RegiaoFilialDto(RegiaoDto regiaoDto, List<RegiaoFilialDto> regiaoFilialDto) {
		regiaoDto.setCodigo(regiao.getCodigo());
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public Filial getFilial() {
		return filial;
	}

	public Long getOrdem() {
		return ordem;
	}

}
