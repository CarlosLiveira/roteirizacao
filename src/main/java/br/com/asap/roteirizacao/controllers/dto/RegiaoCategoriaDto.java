package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.List;

import br.com.asap.roteirizacao.entities.Categoria;
import br.com.asap.roteirizacao.entities.Regiao;

public class RegiaoCategoriaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Regiao regiao;
	private Categoria categoria;

	public RegiaoCategoriaDto() {
	}

	public RegiaoCategoriaDto(Regiao regiao, Categoria categoria) {
		this.regiao = regiao;
		this.categoria = categoria;
	}

	public RegiaoCategoriaDto(RegiaoDto regiaoDto, List<RegiaoCategoriaDto> regiaoCategoriaDto) {
		regiaoDto.setCodigo(regiao.getCodigo());
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
