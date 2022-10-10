package br.com.asap.roteirizacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoFaixasCep;

public interface RegiaoFaixasCepRepository extends JpaRepository<RegiaoFaixasCep, Long> {

	@Query("SELECT R FROM RegiaoFaixasCep R WHERE regiao = ?1")
	List<RegiaoFaixasCep> findByCodigoRegiao(Regiao regiao);

	@Query("SELECT R.regiao FROM RegiaoFaixasCep R WHERE ?1 BETWEEN cep_inicial AND cep_final")
	List<Regiao> findByCep(Long cep);

}
