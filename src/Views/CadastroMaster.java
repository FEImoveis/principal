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

import principal.Utils;

public abstract class CadastroMaster extends JFrame {

	private JPanel pnlPrincipal, pnlRodape, pnlCabecalho;
	public JPanel pnlConteudo;
	public JLabel lblTitulo;
	private JButton btnGravar, btnCancelar;

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

		Utils.setLocation(this);
		montaPnlCabecalho();
		montaPnlConteudo();
		montaPnlRodape();
		montaPnlPrincipal();

		this.add(pnlPrincipal);
	}

	private void montaPnlPrincipal() {
		// TODO Auto-generated method stub
		pnlPrincipal.add(pnlCabecalho, BorderLayout.NORTH);
		pnlPrincipal.add(pnlConteudo, BorderLayout.CENTER);
		pnlPrincipal.add(pnlRodape, BorderLayout.SOUTH);
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
