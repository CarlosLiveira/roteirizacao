package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.RegiaoDto;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.repositories.RegiaoRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class RegiaoService {

	@Autowired
	private RegiaoRepository regiaoRepository;

	@Transactional(readOnly = true)
	public List<RegiaoDto> listar() {
		List<Regiao> regioes = regiaoRepository.findAll();
		List<RegiaoDto> regioesDto = regioes.stream().map(x -> RegiaoDto.toDto(x)).collect(Collectors.toList());
		return regioesDto;
	}

	@Transactional(readOnly = true)
	public RegiaoDto findById(Long codigo) {
		Regiao regiao = regiaoRepository.findById(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Região não localizada " + codigo));
		return RegiaoDto.toDto(regiao);
	}

	@Transactional
	public Long cadastrar(RegiaoDto form) {
		Regiao regiao = form.toRegiao();
		regiaoRepository.save(regiao);
		return regiao.getCodigo();
	}

	@Transactional
	public RegiaoDto excluir(Long codigo) {
		Regiao regiao = regiaoRepository.findById(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Região não localizada " + codigo));
		regiaoRepository.deleteById(codigo);
		return RegiaoDto.toDto(regiao);
	}

	@Transactional
	public RegiaoDto atualizar(Long codigo, RegiaoDto form) {
		Regiao regiao = regiaoRepository.findById(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Região não localizada " + codigo));
		regiao.setDescricao(form.getDescricao());
		regiao.setStatus(form.getStatus());
		regiaoRepository.save(regiao);
		return RegiaoDto.toDto(regiao);
	}
}
