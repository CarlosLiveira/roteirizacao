package br.com.asap.roteirizacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoTipoTransporte;
import br.com.asap.roteirizacao.entities.RegiaoTipoTransportePK;
import br.com.asap.roteirizacao.entities.TipoTransporte;

@Repository
public interface RegiaoTipoTransporteRepository extends JpaRepository<RegiaoTipoTransporte, RegiaoTipoTransportePK> {

	@Query("SELECT R FROM RegiaoTipoTransporte R WHERE regiaoTipoTransportePK.regiao = ?1")
	List<RegiaoTipoTransporte> findByCodigoRegiao(Regiao regiao);
	
	@Query("SELECT R FROM RegiaoTipoTransporte R WHERE regiaoTipoTransportePK.regiao in (?1)"
			+ " AND regiaoTipoTransportePK.tipoTransporte = ?2")
	List<RegiaoTipoTransporte> findByRegiaoInAndTipoTransporte(List<Regiao> regiao, TipoTransporte tipoTransporte);

}
