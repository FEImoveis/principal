package Views;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		JScrollPane barraRolagem; 
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
				{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com", "teste"} };
		
		String [] colunas = {"Nome", "Telefone", "Email", "testes"};
		tabela = new JTable(dados, colunas);
		tabela.setPreferredSize(new Dimension(700,300));
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setPreferredSize(new Dimension(700,300));
		Utils.addGridBag(pnlConteudo, barraRolagem, 0, 0);
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
