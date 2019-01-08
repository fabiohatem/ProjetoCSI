package br.ufrpe.app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrgaoViewTeste {

	private JFrame OrgaoView;
	private JTextField textField;
	private JTextField textField_1;

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
		lblNome.setBounds(10, 190, 46, 14);
		OrgaoView.getContentPane().add(lblNome);
		
		JLabel lblSigla = new JLabel("Sigla");
		lblSigla.setHorizontalAlignment(SwingConstants.CENTER);
		lblSigla.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSigla.setBounds(10, 263, 46, 14);
		OrgaoView.getContentPane().add(lblSigla);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(10, 215, 207, 27);
		OrgaoView.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 288, 207, 27);
		OrgaoView.getContentPane().add(textField_1);
		
		JButton button = new JButton("Adicionar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.BLUE);
		button.setBounds(10, 345, 143, 34);
		OrgaoView.getContentPane().add(button);
		
		JButton button_1 = new JButton("Procurar");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(181, 345, 143, 34);
		OrgaoView.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Remover");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBackground(Color.BLUE);
		button_2.setBounds(350, 345, 143, 34);
		OrgaoView.getContentPane().add(button_2);
		OrgaoView.setBounds(100, 100, 620, 474);
		OrgaoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}