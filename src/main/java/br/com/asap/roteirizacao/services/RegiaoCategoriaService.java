package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.RegiaoCategoriaDto;
import br.com.asap.roteirizacao.entities.RegiaoCategoria;
import br.com.asap.roteirizacao.repositories.RegiaoCategoriaRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class RegiaoCategoriaService {

	@Autowired
	private RegiaoCategoriaRepository regiaoCategoriaRepository;

	@Transactional(readOnly = true)
	public List<RegiaoCategoriaDto> listar() {
		List<RegiaoCategoria> regiaoCategoria = regiaoCategoriaRepository.findAll();
		List<RegiaoCategoriaDto> regiaoCategoriaDto = regiaoCategoria.stream().map(e -> RegiaoCategoriaDto.toDto(e))
				.collect(Collectors.toList());
		return regiaoCategoriaDto;
	}

	@Transactional(readOnly = true)
	public RegiaoCategoriaDto listarPorCodigo(Long codigo) {
		RegiaoCategoria regiaoCategoria = regiaoCategoriaRepository.findById(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Codigo inexistente " + codigo));
		return RegiaoCategoriaDto.toDto(regiaoCategoria);
	}

	@Transactional
	public Long cadastrar(RegiaoCategoriaDto form) {
		RegiaoCategoria regiaoCategoria = regiaoCategoriaRepository.save(form.toEntity());
		return regiaoCategoria.getCodigo();
	}

	@Transactional
	public RegiaoCategoriaDto atualizar(Long codigo, RegiaoCategoriaDto form) {
		RegiaoCategoria regiaoCategoria = regiaoCategoriaRepository.findById(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Codigo inexistente " + codigo));
		regiaoCategoria.setCodigoRegiao(form.getCodigoRegiao());
		regiaoCategoria.setCodigoCategoria(form.getCodigoCategoria());
		regiaoCategoriaRepository.save(regiaoCategoria);
		return RegiaoCategoriaDto.toDto(regiaoCategoria);
	}

	public RegiaoCategoriaDto excluir(Long codigo) {
		RegiaoCategoria regiaoCategoria = regiaoCategoriaRepository.findById(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Codigo inexistente " + codigo));
		regiaoCategoriaRepository.deleteById(codigo);
		return RegiaoCategoriaDto.toDto(regiaoCategoria);
	}

}
