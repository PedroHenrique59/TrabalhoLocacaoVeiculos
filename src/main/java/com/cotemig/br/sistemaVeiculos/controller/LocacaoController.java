package com.cotemig.br.sistemaVeiculos.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.br.sistemaVeiculos.model.Automovel;
import com.cotemig.br.sistemaVeiculos.model.Cliente;
import com.cotemig.br.sistemaVeiculos.model.Locacao;
import com.cotemig.br.sistemaVeiculos.service.AutomovelService;
import com.cotemig.br.sistemaVeiculos.service.ClienteService;
import com.cotemig.br.sistemaVeiculos.service.LocacaoService;

@Controller
public class LocacaoController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	AutomovelService automovelService;

	@Autowired
	LocacaoService locacaoService;

	@RequestMapping(value = "locacao/menulocacao", method = RequestMethod.GET)
	public ModelAndView menuLocacao() {
		ModelAndView mav = new ModelAndView("locacao/menuLocacao");
		mav.addObject("listaDeClientes", clienteService.buscarTodosOsClientesCadastrados());
		return mav;
	}		

	@RequestMapping(value = "locacao/dadoslocacao", method = RequestMethod.GET)
	public ModelAndView dadosLocacao(Integer id) {
		ModelAndView mav = new ModelAndView("locacao/dadosLocacao");
		mav.addObject("cliente", clienteService.buscarClientePorId(id).get());	
		mav.addObject("listaDeVeiculos", automovelService.buscarVeiculosDisponiveis());
		return mav;
	}			

	@RequestMapping(value = "locacao/realizarlocacao", method = RequestMethod.GET)
	public ModelAndView realizarLocacao(Integer idVeiculo, Integer idCliente) {
		ModelAndView mav = new ModelAndView("locacao/realizarLocacao");
		mav.addObject("veiculoEscolhido", automovelService.buscarVeiculoPorId(idVeiculo).get());
		mav.addObject("clienteEscolhido", clienteService.buscarClientePorId(idCliente).get());
		return mav;
	}		

	@RequestMapping(value = "locacao/realizarlocacao", method = RequestMethod.POST)
	public String salvarLocacao(@ModelAttribute("locacao") Locacao locacao, Cliente cliente, Automovel automovel) {
		try {		
			String dataHoraAtual = obterDataHoraAtual();
			automovel.setDisponivel("N");
			locacao.setAutomovel(automovel);
			locacao.setCliente(cliente);
			locacao.setDataHoraLocacao(dataHoraAtual);
			locacao.setQuilometragemInicial(automovel.getQuilometragem());
			locacao.setFinalizada("N");
			locacaoService.salvarLocacao(locacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	public String obterDataHoraAtual() {
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataHoraFormatada = formatacao.format(dataHoraAtual);
		return dataHoraFormatada;
	}

	@RequestMapping(value = "locacao/vertodaslocacoes", method = RequestMethod.GET)
	public ModelAndView verTodasLocacoes() {
		ModelAndView mav = new ModelAndView("locacao/verTodasLocacoes");
		String naofinalizada = "N";
		mav.addObject("listaDeLocacoes", locacaoService.buscarTodasLocacoesNaoFinalizadas(naofinalizada));
		return mav;
	}		

	@RequestMapping(value = "locacao/vertodaslocacoesfinalizadas", method = RequestMethod.GET)
	public ModelAndView verTodasLocacoesNaoFinalizadas() {
		ModelAndView mav = new ModelAndView("locacao/verTodasLocacoesFinalizadas");
		String finalizada = "S";
		mav.addObject("listaDeLocacoes", locacaoService.buscarTodasLocacoesFinalizadas(finalizada));
		return mav;
	}		
	
	@RequestMapping(value = "locacao/devolverveiculo", method = RequestMethod.GET)
	public ModelAndView devolverVeiculo(Integer idLocacao) {
		ModelAndView mav = new ModelAndView("locacao/devolverVeiculo");
		mav.addObject("locacao", locacaoService.buscarLocacaoPorId(idLocacao).get());
		return mav;
	}	

	@RequestMapping(value = "locacao/devolverveiculo", method = RequestMethod.POST)
	public String devolverVeiculo(@ModelAttribute("locacao") Locacao locacao) {	
		try {		
			Locacao locacaoFinalizada = locacao;
			locacaoFinalizada.setDataHoraDevolucao(obterDataHoraAtual());
			Integer quantidadeDias = calcularNumeroDias(locacaoFinalizada);
			Integer totalAPagar = quantidadeDias * locacao.getAutomovel().getValorAluguel();
			locacaoFinalizada.setValorTotalLocacao(totalAPagar.doubleValue());
			locacao.getAutomovel().setDisponivel("S");
			locacao.setFinalizada("S");
			locacaoService.salvarLocacao(locacaoFinalizada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/locacao/vertodaslocacoes";
	}

	public Integer calcularNumeroDias(Locacao locacao) {
		String dataHoraLocacao = locacao.getDataHoraLocacao();
		String dataHoraDevolucao = locacao.getDataHoraDevolucao();
		Integer quantidadeDias;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDate dataLocacao = LocalDate.parse(dataHoraLocacao, formatter);
		LocalDate dataDevolucao = LocalDate.parse(dataHoraDevolucao, formatter);

		Period p = Period.between(dataLocacao, dataDevolucao);
		quantidadeDias = p.getDays();

		return quantidadeDias + 1;
	}
}
