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

import br.com.asap.roteirizacao.controllers.dto.RegiaoDto;
import br.com.asap.roteirizacao.services.RegiaoService;

@RestController
@RequestMapping(path = "/regiao")
public class RegiaoController {
	
	@Autowired
	private RegiaoService regiaoService;
	
	@GetMapping
	public ResponseEntity<List<RegiaoDto>> listar(){
		List<RegiaoDto> regiaoDto = regiaoService.listar();		
		return ResponseEntity.ok().body(regiaoDto);
	}
	
	@GetMapping(path = "/{codigo}")
	public ResponseEntity <RegiaoDto> listarPorCodigo(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(regiaoService.findById(codigo));
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid RegiaoDto form, UriComponentsBuilder uriBuilder) {
		Long codigo = regiaoService.cadastrar(form);
		
		URI uri = uriBuilder.path("/regiao/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/{codigo}")
	public ResponseEntity<?> excluir(@PathVariable Long codigo){
		regiaoService.excluir(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(path = "/{codigo}")
	public ResponseEntity<RegiaoDto> atualizar(@PathVariable Long codigo, @RequestBody @Valid RegiaoDto form) {
		RegiaoDto regiaoDto = regiaoService.atualizar(codigo, form);
		return ResponseEntity.ok(regiaoDto);
	}
	
}
