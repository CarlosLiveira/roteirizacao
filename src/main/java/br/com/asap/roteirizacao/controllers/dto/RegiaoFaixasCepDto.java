package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoFaixasCep;

public class RegiaoFaixasCepDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Regiao regiao;

	private Long cepInicial;
	private Long cepFinal;

	public RegiaoFaixasCepDto() {
	}

	public RegiaoFaixasCepDto(Regiao regiao, Long cepInicial, Long cepFinal) {
		this.regiao = regiao;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
	}

	public RegiaoFaixasCepDto(RegiaoFaixasCep faixasCep) {
		this.regiao = faixasCep.getRegiao();
		this.cepInicial = faixasCep.getCepInicial();
		this.cepFinal = faixasCep.getCepFinal();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Long getCepInicial() {
		return cepInicial;
	}

	public void setCepInicial(Long cepInicial) {
		this.cepInicial = cepInicial;
	}

	public Long getCepFinal() {
		return cepFinal;
	}

	public void setCepFinal(Long cepFinal) {
		this.cepFinal = cepFinal;
	}

}
