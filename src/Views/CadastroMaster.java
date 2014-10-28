package Views;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import utils.Utils;

public abstract class CadastroMaster extends JInternalFrame implements FocusListener, ActionListener{

	private JPanel pnlPrincipal, pnlRodape, pnlCabecalho;
	protected JPanel pnlConteudo;
	public JLabel lblTitulo;
	private JButton btnGravar, btnCancelar;
	public MenuView m = new MenuView();
	public ImovelConsultaView imovelConsulta;
	public UsuarioConsultaView usuarioConsulta;
	public JDesktopPane desktopPane;
	public JMenuItem itemMenuImovel, itemMenuUsuario, itemMenuVisita, itemSair;
	public JPopupMenu btnDireitoMouse;
	private JTextField aux;
	private String item;
	
	public abstract void gravar();

	public abstract void cancelar();

	public abstract void montaConteudo();

	public abstract void setaTituloCadastro();

	private void InstanciaObjetos() {
		pnlPrincipal = new JPanel(new BorderLayout());
		pnlRodape = new JPanel(new GridBagLayout());
		pnlCabecalho = new JPanel(new GridBagLayout());
		pnlConteudo = new JPanel(new GridBagLayout());

		btnCancelar = new JButton("Cancelar");
		btnGravar = new JButton("Gravar");
		lblTitulo = new JLabel();
		
	}

	public CadastroMaster() {
		InstanciaObjetos();
		montaPnlCabecalho();
		montaPnlConteudo();
		montaPnlRodape();
		montaMenu();
		montaPnlPrincipal();
		

		this.add(pnlPrincipal);
	}

	private void montaMenu() {
		// TODO Auto-generated method stub
	
	}
	
	private void montaPnlPrincipal() {
		// TODO Auto-generated method stub
		pnlPrincipal.add(pnlCabecalho, BorderLayout.NORTH);
		pnlPrincipal.add(pnlConteudo, BorderLayout.CENTER);
		pnlPrincipal.add(pnlRodape, BorderLayout.SOUTH);
		menuConsultas();
		menuEditar();
//		Utils.m.menuEditar();
		setJMenuBar(m);
	}

	private void montaPnlRodape() {
		pnlRodape.setBorder(BorderFactory.createEtchedBorder());

		Utils.addGridBag(pnlRodape, btnGravar, 0, 0);
		Utils.addGridBag(pnlRodape, btnCancelar, 1, 0);
		
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		
		btnGravar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gravar();
			}
		});
	}

	private void montaPnlCabecalho() {

		pnlCabecalho.setBorder(BorderFactory.createEtchedBorder());
		setaTituloCadastro();
		Utils.addGridBag(pnlCabecalho, lblTitulo, 0, 0);
	}

	private void montaPnlConteudo() {
		montaConteudo();
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
		m.add(menuEditar);
		
		itemRecortar.addActionListener(this);
		itemCopiar.addActionListener(this);
		itemColar.addActionListener(this);

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

		m.itemMenuImovel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imovelConsulta = new ImovelConsultaView();
				imovelConsulta.setVisible(true);
				imovelConsulta.setSize(1000, 600);
				imovelConsulta.setLocation(10, 10);
				Utils.clearFramesLayer();
				imovelConsulta.setLayer(1);
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
				
				Utils.clearFramesLayer();
				
				usuarioConsulta.setLayer(1);
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
				Utils.clearFramesLayer();
				visita.setLayer(1);
				Utils.desktopPane.add(visita);
			}
		});

		this.add(menu);

	}
	
	public void popUpBtnDireitoMouse(){
		btnDireitoMouse = new JPopupMenu();
		btnDireitoMouse.add(new JMenuItem("Recortar")).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 aux.cut();	
			}
		});
		btnDireitoMouse.add(new JMenuItem("Copiar")).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aux.copy();
			}
		});
		btnDireitoMouse.add(new JMenuItem("Colar")).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aux.paste();
			}
		});
	}
	
	public void focusLost(FocusEvent evt)
	{	
	  aux =  (JTextField)evt.getComponent();
	}
	
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
   public void actionPerformed(ActionEvent e) {
    	
    	Object result = e.getSource();
    	
    	if(result.getClass() == JMenuItem.class)
    	{
	    	JMenuItem item = (JMenuItem) result ;
	    	
	    	if(item.getText() == "Copiar..."){
	    		  aux.copy();
	    	}
	    	else if(item.getText() == "Colar..."){
	    	  aux.paste();
	    	}
	    	else if(item.getText() == "Recortar..."){
	    	  aux.cut();
	    	}    
    	}
    }  

}
