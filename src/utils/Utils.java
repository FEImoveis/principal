package utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import sun.reflect.generics.visitor.Reifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import Views.ImovelConsultaView;
import Views.MenuView;
import Views.UsuarioConsultaView;
import Views.VisitaConsultaView;

public class Utils {
	static Toolkit toolkit = Toolkit.getDefaultToolkit();
	static Dimension screen = toolkit.getScreenSize();
	static Insets margin = new Insets(5, 5, 5, 5);
	static GridBagConstraints restricoes = new GridBagConstraints();
	public static MenuView m = new MenuView();
	public static ImovelConsultaView imovelConsulta;
	public static UsuarioConsultaView usuarioConsulta;
	public static JDesktopPane desktopPane;


	public static void MontaMenu() {
//		desktopPane = new JDesktopPane();
		
		m.itemMenuImovel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imovelConsulta = new ImovelConsultaView();
				imovelConsulta.setVisible(true);
				imovelConsulta.setSize(1000, 600);
				imovelConsulta.setLocation(10, 10);
				imovelConsulta.setLayer(1);
				Utils.clearFramesLayer();
				desktopPane.add(imovelConsulta);
			}
		});
		
		m.itemMenuUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				usuarioConsulta = new UsuarioConsultaView();
				usuarioConsulta.setVisible(true);
				usuarioConsulta.setSize(1000, 600);
				usuarioConsulta.setLocation(10, 10);
				Utils.clearFramesLayer();
				usuarioConsulta.setLayer(1);
				
				desktopPane.add(usuarioConsulta);
			}
		});
		
		m.itemMenuVisita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisitaConsultaView visita = new VisitaConsultaView();
				visita.setVisible(true);
				visita.setSize(1000, 600);
				visita.setLocation(10, 10);
				Utils.clearFramesLayer();
				visita.setLayer(1);
				desktopPane.add(visita);
			}
		});
	}

	
	public static void setLocation(JFrame frame) {
		int h, w;
		w = 1024; // height
		h = 768; // width

		frame.pack();
		frame.setSize(w, h);
		frame.setSize(w, h);
		frame.setLocation((((screen.width - frame.getSize().width) / 2)),
				((screen.height - frame.getSize().height) / 2));

	}

	public static void addGridBag(JPanel pnl, Component obj, int x, int y) {

		restricoes.anchor = GridBagConstraints.WEST;
		restricoes.insets = Utils.margin;
		restricoes.gridx = x;
		restricoes.gridy = y;
		pnl.add(obj, restricoes);
	}

	public static void addGridBag(JPanel pnl, Component obj, int x, int y,
			Insets margin) {
		restricoes.anchor = GridBagConstraints.WEST;
		restricoes.gridx = x;
		restricoes.gridy = y;
		restricoes.insets = margin;
		pnl.add(obj, restricoes);
		// volta ao normal
		restricoes.insets = Utils.margin;
	}

	public static void clearFramesLayer()
	{
		for (int i = 0; i < Utils.desktopPane.getComponentCount(); i++) {
			((JInternalFrame)Utils.desktopPane.getComponent(i)).setLayer(0);
		}
	}
	
	public static void addGridBag(JPanel pnl, Component obj, int x, int y,
			Insets margin, int gridwidth, int gridheight) {
		restricoes.anchor = GridBagConstraints.WEST;
		restricoes.gridx = x;
		restricoes.gridy = y;
		restricoes.gridheight = gridheight;
		restricoes.gridwidth = gridwidth;
		restricoes.insets = margin;
		pnl.add(obj, restricoes);
		// volta ao normal
		restricoes.insets = Utils.margin;
		restricoes.gridheight = 1;
		restricoes.gridwidth = 1;
	}

	public static void addGridBag(JPanel pnl, Component obj, int x, int y,
			Insets margin, int gridwidth, int gridheight, int anchor) {
		
		restricoes.anchor = GridBagConstraints.WEST;
		restricoes.gridx = x;
		restricoes.gridy = y;
		restricoes.gridheight = gridheight;
		restricoes.gridwidth = gridwidth;
		restricoes.insets = margin;
		restricoes.anchor = anchor;
		pnl.add(obj, restricoes);
		// volta ao normal
		restricoes.insets = Utils.margin;
		restricoes.gridheight = 1;
		restricoes.gridwidth = 1;
		restricoes.anchor = GridBagConstraints.CENTER;
	}

	public static Dimension getScaledDimension(Dimension imgSize) {

		int original_width = imgSize.width;
		int original_height = imgSize.height;
		int bound_width = 300;
		int bound_height = 300;
		int new_width = original_width;
		int new_height = original_height;

		// first check if we need to scale width
		if (original_width > bound_width) {
			// scale width to fit
			new_width = bound_width;
			// scale height to maintain aspect ratio
			new_height = (new_width * original_height) / original_width;
		}

		// then check if we need to scale even with the new height
		if (new_height > bound_height) {
			// scale height to fit instead
			new_height = bound_height;
			// scale width to maintain aspect ratio
			new_width = (new_height * original_width) / original_height;
		}

		return new Dimension(new_width, new_height);
	}

	public static BufferedImage resizeImage(BufferedImage originalImage,
			int type, Integer img_width, Integer img_height) {

		BufferedImage resizedImage = new BufferedImage(img_width, img_height,type);
		
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, img_width, img_height, null);
		g.dispose();

		return resizedImage;
	}

}