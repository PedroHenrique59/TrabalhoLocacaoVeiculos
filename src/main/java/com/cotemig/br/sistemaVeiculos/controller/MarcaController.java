package com.cotemig.br.sistemaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.br.sistemaVeiculos.model.Marca;
import com.cotemig.br.sistemaVeiculos.service.MarcaService;

@Controller
public class MarcaController {

	@Autowired
	MarcaService marcaService;
	
	@RequestMapping(value = "marca/cadastrarmarca", method = RequestMethod.GET)
	public ModelAndView cadastrarMarca() {
		ModelAndView mav = new ModelAndView("marca/cadastrarMarca");
		mav.addObject("marca", new Marca());
		return mav;
	}
	
	@RequestMapping(value = "marca/cadastrarmarca", method = RequestMethod.POST)
	public String salvarMarca(@ModelAttribute("marca") Marca marca){
		try {			
			marcaService.salvarMarca(marca);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "marca/gerirmarca", method = RequestMethod.GET)
	public ModelAndView gerirMarca() {
		ModelAndView mav = new ModelAndView("marca/gerirMarca");
		mav.addObject("listaDeMarcas", marcaService.buscarTodasAsMarcas());
		return mav;
	}

	@RequestMapping(value = "marca/alterarmarca", method = RequestMethod.GET)
	public ModelAndView alterarMarca(Integer idMarca) {
		ModelAndView mav = new ModelAndView("marca/alterarMarca");
		mav.addObject("marca", marcaService.buscarMarcaPorId(idMarca).get());
		return mav;
	}
	
	@RequestMapping(value = "marca/alterarmarca", method = RequestMethod.POST)
	public String alterarMarca(@ModelAttribute("marca") Marca marcaAtual){
		try {			
			marcaService.salvarMarca(marcaAtual);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "marca/excluirmarca", method = RequestMethod.GET)
	public ModelAndView excluirMarca(Integer idMarca) {
		ModelAndView mav = new ModelAndView("marca/excluirMarca");
		mav.addObject("marca", marcaService.buscarMarcaPorId(idMarca).get());
		return mav;
	}
	
	@RequestMapping(value = "marca/excluirmarca", method = RequestMethod.POST)
	public String excluirMarca(@ModelAttribute("marca") Marca marcaAtual){
		try {			
			marcaService.excluirMarcaPorId(marcaAtual.getId());		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
