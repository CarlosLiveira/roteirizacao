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

import br.com.asap.roteirizacao.controllers.dto.FaixaCep;
import br.com.asap.roteirizacao.controllers.dto.FaixasCepDaRegiaoDto;
import br.com.asap.roteirizacao.controllers.dto.FaixasCepDto;
import br.com.asap.roteirizacao.services.FaixasCepService;

@RestController
@RequestMapping(value = "/faixasCep")
public class FaixasCepController {
	
	@Autowired
	private FaixasCepService service;
	
	@GetMapping
	public ResponseEntity<List<FaixaCep>> listar() {
		return ResponseEntity.ok().body(service.listar());
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<FaixaCep> listarPorCodigo(@PathVariable Long codigo){
		return ResponseEntity.ok().body(service.listarPorCodigo(codigo));
	}
	
	@GetMapping(value = "/regiao/{codigoRegiao}")
	public ResponseEntity<FaixasCepDaRegiaoDto> listarPorCodigoRegiao(@PathVariable Long codigoRegiao){
		return ResponseEntity.ok().body(service.listarPorCodigoRegiao(codigoRegiao));
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid FaixasCepDto form, UriComponentsBuilder uriBuilder){
		Long codigo = service.cadastrar(form);
		
		URI uri = uriBuilder.path("/faixasCep/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{codigo}")
	public ResponseEntity<FaixaCep> atualizar(@PathVariable Long codigo, @RequestBody @Valid FaixasCepDto form){
		FaixasCepDto faixasCepDto = service.atualizar(codigo, form);
		FaixaCep faixaCep = new FaixaCep(faixasCepDto);
		return ResponseEntity.ok(faixaCep);
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<?> excluir(@PathVariable Long codigo){
		service.excluir(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
