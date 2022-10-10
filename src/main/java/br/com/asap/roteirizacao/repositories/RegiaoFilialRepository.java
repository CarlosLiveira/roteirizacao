package br.com.asap.roteirizacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoFilial;
import br.com.asap.roteirizacao.entities.RegiaoFilialPk;

public interface RegiaoFilialRepository extends JpaRepository<RegiaoFilial, RegiaoFilialPk> {

	@Query("SELECT F FROM RegiaoFilial F WHERE regiaoFilialPk.regiao = ?1" 
			+ " ORDER BY regiaoFilialPk.filial.cnpj ASC")
	List<RegiaoFilial> findByCodigoRegiao(Regiao regiao);
	
	@Query("SELECT F FROM RegiaoFilial F WHERE regiaoFilialPk.regiao in (?1)")
	List<RegiaoFilial> findByRegiaoIn(List<Regiao> regiao);
	

}