package principal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Home extends JFrame {

	private JPanel pnlPrincipal;	
	private ImovelView imovelView = new ImovelView();
	private Home aux = this;
	private MenuView m = new MenuView();
	private UsuarioView usuarioView; 
	
	public Home() {
		pnlPrincipal = new JPanel(new BorderLayout());
		
		usuarioView = new UsuarioView();
		
		pnlPrincipal.add(m, BorderLayout.NORTH);
		
		EscondePanels();
		m.btnUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EscondePanels();
				pnlPrincipal.add(usuarioView, BorderLayout.CENTER);
				showView();
			}
		});

		m.btnImovel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EscondePanels();
				pnlPrincipal.add(imovelView, BorderLayout.CENTER);
				showView();
			}
		});
		
		Utils.setLocation(this);
		
		Container P = getContentPane();
		P.add(pnlPrincipal);
	}

	private void EscondePanels() {
		pnlPrincipal.remove(usuarioView);
		pnlPrincipal.remove(imovelView);
	}
	
	private void showView(){
		Container P = getContentPane();
		Utils.setLocation(this);
		P.add(pnlPrincipal);
	}
}


public class Program {

	public static void main(String[] args) {
		Home principal = new Home();
		principal.setVisible(true);
	}

}
