package Views;

import javax.swing.JLabel;

import principal.Utils;

public class UsuarioConsultaView extends ConsultaMaster{

	@Override
	public void sair() {
		super.dispose();
	}

	@Override
	public void montaConteudo() {
		Utils.addGridBag(pnlConteudo, new JLabel("NOI"), 0, 0);
	}

	@Override
	public void incluir() {
		UsuarioCadastroView cadastro = new UsuarioCadastroView();
		cadastro.setVisible(true);
	}


	@Override
	public void editar() {
		UsuarioCadastroView cadastro = new UsuarioCadastroView();
		cadastro.setVisible(true);
	}

}
