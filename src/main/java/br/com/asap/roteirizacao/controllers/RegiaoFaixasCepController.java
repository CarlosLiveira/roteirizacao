package br.com.asap.roteirizacao.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.asap.roteirizacao.controllers.dto.RegiaoFaixasCepDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoFaixasCepDtoOutput;
import br.com.asap.roteirizacao.services.RegiaoFaixasCepService;

@RestController
@RequestMapping(value = "/regiaoFaixasCep")
public class RegiaoFaixasCepController {

	@Autowired
	private RegiaoFaixasCepService service;

	@GetMapping(value = "/regiao/{codigo}")
	public ResponseEntity<RegiaoFaixasCepDtoOutput> listarPorCodigoRegiao(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(service.listarPorCodigoRegiao(codigo));
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid RegiaoFaixasCepDto form,
			UriComponentsBuilder uriBuilder) {
		Long codigo = service.cadastrar(form);

		URI uri = uriBuilder.path("/regiaoFaixasCep/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/excluir")
	public ResponseEntity<?> excluir(@RequestParam(name = "regiao", defaultValue = "0") Long codigoRegiao,
			@RequestParam(name = "faixaCep", defaultValue = "0") Long codigoFaixaCep) {
		service.excluir(codigoRegiao, codigoFaixaCep);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
