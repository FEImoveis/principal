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
import javax.swing.JDesktopPane;
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
		// pnlPrincipal.add(m, BorderLayout.NORTH);
		Utils.desktopPane = new JDesktopPane();
		EscondePanels();

		try {
			UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MontaMenu();

		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		this.setDefaultLookAndFeelDecorated(true);

		Utils.setLocation(this);

		Container P = getContentPane();
		P.setLayout(new BorderLayout());
		P.add(m, BorderLayout.NORTH);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		P.add(Utils.desktopPane, BorderLayout.CENTER);
	}

	private void MontaMenu() {
		m.itemMenuImovel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imovelConsulta = new ImovelConsultaView();
				imovelConsulta.setVisible(true);
				imovelConsulta.setSize(1000, 600);
				imovelConsulta.setLocation(10, 10);

				Utils.desktopPane.add(imovelConsulta);
			}
		});
		
		m.itemMenuUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				usuarioConsulta = new UsuarioConsultaView();
				usuarioConsulta.setVisible(true);
				usuarioConsulta.setSize(1000, 600);
				usuarioConsulta.setLocation(10, 10);

				Utils.desktopPane.add(usuarioConsulta);
			}
		});
		
		m.itemMenuVisita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisitaConsultaView visita = new VisitaConsultaView();
				visita.setVisible(true);
				visita.setSize(1000, 600);
				visita.setLocation(10, 10);
				
				Utils.desktopPane.add(visita);
			}
		});
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
