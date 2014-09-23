package principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

public class ImovelView extends JPanel {

	private static final int IMAGEHEIGHT = 220; 
	private static final int IMAGEWIDTH = 320;	
	
	private GridBagConstraints restricoes = new GridBagConstraints();
	
	private JFileChooser fc;

	private JPanel pnlPrincipal = new JPanel(new BorderLayout());

	private JPanel pnlCima = new JPanel(new GridBagLayout());
	private JPanel pnlCadastro = new JPanel(new GridBagLayout());
	private JPanel pnlAtributos = new JPanel(new GridBagLayout());
	private JScrollPane pnlScrollImagem = new JScrollPane();
	private JPanel pnlImagem = new JPanel(new GridBagLayout());
	private JPanel pnlAuxImagem = new JPanel();

	private JPanel pnlBaixo = new JPanel(new GridBagLayout());

	private JLabel txtTitulo;

	private JLabel lblCod;
	private JLabel lblRua;
	private JLabel lblComplemento;
	private JLabel lblDormitorio;
	private JLabel lblBairro;
	private JLabel lblValor;
	private Image imgImovel;

	private JTextField txtCod;
	private JTextField txtRua;
	private JTextField txtComplemento;
	private JSpinner spiDormitorio;
	private JTextField txtBairro;
	private JTextField txtValor;

	private JButton btnProcurar;
	private JButton btnGravar;
	
	private JLabel lblImageAux;

	public ImovelView() {

		restricoes.insets = new Insets(5, 5, 5, 5);

		txtTitulo = new JLabel("Cadastro de Imóveis");
		txtTitulo.setFont(new Font("ARIAL", Font.BOLD, 16));
		Utils.addGridBag(pnlCima, txtTitulo, 0, 0, new Insets(5, 5, 5, 5), 3, 1, GridBagConstraints.WEST);

		montaPnlCima();		
		montaPnlBaixo();
		
		showView();
	}

	private void montaPnlBaixo() {
		
		btnGravar= new JButton("Gravar");		
		Utils.addGridBag(pnlBaixo, btnGravar, 3, 1, new Insets(10, 680, 10, 10), 1, 1, GridBagConstraints.EAST);
	}

	private void montaPnlCima() {

		montaPnlCadastro();

		Insets margin = new Insets(5, 2, 5, 2);

		Utils.addGridBag(pnlCima, pnlCadastro, 0, 1, margin);

	}

	private void montaPnlImagem() {
		
		Insets margin = new Insets(0, 5, 0, 5);

		pnlImagem.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Imagem"));

		pnlAuxImagem.setSize(new Dimension(100, 100));
		Utils.addGridBag(pnlImagem, pnlAuxImagem, 0, 0, margin, 1, 1);

		btnProcurar = new JButton("Procurar");
		Utils.addGridBag(pnlImagem, btnProcurar, 0, 1, margin, 1, 1);

		btnProcurar.addActionListener(new ActionListener() {		

			@Override
			public void actionPerformed(ActionEvent e) {
				
				fc = new JFileChooser();
				
				int ret = fc.showDialog(null, "Abrir imagem");
				int height, width;
				
				if (ret == JFileChooser.APPROVE_OPTION) {
					String path = fc.getSelectedFile().getPath();
					BufferedImage img = null;
					try {
						imgImovel = ImageIO.read(new File(path));
						
						width = ImageIO.read(new File(path)).getWidth();
						height = ImageIO.read(new File(path)).getHeight();					
						
						//Dimension d = Utils.getScaledDimension(new Dimension(width, height));
						imgImovel = Utils.resizeImage(ImageIO.read(new File(path)), ImageIO.read(new File(path)).getType(), IMAGEWIDTH, IMAGEHEIGHT);
						
						lblImageAux.setIcon(new ImageIcon(imgImovel));						
						
					} catch (IOException exc) {
						JOptionPane.showMessageDialog(pnlPrincipal, "Erro ao abrir a imagem selecionada");						
					}
				} 
			}
		});
		
		BufferedImage imgNoImage = null;
		try {
			imgNoImage = ImageIO.read(new File("src\\principal\\no-image-320x200.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		imgImovel = Utils.resizeImage(imgNoImage, imgNoImage.getType(), 400, 200);
		
		lblImageAux = new JLabel(new ImageIcon("src\\principal\\no-image-320x200.png"));
		pnlAuxImagem.add(lblImageAux);
		
	}	
	
	private void montaPnlCadastro() {		

		montaPnlAtributos();
		Utils.addGridBag(pnlCadastro, pnlAtributos, 0, 0);

		montaPnlImagem();		
		Utils.addGridBag(pnlCadastro, pnlImagem, 0, 1);

	}

	private void montaPnlAtributos() {

		Insets margin = new Insets(2, 3, 2, 3);
		pnlAtributos.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder()));

		// Código
		lblCod = new JLabel("Código");
		lblCod.setToolTipText("Código do Imovel");
		Utils.addGridBag(pnlAtributos, lblCod, 0, 0, new Insets(0, 0, 0, 0), 1,
				1, GridBagConstraints.EAST);

		txtCod = new JTextField(6);
		txtCod.setEditable(false);
		Utils.addGridBag(pnlAtributos, txtCod, 1, 0, margin, 2, 1, GridBagConstraints.WEST);

		// Rua
		lblRua = new JLabel("Rua");
		lblRua.setToolTipText("Rua do imóvel");
		Utils.addGridBag(pnlAtributos, lblRua, 0, 1, margin, 1, 1,
				GridBagConstraints.EAST);

		txtRua = new JTextField(50);
		Utils.addGridBag(pnlAtributos, txtRua, 1, 1, margin, 5, 1, GridBagConstraints.WEST);

		// Complemento
		lblComplemento = new JLabel("Complemento");
		lblComplemento.setToolTipText("Complemteno do Imovel. EX: APTO 22");
		Utils.addGridBag(pnlAtributos, lblComplemento, 0, 2, margin, 1, 1,
				GridBagConstraints.EAST);

		txtComplemento = new JTextField(50);
		Utils.addGridBag(pnlAtributos, txtComplemento, 1, 2, margin, 5, 1, GridBagConstraints.WEST);

		// Bairro
		lblBairro = new JLabel("Bairro");
		lblBairro.setToolTipText("Bairro do imóvel");
		Utils.addGridBag(pnlAtributos, lblBairro, 0, 3, margin, 1, 1,
				GridBagConstraints.EAST);

		txtBairro = new JTextField(30);
		Utils.addGridBag(pnlAtributos, txtBairro,1, 3, margin, 3, 1, GridBagConstraints.WEST);

		// Dormitorios
		lblDormitorio = new JLabel("Dormitorios");
		
		
		lblDormitorio.setToolTipText("Quantidade de dormitorios do imóvel");
		Utils.addGridBag(pnlAtributos, lblDormitorio, 4, 3, new Insets(2, 63, 2, 0), 1, 1,
				GridBagConstraints.EAST);

		spiDormitorio = new JSpinner(new SpinnerNumberModel(1, 1, 99999, 1));
		spiDormitorio.setSize((new Dimension(5, 1)));
		Utils.addGridBag(pnlAtributos, spiDormitorio, 5, 3, margin, 1, 1, GridBagConstraints.WEST);

	}

	private void showView() {
		pnlPrincipal.add(pnlCima, BorderLayout.NORTH);
		pnlPrincipal.add(pnlBaixo, BorderLayout.SOUTH);
		this.add(pnlPrincipal);
	}

}

