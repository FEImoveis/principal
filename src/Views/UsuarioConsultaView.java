package Views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import exemplotabela.ModeloTabela;
import utils.Utils;

public class UsuarioConsultaView extends ConsultaMaster {

	JTable tabela;
	public static ModeloTabela modelo;

	@Override
	public void montaConteudo() {
		// setSize(500,250);
		// setLocation(100,50);
		//
		// criação de um arranjo sem tamanho definido para inserção
		// dinâmica de objetos
		ArrayList dados = new ArrayList();
		// criação de um arranjo para os títulos no cabeçalho
		String[] colunas = new String[] { "ID", "Nome", "Usuário" };
		// criação de um arranjo para identificar se a célula é editável ou não
		boolean[] edicao = { true, true, true };
		// Inserção da primeira linha da tabela

		// criação da tabela baseada no modelo ModeloTabela
		modelo = new ModeloTabela(dados, colunas, edicao);
		tabela = new JTable(modelo);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(1).setResizable(true);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(2).setResizable(true);
		tabela.getTableHeader().setReorderingAllowed(false);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setPreferredSize(new Dimension(800, 350));
		JScrollPane rolagemTabela = new JScrollPane(tabela);
		rolagemTabela.setPreferredSize(new Dimension(800, 350));
		Utils.addGridBag(pnlConteudo, rolagemTabela, 0, 0, new Insets(0, 0, 0,
				0), 1, 1, GridBagConstraints.WEST);

	}

	@Override
	public void incluir() {
		//TO DO FAZER ADICIONAR PELO CADASTRO
		
		UsuarioCadastroView cadastro = new UsuarioCadastroView();
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
		UsuarioCadastroView cadastro = new UsuarioCadastroView();
		cadastro.setVisible(true);
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub

	}

}
