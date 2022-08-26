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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.asap.roteirizacao.controllers.dto.FilialDto;
import br.com.asap.roteirizacao.services.FilialService;

@RestController
@RequestMapping(value = "/filial")
public class FilialController {
	
	@Autowired
	private FilialService filialService;
	
	@GetMapping
	public ResponseEntity<List<FilialDto>> listar(){
		return ResponseEntity.ok().body(filialService.listar());
	}
	
	@GetMapping(path = "/{cnpj}")
	public ResponseEntity <FilialDto> listarPorCnpj(@PathVariable String cnpj){
		return ResponseEntity.ok().body(filialService.findById(cnpj));
	}
	
	@PostMapping
	public ResponseEntity<FilialDto> cadastrar(@RequestBody @Valid FilialDto form, UriComponentsBuilder uriBuilder){
		String cnpj = filialService.cadastrar(form);
		
		URI uri = uriBuilder.path("/filial/{cnpj}").buildAndExpand(cnpj).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/{cnpj}")
	public ResponseEntity<?> excluir(@PathVariable String cnpj) {
		filialService.excuir(cnpj);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(path = "/{cnpj}")
	public ResponseEntity<FilialDto> atualizar(@PathVariable String cnpj, @RequestBody @Valid FilialDto form) {
		FilialDto filialDto = filialService.atualizar(cnpj, form);
		return ResponseEntity.ok(filialDto);
	}
	
	
	
	//Excluir com Request Param
	@GetMapping(path = "/excluir")
	public ResponseEntity <FilialDto> testeRequestParam(
			@RequestParam(name = "regiao", defaultValue = "0") Integer codigoRegiao, 
			@RequestParam(name = "categoria", defaultValue = "0") Integer codigoCategoria) {
		System.out.println("--------------");
		System.out.println(codigoRegiao);
		
		System.out.println(codigoCategoria);
		return null;
	}

}
