package principal;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.reflect.generics.visitor.Reifier;

public class Utils {
	static Toolkit toolkit = Toolkit.getDefaultToolkit();
	static Dimension screen = toolkit.getScreenSize();

	static GridBagConstraints restricoes = new GridBagConstraints();

	public static void setLocation(JFrame frame) {
		int h, w;
		w = 800; // height
		h = 600; // width

		frame.pack();
		frame.setSize(w, h);
		frame.setSize(800, 600);
		frame.setLocation((((screen.width - frame.getSize().width) / 2)),
				((screen.height - frame.getSize().height) / 2));

	}

	public static void addGridBag(JPanel pnl, Component obj, int x, int y) {

		restricoes.gridx = x;
		restricoes.gridy = y;
		pnl.add(obj, restricoes);
	}

	public static void addGridBag(JPanel pnl, Component obj, int x, int y,
			Insets margin) {
		restricoes.gridx = x;
		restricoes.gridy = y;
		restricoes.insets = margin;
		pnl.add(obj, restricoes);
		// volta ao normal
		restricoes.insets = new Insets(0, 0, 0, 0);
	}

	public static void addGridBag(JPanel pnl, Component obj, int x, int y,
			Insets margin, int gridwidth, int gridheight) {
		restricoes.gridx = x;
		restricoes.gridy = y;
		restricoes.gridheight = gridheight;
		restricoes.gridwidth = gridwidth;
		restricoes.insets = margin;
		pnl.add(obj, restricoes);
		// volta ao normal
		restricoes.insets = new Insets(0, 0, 0, 0);
		restricoes.gridheight = 1;
		restricoes.gridwidth = 1;
	}

	public static void addGridBag(JPanel pnl, Component obj, int x, int y,
			Insets margin, int gridwidth, int gridheight, int anchor) {
		restricoes.gridx = x;
		restricoes.gridy = y;
		restricoes.gridheight = gridheight;
		restricoes.gridwidth = gridwidth;
		restricoes.insets = margin;
		restricoes.anchor = anchor;
		pnl.add(obj, restricoes);
		// volta ao normal
		restricoes.insets = new Insets(0, 0, 0, 0);
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
		
		BufferedImage resizedImage = new BufferedImage(img_width, img_height,	type);

		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, img_width, img_height, null);
		g.dispose();

		return resizedImage;
	}
}
