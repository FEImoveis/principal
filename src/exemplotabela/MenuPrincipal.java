package exemplotabela;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.beans.*;

public class MenuPrincipal extends JFrame implements ActionListener {
	private JDesktopPane DPane;
	private JPopupMenu Menu;
	private JButton abreConsulta;
	private JButton sair;

	public MenuPrincipal() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(800, 600);
		setLocation(100, 50);
		setTitle("Aplica��o MDI com Barra de Ferramentas e Menu Flutuante");
		// cria��o do menu
		JMenuBar BarraMenu = new JMenuBar();
		setJMenuBar(BarraMenu);
		JMenu menuArquivo = new JMenu("Consulta");
		menuArquivo.setMnemonic('C');
		JMenuItem itemAbrirUm = new JMenuItem("Abrir...");
		itemAbrirUm.setMnemonic('A');
		JMenuItem itemSair = new JMenuItem("Sair");
		itemSair.setMnemonic('r');
		itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				InputEvent.ALT_MASK));
		;
		menuArquivo.add(itemAbrirUm);
		menuArquivo.addSeparator();
		menuArquivo.add(itemSair);
		BarraMenu.add(menuArquivo);
		itemAbrirUm.addActionListener(this);
		itemSair.addActionListener(this);
		// cria��o da barra de ferramentas
		JToolBar barra = new JToolBar();
		abreConsulta = new JButton(new ImageIcon("EstrelaUm.gif"));
		abreConsulta.setToolTipText("Abre a Consulta");
		sair = new JButton(new ImageIcon("Sair.gif"));
		sair.setToolTipText("Encerra a aplica��o");
		barra.add(abreConsulta);
		barra.addSeparator();
		barra.add(sair);
		abreConsulta.addActionListener(this);
		sair.addActionListener(this);
		Container P = getContentPane();
		P.setLayout(new BorderLayout());
		P.add(barra, "North");
		// cria��o da �rea para inser��o de frames internos
		DPane = new JDesktopPane();
		DPane.putClientProperty("JDesktopPane.dragMode", "outline");
		P.add(DPane, "Center");
	}

	public void actionPerformed(ActionEvent evt) {
		Object origem = evt.getSource();
		String item = evt.getActionCommand();
		if (item == "Abrir..." || origem == abreConsulta) {
			Consulta fr = new Consulta();
			fr.setVisible(true);
			DPane.add(fr);
			try {
				fr.setSelected(true);
			} catch (PropertyVetoException exc) {
			}
		} else if (item == "Sair" || origem == sair)
			System.exit(0);
	}

	public static void main(String args[]) {
		MenuPrincipal fr = new MenuPrincipal();
		fr.setVisible(true);
	}
}
