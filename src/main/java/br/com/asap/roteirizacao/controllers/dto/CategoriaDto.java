package br.com.asap.roteirizacao.controllers.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.asap.roteirizacao.entities.Categoria;

public class CategoriaDto {

		private Long codigo;
		
		@NotNull @NotEmpty
		private String descricao;
		
		public CategoriaDto() {
		}
		
		public CategoriaDto(Long codigo, @NotNull @NotEmpty String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public CategoriaDto(Categoria categoria) {
			codigo = categoria.getCodigo();
			descricao = categoria.getDescricao();
		}
		
		public Long getCodigo() {
			return codigo;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
		//Converte a entidade Categoria em CategoriaDto para que seja enviada ao controller (reponde a requisição)
		public static CategoriaDto converter (Categoria categoria){
			CategoriaDto categoriaDto = new CategoriaDto(categoria);
			return categoriaDto;
		}
		
		//Converte a entidade CategoriaDto em Categoria para que seja enviada ao repository (armazena no banco)
		public Categoria toCategoria(){
			Categoria categoria = new Categoria(this.codigo, this.descricao);
			return categoria;
		}
		
}
