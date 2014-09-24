package Views;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import principal.Utils;

public class UsuarioView extends JPanel {

	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screen = toolkit.getScreenSize();

	private JLabel lblNome, lblUsuario, lblNumero, lblEmail, lblCodigo;
	private JTextField txtNome, txtUsuario, txtNumero, txtEmail, txtCodigo;
	private JButton btnGravar, btnLimpar;
	private JPanel pnlUsuario, pnlBotoes;
	private GridBagConstraints restricoes = new GridBagConstraints();
	
	public void InstanciaObjetos() {
		pnlUsuario = new JPanel();
		pnlBotoes = new JPanel();
		lblCodigo = new JLabel("Código");
		txtCodigo = new JTextField();
		btnGravar = new JButton("Gravar");
		btnLimpar = new JButton("Limpar");
		lblEmail = new JLabel("Email");
		lblNome = new JLabel("Nome");
		lblNumero = new JLabel("Número");
		lblUsuario = new JLabel("Usuário");
		
		txtEmail = new JTextField();
		txtNome = new JTextField();
		txtNumero = new JTextField();
		txtUsuario = new JTextField();
	}
	
	protected void adicionaNoPanel(JPanel pnl, Component obj, int x, int y) {
		restricoes.gridx = x;
		restricoes.gridy = y;

		pnl.add(obj, restricoes);
	}
	
	public UsuarioView()
	{
		InstanciaObjetos();
		restricoes.insets = new Insets(5,5,5,5);
		pnlUsuario.setLayout(new GridBagLayout());
		pnlBotoes.setLayout(new GridBagLayout());
		pnlUsuario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtNome.setColumns(20);
		txtEmail.setColumns(20);
		txtUsuario.setColumns(20);
		txtNumero.setColumns(20);
		txtCodigo.setColumns(10);
		
		pnlUsuario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cadastro de usuários"));
		
		restricoes.weightx = 0;
		restricoes.weighty = 1.0;
		restricoes.anchor = GridBagConstraints.WEST;
		txtCodigo.setEditable(false);
		adicionaNoPanel(pnlUsuario, lblCodigo, 0, 1);
		Utils.addGridBag(pnlUsuario, txtCodigo, 2, 1, new Insets(5,5,5,5), 1, 1, GridBagConstraints.WEST);
		adicionaNoPanel(pnlUsuario, lblNome, 0, 2);
		adicionaNoPanel(pnlUsuario, txtNome, 2, 2);
		adicionaNoPanel(pnlUsuario, lblEmail, 3, 2);
		adicionaNoPanel(pnlUsuario, txtEmail, 4, 2);
		adicionaNoPanel(pnlUsuario, lblUsuario, 0, 3);
		adicionaNoPanel(pnlUsuario, txtUsuario, 2, 3);
		adicionaNoPanel(pnlUsuario, lblNumero, 3, 3);
		adicionaNoPanel(pnlUsuario, txtNumero, 4, 3);
		
		adicionaNoPanel(pnlBotoes, btnGravar, 0, 0);
		adicionaNoPanel(pnlBotoes, btnLimpar, 1, 0);
		restricoes.weightx = 2;
		adicionaNoPanel(pnlUsuario, pnlBotoes, 4, 4);
		
		btnGravar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Limpar();				
			}
		});
		
		this.add(pnlUsuario);
	}
	
	
	protected void Limpar()
	{
		txtEmail.setText("");
		txtNome.setText("");
		txtNumero.setText("");
		txtUsuario.setText("");
	}
}
