package br.com.asap.roteirizacao.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.asap.roteirizacao.controllers.dto.RegiaoCategoriaDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoCategoriaDtoOutput;
import br.com.asap.roteirizacao.services.RegiaoCategoriaService;

@RestController
@RequestMapping(value = "/regiaoCategoria")
public class RegiaoCategoriaController {

	@Autowired
	private RegiaoCategoriaService regiaoCategoriaService;

	@GetMapping(value = "/regiao/{codigo}")
	public ResponseEntity<RegiaoCategoriaDtoOutput> listarPorCodigoRegiao(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(regiaoCategoriaService.listarPorCodigoRegiao(codigo));
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid RegiaoCategoriaDto form,
			UriComponentsBuilder uriBuilder) {
		regiaoCategoriaService.cadastrar(form);
//		URI uri = uriBuilder.path("/regiaoCategoria/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(null).build();
	}

	@DeleteMapping(path = "/excluir")
	public ResponseEntity<?> excluir(
			@RequestParam(name = "regiao", defaultValue = "0") Long codigoRegiao,
			@RequestParam(name = "categoria", defaultValue = "0") Long codigoCategoria) 
	{
		regiaoCategoriaService.excluir(codigoRegiao, codigoCategoria);
		return ResponseEntity.noContent().build();
	}
}
