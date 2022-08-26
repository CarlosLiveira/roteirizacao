package br.com.asap.roteirizacao.controllers;

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

import br.com.asap.roteirizacao.controllers.dto.RegiaoTipoTransporteDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoTipoTransporteDtoOutput;
import br.com.asap.roteirizacao.services.RegiaoTipoTransporteService;

@RestController
@RequestMapping(value = "/regiaoTipoTransporte")
public class RegiaoTipoTransporteController {

	@Autowired
	private RegiaoTipoTransporteService service;

	@GetMapping(value = "/regiao/{codigo}")
	public ResponseEntity<RegiaoTipoTransporteDtoOutput> listarPorCodigoRegiao(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(service.listarPorCodigoRegiao(codigo));
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid RegiaoTipoTransporteDto form,
			UriComponentsBuilder uriBuilder) {
		service.cadastrar(form);
//		URI uri = uriBuilder.path("/regiaoTipoTransporte/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(null).build();
	}

	@DeleteMapping(path = "/excluir")
	public ResponseEntity<?> excluir(
			@RequestParam(name = "regiao", defaultValue = "0") Long codigoRegiao,
			@RequestParam(name = "tipoTransporte", defaultValue = "0") Long codigoTipoTransporte) 
	{
		service.excluir(codigoRegiao, codigoTipoTransporte);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
