package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MenuView extends JMenuBar {

	private JPanel window = new JPanel(new BorderLayout());
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screen = toolkit.getScreenSize();
	private ImovelConsultaView imovelConsulta;
	private UsuarioConsultaView usuarioConsulta;

	public JButton btnPrincipal, btnUsuario, btnImovel, btnVisita;
	public JMenuItem itemMenuImovel, itemMenuUsuario, itemMenuVisita, itemSair;

	public MenuView() {
		// TODO Auto-generated constructor stub
		createWindow();
	}

	private void createWindow() {
		// TODO Auto-generated method stub

		menuConsultas();
		showWindow();
	}

	public void menuEditar() {
		// criação do menu Editar
		JMenu menuEditar = new JMenu("Editar");
		menuEditar.setMnemonic('E');
		JMenuItem itemRecortar = new JMenuItem("Recortar...");
		itemRecortar.setMnemonic('t');
		itemRecortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));
		;
		JMenuItem itemCopiar = new JMenuItem("Copiar...");
		itemCopiar.setMnemonic('b');
		itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));
		;
		JMenuItem itemColar = new JMenuItem("Colar...");
		itemColar.setMnemonic('S');
		itemColar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));
		;
		menuEditar.add(itemRecortar);
		menuEditar.add(itemCopiar);
		menuEditar.add(itemColar);
		this.add(menuEditar);

		itemRecortar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		itemCopiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		itemColar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void menuConsultas() {
		// TODO Auto-generated method stub
		itemMenuImovel = new JMenuItem("Imóvel");
		itemMenuUsuario = new JMenuItem("Usuário");
		itemMenuVisita = new JMenuItem("Visita");
		itemSair = new JMenuItem("Sair");
		JMenu menu = new JMenu("Consultas");

		itemMenuImovel.setMnemonic('I');
		itemMenuImovel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				ActionEvent.SHIFT_MASK + ActionEvent.CTRL_MASK));

		itemMenuUsuario.setMnemonic('U');
		itemMenuUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				ActionEvent.SHIFT_MASK + ActionEvent.CTRL_MASK));

		itemMenuVisita.setMnemonic('V');
		itemMenuVisita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				ActionEvent.SHIFT_MASK + ActionEvent.CTRL_MASK));

		menu.add(itemMenuImovel);
		menu.add(itemMenuUsuario);
		menu.add(itemMenuVisita);
		menu.addSeparator();
		menu.add(itemSair);

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

		this.add(menu);

	}

	public void showWindow() {
		// TODO Auto-generated method stub

		int h, w;
		w = 800; // height
		h = 100; // width

		this.setSize(w, h);
		this.setVisible(true);
	}

}
