package Views;

import javax.swing.JTable;

public class CidadeListaConsultaView extends ConsultaMaster{

	private JTable tblCidades;
	private Object [][] dados = { };
	private String [] colunas = {"Cod", "Cidade", "Estado"};
	
	
	
	@Override
	public void montaConteudo() {
		// TODO Auto-generated method stub
		tblCidades = new JTable(dados, colunas);	
	}

	@Override
	public void incluir() {
		// TODO Auto-generated method stub
		
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
