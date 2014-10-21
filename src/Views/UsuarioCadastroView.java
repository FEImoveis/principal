package Views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessObejct.UsuarioBO;
import businessObejct.UsuarioBO.UsuarioException;
import utils.Utils;

public class UsuarioCadastroView extends CadastroMaster {

	private JLabel lblNome, lblUsuario, lblNumero, lblEmail, lblCodigo;
	private JTextField txtNome, txtUsuario, txtNumero, txtEmail, txtCodigo;
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
		txtNumero = new JTextField();
		txtUsuario = new JTextField();
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
		try {
			usuario.setTelfone(txtNumero.getText());
		} catch (UsuarioException e2) {
			JOptionPane.showMessageDialog(null, e2.message);
		}
		
		//usuarioDAO.salvar(usuario);
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
		txtEmail.setColumns(20);
		txtUsuario.setColumns(20);
		txtNumero.setColumns(20);
		txtCodigo.setColumns(10);

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
