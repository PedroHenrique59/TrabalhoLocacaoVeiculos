package com.cotemig.br.sistemaVeiculos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Locacao {

	private Integer id;
	private String dataHoraLocacao;
	private String dataHoraDevolucao;
	private Integer quilometragemInicial;
	private Integer quilometragemFinal;
	private Double valorTotalLocacao;	
	private String finalizada;
	private Automovel automovel;
	private Cliente cliente;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDataHoraLocacao() {
		return dataHoraLocacao;
	}

	public void setDataHoraLocacao(String dataHoraLocacao) {
		this.dataHoraLocacao = dataHoraLocacao;
	}

	public String getDataHoraDevolucao() {
		return dataHoraDevolucao;
	}

	public void setDataHoraDevolucao(String dataHoraDevolucao) {
		this.dataHoraDevolucao = dataHoraDevolucao;
	}

	public Integer getQuilometragemInicial() {
		return quilometragemInicial;
	}

	public void setQuilometragemInicial(Integer quilometragemInicial) {
		this.quilometragemInicial = quilometragemInicial;
	}

	public Integer getQuilometragemFinal() {
		return quilometragemFinal;
	}

	public void setQuilometragemFinal(Integer quilometragemFinal) {
		this.quilometragemFinal = quilometragemFinal;
	}

	public Double getValorTotalLocacao() {
		return valorTotalLocacao;
	}

	public void setValorTotalLocacao(Double valorTotalLocacao) {
		this.valorTotalLocacao = valorTotalLocacao;
	}

	@ManyToOne
	@JoinColumn(name="id_automovel")
	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	@ManyToOne
	@JoinColumn(name="id_cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(String finalizada) {
		this.finalizada = finalizada;
	}
}
