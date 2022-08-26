package br.com.asap.roteirizacao.controllers;

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

import br.com.asap.roteirizacao.controllers.dto.RegiaoFilialDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoFilialDtoOutput;
import br.com.asap.roteirizacao.services.RegiaoFilialService;

@RestController
@RequestMapping(value = "/regiaoFilial")
public class RegiaoFilialControler {

	@Autowired
	private RegiaoFilialService regiaoFilialService;

	@GetMapping(value = "/regiao/{codigo}")
	public ResponseEntity<RegiaoFilialDtoOutput> listarPorCodigoRegiao(@PathVariable Long codigo) {
		return ResponseEntity.ok(regiaoFilialService.listarPorCodigo(codigo));
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody RegiaoFilialDto form, UriComponentsBuilder uriBuilder) {
		regiaoFilialService.cadastrar(form);
//		URI uri = uriBuilder.path("/regiaoFilial/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(null).build();
	}

	@DeleteMapping(value = "/excluir")
	public ResponseEntity<?> excluir(@RequestParam(name = "regiao", defaultValue = "0") Long codigoRegiao,
			@RequestParam(name = "cnpj", defaultValue = "0") String cnpj) {
		regiaoFilialService.excluir(codigoRegiao, cnpj);
		return ResponseEntity.noContent().build();
	}

}
