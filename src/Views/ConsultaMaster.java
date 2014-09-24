package Views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import principal.Utils;

public abstract class ConsultaMaster extends JFrame {

	private JPanel pnlCabecalho, pnlRodape, pnlPrincipal;
	public JPanel pnlConteudo;
	private JLabel lblFiltro;
	private JTextField txtFiltro;
	private JButton btnBuscar, btnIncluir, btnEditar, btnExcluir, btnSair;
	private JComboBox<String> cboFiltro;

	public abstract void sair();
	public abstract void montaConteudo();
	public abstract void incluir();
	public abstract void editar();
	
	private void InstanciaObjeto() {
		pnlCabecalho = new JPanel(new GridBagLayout());
		pnlConteudo = new JPanel(new GridBagLayout());
		pnlRodape = new JPanel(new GridBagLayout());
		txtFiltro = new JTextField();
		String[] itensCombo = { "Código", "Nome/Descrição", ""};
		pnlPrincipal = new JPanel(new BorderLayout());

		btnBuscar = new JButton("Buscar");
		btnEditar = new JButton("Editar");
		btnExcluir = new JButton("Excluir");
		btnIncluir = new JButton("Incluir");
		btnSair = new JButton("Sair");
		cboFiltro = new JComboBox<String>(itensCombo);
		lblFiltro = new JLabel("Filtro");
	}

	public ConsultaMaster() {
		InstanciaObjeto();

		Utils.setLocation(this);
		montaPnlPrincipal();
		montaPnlCabecalho();
		montaPnlRodape();
		montaPnlConteudo();

		this.add(pnlPrincipal);
	}

	private void montaPnlConteudo() {
		montaConteudo();
	}

	
	private void montaPnlRodape() {
		pnlRodape.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder()));
		
		Utils.addGridBag(pnlRodape, btnIncluir, 0, 0);
		Utils.addGridBag(pnlRodape, btnEditar, 1, 0);
		Utils.addGridBag(pnlRodape, btnExcluir, 2, 0);
		Utils.addGridBag(pnlRodape, btnSair, 3, 0);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		
		btnIncluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				incluir();
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		
	}

	private void montaPnlPrincipal() {
		pnlPrincipal.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder()));
		
		pnlPrincipal.add(pnlCabecalho, BorderLayout.NORTH);
		pnlPrincipal.add(pnlConteudo, BorderLayout.CENTER);
		pnlPrincipal.add(pnlRodape, BorderLayout.SOUTH);
	}
	
	private void montaPnlCabecalho() {
		// TODO Auto-generated method stub
		
		txtFiltro.setColumns(40);
		pnlCabecalho.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Pesquisa"));
		Utils.addGridBag(pnlCabecalho, lblFiltro, 0, 0, new Insets(5, 5, 5, 5), 1, 1, GridBagConstraints.WEST);
		Utils.addGridBag(pnlCabecalho, cboFiltro, 1, 0);
		Utils.addGridBag(pnlCabecalho, txtFiltro, 2, 0);
		Utils.addGridBag(pnlCabecalho, btnBuscar, 4, 0);
	}
}
