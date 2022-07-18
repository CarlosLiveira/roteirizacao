package br.com.asap.roteirizacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.asap.roteirizacao.entities.Filial;

public interface FilialRepository extends JpaRepository<Filial, String> {

}
