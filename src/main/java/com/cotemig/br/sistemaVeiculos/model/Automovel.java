package com.cotemig.br.sistemaVeiculos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Automovel {

	private Integer id;
	private Integer numeroPortas;
	private Integer quilometragem;
	private Integer valorAluguel;
	private String placa;
	private String chassi;
	private String cor;
	private String ano;
	private String tipoCombustivel;
	private Modelo modelo;
	private String disponivel;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getNumeroPortas() {
		return numeroPortas;
	}
	
	public void setNumeroPortas(Integer numeroPortas) {
		this.numeroPortas = numeroPortas;
	}
	
	public Integer getQuilometragem() {
		return quilometragem;
	}
	
	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}
	
	public Integer getValorAluguel() {
		return valorAluguel;
	}
	
	public void setValorAluguel(Integer valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getChassi() {
		return chassi;
	}
	
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	@ManyToOne
    @JoinColumn(name="id_modelo", nullable=false)
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
}
