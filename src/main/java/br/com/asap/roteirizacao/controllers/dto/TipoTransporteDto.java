package br.com.asap.roteirizacao.controllers.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.asap.roteirizacao.entities.TipoTransporte;

public class TipoTransporteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String descricao;

	public TipoTransporteDto() {
	}

	public TipoTransporteDto(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public TipoTransporteDto(TipoTransporte tipoTransporte) {
		codigo = tipoTransporte.getCodigo();
		descricao = tipoTransporte.getDescricao();
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
		TipoTransporteDto other = (TipoTransporteDto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public static TipoTransporteDto toDto(TipoTransporte tipoTransporte) {
		TipoTransporteDto tipoTransporteDto = new TipoTransporteDto(tipoTransporte);
		return tipoTransporteDto;
	}

	public TipoTransporte toTipoTransporte() {
		TipoTransporte tipoTransporte = new TipoTransporte(this.codigo, this.descricao);
		return tipoTransporte;
	}

}
