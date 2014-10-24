package Views;

import javax.swing.JLabel;

import utils.Utils;

public class UsuarioConsultaView extends ConsultaMaster{



	@Override
	public void montaConteudo() {
		Utils.addGridBag(pnlConteudo, new JLabel("NOI"), 0, 0);
	}

	@Override
	public void incluir() {
		UsuarioCadastroView cadastro = new UsuarioCadastroView();
		cadastro.setVisible(true);
		getDesktopPane().add(cadastro);
		cadastro.setSize(1000, 600);
		cadastro.setLocation(10, 10);
		cadastro.setResizable(true);
	}


	@Override
	public void editar() {
		UsuarioCadastroView cadastro = new UsuarioCadastroView();
		cadastro.setVisible(true);
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

}
