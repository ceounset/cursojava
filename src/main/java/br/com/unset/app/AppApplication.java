package br.com.unset.app;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.unset.app.domain.Categoria;
import br.com.unset.app.domain.Cidade;
import br.com.unset.app.domain.Estado;
import br.com.unset.app.domain.Produto;
import br.com.unset.app.repositories.CategoriaRepository;
import br.com.unset.app.repositories.CidadeRepository;
import br.com.unset.app.repositories.EstadoRepository;
import br.com.unset.app.repositories.ProdutoRepository;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Teste");

		Produto p1 = new Produto(null, "Computador", 500.00);
		Produto p2 = new Produto(null, "Impressora", 300.50);
		Produto p3 = new Produto(null, "Mouse", 50.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		Estado e1 = new Estado(null, "Mato Grosso");
		Estado e2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Nova Xavantina", e1);
		Cidade c2 = new Cidade(null, "Campinas", e2);
		Cidade c3 = new Cidade(null, "Água Boa", e1);

		e1.getCidades().addAll(Arrays.asList(c1, c3));
		e2.getCidades().addAll(Arrays.asList(c2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

	}

}
