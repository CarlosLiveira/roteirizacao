package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.FilialDto;
import br.com.asap.roteirizacao.entities.Filial;
import br.com.asap.roteirizacao.repositories.FilialRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class FilialService {

	@Autowired
	private FilialRepository filialRepository;
	
	@Transactional(readOnly = true)
	public List<FilialDto> listar() {
		List<Filial> filiais = filialRepository.findAll();
		List<FilialDto> filiaisDto = filiais.stream().map(x -> FilialDto.toFilialDto(x))
				.collect(Collectors.toList());
		return filiaisDto;
	}
	
	@Transactional(readOnly = true)
	public FilialDto findById(String cnpj) {
		Filial filial = filialRepository.findById(cnpj).orElseThrow(
				() -> new EntityNotFoundException("Cnpj inexistente " + cnpj));
		return FilialDto.toFilialDto(filial);
	}
	
	@Transactional
	public String cadastrar(FilialDto form) {
		Filial filial = form.toFilial();
		filialRepository.save(filial);
		return filial.getCnpj();		
	}
	
	@Transactional
	public FilialDto excuir(String cnpj) {
		Filial filial = filialRepository.findById(cnpj).orElseThrow(
				() -> new EntityNotFoundException("Cnpj inexistente " + cnpj));
		filialRepository.deleteById(cnpj);
		return FilialDto.toFilialDto(filial);
	}
	
	@Transactional
	public FilialDto atualizar(String cnpj, FilialDto form) {
		Filial filial = filialRepository.findById(cnpj).orElseThrow(
				() -> new EntityNotFoundException("Cnpj inexistente " + cnpj));
		filial.setDescricao(form.getDescricao());
		filialRepository.save(filial);
		return FilialDto.toFilialDto(filial);
	}
}
