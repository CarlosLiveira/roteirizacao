package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.SkuDto;
import br.com.asap.roteirizacao.entities.Sku;
import br.com.asap.roteirizacao.repositories.SkuRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class SkuService {

	@Autowired
	private SkuRepository skuRepository;

	@Transactional(readOnly = true)
	public List<SkuDto> listar() {
		List<Sku> skus = skuRepository.findAll();
		List<SkuDto> skusDto = skus.stream().map(x -> SkuDto.toSkuDto(x))
				.collect(Collectors.toList());
		return skusDto;
	}

	@Transactional(readOnly = true)
	public SkuDto listarPorCodigo(Long codigo) {
		Sku sku = skuRepository.findById(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Código inexistente " + codigo));
		SkuDto skuDto = new SkuDto(sku);
		return skuDto;
	}

	@Transactional
	public Long cadastrar(SkuDto form) {
		Sku sku = form.toSku();
		skuRepository.save(sku);
		return sku.getCodigo();
	}

	@Transactional
	public SkuDto excluir(Long codigo) {
		Sku sku = skuRepository.findById(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Código inexistente " + codigo));
		skuRepository.delete(sku);
		return SkuDto.toSkuDto(sku);
	}
	
	public SkuDto atualizar(Long codigo, SkuDto form) {
		Sku sku = skuRepository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Código inexistente " + codigo));
		sku.setDescricao(form.getDescricao());
		sku.setCodigoCategoria(form.getCodigoCategoria());
		sku.setCodigoTipoTransporte(form.getCodigoTipoTransporte());
		skuRepository.save(sku);
		return SkuDto.toSkuDto(sku);
	}

}
