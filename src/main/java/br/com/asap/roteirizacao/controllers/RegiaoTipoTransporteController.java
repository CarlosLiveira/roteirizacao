package br.com.asap.roteirizacao.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

//	@PutMapping(value = "/{codigo}")
//	public ResponseEntity<RegiaoTipoTransporteDto2> atualizar(@PathVariable Long codigo,
//			@RequestBody @Valid RegiaoTipoTransporteDto2 form) {
//		RegiaoTipoTransporteDto2 regiaoTipoTransporteDto2 = service.atualizar(codigo, form);
//		return ResponseEntity.ok(regiaoTipoTransporteDto2);
//	}

//	@DeleteMapping(path = "/{codigo}") 
//	public ResponseEntity<?> excluir(@PathVariable Long codigo){
//		service.excluir(codigo);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//	}

}
