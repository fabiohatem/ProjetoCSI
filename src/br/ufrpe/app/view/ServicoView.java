package br.ufrpe.app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServicoView {

	private JFrame frame;
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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 128, 54, 22);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 157, 165, 34);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 202, 60, 22);
		frame.getContentPane().add(lblDescrio);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkExistencia(txtNome.getText(), txtDescricao.getText())) {
		
					JOptionPane.showMessageDialog(null, "Serviço já foi cadastrado", "Tela de cadastro de serviço", JOptionPane.ERROR_MESSAGE);
				} else {
					
					JOptionPane.showMessageDialog(null, "Serviço cadastrado", "Tela de cadastro de serviço", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNovo.setBounds(252, 157, 89, 23);
		frame.getContentPane().add(btnNovo);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAtualizar.setBounds(252, 188, 89, 23);
		frame.getContentPane().add(btnAtualizar);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnVisualizar.setBounds(252, 222, 89, 23);
		frame.getContentPane().add(btnVisualizar);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(10, 227, 165, 34);
		frame.getContentPane().add(txtDescricao);
	}
	
	public boolean checkExistencia (String nome, String descricao) {
		return nome.equals("CPU") && descricao.equals("Nao liga");
	}
}
