package br.com.asap.roteirizacao.controllers.dto;

import br.com.asap.roteirizacao.entities.FaixasCep;

public class FaixaCep {
	
	private Long codigo;
	private Long cepInicial;
	private Long cepFinal;
	
	public FaixaCep(Long codigo, Long cepInicial, Long cepFinal) {
		this.codigo = codigo;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
	}

	public FaixaCep(FaixasCep faixasCep) {
		this.codigo = faixasCep.getCodigo();
		this.cepInicial = faixasCep.getCepInicial();
		this.cepFinal = faixasCep.getCepFinal();
	}
	
	public FaixaCep(FaixasCepDto faixasCepDto) {
		this.codigo = faixasCepDto.getCodigo();
		this.cepInicial = faixasCepDto.getCepInicial();
		this.cepFinal = faixasCepDto.getCepFinal();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
