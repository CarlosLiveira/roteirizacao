//package br.com.asap.roteirizacao.controllers;
//
//import java.net.URI;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import br.com.asap.roteirizacao.controllers.dto.RegiaoCategoriaDto;
//import br.com.asap.roteirizacao.services.RegiaoCategoriaService;
//
//@RestController
//@RequestMapping(path = "/regiaoCategoria")
//public class RegiaoCategoriaController {
//	
//	@Autowired
//	private RegiaoCategoriaService regiaoCategoriaService;
//	
//	@GetMapping
//	public ResponseEntity<List<RegiaoCategoriaDto>> listar(){
//		return ResponseEntity.ok().body(regiaoCategoriaService.listar());
//	}
//	
//	@GetMapping(path = "/{codigo}")
//	public ResponseEntity<RegiaoCategoriaDto> listarPorCodigo(@PathVariable Long codigo){
//		return ResponseEntity.ok().body(regiaoCategoriaService.listarPorCodigo(codigo));
//	}
//	
//	@PostMapping
//	public ResponseEntity<Void> cadastrar(@RequestBody @Valid RegiaoCategoriaDto form, UriComponentsBuilder uriBuilder){
//		Long codigo = regiaoCategoriaService.cadastrar(form);
//		
//		URI uri = uriBuilder.path("/regiaoCategoria/{codigo}").buildAndExpand(codigo).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@PutMapping(path = "/{codigo}")
//	public ResponseEntity<RegiaoCategoriaDto> atualizar(@PathVariable Long codigo, @RequestBody @Valid RegiaoCategoriaDto form ){
//		return ResponseEntity.ok().body(regiaoCategoriaService.atualizar(codigo, form));
//	}
//	
//	@DeleteMapping(path = "/{codigo}")
//	public ResponseEntity<?> excluir(@PathVariable Long codigo){
//		regiaoCategoriaService.excluir(codigo);
//		return ResponseEntity.noContent().build();
//	}
//}
