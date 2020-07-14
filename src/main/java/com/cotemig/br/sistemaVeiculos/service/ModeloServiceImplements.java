package com.cotemig.br.sistemaVeiculos.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.br.sistemaVeiculos.enums.TipoModeloEnum;
import com.cotemig.br.sistemaVeiculos.model.Modelo;
import com.cotemig.br.sistemaVeiculos.repository.ModeloRepository;

@Service("modeloService")
public class ModeloServiceImplements implements ModeloService {

	@Autowired
	ModeloRepository modeloRepository;
	
	@Override
	public List<Modelo> buscarTodosOsModelos() {
		return modeloRepository.findAll();
	}

	@Override
	public Optional<Modelo> buscarModeloPorNome(String nome) {
		return modeloRepository.buscarModeloPorNome(nome);
	}

	@Override
	public Optional<Modelo> buscarModeloPorTipo(TipoModeloEnum tipo) {
		return modeloRepository.buscarModeloPorTipo(tipo);
	}

	@Override
	public Optional<Modelo> buscarModeloPorMarca(String nomeMarca) {
		return modeloRepository.buscarModeloPorMarca(nomeMarca);
	}

	@Override
	public void salvarModelo(Modelo modelo) throws Exception {
		try {
			modeloRepository.save(modelo);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar modelo!");
		}
	}

	@Override
	public void excluirTodosModelos() throws Exception {
		try {
			modeloRepository.deleteAll();
		} catch (Exception e) {
			throw new Exception("Erro ao excluir todos os modelos!");
		}
	}

	@Override
	public void excluirModeloPorId(Integer idModelo) throws Exception {
		try {
			modeloRepository.deleteById(idModelo);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir o modelo!");
		}
	}

	@Override
	public void atualizarModeloPorNome(String nome, Modelo modeloAtual) throws Exception {
		try {
				
			Optional<Modelo> modeloRetornado = modeloRepository.buscarModeloPorNome(nome);
			
			modeloRetornado.get().setNome(modeloAtual.getNome());
			modeloRetornado.get().setTipo(modeloAtual.getTipo());
			modeloRetornado.get().setMarca(modeloAtual.getMarca());
			
			//lista de automoveis?
			
			modeloRepository.save(modeloRetornado.get());
			
		} catch (Exception e) {
			throw new Exception("Erro ao excluir o modelo!");
		}	
	}

	@Override
	public List<TipoModeloEnum> buscarTiposModelo() {
		return Arrays.asList(TipoModeloEnum.values());
	}

	@Override
	public Optional<Modelo> buscarModeloPorId(Integer idModelo) {
		return modeloRepository.findById(idModelo);
	}	
}
