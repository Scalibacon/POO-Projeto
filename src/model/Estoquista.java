package model;

import java.util.ArrayList;
import java.util.List;

import dao.DAOException;
import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;

public class Estoquista {

	private Privilegio privilegio;
	private String cpf;
	private String nome;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String senha;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Privilegio getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}

	public void adicionarProduto(Produto p) {
		ProdutoDAO proDAO = new ProdutoDAOImpl();
		try {
			proDAO.inserirProduto(p);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public void excluirProduto(String cod_barras) {
		ProdutoDAO proDAO = new ProdutoDAOImpl();
		try {
			proDAO.excluirProduto(cod_barras);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public void alterarProduto(Produto p, String cod_barras) {
		ProdutoDAO proDAO = new ProdutoDAOImpl();
		try {
			proDAO.alterarProduto(p, cod_barras);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public List<Produto> visualizarEstoque() {
		List<Produto> produtos = new ArrayList<Produto>();
		ProdutoDAO proDAO = new ProdutoDAOImpl();

		try {
			produtos = proDAO.buscarTodosProdutos();
			return produtos;
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
