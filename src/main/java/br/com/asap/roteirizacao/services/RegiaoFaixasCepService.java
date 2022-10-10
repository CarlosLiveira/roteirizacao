package br.com.asap.roteirizacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.RegiaoDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoFaixasCepDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoFaixasCepDtoOutput;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoFaixasCep;
import br.com.asap.roteirizacao.repositories.RegiaoFaixasCepRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class RegiaoFaixasCepService {

	@Autowired
	private RegiaoFaixasCepRepository repository;

	@Autowired
	private RegiaoService regiaoService;

	@Transactional
	public RegiaoFaixasCepDtoOutput listarPorCodigoRegiao(Long codigo) {
		RegiaoDto regiaoDto = regiaoService.findById(codigo);
		List<RegiaoFaixasCep> regiaoFaixasCep = repository.findByCodigoRegiao(regiaoDto.toRegiao());
		return new RegiaoFaixasCepDtoOutput(regiaoDto, regiaoFaixasCep);
	}

	@Transactional
	public Long cadastrar(RegiaoFaixasCepDto form) {
		Regiao regiao = regiaoService.findById(form.getRegiao().getCodigo()).toRegiao();
		RegiaoFaixasCep regiaoFaixasCep = new RegiaoFaixasCep(form.getCepInicial(), form.getCepFinal(), regiao);
		repository.save(regiaoFaixasCep);
		return regiaoFaixasCep.getCodigo();
	}

	@Transactional
	public RegiaoFaixasCepDto excluir(Long codigoRegiao, Long codigoFaixaCep) {
		Regiao regiao = regiaoService.findById(codigoRegiao).toRegiao();
		RegiaoFaixasCep regiaoFaixasCep = repository.findById(codigoFaixaCep)
				.orElseThrow(() -> new EntityNotFoundException("Faixa de cep não localizada: " + codigoFaixaCep));
		RegiaoFaixasCep faixasCep = new RegiaoFaixasCep(regiao, regiaoFaixasCep);
		repository.delete(faixasCep);
		return new RegiaoFaixasCepDto(faixasCep);
	}
	
}
