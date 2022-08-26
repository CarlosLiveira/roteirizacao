package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.CategoriaDto;
import br.com.asap.roteirizacao.entities.Categoria;
import br.com.asap.roteirizacao.repositories.CategoriaRepository;
import br.com.asap.roteirizacao.service.exceptions.EntityNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional(readOnly = true)
	public List<CategoriaDto> listar() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDto> categoriasDto = categorias.stream().map(x -> CategoriaDto.converter(x))
				.collect(Collectors.toList());
		return categoriasDto;
	}
	
	@Transactional(readOnly = true)
	public CategoriaDto findById(Long codigo) {
		Categoria categoria = categoriaRepository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Código inexistente " + codigo));
		return CategoriaDto.converter(categoria);
	}
	
	@Transactional
	public Long cadastrar(CategoriaDto form) {
		Categoria categoria = form.toCategoria();
		categoriaRepository.save(categoria);
		return categoria.getCodigo();
	}
	
	@Transactional
	public CategoriaDto excluir(Long codigo) {
		Categoria categoria = categoriaRepository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Código inexistente " + codigo));
		categoriaRepository.deleteById(codigo);
		return CategoriaDto.converter(categoria);
	}
	
	@Transactional
	public CategoriaDto atualizar(Long codigo, CategoriaDto form) {
		Categoria categoria = categoriaRepository.findById(codigo).orElseThrow(
				() -> new EntityNotFoundException("Código inexistente " + codigo));
		categoria.setDescricao(form.getDescricao());
		categoriaRepository.save(categoria);
		return CategoriaDto.converter(categoria);
	}
	
}
