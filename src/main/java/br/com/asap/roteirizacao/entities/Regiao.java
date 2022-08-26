package br.com.asap.roteirizacao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.asap.roteirizacao.entities.enums.RegiaoStatus;

@Entity
@Table(name = "tbRegiao")
public class Regiao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;

	@Enumerated(value = EnumType.STRING)
	private RegiaoStatus status;

	@OneToMany
	@JoinColumn(name = "codigoRegiao")
	private List<FaixasCep> faixasCep = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "tipoTransporte")
	private List<RegiaoTipoTransporte> regioesTiposTransporte = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "codigoCategoria")
	private List<RegiaoCategoria> categorias = new ArrayList<RegiaoCategoria>();

	@OneToMany
	@JoinColumn(name = "sku")
	private List<RegiaoSku> skus = new ArrayList<RegiaoSku>();

	@OneToMany
	@JoinColumn(name = "filial")
	private List<RegiaoFilial> filiais = new ArrayList<RegiaoFilial>();

	public Regiao() {
	}

	public Regiao(Long codigo, String descricao, RegiaoStatus status, List<FaixasCep> faixasCep,
			List<RegiaoTipoTransporte> regioesTiposTransporte, List<RegiaoCategoria> categorias, List<RegiaoSku> skus,
			List<RegiaoFilial> filiais) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.status = status;
		this.faixasCep = faixasCep;
		this.regioesTiposTransporte = regioesTiposTransporte;
		this.categorias = categorias;
		this.skus = skus;
		this.filiais = filiais;
	}

	public Regiao(Long codigo, String descricao, RegiaoStatus status) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.status = status;
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

	public List<FaixasCep> getFaixasCep() {
		return faixasCep;
	}

	public void setFaixasCep(List<FaixasCep> faixasCep) {
		this.faixasCep = faixasCep;
	}

	public List<RegiaoTipoTransporte> getRegioesTiposTransporte() {
		return regioesTiposTransporte;
	}

	public void setRegioesTiposTransporte(List<RegiaoTipoTransporte> regioesTiposTransporte) {
		this.regioesTiposTransporte = regioesTiposTransporte;
	}

	public List<RegiaoCategoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<RegiaoCategoria> categorias) {
		this.categorias = categorias;
	}

	public List<RegiaoSku> getSkus() {
		return skus;
	}

	public void setSkus(List<RegiaoSku> skus) {
		this.skus = skus;
	}

	public List<RegiaoFilial> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<RegiaoFilial> filiais) {
		this.filiais = filiais;
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
		Regiao other = (Regiao) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
