package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.TipoTransporteDto;
import br.com.asap.roteirizacao.entities.TipoTransporte;
import br.com.asap.roteirizacao.repositories.TipoTransporteRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class TipoTransporteService {

	@Autowired
	private TipoTransporteRepository repository;
	
	@Transactional(readOnly = true)
	public List<TipoTransporteDto> listar() {
		List<TipoTransporte> tiposTransporte = repository.findAll();
		List<TipoTransporteDto> tiposTransporteDto = tiposTransporte.stream().map(x -> TipoTransporteDto.toDto(x))
				.collect(Collectors.toList());
		return tiposTransporteDto;
	}
	
	@Transactional(readOnly = true)
	public TipoTransporteDto findById(Long codigo) {
		TipoTransporte tipoTransporte = repository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Código inexistente " + codigo));
		return TipoTransporteDto.toDto(tipoTransporte);
	}
	
	@Transactional
	public Long cadastrar(TipoTransporteDto form) {
		TipoTransporte tipoTransporte = new TipoTransporte(form);
		repository.save(tipoTransporte);
		return tipoTransporte.getCodigo();
	}
	
	@Transactional
	public TipoTransporteDto excluir(Long codigo) {
		TipoTransporte tipoTransporte = repository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Código inexistente" + codigo));
		repository.deleteById(codigo);
		return TipoTransporteDto.toDto(tipoTransporte);				
	}
	
	@Transactional
	public TipoTransporteDto atualizar(Long codigo, TipoTransporteDto form) {
		TipoTransporte tipoTransporte = repository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Código inexistente" + codigo));
		tipoTransporte.setDescricao(form.getDescricao());
		repository.save(tipoTransporte);
		return TipoTransporteDto.toDto(tipoTransporte);
	}
	
}
