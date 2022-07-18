package br.com.asap.roteirizacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoTipoTransporte;
import br.com.asap.roteirizacao.entities.RegiaoTipoTransportePK;

@Repository
public interface RegiaoTipoTransporteRepository extends JpaRepository<RegiaoTipoTransporte, RegiaoTipoTransportePK> {

	@Query("SELECT R FROM RegiaoTipoTransporte R WHERE regiaoTipoTransportePK.regiao = ?1")
	List<RegiaoTipoTransporte> findByCodigoRegiao(Regiao regiao);

}
