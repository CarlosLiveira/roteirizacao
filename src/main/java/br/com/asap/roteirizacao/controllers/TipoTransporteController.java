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

import br.com.asap.roteirizacao.controllers.dto.TipoTransporteDto;
import br.com.asap.roteirizacao.services.TipoTransporteService;

@RestController
@RequestMapping(value = "/tipoTransporte")
public class TipoTransporteController {
	
	@Autowired
	TipoTransporteService service;
	
	@GetMapping
	public ResponseEntity<List<TipoTransporteDto>> listar(){
		return ResponseEntity.ok().body(service.listar());
	}
	
	@GetMapping(path = "/{codigo}")
	public ResponseEntity<TipoTransporteDto> listarPorCodigo(@PathVariable(name = "codigo") Long codigo) {
		return ResponseEntity.ok().body(service.findById(codigo));
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid TipoTransporteDto form, UriComponentsBuilder uriBuilder) {
		Long codigo = service.cadastrar(form);
		URI uri = uriBuilder.path("/tipoTransporte/{codigo}").buildAndExpand(codigo).toUri();
		System.out.println(uri);
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		service.excluir(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping(path = "/{codigo}")
	public ResponseEntity<TipoTransporteDto> atualizar(@PathVariable Long codigo, @RequestBody @Valid TipoTransporteDto form) {
		TipoTransporteDto tipoTransporteDto = service.atualizar(codigo, form);
		return ResponseEntity.ok(tipoTransporteDto);
	}
}
