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
@Table(name = "tbRegiaoFaixasCep")
public class RegiaoFaixasCep implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private Long cepInicial;
	private Long cepFinal;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "regiao")
	private Regiao regiao;

	public RegiaoFaixasCep() {
	}

	public RegiaoFaixasCep(Long codigo, Long cepInicial, Long cepFinal, Regiao regiao) {
		this.codigo = codigo;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
		this.regiao = regiao;
	}
	
	public RegiaoFaixasCep(Long cepInicial, Long cepFinal, Regiao regiao) {
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
		this.regiao = regiao;
	}

	public RegiaoFaixasCep(Regiao regiao, RegiaoFaixasCep regiaoFaixasCep) {
		this.regiao = regiao;
		this.codigo = regiaoFaixasCep.getCodigo();
		this.cepInicial = regiaoFaixasCep.getCepInicial();
		this.cepFinal = regiaoFaixasCep.getCepFinal();
	}

	//************ATENÇÃO*********************
	public RegiaoFaixasCep(Long cep) {
		this.codigo = cep;
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
		RegiaoFaixasCep other = (RegiaoFaixasCep) obj;
		return Objects.equals(codigo, other.codigo);
	}

}