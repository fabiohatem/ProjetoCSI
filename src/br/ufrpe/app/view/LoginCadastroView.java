package br.ufrpe.app.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.ufrpe.app.controller.CsiFacade;
import br.ufrpe.app.model.dao.UsuarioDao;
import br.ufrpe.app.model.dao.daoImpl.UsuarioDaoImpl;
import br.ufrpe.app.util.exception.UsuarioException;
import br.ufrpe.app.view.UsuarioViewTeste;

public class LoginCadastroView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmreaDeAcesso;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	
	private boolean logged;
    
	public boolean isLogged() {
        return logged;
    }
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
					LoginCadastroView window = new LoginCadastroView();
					window.frmreaDeAcesso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginCadastroView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmreaDeAcesso = new JFrame();
		frmreaDeAcesso.setTitle("\u00C1rea de Acesso");
		frmreaDeAcesso.getContentPane().setBackground(Color.WHITE);
		frmreaDeAcesso.setBounds(100, 100, 425, 414);
		frmreaDeAcesso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmreaDeAcesso.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 409, 134);
		frmreaDeAcesso.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTelaDeCadastro = new JLabel("\u00C1rea de Acesso");
		lblTelaDeCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaDeCadastro.setForeground(Color.WHITE);
		lblTelaDeCadastro.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTelaDeCadastro.setBounds(120, 46, 184, 52);
		panel.add(lblTelaDeCadastro);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(27, 170, 46, 25);
		frmreaDeAcesso.getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(104, 168, 217, 27);
		frmreaDeAcesso.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(27, 223, 46, 25);
		frmreaDeAcesso.getContentPane().add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(104, 221, 217, 27);
		frmreaDeAcesso.getContentPane().add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CsiFacade facade = new CsiFacade();
				ServicoView servico = new ServicoView();
				
				if ((txtLogin.getText().isEmpty()) || (txtSenha.getText().isEmpty())) {
					   JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
					}
					else if (txtLogin.getText().equals("adm") &&
	                    txtSenha.getText().equals("123")) {
						servico.setVisible(true);
	                    dispose();
					}
			}
		});
		btnEntrar.setBounds(86, 270, 96, 35);
		frmreaDeAcesso.getContentPane().add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(225, 270, 96, 35);
		frmreaDeAcesso.getContentPane().add(btnSair);
		
		JButton btnCadastrarNovoUsurio = new JButton("Cadastrar novo usu\u00E1rio");
		btnCadastrarNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioViewTeste UsuarioTela = new UsuarioViewTeste();
				UsuarioTela.setVisible(true);
	
				
			}
		});
		btnCadastrarNovoUsurio.setBounds(117, 316, 180, 35);
		frmreaDeAcesso.getContentPane().add(btnCadastrarNovoUsurio);
	}
}
