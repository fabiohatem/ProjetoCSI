package br.ufrpe.app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SolicitacaoViewTeste {

	private JFrame SolicitacaoView;
	private JTextField txtCodigo;
	private JTextField txtDescricao;

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
					SolicitacaoViewTeste window = new SolicitacaoViewTeste();
					window.SolicitacaoView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SolicitacaoViewTeste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SolicitacaoView = new JFrame();
		SolicitacaoView.setTitle("Solicita\u00E7\u00F5es");
		SolicitacaoView.getContentPane().setBackground(Color.WHITE);
		SolicitacaoView.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 202, 46, 14);
		SolicitacaoView.getContentPane().add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(10, 229, 217, 27);
		SolicitacaoView.getContentPane().add(txtCodigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrio.setBounds(10, 274, 62, 14);
		SolicitacaoView.getContentPane().add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(10, 299, 217, 27);
		SolicitacaoView.getContentPane().add(txtDescricao);
		
		JButton button = new JButton("Novo");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.BLUE);
		button.setBounds(270, 231, 143, 34);
		SolicitacaoView.getContentPane().add(button);
		
		JButton button_1 = new JButton("Atualizar");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(436, 231, 143, 34);
		SolicitacaoView.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Remover");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBackground(Color.BLUE);
		button_2.setBounds(270, 292, 143, 34);
		SolicitacaoView.getContentPane().add(button_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 604, 162);
		SolicitacaoView.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblreaDeSolicitaes = new JLabel("\u00C1rea de Solicita\u00E7\u00F5es");
		lblreaDeSolicitaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblreaDeSolicitaes.setForeground(Color.WHITE);
		lblreaDeSolicitaes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblreaDeSolicitaes.setBounds(210, 116, 180, 22);
		panel.add(lblreaDeSolicitaes);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Downloads\\low_thecomputer_theapplication_2917.png"));
		lblNewLabel_1.setBounds(259, 41, 70, 64);
		panel.add(lblNewLabel_1);
		SolicitacaoView.setBounds(100, 100, 620, 420);
		SolicitacaoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
