package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.br.sistemaVeiculos.model.Marca;
import com.cotemig.br.sistemaVeiculos.repository.MarcaRepository;

@Service("marcaService")
public class MarcaServiceImplements implements MarcaService{

	@Autowired
	MarcaRepository marcaRepository;
	
	@Override
	public List<Marca> buscarTodasAsMarcas() {
		return marcaRepository.findAll();
	}

	@Override
	public Optional<Marca> buscarMarcaPorNome(String nomeMarca) {	
		return marcaRepository.buscarMarcaPorNome(nomeMarca);
	}

	@Override
	public void salvarMarca(Marca marca) throws Exception {
		try {
			marcaRepository.save(marca);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar marca!");
		}	
	}

	@Override
	public void excluirTodasMarcas() throws Exception {
		try {
			marcaRepository.deleteAll();
		} catch (Exception e) {
			throw new Exception("Erro ao excluir todas as marcas!");
		}
	}

	@Override
	public void excluirMarcaPorId(Integer idMarca) throws Exception {
		try {
			marcaRepository.deleteById(idMarca);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir a marca!");
		}
	}

	@Override
	public void atualizarMarcaPorNome(String nome, Marca marcaAtual) throws Exception {
		
		try {
			
			Optional<Marca> marcaRetornada = marcaRepository.buscarMarcaPorNome(nome);
			
			marcaRetornada.get().setNome(marcaAtual.getNome());
			
			// lista de automoveis?
			
			marcaRepository.save(marcaRetornada.get());
			
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar a marca!");
		}		
	}

	@Override
	public Optional<Marca> buscarMarcaPorId(Integer idMarca) {
		return marcaRepository.findById(idMarca);
	}	
}
