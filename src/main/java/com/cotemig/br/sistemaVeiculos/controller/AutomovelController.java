package com.cotemig.br.sistemaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.br.sistemaVeiculos.model.Automovel;
import com.cotemig.br.sistemaVeiculos.service.AutomovelService;
import com.cotemig.br.sistemaVeiculos.service.MarcaService;
import com.cotemig.br.sistemaVeiculos.service.ModeloService;

@Controller
public class AutomovelController {

	@Autowired
	private AutomovelService automovelService;

	@Autowired
	private ModeloService modeloService;
	
	@Autowired
	private MarcaService marcaService;
	
	@RequestMapping(value = "automovel/cadastrarautomovel", method = RequestMethod.GET)
	public ModelAndView cadastrarVeiculo() {
		ModelAndView mav = new ModelAndView("automovel/cadastrarVeiculo");
		mav.addObject("automovel", new Automovel());
		mav.addObject("listaDeModelos", modeloService.buscarTodosOsModelos());
		mav.addObject("listaDeMarcas", marcaService.buscarTodasAsMarcas());
		return mav;
	}

	@RequestMapping(value = "automovel/cadastrarautomovel", method = RequestMethod.POST)
	public String salvarAutomovel(@ModelAttribute("automovel") Automovel automovel) {
		try {
			//Todo veículo cadastrado já está disponível para alugar
			automovel.setDisponivel("S");
			automovelService.salvarAutomovel(automovel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}	

	@RequestMapping(value = "automovel/gerirautomovel", method = RequestMethod.GET)
	public ModelAndView gerirAutomovel() {
		ModelAndView mav = new ModelAndView("automovel/gerirAutomovel");
		mav.addObject("listaDeVeiculos", automovelService.buscarTodosOsVeiculos());
		return mav;
	}		
	
	@RequestMapping(value = "automovel/alterarautomovel", method = RequestMethod.GET)
	public ModelAndView alterarAutomovel(Integer idAutomovel) {
		ModelAndView mav = new ModelAndView("automovel/alterarAutomovel");
		mav.addObject("automovel", automovelService.buscarVeiculoPorId(idAutomovel).get());
		mav.addObject("listaDeModelos", modeloService.buscarTodosOsModelos());
		return mav;
	}	

	@RequestMapping(value = "automovel/alterarautomovel", method = RequestMethod.POST)
	public String alterarAutomovel(@ModelAttribute("automovel") Automovel automovel) {
		try {
			automovelService.salvarAutomovel(automovel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}	

	@RequestMapping(value = "automovel/excluirautomovel", method = RequestMethod.GET)
	public ModelAndView excluirAutomovel(Integer idAutomovel) {
		ModelAndView mav = new ModelAndView("automovel/excluirAutomovel");
		mav.addObject("automovel", automovelService.buscarVeiculoPorId(idAutomovel).get());
		return mav;
	}	

	@RequestMapping(value = "automovel/excluirautomovel", method = RequestMethod.POST)
	public String excluirAutomovel(@ModelAttribute("automovel") Automovel automovel) {
		try {
			automovelService.excluirAutomovelPorId(automovel.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}	
}
