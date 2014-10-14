package Views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import utils.Utils;

public class ImovelConsultaView extends ConsultaMaster {

	public ImovelConsultaView() {

	}

	@Override
	public void sair() {
		super.dispose();
	}
	
	@Override
	public void montaConteudo() {
		JTable tabela = null; 
		JScrollPane barraRolagem = null; 
		Object [][] dados = { 
				{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com", "teste"}, 
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"}, 
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com", "teste"},				
				{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com", "teste"} };
		
		String [] colunas = {"Nome", "Telefone", "Email", "testes"};
		tabela = new JTable(dados, colunas);
		Dimension i = pnlConteudo.getMaximumSize();
		
		tabela.setPreferredSize(i);
		
		pnlConteudo.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "asdasd"));	
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setPreferredSize(i);
		Utils.addGridBag(pnlConteudo, barraRolagem, 0, 0, new Insets(0, 0, 0, 0), 1, 1, GridBagConstraints.WEST);
	}

	@Override
	public void incluir() {
		// TODO Auto-generated method stub
		ImovelCadastroView cadastro = new ImovelCadastroView();
		cadastro.setVisible(true);
	}

	@Override
	public void editar() {
		// TODO Auto-generated method stub
		
	}
}
