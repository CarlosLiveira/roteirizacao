package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.FaixaCep;
import br.com.asap.roteirizacao.controllers.dto.FaixasCepDaRegiaoDto;
import br.com.asap.roteirizacao.controllers.dto.FaixasCepDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoDto;
import br.com.asap.roteirizacao.entities.FaixasCep;
import br.com.asap.roteirizacao.repositories.FaixasCepRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class FaixasCepService {
	
	@Autowired
	private FaixasCepRepository repository;
	
	@Autowired
	private RegiaoService regiaoService;
	
	@Transactional(readOnly = true)
	public List<FaixaCep> listar(){
		List<FaixasCep> faixasCep = repository.findAll();
		List<FaixaCep> dto = faixasCep.stream().map(x -> new FaixaCep(x))
				.collect(Collectors.toList());
		return dto;
	}
	
	@Transactional(readOnly = true)
	public FaixaCep listarPorCodigo(Long codigo) {
		FaixasCep faixasCep = repository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Codigo não localizado" + codigo));
		FaixaCep faixaCep = new FaixaCep(faixasCep);
		return faixaCep;
	}
	
	@Transactional
	public FaixasCepDaRegiaoDto listarPorCodigoRegiao(Long codigoRegiao) {
		RegiaoDto regiao = regiaoService.findById(codigoRegiao);
		List<FaixasCep> faixasCep = repository.findByCodigoRegiao(regiao.toRegiao());
		List<FaixaCep> faixaCepLista = faixasCep.stream()
				.map(obj -> new FaixaCep(obj.getCodigo(), obj.getCepInicial(), obj.getCepFinal()))
				.collect(Collectors.toList());
		return new FaixasCepDaRegiaoDto(regiao, faixaCepLista);
	}
	
	@Transactional
	public Long cadastrar(FaixasCepDto form) {
		FaixasCep faixasCep = form.toEntity();
		repository.save(faixasCep);
		return faixasCep.getCodigo();		
	}
		
	@Transactional
	public FaixasCepDto atualizar(Long codigo, FaixasCepDto form) {
		FaixasCep faixasCep = repository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Codigo não localizado " + codigo));
		faixasCep.setCepInicial(form.getCepInicial());
		faixasCep.setCepFinal(form.getCepFinal());
		repository.save(faixasCep);
		return FaixasCepDto.toDto(faixasCep);
	}
	
	@Transactional
	public FaixasCepDto excluir(Long codigo) {
		FaixasCep faixasCep = repository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Codigo não localizado " + codigo));
		repository.delete(faixasCep);
		return FaixasCepDto.toDto(faixasCep);
	}

}
