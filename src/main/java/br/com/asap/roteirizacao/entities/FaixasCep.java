package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbFaixasCep")
public class FaixasCep implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private Long cepInicial;
	private Long cepFinal;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "codigoRegiao")
	private Regiao codigoRegiao;

	public FaixasCep() {
	}
	
	public FaixasCep(Long codigo, Long cepInicial, Long cepFinal, Regiao codigoRegiao) {
		this.codigo = codigo;
		this.codigoRegiao = codigoRegiao;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		FaixasCep other = (FaixasCep) obj;
		return Objects.equals(codigo, other.codigo);
	}	
	
}
