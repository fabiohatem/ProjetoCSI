package br.ufrpe.app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import br.ufrpe.app.controller.CsiFacade;
import br.ufrpe.app.model.dao.OrgaoDao;
import br.ufrpe.app.model.dao.daoImpl.OrgaoDaoImpl;
import br.ufrpe.app.model.dao.daoImpl.ServicoDaoImpl;
import br.ufrpe.app.model.entity.Orgao;
import br.ufrpe.app.util.exception.OrgaoException;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrgaoViewTeste extends javax.swing.JFrame {

	
	private JFrame OrgaoView;
	private JTextField txtNome;
	private JTextField txtSigla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException  ex) {
            System.err.println(ex);
        } 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrgaoViewTeste window = new OrgaoViewTeste();
					window.OrgaoView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OrgaoViewTeste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		OrgaoView = new JFrame();
		OrgaoView.setTitle("Orgao View");
		OrgaoView.getContentPane().setBackground(Color.WHITE);
		OrgaoView.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 604, 162);
		OrgaoView.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblOrgo = new JLabel("");
		lblOrgo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrgo.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Downloads\\user-id-icon_34334.png"));
		lblOrgo.setForeground(Color.WHITE);
		lblOrgo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOrgo.setBounds(247, 25, 113, 72);
		panel.add(lblOrgo);
		
		JLabel lblOrgo_1 = new JLabel("\u00D3rg\u00E3o");
		lblOrgo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrgo_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOrgo_1.setForeground(Color.WHITE);
		lblOrgo_1.setBounds(262, 103, 79, 23);
		panel.add(lblOrgo_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(206, 197, 46, 14);
		OrgaoView.getContentPane().add(lblNome);
		
		JLabel lblSigla = new JLabel("Sigla");
		lblSigla.setHorizontalAlignment(SwingConstants.CENTER);
		lblSigla.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSigla.setBounds(206, 270, 46, 14);
		OrgaoView.getContentPane().add(lblSigla);
		
		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setBounds(206, 221, 207, 27);
		OrgaoView.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtSigla = new JTextField();
		txtSigla.setHorizontalAlignment(SwingConstants.LEFT);
		txtSigla.setColumns(10);
		txtSigla.setBounds(206, 295, 207, 27);
		OrgaoView.getContentPane().add(txtSigla);
		
		JButton button = new JButton("Adicionar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.BLUE);
		button.setBounds(72, 354, 143, 34);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome =txtNome.getText();
				String sigla=txtSigla.getText();
				
				Orgao orgao= new Orgao(nome,sigla);
				
				CsiFacade facade = new CsiFacade();
				OrgaoDao org= OrgaoDaoImpl.getInstance();
				
				try {
					org.create(orgao);
					org.salvarArquivo();
					JOptionPane.showMessageDialog(null,"Orgao Adicionado" , "Orgao Screen", JOptionPane.INFORMATION_MESSAGE);
				} catch (OrgaoException e) {
					JOptionPane.showMessageDialog(null, "Orgão já Adicionado", "Orgao Screen", JOptionPane.ERROR_MESSAGE);
				}
				txtNome.setText("");
				txtSigla.setText("");
			}
		});
		
		OrgaoView.getContentPane().add(button);
		
		JButton button_1 = new JButton("Procurar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				CsiFacade facade = new CsiFacade ();
				OrgaoDao org=OrgaoDaoImpl.getInstance();
				
				Orgao[]or=facade.findAllOrgao();
				for (int i = 0; i < or.length; i++) {
					JOptionPane.showInputDialog(or[i]);
					} 
			}
		});
				
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(243, 354, 143, 34);
		OrgaoView.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Remover");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CsiFacade facade= new CsiFacade();
				String nome=txtNome.getText();
				String sigla=txtSigla.getText();
				//OrgaoDao org= OrgaoDaoImpl.getInstance();
				if((txtSigla.getText().isEmpty()) || (txtNome.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null,"Preencha Todos os Campos");
				} else {
					Orgao orgao = new Orgao (nome,sigla);
					OrgaoDao org = OrgaoDaoImpl.getInstance();
					org.contem(orgao);
					org.delete(sigla);
					JOptionPane.showMessageDialog(null, "Orgão "+txtNome.getText()+" removido com sucesso! ");
				}
				
				
				

				
				
				/*try {
					org.findBySigla(sigla);
					org.delete(sigla);
					JOptionPane.showMessageDialog(null, "Orgao Achado e Removido com Sucesso", "Orgao Screen", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception error){
					
					JOptionPane.showMessageDialog(null, "Orgao Não Achado", "Orgao Screen", JOptionPane.ERROR_MESSAGE);
				}*/
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBackground(Color.BLUE);
		button_2.setBounds(413, 354, 143, 34);
		OrgaoView.getContentPane().add(button_2);
		OrgaoView.setBounds(100, 100, 620, 474);
		OrgaoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
