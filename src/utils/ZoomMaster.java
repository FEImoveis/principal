package utils;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Views.UsuarioConsultaView;

public class ZoomMaster extends JPanel {

	public JFrame tela;
	private JButton btnZoom;
	private JTextField txtCodigo;
	private JTextField txtDesc;

	public ZoomMaster(JFrame tela) {

		this.setLayout(new GridBagLayout());

		montaCampos(tela, 0, true);
	}

	public ZoomMaster(JFrame usuarioConsultaView, int i, boolean edit) {
		montaCampos(usuarioConsultaView, i, edit);
	}

	private void montaCampos(JFrame tela, int tamanhoDesc,  boolean edit) {
		// TODO Auto-generated method stub
		btnZoom = new JButton();

		txtCodigo = new JTextField(4);
		
		if (tamanhoDesc == 0)
			txtDesc = new JTextField(25);
		else
			txtDesc = new JTextField(tamanhoDesc);

		String path = "src\\Views\\imagens\\lupa.png";

		txtDesc.setEditable(edit);
		
		Image image;
		try {
			image = Utils.resizeImage(ImageIO.read(new File(path)), ImageIO
					.read(new File(path)).getType(), 20, 20);
			btnZoom.setIcon(new ImageIcon(image));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.tela = tela;

		txtCodigo.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"AQUI IRIA PESQUISAR MAS AINDA NAO ESTA PRONTO SEGURA AI BASTIAO");
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnZoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ZoomMaster.this.tela.setVisible(true);

			}
		});

		Utils.addGridBag(this, txtCodigo, 0, 0, new Insets(5, 5, 5, 5), 1, 1, GridBagConstraints.WEST);
		Utils.addGridBag(this, btnZoom, 1, 0, new Insets(5, 5, 5, 5), 1, 1, GridBagConstraints.WEST);
		Utils.addGridBag(this, txtDesc, 2, 0, new Insets(5, 5, 5, 5), 5, 1, GridBagConstraints.WEST);
	}

}
