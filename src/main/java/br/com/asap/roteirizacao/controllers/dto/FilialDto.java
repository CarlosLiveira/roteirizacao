package br.com.asap.roteirizacao.controllers.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.asap.roteirizacao.entities.Filial;

public class FilialDto {

	private String cnpj;
	
	@NotNull @NotEmpty
	private String descricao;
	
	public FilialDto() {
	}
	
	public FilialDto(@NotNull @NotEmpty String cnpj, String descricao) {
		this.cnpj = cnpj;
		this.descricao = descricao;
	}
	
	public FilialDto(Filial filial) {
		cnpj = filial.getCnpj();
		descricao = filial.getDescricao();
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescriao(String descricao) {
		this.descricao = descricao;
	}
	
	public static FilialDto toFilialDto(Filial filial) {
		FilialDto filialDto = new FilialDto(filial);
		return filialDto;
	}
	
	public Filial toFilial() {
		Filial filial = new Filial(this.cnpj, this.descricao);
		return filial;		
	}
	
}
