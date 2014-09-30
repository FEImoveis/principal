package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

import java.text.NumberFormat;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.sun.org.apache.xerces.internal.util.MessageFormatter;

import principal.JNumberFormatField;
import principal.Utils;

public class ImovelCadastroView extends CadastroMaster {

	private static final int IMAGEHEIGHT = 220;
	private static final int IMAGEWIDTH = 320;

	private JLabel lblCod;
	private JLabel lblRua;
	private JLabel lblComplemento;
	private JLabel lblDormitorio;
	private JLabel lblBairro;
	private JLabel lblValor;
	private JLabel lblCozinha;
	private JLabel lblCidade;
	private JLabel lblCorretor;
	private JLabel lblBanheiro;
	private JLabel lblSuite;
	private JLabel lblSacada;
	private JLabel lblArea;

	private JTextField txtCod;
	private JTextField txtRua;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCorretor;
	
	private JTextField txtArea;
	private MaskFormatter mskArea = null;
	
	private NumberFormat mskValor = NumberFormat.getCurrencyInstance();
	private JNumberFormatField txtValor;

	private JSpinner spiDormitorio;
	private JSpinner spiCozinha;
	private JSpinner spiBanheiro;
	private JSpinner spiSuite;
	private JSpinner spiSacada;

	private JCheckBox cbxArCondicionado;
	private JCheckBox cbxAluga;
	private JCheckBox cbxNovo;
	private JCheckBox cbxChurrasqueira;
	private JCheckBox cbxLareira;
	private JCheckBox cbxPiscina;
	private JCheckBox cbxAguaQuente;

	private JPanel pnlPrincipal;

	private JPanel pnlCima;
	private JPanel pnlCadastro;
	private JPanel pnlAtributos;
	private JPanel pnlOutrasInformacoes;

	private GridBagConstraints restricoes = new GridBagConstraints();

	public void InstanciaObjetos() {

		pnlPrincipal = new JPanel(new BorderLayout());

		pnlCima = new JPanel(new GridBagLayout());
		pnlCadastro = new JPanel(new GridBagLayout());
		pnlAtributos = new JPanel(new GridBagLayout());
		pnlOutrasInformacoes = new JPanel(new GridBagLayout());

	}

	private void montaPnlOutrasInformacoes() {

		Insets margin = new Insets(5, 5, 5, 5);

		pnlOutrasInformacoes.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Outras Informacoes"));

		// Novo
		cbxNovo = new JCheckBox("Novo");
		//cbxNovo
		Utils.addGridBag(pnlOutrasInformacoes, cbxNovo, 2, 5, margin, 1, 1,
				GridBagConstraints.WEST);

		// ArCondicionado
		cbxArCondicionado = new JCheckBox("Ar-Condicionado");
		Utils.addGridBag(pnlOutrasInformacoes, cbxArCondicionado, 1, 5, margin,
				1, 1, GridBagConstraints.WEST);

		// Aluga
		cbxAluga = new JCheckBox("Aluga");
		Utils.addGridBag(pnlOutrasInformacoes, cbxAluga, 1, 6, margin, 1, 1,
				GridBagConstraints.WEST);

		cbxChurrasqueira = new JCheckBox("Churrasqueira");
		Utils.addGridBag(pnlOutrasInformacoes, cbxChurrasqueira, 2, 6, margin,
				1, 1, GridBagConstraints.WEST);

		cbxLareira = new JCheckBox("Lareira");
		Utils.addGridBag(pnlOutrasInformacoes, cbxLareira, 1, 7, margin, 1, 1,
				GridBagConstraints.WEST);

		cbxAguaQuente = new JCheckBox("Agua Quente");
		Utils.addGridBag(pnlOutrasInformacoes, cbxAguaQuente, 2, 7, margin, 1,
				1, GridBagConstraints.WEST);

		Utils.addGridBag(pnlAtributos, pnlOutrasInformacoes, 1, 6, margin, 2, 3);

	}

