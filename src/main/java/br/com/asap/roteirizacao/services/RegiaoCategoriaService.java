package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.asap.roteirizacao.controllers.dto.RegiaoCategoriaDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoCategoriaDtoOutput;
import br.com.asap.roteirizacao.controllers.dto.RegiaoDto;
import br.com.asap.roteirizacao.entities.Categoria;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoCategoria;
import br.com.asap.roteirizacao.entities.RegiaoCategoriaPk;
import br.com.asap.roteirizacao.entities.Sku;
import br.com.asap.roteirizacao.repositories.RegiaoCategoriaRepository;

@Service
public class RegiaoCategoriaService {

	@Autowired
	private RegiaoCategoriaRepository regiaoCategoriaRepository;
	
	@Autowired
	private RegiaoService regiaoService;
	
	@Autowired
	private CategoriaService categoriaService ;

	@Transactional(readOnly = true)
	public RegiaoCategoriaDtoOutput listarPorCodigoRegiao(Long codigo) {
		RegiaoDto regiaoDto = regiaoService.findById(codigo);
		List<RegiaoCategoria> regiaoCategoria = regiaoCategoriaRepository.findByCodigoRegiao(regiaoDto.toRegiao());
		List<Categoria> categorias = regiaoCategoria.stream()
				.map(obj -> obj.getRegiaoCategoriaPk().getCategoria()).collect(Collectors.toList());
		return new RegiaoCategoriaDtoOutput(regiaoDto, categorias);
	}

	@Transactional
	public RegiaoCategoriaPk cadastrar(RegiaoCategoriaDto form) {
		Regiao regiao = regiaoService.findById(form.getRegiao().getCodigo()).toRegiao();
		Categoria categoria = categoriaService.findById(form.getCategoria().getCodigo())				.toCategoria();
		RegiaoCategoria regiaoCategoria = new RegiaoCategoria(regiao, categoria);
		regiaoCategoriaRepository.save(regiaoCategoria);
		return regiaoCategoria.getRegiaoCategoriaPk();
	}

	@Transactional
	public RegiaoCategoriaPk excluir(Long codigoRegiao, Long codigoCategoria) {
		Regiao regiao = regiaoService.findById(codigoRegiao).toRegiao();
		Categoria categoria = categoriaService.findById(codigoCategoria).toCategoria();
		RegiaoCategoria regiaoCategoria = new RegiaoCategoria(regiao, categoria);
		regiaoCategoriaRepository.delete(regiaoCategoria);
		return regiaoCategoria.getRegiaoCategoriaPk();
	}
	
	public List<Regiao> metodoRegioesQueAtendemCategoria(Sku sku, List<Regiao> regioesQueAtendeOCep){
		List<Regiao>regioesQueAtendemCategoria = regiaoCategoriaRepository.
			findByRegiaoCategoriaPkCategoriaAndRegiaoCategoriaPkRegiaoIn(
				sku.getCodigoCategoria(), regioesQueAtendeOCep)
		.stream()
		.map(r -> r.getRegiaoCategoriaPk().getRegiao())
		.collect(Collectors.toList());
		return regioesQueAtendemCategoria;
	}
		

}
