package br.ufrpe.app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class ServicoView {

	private JFrame ServicoView;
	private JTextField txtNome;
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
					ServicoView window = new ServicoView();
					window.ServicoView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServicoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ServicoView = new JFrame();
		ServicoView.setTitle(" Servi\u00E7os");
		ServicoView.getContentPane().setBackground(Color.WHITE);
		ServicoView.setBounds(100, 100, 620, 420);
		ServicoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ServicoView.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(10, 189, 54, 22);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		ServicoView.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 218, 217, 27);
		ServicoView.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrio.setBounds(10, 263, 60, 22);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		ServicoView.getContentPane().add(lblDescrio);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(255, 282, 143, 34);
		btnNovo.setBackground(Color.BLUE);
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovo.setForeground(Color.WHITE);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkExistencia(txtNome.getText(), txtDescricao.getText())) {
		
					JOptionPane.showMessageDialog(null, "Serviço já foi cadastrado", "Tela de cadastro de serviço", JOptionPane.ERROR_MESSAGE);
				} else {
					
					JOptionPane.showMessageDialog(null, "Serviço cadastrado", "Tela de cadastro de serviço", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		ServicoView.getContentPane().add(btnNovo);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 288, 217, 27);
		txtDescricao.setColumns(10);
		ServicoView.getContentPane().add(txtDescricao);
		
		JButton button = new JButton("Atualizar");
		button.setBounds(422, 282, 143, 34);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.BLUE);
		ServicoView.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 604, 162);
		panel.setBackground(Color.BLUE);
		ServicoView.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Downloads\\customer-service_icon-icons.com_51012.png"));
		lblNewLabel.setBounds(269, 35, 64, 64);
		panel.add(lblNewLabel);
		
		JLabel lblreaDeServios = new JLabel("\u00C1rea de Servi\u00E7os");
		lblreaDeServios.setHorizontalAlignment(SwingConstants.CENTER);
		lblreaDeServios.setForeground(Color.WHITE);
		lblreaDeServios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblreaDeServios.setBounds(224, 110, 155, 22);
		panel.add(lblreaDeServios);
		
		JButton button_1 = new JButton("Remover");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(255, 327, 143, 34);
		ServicoView.getContentPane().add(button_1);
	}
	
	public boolean checkExistencia (String nome, String descricao) {
		return nome.equals("CPU") && descricao.equals("Nao liga");
	}
}
