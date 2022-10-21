package br.com.asap.roteirizacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.asap.roteirizacao.entities.Filial;
import br.com.asap.roteirizacao.services.ConsultaService;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultasController {

	@Autowired
	private ConsultaService consultaService;

	@GetMapping(value = "/filial")
	public ResponseEntity<List<Filial>> findFiliais(
			@RequestParam(name = "cep", defaultValue = "0") Long cep,
			@RequestParam(name = "sku", defaultValue = "0") Long codigoSku) {
		List<Filial> filiais = consultaService.listarRegiaoAtendeCep(cep, codigoSku);
		return ResponseEntity.ok().body(filiais);
	}

}
