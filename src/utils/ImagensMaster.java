package utils;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagensMaster extends JPanel {	

	private JPanel pnlAuxImagem;
	
	private JButton btnProcurar;	
	private JFileChooser fcsImagem;	
	private Image img;
	private JLabel lblImageAux;
	private ArrayList<Image> galeryImages;	
	
	/*
	 * número de imagens da galeria
	 * por padrão são 5 imagens
	 */
	
	private int numImagens = 5;
	
	/*
	 * Largura e altura de todas as imagens
	 */
	
	private int widthImage = 300;
	private int heightImage = 300;
	
	
	/*
	 * Construtor padrão
	 */	
	public ImagensMaster(){
		montaPnlImagem();
	}
	
	/*
	 * Construtor com número de imagens personalizdo
	 */
	public ImagensMaster(int numImagens){
		montaPnlImagem();
	}
	
	/*
	 * Construtor com número de imagens personalizdo
	 * Tamanho das imagens personalizado
	 */
	public ImagensMaster(int numImagens, int heightImage, int widthImage){
		
		this.numImagens = numImagens;
		this.heightImage = heightImage;
		this.widthImage = widthImage;
		
		montaPnlImagem();
	}

	
	private void montaPnlImagem() {

		this.setLayout(new GridBagLayout());
		pnlAuxImagem = new JPanel(new GridBagLayout());
		
		Insets margin = new Insets(0, 5, 0, 5);

		pnlAuxImagem.setSize(new Dimension(100, 100));
		Utils.addGridBag(this, pnlAuxImagem, 0, 0, margin, 1, 1);

		btnProcurar = new JButton("Procurar");
		Utils.addGridBag(this, btnProcurar, 0, 1, margin, 1, 1);

		btnProcurar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fcsImagem = new JFileChooser();

				int ret = fcsImagem.showDialog(null, "Abrir imagem");
				int height, width;

				if (ret == JFileChooser.APPROVE_OPTION) {
					String path = fcsImagem.getSelectedFile().getPath();
					BufferedImage img = null;
					try {
						img = ImageIO.read(new File(path));

						width = ImageIO.read(new File(path)).getWidth();
						height = ImageIO.read(new File(path)).getHeight();

						// Dimension d = Utils.getScaledDimension(new
						// Dimension(width, height));
						img = Utils.resizeImage(
								ImageIO.read(new File(path)),
								ImageIO.read(new File(path)).getType(),
								widthImage, heightImage);

						lblImageAux.setIcon(new ImageIcon(img));

					} catch (IOException exc) {
						JOptionPane.showMessageDialog(null,
								"Erro ao abrir a imagem selecionada");
					}
				}
			}
		});

		BufferedImage imgNoImage = null;
		try {
			imgNoImage = ImageIO.read(new File(
					"src\\principal\\no-image-320x200.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		img = Utils.resizeImage(imgNoImage, imgNoImage.getType(), 400,
				200);

		lblImageAux = new JLabel(new ImageIcon(
				"src\\principal\\no-image-320x200.png"));
		pnlAuxImagem.add(lblImageAux);

	}
}
