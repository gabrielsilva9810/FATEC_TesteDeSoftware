package com.fatec.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.ProdutoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class Req01CadastrarProduto {
	@Autowired
	ProdutoRepository repository;

	@Test
	void ct01_cadastrar_produto_com_sucesso() {
		// dado que não existem registros cadastrados
		repository.deleteAll(); // inicia sempre vazia

		// quando o usuário cadastra um produto
		Produto produto = new Produto();

		produto.setDescricao("Eletrobomba 110v");
		produto.setCategoria("Maquina de Lavar");
		produto.setCusto(51.66);
		produto.setQuantidadeNoEstoque(10);

		Produto p = repository.save(produto);

		// entao o produto fica disponivel para consulta
		assertEquals(1, repository.count());
		assertNotNull(p);
	}

	@Test
	void ct_02_cadastrar_produto_com_descricao_invalida() {
		// dado que o usuário deseja cadastrar um produto
		Produto produto = new Produto();

		try {
			// quando a descrição é invalida
			produto.setDescricao("");

			// então retorna mensagem de erro
		} catch (IllegalArgumentException e) {
			assertEquals("A descrição não deve estar em branco", e.getMessage());
		}
	}

	@Test
	void ct_03_cadastrar_produto_com_descricao_invalida_null() {
		// dado que o usuário deseja cadastrar um produto
		Produto produto = new Produto();

		try {
			// quando a descrição é invalida
			produto.setDescricao(null);

			// então retorna mensagem de erro
		} catch (IllegalArgumentException e) {
			assertEquals("A descrição não deve estar em branco", e.getMessage());
		}
	}
}
