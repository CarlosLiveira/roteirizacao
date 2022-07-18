package br.com.asap.roteirizacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.asap.roteirizacao.entities.FaixasCep;
import br.com.asap.roteirizacao.entities.Regiao;

public interface FaixasCepRepository extends JpaRepository<FaixasCep, Long> {
	
	List<FaixasCep> findByCodigoRegiao(Regiao regiao);

}
