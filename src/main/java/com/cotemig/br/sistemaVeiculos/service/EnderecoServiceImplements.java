package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.br.sistemaVeiculos.model.Endereco;
import com.cotemig.br.sistemaVeiculos.repository.EnderecoRepository;

@Service("enderecoService")
public class EnderecoServiceImplements implements EnderecoService{

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Override
	public List<Endereco> buscarTodosEnderecos() throws Exception {
			return enderecoRepository.findAll();
	}
	
	@Override
	public Optional<Endereco> buscarEnderecoDoCliente(Integer idEndereco) throws Exception {
		
		Optional<Endereco> enderecoRetornado = null;
		try {
			enderecoRetornado = enderecoRepository.buscarEnderecoPorId(idEndereco);
		} catch (Exception e) {
			throw new Exception("Erro ao consultar endereço do cliente!");
		}
		return enderecoRetornado;
	}

	@Override
	public void salvarEndereco(Endereco endereco) throws Exception {
		try {
			enderecoRepository.save(endereco);	
		}catch (Exception e) {
			throw new Exception("Erro ao salvar Endereço!!");
		}		
	}

	@Override
	public void excluirEndereco(Endereco endereco) throws Exception{
		try {
			enderecoRepository.delete(endereco);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir Endereço!!");
		}		
	}		
}
