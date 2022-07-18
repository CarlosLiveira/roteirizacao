package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.RegiaoSkuDto;
import br.com.asap.roteirizacao.entities.RegiaoSku;
import br.com.asap.roteirizacao.repositories.RegiaoSkuRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class RegiaoSkuService {
	
	@Autowired
	private RegiaoSkuRepository regiaoSkuRepository;
	
	@Transactional(readOnly = true)
	public List<RegiaoSkuDto> listar(){
		List<RegiaoSku> regiaoSku = regiaoSkuRepository.findAll();
		List<RegiaoSkuDto> regiaoSkuDto = regiaoSku.stream().map(x -> RegiaoSkuDto.toDto(x))
				.collect(Collectors.toList());
		return regiaoSkuDto;
	}
	
	@Transactional(readOnly = true)
	public RegiaoSkuDto listarPorCodigo(Long codigo) {
		RegiaoSku regiaoSku = regiaoSkuRepository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Codigo inexistente " + codigo));
		return RegiaoSkuDto.toDto(regiaoSku);
	}
	
	@Transactional
	public Long cadastrar(RegiaoSkuDto form) {
		RegiaoSku regiaoSku = form.toEntity();
		regiaoSkuRepository.save(regiaoSku);
		return regiaoSku.getCodigo();
	}
	
	@Transactional
	public RegiaoSkuDto atualizar(Long codigo, RegiaoSkuDto form) {
		RegiaoSku regiaoSku = regiaoSkuRepository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Codigo inexistente " + codigo));
		regiaoSku.setCodigoRegiao(form.getCodigoRegiao());
		regiaoSku.setCodigoSku(form.getCodigoSku());
		regiaoSkuRepository.save(regiaoSku);
		return RegiaoSkuDto.toDto(regiaoSku);
	}
	
	@Transactional
	public RegiaoSkuDto excluir(Long codigo) {
		RegiaoSku regiaoSku = regiaoSkuRepository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Codigo inexistente " + codigo));
		regiaoSkuRepository.deleteById(codigo);
		return RegiaoSkuDto.toDto(regiaoSku);
	}

}
