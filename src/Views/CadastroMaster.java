package Views;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Utils;

public abstract class CadastroMaster extends JInternalFrame {

	private JPanel pnlPrincipal, pnlRodape, pnlCabecalho;
	protected JPanel pnlConteudo;
	public JLabel lblTitulo;
	private JButton btnGravar, btnCancelar;
	private MenuView m;

	public abstract void gravar();

	public abstract void cancelar();

	public abstract void montaConteudo();

	public abstract void setaTituloCadastro();

	private void InstanciaObjetos() {
		pnlPrincipal = new JPanel(new BorderLayout());
		pnlRodape = new JPanel(new GridBagLayout());
		pnlCabecalho = new JPanel(new GridBagLayout());
		pnlConteudo = new JPanel(new GridBagLayout());

		btnCancelar = new JButton("Cancelar");
		btnGravar = new JButton("Gravar");
		lblTitulo = new JLabel();
	}

	public CadastroMaster() {
		InstanciaObjetos();
		montaPnlCabecalho();
		montaPnlConteudo();
		montaPnlRodape();
		montaMenu();
		montaPnlPrincipal();
		

		this.add(pnlPrincipal);
	}

	private void montaMenu() {
		// TODO Auto-generated method stub		
		m = new MenuView();
		m.menuEditar();	
		//m.showWindow();
	}

	private void montaPnlPrincipal() {
		// TODO Auto-generated method stub
		pnlPrincipal.add(pnlCabecalho, BorderLayout.NORTH);
		pnlPrincipal.add(pnlConteudo, BorderLayout.CENTER);
		pnlPrincipal.add(pnlRodape, BorderLayout.SOUTH);
		//pnlPrincipal.add(m,BorderLayout.NORTH);
		setJMenuBar(m);
	}

	private void montaPnlRodape() {
		pnlRodape.setBorder(BorderFactory.createEtchedBorder());

		Utils.addGridBag(pnlRodape, btnGravar, 0, 0);
		Utils.addGridBag(pnlRodape, btnCancelar, 1, 0);
		
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		
		btnGravar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gravar();
			}
		});
	}

	private void montaPnlCabecalho() {

		pnlCabecalho.setBorder(BorderFactory.createEtchedBorder());
		setaTituloCadastro();
		Utils.addGridBag(pnlCabecalho, lblTitulo, 0, 0);
	}

	private void montaPnlConteudo() {
		montaConteudo();
	}

}
