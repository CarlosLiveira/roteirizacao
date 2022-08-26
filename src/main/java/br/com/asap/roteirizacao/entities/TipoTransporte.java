package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.asap.roteirizacao.controllers.dto.TipoTransporteDto;

@Entity
@Table(name = "tbTipoTransporte")
public class TipoTransporte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;

	public TipoTransporte() {
	}

	public TipoTransporte(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public TipoTransporte(TipoTransporteDto form) {
		this.codigo = form.getCodigo();
		this.descricao = form.getDescricao();
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
		TipoTransporte other = (TipoTransporte) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
