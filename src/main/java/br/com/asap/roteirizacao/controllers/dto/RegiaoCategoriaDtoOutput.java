package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.asap.roteirizacao.entities.Categoria;

public class RegiaoCategoriaDtoOutput implements Serializable {

	private static final long serialVersionUID = 1L;

	private RegiaoDto regiaoDto;
	private List<Categoria> categorias = new ArrayList<Categoria>();

	public RegiaoCategoriaDtoOutput() {
	}

	public RegiaoCategoriaDtoOutput(RegiaoDto regiaoDto, List<Categoria> categorias) {
		this.regiaoDto = regiaoDto;
		this.categorias = categorias;
	}

	public RegiaoDto getRegiaoDto() {
		return regiaoDto;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

}
