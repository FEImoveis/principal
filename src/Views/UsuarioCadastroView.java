package Views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import businessObejct.UsuarioBO;
import businessObejct.UsuarioBO.UsuarioException;
import utils.Utils;

public class UsuarioCadastroView extends CadastroMaster {

	private JLabel lblNome, lblUsuario, lblNumero, lblEmail, lblCodigo;
	private JTextField txtNome, txtUsuario, txtNumero, txtEmail, txtCodigo;
	private MaskFormatter mskEmail, mskNumero;
	private JPanel pnlUsuario;
	

	public void InstanciaObjetos() {
		lblCodigo = new JLabel("Código");
		txtCodigo = new JTextField();
		lblEmail = new JLabel("Email");
		lblNome = new JLabel("Nome");
		lblNumero = new JLabel("Número");
		lblUsuario = new JLabel("Usuário");

		txtEmail = new JTextField();
		txtNome = new JTextField();		
		txtUsuario = new JTextField();
		
		try {
	    	 mskNumero = new MaskFormatter("(##)####-####"); 
	    	 mskNumero.setPlaceholderCharacter('_');
	    }catch (Exception e){ 
	    	// msg de erro
	    }
		txtNumero = new JFormattedTextField(mskNumero);
		
	}

	public UsuarioCadastroView() {
//		InstanciaObjetos();
	}

	protected void Limpar() {
		txtEmail.setText("");
		txtNome.setText("");
		txtNumero.setText("");
		txtUsuario.setText("");
	}

	@Override
	public void cancelar() {
		super.dispose();
	}

	@Override
	public void gravar() {
		UsuarioBO usuario = new UsuarioBO();
	
		usuarioConsulta.modelo.addRow(new Object[]{txtCodigo.getText(), txtNome.getText(), txtUsuario.getText()});
		try {
			usuario.setNome(txtNome.getText());
			usuario.setCodigo(Integer.parseInt(txtCodigo.getText()));
			usuario.setEmail(txtEmail.getText());
			usuario.setNumero(txtNumero.getText());
			usuario.setUsuario(txtUsuario.getText());
			
			usuarioConsulta.modelo.addRow(new Object[]{ usuario.getCodigo(), usuario.getNome(), usuario.getUsuario()});
			usuario.Gravar();
		} catch(UsuarioException e)
		{
			JOptionPane.showMessageDialog(null, "Ocoorreu um erro "+ e.message);
		}
		catch (Exception e) {
			// TODO: handle exception
		}	
		
		limpaCampos();
	}

	private void limpaCampos() {
		txtNome.setText("");
		txtNumero.setText("");
		txtEmail.setText("");
		txtUsuario.setText("");
	}

	@Override
	public void montaConteudo() {
		InstanciaObjetos();
		
		montaPnlConteudo();			
	}
	
	@Override
	public void setaTituloCadastro() {
		lblTitulo.setText("Cadastro de usuário");
	}

	private void montaPnlConteudo() {
		txtNome.setColumns(20);
		txtNome.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				   if (e.isPopupTrigger()){
					  popUpBtnDireitoMouse();
				      btnDireitoMouse.show(e.getComponent(), e.getX(), e.getY());
				   }
				}
		});
		txtNome.addActionListener(this);
		txtNome.addFocusListener(this);
		
		txtEmail.setColumns(20);
		txtEmail.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				   if (e.isPopupTrigger()){
					  popUpBtnDireitoMouse();
				      btnDireitoMouse.show(e.getComponent(), e.getX(), e.getY());
				   }
				}
		});
		
		txtUsuario.setColumns(20);
		txtUsuario.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				   if (e.isPopupTrigger()){
					  popUpBtnDireitoMouse();
				      btnDireitoMouse.show(e.getComponent(), e.getX(), e.getY());
				   }
				}
		});
		txtUsuario.addActionListener(this);
		txtUsuario.addFocusListener(this);
				
		txtNumero.setColumns(20);
		txtNumero.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				   if (e.isPopupTrigger()){
					  popUpBtnDireitoMouse();
				      btnDireitoMouse.show(e.getComponent(), e.getX(), e.getY());
				   }
				}
		});
		txtNumero.addActionListener(this);
		txtNumero.addFocusListener(this);
		txtCodigo.setColumns(10);
		txtCodigo.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				   if (e.isPopupTrigger()){
					  popUpBtnDireitoMouse();
				      btnDireitoMouse.show(e.getComponent(), e.getX(), e.getY());
				   }
				}
		});
		txtCodigo.addFocusListener(this);
		txtCodigo.addActionListener(this);
		
		pnlConteudo.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Cadastro de usuários"));

		txtCodigo.setEditable(false);
		
		Utils.addGridBag(pnlConteudo, lblCodigo, 0, 1);
		Utils.addGridBag(pnlConteudo, txtCodigo, 2, 1, new Insets(5, 5, 5, 5),
				1, 1, GridBagConstraints.WEST);
		Utils.addGridBag(pnlConteudo, lblNome, 0, 2);
		Utils.addGridBag(pnlConteudo, txtNome, 2, 2);
		Utils.addGridBag(pnlConteudo, lblEmail, 3, 2);
		Utils.addGridBag(pnlConteudo, txtEmail, 4, 2);
		Utils.addGridBag(pnlConteudo, lblUsuario, 0, 3);
		Utils.addGridBag(pnlConteudo, txtUsuario, 2, 3);
		Utils.addGridBag(pnlConteudo, lblNumero, 3, 3);
		Utils.addGridBag(pnlConteudo, txtNumero, 4, 3);
	}

}