	private void montaPnlAtributos() {

		Insets margin = new Insets(2, 3, 2, 3);
		pnlAtributos.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createEtchedBorder()));

		// Código
		lblCod = new JLabel("Código");
		lblCod.setToolTipText("Código do Imovel");
		Utils.addGridBag(pnlAtributos, lblCod, 0, 0, new Insets(0, 0, 0, 0), 1,
				1, GridBagConstraints.EAST);

		txtCod = new JTextField(6);
		txtCod.setEditable(false);
		Utils.addGridBag(pnlAtributos, txtCod, 1, 0, margin, 2, 1,
				GridBagConstraints.WEST);

		// Rua
		lblRua = new JLabel("Rua");
		lblRua.setToolTipText("Rua do imóvel");
		Utils.addGridBag(pnlAtributos, lblRua, 0, 1, margin, 1, 1,
				GridBagConstraints.EAST);

		txtRua = new JTextField(50);
		Utils.addGridBag(pnlAtributos, txtRua, 1, 1, margin, 5, 1,
				GridBagConstraints.WEST);

		// Complemento
		lblComplemento = new JLabel("Complemento");
		lblComplemento.setToolTipText("Complemteno do Imovel. EX: APTO 22");
		Utils.addGridBag(pnlAtributos, lblComplemento, 0, 2, margin, 1, 1,
				GridBagConstraints.EAST);

		txtComplemento = new JTextField(50);
		Utils.addGridBag(pnlAtributos, txtComplemento, 1, 2, margin, 5, 1,
				GridBagConstraints.WEST);

		// Bairro
		lblBairro = new JLabel("Bairro");
		lblBairro.setToolTipText("Bairro do imóvel");
		Utils.addGridBag(pnlAtributos, lblBairro, 0, 4, margin, 1, 1,
				GridBagConstraints.EAST);

		txtBairro = new JTextField(30);
		Utils.addGridBag(pnlAtributos, txtBairro, 1, 4, margin, 3, 1,
				GridBagConstraints.WEST);

		// Dormitorios
		lblDormitorio = new JLabel("Dormitorios");

		lblDormitorio.setToolTipText("Quantidade de dormitorios do imóvel");
		Utils.addGridBag(pnlAtributos, lblDormitorio, 4, 4, new Insets(2, 63,
				2, 0), 1, 1, GridBagConstraints.EAST);

		spiDormitorio = new JSpinner(new SpinnerNumberModel(1, 1, 99999, 1));
		spiDormitorio.setSize((new Dimension(5, 1)));
		Utils.addGridBag(pnlAtributos, spiDormitorio, 5, 4, margin, 1, 1,
				GridBagConstraints.WEST);

		// Cozinhas
		lblCozinha = new JLabel("Cozinhas");

		lblCozinha.setToolTipText("Quantidade de Cozinhas do imóvel");
		Utils.addGridBag(pnlAtributos, lblCozinha, 4, 5,
				new Insets(2, 63, 2, 0), 1, 1, GridBagConstraints.EAST);

		spiCozinha = new JSpinner(new SpinnerNumberModel(1, 1, 99999, 1));
		spiCozinha.setSize((new Dimension(5, 1)));
		Utils.addGridBag(pnlAtributos, spiCozinha, 5, 5, margin, 1, 1,
				GridBagConstraints.WEST);

		// Valor
		lblValor = new JLabel("Valor");
		lblValor.setToolTipText("Valor do imóvel");
		Utils.addGridBag(pnlAtributos, lblValor, 0, 5, margin, 1, 1,
				GridBagConstraints.EAST);

		txtValor = new JNumberFormatField();
		txtValor.setPreferredSize(new Dimension(140, 30));
		Utils.addGridBag(pnlAtributos, txtValor, 1, 5, margin, 3, 1,
				GridBagConstraints.WEST);

		// Corretor
		lblCorretor = new JLabel("Corretor");
		lblCorretor.setToolTipText("Corretor responsavel");
		Utils.addGridBag(pnlAtributos, lblCorretor, 0, 10, margin, 1, 1,
				GridBagConstraints.EAST);

		txtCorretor = new JTextField(30);
		Utils.addGridBag(pnlAtributos, txtCorretor, 1, 10, margin, 3, 1,
				GridBagConstraints.WEST);

		// Banheiros
		lblBanheiro = new JLabel("Banheiros");

		lblBanheiro.setToolTipText("Quantidade de Banheiros do imóvel");
		Utils.addGridBag(pnlAtributos, lblBanheiro, 4, 6, new Insets(2, 63, 2,
				0), 1, 1, GridBagConstraints.NORTHEAST);

		spiBanheiro = new JSpinner(new SpinnerNumberModel(1, 1, 99999, 1));
		spiBanheiro.setSize((new Dimension(5, 1)));
		Utils.addGridBag(pnlAtributos, spiBanheiro, 5, 6, margin, 1, 1,
				GridBagConstraints.NORTHWEST);

		// Painel Outras Informações
		montaPnlOutrasInformacoes();

		// Suite
		lblSuite = new JLabel("Suites");

		lblSuite.setToolTipText("Quantidade de Suites do imóvel");
		Utils.addGridBag(pnlAtributos, lblSuite, 4, 7, new Insets(2, 63, 2, 0),
				1, 1, GridBagConstraints.NORTHEAST);

		spiSuite = new JSpinner(new SpinnerNumberModel(1, 1, 99999, 1));
		spiSuite.setSize((new Dimension(5, 1)));
		Utils.addGridBag(pnlAtributos, spiSuite, 5, 7, margin, 1, 1,
				GridBagConstraints.NORTH);

		// Sacadas
		lblSacada = new JLabel("Sacadas");

		lblSacada.setToolTipText("Quantidade de Sacadas do imóvel");
		Utils.addGridBag(pnlAtributos, lblSacada, 4, 8,
				new Insets(2, 63, 2, 0), 1, 1, GridBagConstraints.NORTHEAST);

		spiSacada = new JSpinner(new SpinnerNumberModel(1, 1, 99999, 1));
		spiSacada.setSize((new Dimension(5, 1)));
		Utils.addGridBag(pnlAtributos, spiSacada, 5, 8, margin, 1, 1,
				GridBagConstraints.NORTH);

		// Cidade
		lblCidade = new JLabel("Cidade");
		lblCidade.setToolTipText("Cidade onde se encontra o imovel");
		Utils.addGridBag(pnlAtributos, lblCidade, 0, 3, margin, 1, 1,
				GridBagConstraints.EAST);

		txtCidade = new JTextField(50);
		Utils.addGridBag(pnlAtributos, txtCidade, 1, 3, margin, 5, 1,
				GridBagConstraints.WEST);

		// area
		lblArea = new JLabel("Area m²");
		lblArea.setToolTipText("Area total em metros quadrados");
		Utils.addGridBag(pnlAtributos, lblArea, 2, 5, margin, 1, 1,
				GridBagConstraints.EAST);		
		
		txtArea = new JTextField();
		txtArea.setColumns(6);		
		txtArea.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);  
		Utils.addGridBag(pnlAtributos, txtArea , 3, 5, margin, 1, 1, GridBagConstraints.WEST);
		
	}

	@Override
	public void gravar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	@Override
	public void montaConteudo() {
		// TODO Auto-generated method stub
		InstanciaObjetos();

		montaPnlConteudo();

		Utils.addGridBag(pnlConteudo, pnlPrincipal, 0, 0);
	}

	@Override
	public void setaTituloCadastro() {
		// TODO Auto-generated method stub

	}

	private void montaPnlConteudo() {
		montaPnlAtributos();

		pnlPrincipal.add(pnlAtributos);
	}

}
