package com.cotemig.br.sistemaVeiculos.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.br.sistemaVeiculos.model.Cliente;
import com.cotemig.br.sistemaVeiculos.model.Endereco;
import com.cotemig.br.sistemaVeiculos.service.ClienteService;
import com.cotemig.br.sistemaVeiculos.service.EnderecoService;

@Controller
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	EnderecoService enderecoService;

	@RequestMapping(value = "cliente/cadastrarcliente", method = RequestMethod.GET)
	public ModelAndView cadastrarCliente() {
		ModelAndView mav = new ModelAndView("cliente/cadastrarCliente");
		mav.addObject("cliente", new Cliente());
		mav.addObject("endereco", new Endereco());
		return mav;
	}		


	@RequestMapping(value = "cliente/cadastrarcliente", method = RequestMethod.POST)
	public String salvarCliente(@ModelAttribute("cliente") Cliente cliente, @ModelAttribute("endereco") Endereco endereco) {
		try {
			if(!Objects.isNull(endereco)) {
				cliente.setEndereco(endereco);
				enderecoService.salvarEndereco(endereco);
			}
			clienteService.salvarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "cliente/gerircliente", method = RequestMethod.GET)
	public ModelAndView gerirCliente() {
		ModelAndView mav = new ModelAndView("cliente/gerirCliente");
		mav.addObject("listaDeClientes", clienteService.buscarTodosOsClientesCadastrados());
		return mav;
	}	
	
	@RequestMapping(value = "cliente/alterarcliente", method = RequestMethod.GET)
	public ModelAndView alterarCliente(Integer idCliente, Cliente cliente) {
		ModelAndView mav = new ModelAndView("cliente/alterarCliente");
		mav.addObject("cliente", clienteService.buscarClientePorId(idCliente).get());
		try {
			cliente = clienteService.buscarClientePorId(idCliente).get();
			mav.addObject("endereco", enderecoService.buscarEnderecoDoCliente(cliente.getEndereco().getIdEndereco()).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}	

	@RequestMapping(value = "cliente/alterarcliente", method = RequestMethod.POST)
	public String alterarCliente(@ModelAttribute("cliente") Cliente clienteAtual, @ModelAttribute("endereco") Endereco enderecoAtual) {
		try {
			enderecoService.salvarEndereco(enderecoAtual);
			clienteAtual.setEndereco(enderecoAtual);
			clienteService.salvarCliente(clienteAtual);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}	

	@RequestMapping(value = "cliente/excluircliente", method = RequestMethod.GET)
	public ModelAndView excluirCliente(Integer idCliente, Cliente cliente) {
		ModelAndView mav = new ModelAndView("cliente/excluirCliente");
		mav.addObject("cliente", clienteService.buscarClientePorId(idCliente).get());
		try {
			cliente = clienteService.buscarClientePorId(idCliente).get();
			mav.addObject("endereco", enderecoService.buscarEnderecoDoCliente(cliente.getEndereco().getIdEndereco()).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}	
	
	@RequestMapping(value = "cliente/excluircliente", method = RequestMethod.POST)
	public String excluirCliente(@ModelAttribute("cliente") Cliente clienteAtual, @ModelAttribute("endereco") Endereco enderecoAtual) {
		try {
			enderecoService.excluirEndereco(enderecoAtual);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}		
}
