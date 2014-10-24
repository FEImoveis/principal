package Views;

import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import utils.Utils;
import utils.ZoomMaster;

public class VisitaCadastroView extends CadastroMaster {
	private JLabel lblCorretor, lblData, lblObservacao, lblImovel;
	private JTextField txtCorretor, txtData, txtImovel;
	private JTextArea txtObservacao;
	private ZoomMaster zoomCorretor;
	private ZoomMaster zoomImovel;
	
	private void InstanciaObjetos() {
		lblCorretor = new JLabel("Corretor");
		lblData = new JLabel("Data");
		lblObservacao = new JLabel("Observação");
		lblImovel = new JLabel("Imóvel");
		txtCorretor = new JTextField();
		txtData = new JTextField();
		txtImovel = new JTextField();
		txtObservacao = new JTextArea(8, 40);
		zoomCorretor = new ZoomMaster(new UsuarioConsultaView(), 30, true);
		zoomImovel = new ZoomMaster(new ImovelConsultaView(), 30, true);
	}

	public VisitaCadastroView() {

	}

	@Override
	public void gravar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelar() {
		super.dispose();
	}

	@Override
	public void montaConteudo() {
		InstanciaObjetos();

		txtImovel.setColumns(40);
		txtCorretor.setColumns(40);
		txtData.setColumns(15);
		txtObservacao.setSize(300, 200);

		Utils.addGridBag(pnlConteudo, lblImovel, 0, 0);
//		Utils.addGridBag(pnlConteudo, txtImovel, 1, 0);
		Utils.addGridBag(pnlConteudo, zoomImovel, 1, 0, new Insets(5, 5, 5, 5), 3, 1);
		Utils.addGridBag(pnlConteudo, lblCorretor, 0, 1);
//		Utils.addGridBag(pnlConteudo, txtCorretor, 1, 1);
		Utils.addGridBag(pnlConteudo, zoomCorretor, 1, 1, new Insets(5, 5, 5, 5), 3, 1);
		Utils.addGridBag(pnlConteudo, lblData, 0, 2);
		Utils.addGridBag(pnlConteudo, txtData, 1, 2);
		Utils.addGridBag(pnlConteudo, lblObservacao, 0, 3);
		Utils.addGridBag(pnlConteudo, txtObservacao, 1, 3);

	}

	@Override
	public void setaTituloCadastro() {
		// TODO Auto-generated method stub
		lblTitulo.setText("Cadastro visita");
	}

}
