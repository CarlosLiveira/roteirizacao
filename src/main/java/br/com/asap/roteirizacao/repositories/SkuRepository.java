package br.com.asap.roteirizacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.asap.roteirizacao.entities.Sku;

public interface SkuRepository extends JpaRepository<Sku, Long> {

}
