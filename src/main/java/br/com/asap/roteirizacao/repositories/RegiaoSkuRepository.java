package br.com.asap.roteirizacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoSku;
import br.com.asap.roteirizacao.entities.RegiaoSkuPk;

@Repository
public interface RegiaoSkuRepository extends JpaRepository<RegiaoSku, RegiaoSkuPk> {

	@Query("SELECT S FROM RegiaoSku S WHERE regiaoSkuPk.regiao = ?1")
	List<RegiaoSku> findByCodigoRegiao(Regiao regiao);

}
