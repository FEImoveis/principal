package Views;

import javax.swing.JLabel;

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
		VisitaCadastroView visita = new VisitaCadastroView();
		visita.setVisible(true);
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
