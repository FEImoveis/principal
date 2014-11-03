package exemplotabela;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Cadastro extends JInternalFrame implements ActionListener
{
  private JButton btnOK;
  private JButton btnCancelar;
  private JTextField txtCodigo;
  private JTextField txtNome;
  private JTextField txtSobrenome;
  Consulta cons;
  String tipo;

  public Cadastro(String t,Consulta c)
  {
  	super("Cadastro",false,true,false,true);
  	tipo = t;
  	cons = c;
 
    setSize(270,150);
    setLocation(200,100);
    Container P = getContentPane();
    P.setLayout(new BorderLayout());
       
    JPanel PCentro = new JPanel();
    PCentro.add(new JLabel("Código:"));
    txtCodigo = new JTextField(String.valueOf(cons.cli.getCodigo()),15);
    if (tipo.equals("Incluir"))
  		txtCodigo.setEditable(true);
  	else
  		txtCodigo.setEditable(false);
    PCentro.add(txtCodigo);
    PCentro.add(new JLabel("Nome:"));
    txtNome = new JTextField(cons.cli.getNome(),15);
    PCentro.add(txtNome);
    PCentro.add(new JLabel("Sobrenome:"));
    txtSobrenome = new JTextField(cons.cli.getSobrenome(),15);
    PCentro.add(txtSobrenome);
       
    P.add(PCentro,"Center");
    // criação do Painel de baixo
    JPanel PSul = new JPanel();
    btnOK = new JButton(tipo);
    PSul.add(btnOK);
    btnCancelar = new JButton("Cancelar");
    PSul.add(btnCancelar);
        
    P.add(PSul, "South");
  
    btnOK.addActionListener(this);
    btnCancelar.addActionListener(this);
     
  }

  public void actionPerformed(ActionEvent evt)
  {
    Object origem = evt.getSource();
    if (origem == btnOK)
    {
    	if (tipo.equals("Incluir")){
    		alteraObjetoCliente();
    		if (cons != null)   // faz apenas se o cadastro foi chamado pela consulta
    		  cons.incluiClienteTabela();
        		
    	}else{
    		alteraObjetoCliente();
    		if (cons != null)   // faz apenas se o cadastro foi chamado pela consulta
    		   cons.alteraClienteTabela();
    	}
   
      dispose();
    }
   
    if (origem == btnCancelar)
      dispose();
    
  }
  
  public void alteraObjetoCliente(){
	 	cons.cli.setCodigo(Integer.parseInt(txtCodigo.getText()));
		cons.cli.setNome(txtNome.getText());
		cons.cli.setSobrenome(txtSobrenome.getText());
  }

}



