package br.com.asap.roteirizacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.asap.roteirizacao.entities.TipoTransporte;

public interface TipoTransporteRepository extends JpaRepository<TipoTransporte, Long> {
	
}
