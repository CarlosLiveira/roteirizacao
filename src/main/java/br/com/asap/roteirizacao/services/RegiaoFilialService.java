package br.com.asap.roteirizacao.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.asap.roteirizacao.controllers.dto.RegiaoDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoFilialDto;
import br.com.asap.roteirizacao.controllers.dto.RegiaoFilialDtoOutput;
import br.com.asap.roteirizacao.controllers.dto.RegiaoFilialDtoOutputList;
import br.com.asap.roteirizacao.entities.Filial;
import br.com.asap.roteirizacao.entities.Regiao;
import br.com.asap.roteirizacao.entities.RegiaoFilial;
import br.com.asap.roteirizacao.entities.RegiaoFilialPk;
import br.com.asap.roteirizacao.repositories.RegiaoFilialRepository;

@Service
public class RegiaoFilialService {

	@Autowired
	private RegiaoService regiaoService;

	@Autowired
	private FilialService filialService;

	@Autowired
	private RegiaoFilialRepository regiaoFilialRepository;

	@Transactional
	public RegiaoFilialDtoOutput listarPorCodigo(Long codigo) {
		RegiaoDto regiaoDto = regiaoService.findById(codigo);
		List<RegiaoFilial> regiaoFilial = regiaoFilialRepository.findByCodigoRegiao(regiaoDto.toRegiao());
		List<RegiaoFilialDtoOutputList> filiais = regiaoFilial.stream()
				.map(obj -> 
				new RegiaoFilialDtoOutputList(obj.getRegiaoFilialPk().getFilial(), obj.getOrdem()))
				.collect(Collectors.toList());
		
		return new RegiaoFilialDtoOutput(regiaoDto, filiais);
	}

	@Transactional
	public RegiaoFilialPk cadastrar(RegiaoFilialDto form) {
		Regiao regiao = regiaoService.findById(form.getRegiao().getCodigo()).toRegiao();
		Filial filial = filialService.findById(form.getFilial().getCnpj()).toFilial();
		RegiaoFilial regiaoFilial = new RegiaoFilial(regiao, filial);
		regiaoFilial.setOrdem(form.getOrdem());
		regiaoFilialRepository.save(regiaoFilial);
		return regiaoFilial.getRegiaoFilialPk();
	}

	@Transactional
	public RegiaoFilialPk excluir(Long codigoRegiao, String cnpj) {
		Regiao regiao = regiaoService.findById(codigoRegiao).toRegiao();
		Filial filial = filialService.findById(cnpj).toFilial();
		RegiaoFilial regiaoFilial = new RegiaoFilial(regiao, filial);
		regiaoFilialRepository.delete(regiaoFilial);
		return regiaoFilial.getRegiaoFilialPk();
	}

}
