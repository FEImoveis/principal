package Views;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import utils.Utils;
import utils.ZoomMaster;

public class CidadeCadastroView extends CadastroMaster{

	private JLabel lblCodigo;
	private JLabel lblCidade;
	private JLabel lblEstado;
	
	private ZoomMaster zoomCidadeLista;	
	private JTextField txtCidade;
	private JTextField txtEstado;	
	
	private void InstanciaObjetos() {		
		
		lblCidade = new JLabel("Cidade");
		lblEstado = new JLabel("Estado");		
		
		txtCidade = new JTextField(50);
		txtEstado = new JTextField(50);
	}	
	
	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		CidadeListaConsultaView cidadeLista = new CidadeListaConsultaView();
		cidadeLista.setVisible(true);		
		
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void montaConteudo() {
		
		Insets margin = new Insets(5, 5, 5, 5);
		
		InstanciaObjetos();		
		txtCidade.setEditable(false);
		txtCidade.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				   if (e.isPopupTrigger()){
					  popUpBtnDireitoMouse();
				      btnDireitoMouse.show(e.getComponent(), e.getX(), e.getY());
				   }
				}
		});		
				
		txtEstado.setEditable(false);		
		txtEstado.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				   if (e.isPopupTrigger()){
					  popUpBtnDireitoMouse();
				      btnDireitoMouse.show(e.getComponent(), e.getX(), e.getY());
				   }
				}
		});
		
		Utils.addGridBag(pnlConteudo, lblCidade, 0, 1, new Insets(5, 0, 5, 0), 1, 1, GridBagConstraints.WEST);
		zoomCidadeLista = new ZoomMaster(new ImovelConsultaView(), 40, false);
		Utils.addGridBag(pnlConteudo, zoomCidadeLista , 1, 1, new Insets(5, 0, 5, 0), 5, 1, GridBagConstraints.WEST);
		
		Utils.addGridBag(pnlConteudo, lblEstado, 0, 2, margin, 1, 1, GridBagConstraints.WEST);
		Utils.addGridBag(pnlConteudo, txtEstado, 1, 2, margin, 5, 1, GridBagConstraints.WEST);
		
	}

	@Override
	public void setaTituloCadastro() {
		// TODO Auto-generated method stub
		lblTitulo.setText("Cadastro Cidade");
	}
	
	

}
