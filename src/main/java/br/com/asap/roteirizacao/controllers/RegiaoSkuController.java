
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

import br.com.asap.roteirizacao.controllers.dto.RegiaoSkuDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoSkuDtoOutput;
import br.com.asap.roteirizacao.services.RegiaoSkuService;

@RestController
@RequestMapping(value = "/regiaoSku")
public class RegiaoSkuController {

	@Autowired
	private RegiaoSkuService regiaoSkuService;

	@GetMapping(value = "/regiao/{codigo}")
	public ResponseEntity<RegiaoSkuDtoOutput> findById(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(regiaoSkuService.findyById(codigo));
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody RegiaoSkuDto form, UriComponentsBuilder uribBuilder) {
		regiaoSkuService.cadastrar(form);
//		URI uri = uribBuilder.path("/regiaoSku/{codigo}").buildAndExpand(codigo).toUri();
		return ResponseEntity.created(null).build();
	}

	@DeleteMapping(path = "/excluir")
	public ResponseEntity<?> excluir(
			@RequestParam(name = "regiao", defaultValue = "0") Long codigoRegiao,
			@RequestParam(name = "sku", defaultValue = "0") Long codigoSku) 
	{
		regiaoSkuService.excluir(codigoRegiao, codigoSku);
		return ResponseEntity.noContent().build();
	}

}
