package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.br.sistemaVeiculos.enums.TipoModeloEnum;
import com.cotemig.br.sistemaVeiculos.model.Automovel;
import com.cotemig.br.sistemaVeiculos.repository.AutomovelRepository;

@Service("automovelService")
public class AutomovelServiceImplements implements AutomovelService {

	@Autowired
	AutomovelRepository automovelRepository;
	
	@Override
	public List<Automovel> buscarTodosOsVeiculos() {
		return automovelRepository.findAll();
	}

	@Override
	public List<Automovel> buscarVeiculoPorModelo(String modeloVeiculo) {
		return automovelRepository.buscarVeiculosPorModelo(modeloVeiculo);
	}

	@Override
	public List<Automovel> buscarVeiculosPorTipoDeModelo(TipoModeloEnum tipoModelo) {
		return automovelRepository.buscarVeiculosPorTipoModelo(tipoModelo);
	}

	@Override
	public List<Automovel> buscarVeiculosPorMarca(String nomeMarca) {
		return automovelRepository.buscarVeiculosPorMarca(nomeMarca);
	}

	@Override
	public void salvarAutomovel(Automovel automovel) throws Exception {
		try {
			automovelRepository.save(automovel);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar automóvel!");
		}	
	}

	@Override
	public void excluirTodosAutomoveis() throws Exception {
		try {
			automovelRepository.deleteAll();
		} catch (Exception e) {
			throw new Exception("Erro ao excluir todos os automóveis!");
		}
	}

	@Override
	public void excluirAutomovelPorId(Integer idAutomovel) throws Exception {
		try {
			automovelRepository.deleteById(idAutomovel);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir automóvel!");
		}
	}

	@Override
	public void atualizarAutomovelPorId(Integer idAutomovel, Automovel automovelAtual) throws Exception {
		try {
			
			Optional<Automovel> automovelRetornado = automovelRepository.findById(idAutomovel);
			
			automovelRetornado.get().setNumeroPortas(automovelAtual.getNumeroPortas());
			automovelRetornado.get().setQuilometragem(automovelAtual.getQuilometragem());
			automovelRetornado.get().setValorAluguel(automovelAtual.getValorAluguel());
			automovelRetornado.get().setPlaca(automovelAtual.getPlaca());
			automovelRetornado.get().setChassi(automovelAtual.getChassi());
			automovelRetornado.get().setCor(automovelAtual.getCor());
			automovelRetornado.get().setAno(automovelAtual.getAno());
			automovelRetornado.get().setTipoCombustivel(automovelAtual.getTipoCombustivel());
			
			//lista de clientes?
			//modelo?
			
			automovelRepository.save(automovelRetornado.get());
			
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar automóvel!");
		}
	}

	@Override
	public List<Automovel> buscarVeiculosDisponiveis() {
		String disponivel = "S";
		return automovelRepository.buscarVeiculosDisponiveis(disponivel);
	}

	@Override
	public Optional<Automovel> buscarVeiculoPorId(Integer id) {
		return automovelRepository.findById(id);	
	}
}
