package br.com.asap.roteirizacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.asap.roteirizacao.entities.Filial;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.Sku;

@Service
public class ConsultaService {

	@Autowired
	private RegiaoFaixasCepService regiaoFaixasCepService;

	@Autowired
	private SkuService skuService;

	@Autowired
	private RegiaoSkuService regiaoSkuService;

	@Autowired
	private RegiaoCategoriaService regiaoCategoriaService;

	@Autowired
	private RegiaoTipoTransporteService regiaoTipoTransporteService;

	@Autowired
	private RegiaoFilialService regiaoFilialService;

	public List<Filial> listarRegiaoAtendeCep(Long cep, Long codigoSku) {

		List<Regiao> regioesQueAtendeOCep =
				regiaoFaixasCepService.regioesQueAtendeOCep(cep);

		Sku sku = skuService.findById(codigoSku).toSku();

		List<Regiao> regioesQueAtendeOSku =
				regiaoSkuService.metodoRegioesQueAtendeOSku(sku, regioesQueAtendeOCep);

		List<Regiao> regioesQueAtendemCategoria =
				regiaoCategoriaService.metodoRegioesQueAtendemCategoria(sku,
				regioesQueAtendeOCep);

		List<Regiao> regioesQueAtendemOTipoTransporte =
				regiaoTipoTransporteService.regioesQueAtendemOTipoTransporte(regioesQueAtendemCategoria, sku);

		regioesQueAtendeOSku.addAll(regioesQueAtendemOTipoTransporte);

		List<Filial> filiaisQueAtendemOCep =
				regiaoFilialService.filiaisQueAtendemOCep(regioesQueAtendeOSku);

		return filiaisQueAtendemOCep;
	}
}
