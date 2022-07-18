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

import br.com.asap.roteirizacao.controllers.dto.RegiaoSkuDto;
import br.com.asap.roteirizacao.services.RegiaoSkuService;

@RestController
@RequestMapping(path = "/regiaoSku")
public class RegiaoSkuController {
	
	@Autowired
	private RegiaoSkuService regiaoSkuService;
	
	@GetMapping
	public ResponseEntity<List<RegiaoSkuDto>> listar(){
		return ResponseEntity.ok().body(regiaoSkuService.listar());
	}
	
	@GetMapping(path = "{codigo}")
	public ResponseEntity<RegiaoSkuDto> listarPorCodigo(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(regiaoSkuService.listarPorCodigo(codigo));
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid RegiaoSkuDto form, UriComponentsBuilder uribBuilder){
		Long codigo = regiaoSkuService.cadastrar(form);
		
		URI uri = uribBuilder.path("/regiaoSku/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path = "{codigo}")
	public ResponseEntity<RegiaoSkuDto> atualizar(@PathVariable Long codigo, @RequestBody @Valid RegiaoSkuDto form){
		return ResponseEntity.ok().body(regiaoSkuService.atualizar(codigo, form));
	}
	
	@DeleteMapping(path = "/{codigo}")
	public ResponseEntity<?> excluir(@PathVariable Long codigo){
		regiaoSkuService.excluir(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
