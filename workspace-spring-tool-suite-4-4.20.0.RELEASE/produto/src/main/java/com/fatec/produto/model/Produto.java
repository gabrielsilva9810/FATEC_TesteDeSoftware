package com.fatec.produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // gera o ID automaticamente
	private Long id;
	private String descricao;
	private String categoria;
	private double custo;
	private int quantidadeNoEstoque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao == null) {
			throw new IllegalArgumentException("A descrição não deve estar em branco");
		} else {
			if (descricao.isBlank()) {
				throw new IllegalArgumentException("A descrição não deve estar em branco");
			} else {
				this.descricao = descricao;
			}
		}
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String string) {
		this.categoria = string;
	}

	public double getCusto() {

		return custo;
	}

	public void setCusto(double custo) {
		try {
			if(custo <=0) {
				throw new IllegalArgumentException ("A custo não deve ser igual ou menor que 0");
			} else {
				this.custo = custo;
			}
		} catch (Exception e) {
			throw new IllegalArgumentException ("A custo não deve ser igual ou menor que 0");
		}
	}

	public int getQuantidadeNoEstoque() {
		return quantidadeNoEstoque;
	}

	public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
		this.quantidadeNoEstoque = quantidadeNoEstoque;
	}

}
