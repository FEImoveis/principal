package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;

public class MenuView extends JPanel {

	private JPanel window = new JPanel(new BorderLayout());
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screen = toolkit.getScreenSize();
	
	public JButton btnPrincipal, btnUsuario, btnImovel, btnVisita;
	
	public MenuView() {
		// TODO Auto-generated constructor stub
		createWindow();
	}

	private void createWindow() {
		// TODO Auto-generated method stub
				
		this.setLayout(new GridLayout(1,3));		
		
		
		btnImovel = new JButton();
		btnPrincipal = new JButton();
		btnUsuario = new JButton();		
		btnVisita = new JButton("Visita");
		
		btnUsuario.setText("Usuario");
		btnImovel.setText("Imovel");
		btnPrincipal.setText("Principal");
		
		this.add(btnImovel);
		this.add(btnPrincipal);
		this.add(btnUsuario);				
		
		showWindow();

	}
	


	private void showWindow() {
		// TODO Auto-generated method stub

		int h, w;
		w = 800; // height
		h = 100; // width	
		
		this.setSize(w, h);		
		this.setVisible(true);
	}

}
