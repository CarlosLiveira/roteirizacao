package br.com.asap.roteirizacao.controllers.dto;

import br.com.asap.roteirizacao.entities.Categoria;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoCategoria;

public class RegiaoCategoriaDto {

	private Regiao codigoRegiao;
	private Categoria codigoCategoria;

	public RegiaoCategoriaDto() {
	}

	public RegiaoCategoriaDto(Regiao codigoRegiao, Categoria codigoCategoria) {
		this.codigoRegiao = codigoRegiao;
		this.codigoCategoria = codigoCategoria;
	}

	public RegiaoCategoriaDto(RegiaoCategoria regiaoCategoria) {
		codigoRegiao = regiaoCategoria.getCodigoRegiao();
		codigoCategoria = regiaoCategoria.getCodigoCategoria();
	}

	public Regiao getCodigoRegiao() {
		return codigoRegiao;
	}

	public void setCodigoRegiao(Regiao codigoRegiao) {
		this.codigoRegiao = codigoRegiao;
	}

	public Categoria getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Categoria codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public static RegiaoCategoriaDto toDto(RegiaoCategoria regiaoCategoria) {
		RegiaoCategoriaDto regiaoCategoriaDto = new RegiaoCategoriaDto(regiaoCategoria);
		return regiaoCategoriaDto;
	}

	public RegiaoCategoria toEntity() {
		RegiaoCategoria regiaoCategoria = new RegiaoCategoria(this.codigoRegiao, this.codigoCategoria);
		return regiaoCategoria;
	}

}
