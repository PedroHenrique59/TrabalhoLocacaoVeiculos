package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.br.sistemaVeiculos.model.Cliente;
import com.cotemig.br.sistemaVeiculos.model.Locacao;
import com.cotemig.br.sistemaVeiculos.repository.LocacaoRepository;

@Service("locacaoService")
public class LocacaoServiceImplements implements LocacaoService {

	@Autowired
	LocacaoRepository locacaoRepository;
	
	@Override
	public List<Locacao> buscarTodasLocacoes() {
		return locacaoRepository.findAll();
	}

	@Override
	public void salvarLocacao(Locacao locacao) throws Exception {
		locacaoRepository.save(locacao);
	}

	@Override
	public void excluirLocacaoPorCliente(Cliente cliente) throws Exception {
		try {
			locacaoRepository.excluirLocacaoPorCliente(cliente.getId());	
		} catch (Exception e) {
			throw new Exception("Erro ao excluir locação do cliente!");
		}	
	}

	@Override
	public void atualizarInformacoesLocacao(Integer idCliente, Locacao locacaoAtual) throws Exception {
		try {
			
			Optional<Locacao> locacaoRetornada = locacaoRepository.buscarLocacaoDoCliente(idCliente);
			
			locacaoRetornada.get().setDataHoraDevolucao(locacaoAtual.getDataHoraDevolucao());
			locacaoRetornada.get().setDataHoraLocacao(locacaoAtual.getDataHoraLocacao());
			locacaoRetornada.get().setQuilometragemFinal(locacaoAtual.getQuilometragemFinal());
			locacaoRetornada.get().setQuilometragemInicial(locacaoAtual.getQuilometragemInicial());
			locacaoRetornada.get().setValorTotalLocacao(locacaoAtual.getValorTotalLocacao());
			
			locacaoRepository.save(locacaoRetornada.get());

		} catch (Exception e) {
			throw new Exception("Erro ao atualizar informações da locação!");
		}
	}

	@Override
	public Optional<Locacao> buscarLocacaoPorId(Integer idLocacao) {
		return locacaoRepository.findById(idLocacao);
	}

	@Override
	public List<Locacao> buscarTodasLocacoesNaoFinalizadas(String naoFinalizada) {
		return locacaoRepository.buscarLocacoesNaoFinalizadas(naoFinalizada);
	}

	@Override
	public List<Locacao> buscarTodasLocacoesFinalizadas(String finalizada) {
		return locacaoRepository.buscarLocacoesFinalizadas(finalizada);
	}
}
