
package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.RegiaoDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoSkuDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoSkuDtoOutput;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoSku;
import br.com.asap.roteirizacao.entities.RegiaoSkuPk;
import br.com.asap.roteirizacao.entities.Sku;
import br.com.asap.roteirizacao.repositories.RegiaoSkuRepository;

@Service
public class RegiaoSkuService {

	@Autowired
	private RegiaoSkuRepository regiaoSkuRepository;

	@Autowired
	private SkuService skuService;

	@Autowired
	private RegiaoService regiaoService;

	@Transactional(readOnly = true)
	public RegiaoSkuDtoOutput findyById(Long codigo) {
		RegiaoDto regiaoDto = regiaoService.findById(codigo);
		List<RegiaoSku> regiaoSku = regiaoSkuRepository.findByCodigoRegiao(regiaoDto.toRegiao());
		List<Sku> skus = regiaoSku.stream().map(obj -> obj.getRegiaoSkuPk().getSku()).collect(Collectors.toList());
		return new RegiaoSkuDtoOutput(regiaoDto, skus);
	}

	@Transactional
	public RegiaoSkuPk cadastrar(RegiaoSkuDto form) {
		Regiao regiao = regiaoService.findById(form.getRegiao().getCodigo()).toRegiao();
		Sku sku = skuService.findById(form.getSku().getCodigo()).toSku();
		RegiaoSku regiaoSku = new RegiaoSku(regiao, sku);
		regiaoSkuRepository.save(regiaoSku);
		return regiaoSku.getRegiaoSkuPk();
	}

	@Transactional
	public RegiaoSkuPk excluir(Long codigoRegiao, Long codigoSku) {
		Regiao regiao = regiaoService.findById(codigoRegiao).toRegiao();
		Sku sku = skuService.findById(codigoSku).toSku();
		RegiaoSku regiaoSku = new RegiaoSku(regiao, sku);
		regiaoSkuRepository.delete(regiaoSku);
		return regiaoSku.getRegiaoSkuPk();
	}

}
