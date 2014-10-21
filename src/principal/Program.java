package principal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import businessObejct.UsuarioBO;
import businessObejct.UsuarioBO.UsuarioException;
import utils.Utils;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;
import Views.CadastroMaster;
import Views.ConsultaMaster;
import Views.ImovelConsultaView;
import Views.ImovelView;
import Views.MenuView;
import Views.UsuarioCadastroView;
import Views.UsuarioConsultaView;
import Views.UsuarioView;
import Views.VisitaConsultaView;

class Home extends JFrame {

	private JPanel pnlPrincipal;
	private Home aux = this;
	private MenuView m = new MenuView();
	private ImovelConsultaView imovelConsulta;
	private UsuarioConsultaView usuarioConsulta;

	public Home() {
		pnlPrincipal = new JPanel(new BorderLayout());

		pnlPrincipal.add(m, BorderLayout.NORTH);

		MenuBar menuBar = new MenuBar();
		MenuItem itemMenuImovel = new MenuItem("Imóvel");
		MenuItem itemMenuUsuario = new MenuItem("Usuário");
		MenuItem itemMenuVisita = new MenuItem("Visita");
		MenuItem itemSair = new MenuItem("Sair");
		Menu menu = new Menu("Consultas");

		menu.add(itemMenuImovel);
		menu.add(itemMenuUsuario);
		menu.add(itemMenuVisita);
		menu.addSeparator();
		menu.add(itemSair);

		menuBar.add(menu);
		setMenuBar(menuBar);

		itemSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null,
						"Deseja encerrar a aplicação", "Confirmação",
						JOptionPane.YES_NO_OPTION);

				if (resp == 0)
					System.exit(0);
			}
		});

		itemMenuImovel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imovelConsulta = new ImovelConsultaView();
				imovelConsulta.setVisible(true);
			}
		});

		itemMenuUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				usuarioConsulta = new UsuarioConsultaView();
				usuarioConsulta.setVisible(true);
			}
		});

		itemMenuVisita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisitaConsultaView visitaConsulta = new VisitaConsultaView();
				visitaConsulta.setVisible(true);
			}
		});

		EscondePanels();
		m.btnUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usuarioConsulta = new UsuarioConsultaView();
				usuarioConsulta.setVisible(true);
			
			}
		});

		m.btnImovel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imovelConsulta = new ImovelConsultaView();
				imovelConsulta.setVisible(true);
			}
		});

		try {
			UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		 this.setUndecorated(true);
//		 this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
//		 this.setDefaultLookAndFeelDecorated(true);

		Utils.setLocation(this);

		Container P = getContentPane();
		P.add(pnlPrincipal);
	}

	private void EscondePanels() {

	}

	private void showView() {
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
