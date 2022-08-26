package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;

import br.com.asap.roteirizacao.entities.Filial;

public class RegiaoFilialDtoOutputList implements Serializable {

	private static final long serialVersionUID = 1L;

	private Filial filial;
	private Long ordem;

	public RegiaoFilialDtoOutputList() {
	}

	public RegiaoFilialDtoOutputList(Filial filial, Long ordem) {
		this.filial = filial;
		this.ordem = ordem;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Long getOrdem() {
		return ordem;
	}

	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}

}
