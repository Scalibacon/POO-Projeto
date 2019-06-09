package dao;

import javax.swing.JOptionPane;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
	
	public static void mensagemConflitoPrimaryKey(String strPrimaryKey) {
		JOptionPane.showMessageDialog(null, "N�o foi poss�vel fazer a inser��o. Talvez o " + strPrimaryKey +
										" j� esteja cadastrado!", "Erro ao inserir", JOptionPane.ERROR_MESSAGE);
	}

}
