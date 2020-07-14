package com.cotemig.br.sistemaVeiculos.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cotemig.br.sistemaVeiculos.enums.TipoModeloEnum;

@Entity
public class Modelo {

	private Integer id;
	private String nome;
	private TipoModeloEnum tipo;
	private Marca marca;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Enumerated(EnumType.STRING)
	public TipoModeloEnum getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoModeloEnum tipo) {
		this.tipo = tipo;
	}

	@ManyToOne
    @JoinColumn(name="id_marca")
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
}
