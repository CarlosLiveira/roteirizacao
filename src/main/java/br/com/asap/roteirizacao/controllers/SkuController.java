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

import br.com.asap.roteirizacao.controllers.dto.SkuDto;
import br.com.asap.roteirizacao.services.SkuService;

@RestController
@RequestMapping(value = "/sku")
public class SkuController {
	
	@Autowired
	private SkuService skuService;
	
	@GetMapping
	public ResponseEntity<List<SkuDto>> listar() {
		return ResponseEntity.ok().body(skuService.listar());
	}
	
	@GetMapping(path = "/{codigo}")
	public ResponseEntity<SkuDto> listarPorCodigo(@PathVariable(name = "codigo") Long codigo){
		return ResponseEntity.ok().body(skuService.findById(codigo));
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid SkuDto form, UriComponentsBuilder uriBuilder) {
		Long codigo = skuService.cadastrar(form);
		
		URI uri = uriBuilder.path("/sku/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable(name = "codigo") Long codigo ){
		skuService.excluir(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(value = "/{codigo}")
	public ResponseEntity<SkuDto> atualizar(@PathVariable(name = "codigo") Long codigo, @RequestBody @Valid SkuDto form ) {
		SkuDto sku = skuService.atualizar(codigo, form);
		return ResponseEntity.ok(sku);
	}
}
