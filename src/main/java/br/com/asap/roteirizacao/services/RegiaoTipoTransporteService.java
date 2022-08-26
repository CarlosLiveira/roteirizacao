package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.asap.roteirizacao.controllers.dto.RegiaoDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoTipoTransporteDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoTipoTransporteDtoOutput;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoTipoTransporte;
import br.com.asap.roteirizacao.entities.RegiaoTipoTransportePK;
import br.com.asap.roteirizacao.entities.TipoTransporte;
import br.com.asap.roteirizacao.repositories.RegiaoTipoTransporteRepository;

@Service
public class RegiaoTipoTransporteService {

	@Autowired
	private RegiaoTipoTransporteRepository repository;

	@Autowired
	private RegiaoService regiaoService;

	@Autowired
	private TipoTransporteService tipoTransporteService;

	@Transactional
	public RegiaoTipoTransporteDtoOutput listarPorCodigoRegiao(Long codigo) {
		RegiaoDto regiaoDto = regiaoService.findById(codigo);
		List<RegiaoTipoTransporte> regiaoTipoTransporte = repository.findByCodigoRegiao(regiaoDto.toRegiao());
		List<TipoTransporte> tiposTransporte = regiaoTipoTransporte.stream()
				.map(obj -> obj.getRegiaoTipoTransportePK().getTipoTransporte()).collect(Collectors.toList());
		return new RegiaoTipoTransporteDtoOutput(regiaoDto, tiposTransporte);
	}

	@Transactional
	public RegiaoTipoTransportePK cadastrar(RegiaoTipoTransporteDto form) {
		Regiao regiao = regiaoService.findById(form.getRegiao().getCodigo()).toRegiao();
		TipoTransporte tipoTransporte = tipoTransporteService.findById(form.getTipoTransporte().getCodigo())
				.toTipoTransporte();
		RegiaoTipoTransporte regiaotipoTransporte = new RegiaoTipoTransporte(regiao, tipoTransporte);
		repository.save(regiaotipoTransporte);
		return regiaotipoTransporte.getRegiaoTipoTransportePK();
	}

	@Transactional
	public RegiaoTipoTransportePK excluir(Long codigoRegiao, Long codigoTipoTransporte) {
		Regiao regiao = regiaoService.findById(codigoRegiao).toRegiao();
		TipoTransporte tipoTransporte = tipoTransporteService.findById(codigoTipoTransporte).toTipoTransporte();
		RegiaoTipoTransporte regiaotipoTransporte = new RegiaoTipoTransporte(regiao, tipoTransporte);
		repository.delete(regiaotipoTransporte);
		return regiaotipoTransporte.getRegiaoTipoTransportePK();
	}

}
