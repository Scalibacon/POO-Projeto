package controller;

import javax.swing.JDialog;

public class MenuController {
	
	public void abrirModal(JDialog tela) {
		tela.setModal(true);
		tela.setVisible(true);
	}
	
	public boolean verificaPrivilegio(int requisito) {
		if(Help.logado.getPrivilegio() >= requisito)
			return true;
		else
			return false;
	}
}
