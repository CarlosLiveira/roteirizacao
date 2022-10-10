package br.com.asap.roteirizacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.asap.roteirizacao.entities.Categoria;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoCategoria;
import br.com.asap.roteirizacao.entities.RegiaoCategoriaPk;

public interface RegiaoCategoriaRepository extends JpaRepository<RegiaoCategoria, RegiaoCategoriaPk> {

	@Query("SELECT C FROM RegiaoCategoria C WHERE regiaoCategoriaPk.regiao = ?1")
	List<RegiaoCategoria> findByCodigoRegiao(Regiao regiao);
	
	List<RegiaoCategoria> findByRegiaoCategoriaPkCategoriaAndRegiaoCategoriaPkRegiaoIn(Categoria categoria, List<Regiao> regiao);
}
