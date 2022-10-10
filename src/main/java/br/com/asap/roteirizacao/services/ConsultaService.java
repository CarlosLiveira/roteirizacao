package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.asap.roteirizacao.entities.Filial;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.Sku;
import br.com.asap.roteirizacao.repositories.RegiaoCategoriaRepository;
import br.com.asap.roteirizacao.repositories.RegiaoFaixasCepRepository;
import br.com.asap.roteirizacao.repositories.RegiaoFilialRepository;
import br.com.asap.roteirizacao.repositories.RegiaoSkuRepository;
import br.com.asap.roteirizacao.repositories.RegiaoTipoTransporteRepository;

@Service
public class ConsultaService {

	@Autowired
	private RegiaoFaixasCepRepository regiaoFaixasCepRepository;
	
	@Autowired
	private RegiaoSkuRepository regiaoSkuRepository;
	
	@Autowired
	private SkuService skuService;
	
	@Autowired
	private RegiaoCategoriaRepository regiaoCategoriaRepository;
	
	@Autowired
	private RegiaoTipoTransporteRepository regiaoTipoTransporteRepository;
	
	@Autowired
	private RegiaoFilialRepository regiaoFilialRepository;

	public List<Filial> ListarRegiaoAtendeCep(Long cep, Long codigoSku) {
		List<Regiao> regioesQueAtendeOCep = regiaoFaixasCepRepository.findByCep(cep);
		
		Sku sku = skuService.findById(codigoSku).toSku();
		
		List<Regiao> regioesQueAtendeOSku = 
				regiaoSkuRepository.findByRegiaoSkuPkSkuAndRegiaoSkuPkRegiaoIn(
						sku, regioesQueAtendeOCep)
				.stream()
				.map(r -> r.getRegiaoSkuPk().getRegiao())
				.collect(Collectors.toList());
		
		List<Regiao> regioesQueAtendemCategoria =
				regiaoCategoriaRepository.
				findByRegiaoCategoriaPkCategoriaAndRegiaoCategoriaPkRegiaoIn(
						sku.getCodigoCategoria(), regioesQueAtendeOCep)
				.stream()
				.map(r -> r.getRegiaoCategoriaPk().getRegiao())
				.collect(Collectors.toList());
		
		List<Regiao> regioesQueAtendemOTipoTransporte =
				regiaoTipoTransporteRepository.findByRegiaoInAndTipoTransporte(
						regioesQueAtendemCategoria, sku.getCodigoTipoTransporte())
				.stream()
				.map(r -> r.getRegiaoTipoTransportePK().getRegiao())
				.collect(Collectors.toList());
		
		regioesQueAtendeOSku.addAll(regioesQueAtendemOTipoTransporte);
		
		List<Filial> filiaisQueAtendemOCep =
				regiaoFilialRepository.findByRegiaoIn(regioesQueAtendeOSku)
				.stream().map(r -> r.getRegiaoFilialPk().getFilial())
				.distinct()
				.collect(Collectors.toList());
		
		return filiaisQueAtendemOCep;
	}

}
