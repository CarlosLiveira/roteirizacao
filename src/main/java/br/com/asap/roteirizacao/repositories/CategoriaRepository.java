package br.com.asap.roteirizacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.asap.roteirizacao.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}
