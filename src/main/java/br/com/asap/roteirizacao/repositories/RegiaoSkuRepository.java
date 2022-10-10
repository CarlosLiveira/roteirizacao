package br.com.asap.roteirizacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoSku;
import br.com.asap.roteirizacao.entities.RegiaoSkuPk;
import br.com.asap.roteirizacao.entities.Sku;

@Repository
public interface RegiaoSkuRepository extends JpaRepository<RegiaoSku, RegiaoSkuPk> {

	@Query("SELECT S FROM RegiaoSku S WHERE regiaoSkuPk.regiao = ?1")
	List<RegiaoSku> findByCodigoRegiao(Regiao regiao);

	@Query("SELECT S FROM RegiaoSku S WHERE S.regiaoSkuPk.regiao.codigo = ?1")
	List<RegiaoSku> findBySku(Long sku);

	List<RegiaoSku> findByRegiaoSkuPkSkuAndRegiaoSkuPkRegiaoIn(Sku sku, List<Regiao> regioes);

//	@Query("SELECT F.cnpj "
//			+ "FROM RegiaoFaixaCep C, RegiaoSku S, Sku K, "
//			+ "RegiaoCategoria A, RegiaoTipoTransporte T, RegiaoFilial F, "
//			+ "WHERE ?1 BETWEEN cep_inicial AND cep_final "
//			+ "AND S.sku.codigo = :sku "
//			+ "AND A.sku.codigo  ")
//	RegiaoSkuPk findBySku(Long cep, Long sku);
}
