package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.enums.RegiaoStatus;

public class RegiaoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Long codigo;
	public String descricao;
	public RegiaoStatus status;
	
	public RegiaoDto() {
	}

	public RegiaoDto(Long codigo, String descricao, RegiaoStatus status) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.status = status;
	}
	
	public RegiaoDto(Regiao regiao) {
		codigo = regiao.getCodigo();
		descricao = regiao.getDescricao();
		status = regiao.getStatus();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public RegiaoStatus getStatus() {
		return status;
	}

	public void setStatus(RegiaoStatus status) {
		this.status = status;
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
		RegiaoDto other = (RegiaoDto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public static RegiaoDto toDto(Regiao regiao) {
		RegiaoDto regiaoDto = new RegiaoDto(regiao);
		return regiaoDto;
	}
	
	public Regiao toRegiao() {
		Regiao entity = new Regiao(this.codigo, this.descricao, this.status);
		return entity;
	}

}
