package controller;

import dao.AlteracaoEstoqueDAO;
import dao.AlteracaoEstoqueDAOImpl;
import dao.DAOException;
import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import model.AlteracaoEstoque;
import model.TipoAlteracao;

public class AdicionarEstoqueController {
	public void adicionarAlteracao(AlteracaoEstoque ae) {
		AlteracaoEstoqueDAO altDAO = new AlteracaoEstoqueDAOImpl();
		ProdutoDAO proDAO = new ProdutoDAOImpl();
		try {
			altDAO.inserirAlteracao(ae);
			if(ae.getTipoAlt() == TipoAlteracao.ADICIONAR) {
				proDAO.adicionarAoEstoque(ae.getProduto().getCod_barras(), ae.getQuantidade());
			}else {
				proDAO.removerDoEstoque(ae.getProduto().getCod_barras(), ae.getQuantidade());
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
