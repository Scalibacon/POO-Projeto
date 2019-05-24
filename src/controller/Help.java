package controller;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class Help {

	public static Estoquista logado;
	public static List<Estoquista> lista_usuarios = new ArrayList<Estoquista>();
	public static List<Produto> lista_produtos = new ArrayList<Produto>();
	public static List<Venda> lista_vendas = new ArrayList<Venda>();
	public static List<AlteracaoEstoque> lista_alteracoes = new ArrayList<AlteracaoEstoque>();
	
	public static void preencheListas() {
		Estoquista e = new Estoquista();
		e.setNome("Tetheus");
		e.setCpf("1");
		e.setSenha("1");
		lista_usuarios.add(e);
		
		Produto p = new Produto();
		p.setCategoria(Categoria.BRINQUEDOS);
		p.setNome("Max Steel");
		p.setCod_barras("1234567");
		p.setPreco(25.99);
		p.setQuantidade_estoque(10);
		lista_produtos.add(p);
	}
}
