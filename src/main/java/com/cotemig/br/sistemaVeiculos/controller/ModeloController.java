package com.cotemig.br.sistemaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.br.sistemaVeiculos.model.Modelo;
import com.cotemig.br.sistemaVeiculos.service.MarcaService;
import com.cotemig.br.sistemaVeiculos.service.ModeloService;

@Controller
public class ModeloController {

	@Autowired
	ModeloService modeloService;

	@Autowired
	MarcaService marcaService;

	@RequestMapping(value = "modelo/cadastrarmodelo", method = RequestMethod.GET)
	public ModelAndView cadastrarModelo() {
		ModelAndView mav = new ModelAndView("modelo/cadastrarModelo");
		mav.addObject("modelo", new Modelo());
		mav.addObject("tiposModelos", modeloService.buscarTiposModelo());
		mav.addObject("listaDeMarcas", marcaService.buscarTodasAsMarcas());
		return mav;
	}

	@RequestMapping(value = "modelo/cadastrarmodelo", method = RequestMethod.POST)
	public String salvarModelo(@ModelAttribute("modelo") Modelo modelo) {
		try {
			modeloService.salvarModelo(modelo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "modelo/gerirmodelo", method = RequestMethod.GET)
	public ModelAndView gerirModelo() {
		ModelAndView mav = new ModelAndView("modelo/gerirModelo");
		mav.addObject("listaDeModelos", modeloService.buscarTodosOsModelos());
		return mav;
	}

	@RequestMapping(value = "modelo/alterarmodelo", method = RequestMethod.GET)
	public ModelAndView alterarModelo(Integer idModelo) {
		ModelAndView mav = new ModelAndView("modelo/alterarModelo");
		mav.addObject("modelo", modeloService.buscarModeloPorId(idModelo).get());
		mav.addObject("listaTiposModelo", modeloService.buscarTiposModelo());
		mav.addObject("listaDeMarcas", marcaService.buscarTodasAsMarcas());
		return mav;
	}

	@RequestMapping(value = "modelo/alterarmodelo", method = RequestMethod.POST)
	public String alterarModelo(@ModelAttribute("modelo") Modelo modeloAtual) {
		try {
			modeloService.salvarModelo(modeloAtual);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "modelo/excluirmodelo", method = RequestMethod.GET)
	public ModelAndView excluirModelo(Integer idModelo) {
		ModelAndView mav = new ModelAndView("modelo/excluirModelo");
		mav.addObject("modeloEscolhido", modeloService.buscarModeloPorId(idModelo).get());
		return mav;
	}

	@RequestMapping(value = "modelo/excluirmodelo", method = RequestMethod.POST)
	public String excluirModelo(Modelo modeloEscolhido) {
		try {
			modeloService.excluirModeloPorId(modeloEscolhido.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}	
}
