package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.asap.roteirizacao.entities.FaixasCep;
import br.com.asap.roteirizacao.entities.Regiao;

public class FaixasCepDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Regiao codigoRegiao;
	
	private Long codigo;
	private Long cepInicial;
	private Long cepFinal;
	
	public FaixasCepDto() {
	}
	
	public FaixasCepDto(Regiao codigoRegiao, Long codigo, Long cepInicial, Long cepFinal) {
		this.codigoRegiao = codigoRegiao;
		this.codigo = codigo;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
	}

	public FaixasCepDto(FaixasCep faixasCep) {
		codigoRegiao = faixasCep.getCodigoRegiao();
		cepInicial = faixasCep.getCepInicial();
		cepFinal = faixasCep.getCepFinal();
		codigo = faixasCep.getCodigo();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Regiao getCodigoRegiao() {
		return codigoRegiao;
	}

	public void setCodigoRegiao(Regiao codigoRegiao) {
		this.codigoRegiao = codigoRegiao;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaixasCepDto other = (FaixasCepDto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public static FaixasCepDto toDto(FaixasCep entity) {
		FaixasCepDto dto = new FaixasCepDto(entity);
		return dto;
	}
	
	public static FaixaCep toFaixaCep(FaixasCep entity) {
		FaixaCep faixaCep = new FaixaCep(entity);
		return faixaCep;
	}
		
	public FaixasCep toEntity() {
		FaixasCep entity = new FaixasCep(null, this.cepInicial, this.cepFinal, this.codigoRegiao);
		return entity;
	}

}
