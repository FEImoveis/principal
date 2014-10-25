package Views;

import javax.swing.JLabel;

import utils.Utils;

public class VisitaConsultaView extends ConsultaMaster {

	
	@Override
	public void sair() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	@Override
	public void montaConteudo() {
		// TODO Auto-generated method stub
		pnlConteudo.add(new JLabel("VISITA"));
	}

	@Override
	public void incluir() {
		// TODO Auto-generated method stub
		VisitaCadastroView cadastro = new VisitaCadastroView();
		cadastro.setVisible(true);
		getDesktopPane().add(cadastro);
		cadastro.setSize(1000, 600);
		cadastro.setLocation(10, 10);
		cadastro.setResizable(true);
		Utils.clearFramesLayer();
		cadastro.setLayer(1);
	}

	@Override
	public void editar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

}
