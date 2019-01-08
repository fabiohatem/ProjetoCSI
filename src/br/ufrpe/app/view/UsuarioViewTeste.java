package br.ufrpe.app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class UsuarioViewTeste {

	private JFrame frmPrincipal;
	private final JPanel panel = new JPanel();
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button_1;
	private JButton button_2;

	public boolean checkLogin (String login, String senha) {
		return login.equals("Usuario") && senha.equals("123");
		
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
					UsuarioViewTeste window = new UsuarioViewTeste();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UsuarioViewTeste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setBounds(100, 100, 620, 486);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 604, 447);
		frmPrincipal.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 604, 158);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Documents\\UFRPE\\PROGRAMA\u00C7\u00C3O\\JAVA\\Projeto - Programa\u00E7\u00E3o\\user.png"));
		lblNewLabel.setBounds(225, 33, 149, 81);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u00C1rea de Acesso");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(225, 125, 149, 22);
		panel_1.add(lblNewLabel_1);
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.LEFT);
		txtLogin.setBounds(10, 214, 207, 27);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtSenha.setBounds(10, 270, 207, 27);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(10, 188, 46, 14);
		panel.add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(10, 245, 46, 14);
		panel.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(checkLogin(txtLogin.getText(), txtSenha.getText())) {
					JOptionPane.showMessageDialog(null, "Dados inv�lidos", "Tela de cadastro de usu�rio", JOptionPane.ERROR_MESSAGE);
				} else {
					
				JOptionPane.showMessageDialog(null, "Entrando no sistema...", "Tela de cadastro de usu�rio", JOptionPane.INFORMATION_MESSAGE);
					
				} */
				
				if(txtLogin.getText().trim().equals("") || txtSenha.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Tela de cadastro de usu�rio", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEntrar.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Documents\\UFRPE\\PROGRAMA\u00C7\u00C3O\\JAVA\\Projeto - Programa\u00E7\u00E3o\\login.png"));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(Color.BLUE);
		btnEntrar.setBounds(284, 327, 143, 34);
		panel.add(btnEntrar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 308, 46, 14);
		panel.add(lblNome);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(10, 333, 207, 27);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 389, 207, 27);
		panel.add(textField_1);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatrcula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatrcula.setBounds(0, 365, 80, 14);
		panel.add(lblMatrcula);
		
		JButton button = new JButton("Remover");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Downloads\\trashcan_full_15175.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.BLUE);
		button.setBounds(437, 327, 143, 34);
		panel.add(button);
		
		button_1 = new JButton("Atualizar");
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Downloads\\blue_upgrade_recyclearrows_arrow_azul_12426.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(284, 383, 143, 34);
		panel.add(button_1);
		
		button_2 = new JButton("Voltar");
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Downloads\\arrow_left_17809.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBackground(Color.BLUE);
		button_2.setBounds(437, 383, 143, 34);
		panel.add(button_2);
	}
}
