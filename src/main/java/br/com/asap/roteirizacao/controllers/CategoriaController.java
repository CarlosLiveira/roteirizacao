package br.com.asap.roteirizacao.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.asap.roteirizacao.controllers.dto.CategoriaDto;
import br.com.asap.roteirizacao.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDto>> listar() {
		return ResponseEntity.ok().body(categoriaService.listar());
	}
	
	@GetMapping(path = "/{codigo}")
	public ResponseEntity<CategoriaDto> listarPorCodigo(@PathVariable(name = "codigo") Long codigo){
		return ResponseEntity.ok().body(categoriaService.findById(codigo));
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid CategoriaDto form, UriComponentsBuilder uriBuilder) {
		Long codigo = categoriaService.cadastrar(form);
		
		URI uri = uriBuilder.path("/categoria/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/{codigo}")
	public ResponseEntity<?> excluir(@PathVariable Long codigo){
		categoriaService.excluir(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(path = "/{codigo}")
	public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long codigo, @RequestBody @Valid CategoriaDto form) {
		CategoriaDto categoriaDto = categoriaService.atualizar(codigo, form);
		return ResponseEntity.ok(categoriaDto);
	}	
}
