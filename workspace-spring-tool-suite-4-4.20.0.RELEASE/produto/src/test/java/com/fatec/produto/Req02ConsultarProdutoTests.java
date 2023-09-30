package com.fatec.produto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.ProdutoRepository;

@SpringBootTest
class Req02ConsultarProdutoTests {
	@Autowired
	ProdutoRepository repository;

	@Test
	void ct_01_consultar_produto_com_sucesso() {
		// dado que produto está cadastrado
		Produto produto = new Produto();

		produto.setDescricao("Eletrobomba 110v");
		produto.setCategoria("Maquina de Lavar");
		produto.setCusto(51.66);
		produto.setQuantidadeNoEstoque(10);
		
		repository.save(produto);
		
		// quando consulto o produto pelo id
		Produto p = repository.findById(1L).get();
		
		// entao os detalhes dos produtos são apresentados
		assertNotNull(p);
	}

}
