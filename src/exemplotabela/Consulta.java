package exemplotabela;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.util.*;
   // para poder utilizar a classe de negocio Clientes

public class Consulta extends JInternalFrame implements ActionListener
{
  private JButton btnExcluir;
  private JButton btnIncluir;
  private JButton btnSair;
  private JButton btnAlterar;
  JTable tabela;
  ModeloTabela modelo;
  Clientes cli;   // declaracao de um objeto da classe de negocio Clientes

  public Consulta()
  {
  	super("Consulta",false,true,false,true);
    setSize(500,250);
    setLocation(100,50);
    Container P = getContentPane();
    P.setLayout(new BorderLayout());
    // cria��o de um arranjo sem tamanho definido para inser��o 
    // din�mica de objetos
    ArrayList dados = new ArrayList();
    // cria��o de um arranjo para os t�tulos no cabe�alho
    String[] colunas = new String[] { "ID", "Nome", "Sobrenome" }; 
    // cria��o de um arranjo para identificar se a c�lula � edit�vel ou n�o
    boolean[] edicao = {true, true, true};
    // Inser��o da primeira linha da tabela
   
    // cria��o da tabela baseada no modelo ModeloTabela
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
    JScrollPane rolagemTabela = new JScrollPane(tabela);
    P.add(rolagemTabela,"Center");
    // cria��o do Painel de baixo
    JPanel PTabSul = new JPanel();
    btnIncluir = new JButton("Incluir");
    PTabSul.add(btnIncluir);
    btnAlterar = new JButton("Alterar");
    PTabSul.add(btnAlterar);
    btnExcluir = new JButton("Excluir");
    PTabSul.add(btnExcluir);
    btnSair = new JButton("Sair");
    PTabSul.add(btnSair);
   
     
    P.add(PTabSul, "South");
    btnExcluir.addActionListener(this);
    btnIncluir.addActionListener(this);
    btnSair.addActionListener(this);
    btnAlterar.addActionListener(this);
  
  }

  public void actionPerformed(ActionEvent evt)
  {
    Object origem = evt.getSource();
    if (origem == btnIncluir)
    {
    	cli = new Clientes();  // cria�ao do objeto cli
    	Cadastro fr = new Cadastro("Incluir",this);
    	fr.setVisible(true);  
    	getDesktopPane().add(fr);
    	try {
          fr.setSelected(true);
    	}catch (PropertyVetoException exc) { }
    }
    else if (origem == btnAlterar)
    {
      if (tabela.getSelectedRow()>=0) {
      	cli = new Clientes();   // cria�ao do objeto cli
      	cli.setCodigo(Integer.parseInt(modelo.getValueAt(tabela.getSelectedRow(),0).toString()));
      	cli.setNome(modelo.getValueAt(tabela.getSelectedRow(),1).toString());
      	cli.setSobrenome(modelo.getValueAt(tabela.getSelectedRow(),2).toString());
      	Cadastro fr = new Cadastro("Alterar",this);
      	fr.setVisible(true);  
      	getDesktopPane().add(fr);
        try {
            fr.setSelected(true);
        }catch (PropertyVetoException exc) { }
      }
    }
    else if (origem == btnExcluir)
    {
      if (tabela.getSelectedRow()>=0){
        Object[] opcoes = { "Sim", "N�o" };
        if (JOptionPane.showOptionDialog(null,"Deseja excluir o registro?",
  	  	    "Confirma��o",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, opcoes, opcoes[0]) == 0)
        			modelo.removeRow(tabela.getSelectedRow());
      }


    }
    else if (origem == btnSair)
      dispose();
  }
  
  public void incluiClienteTabela(){
	  modelo.addRow(new Object[]{String.valueOf(cli.getCodigo()), cli.getNome(), cli.getSobrenome()});
  }
  
  public void alteraClienteTabela(){
	  int linha = tabela.getSelectedRow();
	  modelo.setValueAt(cli.getNome(),linha,1);
	  modelo.setValueAt(cli.getSobrenome(),linha,2);
  }
}

