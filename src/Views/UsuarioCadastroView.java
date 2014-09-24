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
import javax.swing.JPanel;
import javax.swing.JTextField;

import principal.Utils;

public class UsuarioCadastroView extends CadastroMaster {

	private JLabel lblNome, lblUsuario, lblNumero, lblEmail, lblCodigo;
	private JTextField txtNome, txtUsuario, txtNumero, txtEmail, txtCodigo;
	private JPanel pnlUsuario, pnlBotoes;
	private GridBagConstraints restricoes = new GridBagConstraints();

	public void InstanciaObjetos() {
		pnlUsuario = new JPanel(new GridBagLayout());
		pnlBotoes = new JPanel(new GridBagLayout());
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

	}

	@Override
	public void montaConteudo() {
		InstanciaObjetos();
		
		montaPnlConteudo();		
		
		Utils.addGridBag(pnlConteudo, pnlUsuario, 0, 0);
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

		pnlUsuario.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Cadastro de usuários"));

		txtCodigo.setEditable(false);
		
		Utils.addGridBag(pnlUsuario, lblCodigo, 0, 1);
		Utils.addGridBag(pnlUsuario, txtCodigo, 2, 1, new Insets(5, 5, 5, 5),
				1, 1, GridBagConstraints.WEST);
		Utils.addGridBag(pnlUsuario, lblNome, 0, 2);
		Utils.addGridBag(pnlUsuario, txtNome, 2, 2);
		Utils.addGridBag(pnlUsuario, lblEmail, 3, 2);
		Utils.addGridBag(pnlUsuario, txtEmail, 4, 2);
		Utils.addGridBag(pnlUsuario, lblUsuario, 0, 3);
		Utils.addGridBag(pnlUsuario, txtUsuario, 2, 3);
		Utils.addGridBag(pnlUsuario, lblNumero, 3, 3);
		Utils.addGridBag(pnlUsuario, txtNumero, 4, 3);
	}

}
