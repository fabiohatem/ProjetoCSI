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

import br.ufrpe.app.controller.CsiFacade;
import br.ufrpe.app.model.dao.ServicoDao;
import br.ufrpe.app.model.dao.daoImpl.ServicoDaoImpl;
import br.ufrpe.app.model.entity.Servico;
import br.ufrpe.app.util.exception.ServicoException;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class ServicoView extends javax.swing.JFrame {

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
		lblNome.setBounds(203, 188, 54, 22);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		ServicoView.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(203, 217, 217, 27);
		ServicoView.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrio.setBounds(203, 262, 60, 22);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		ServicoView.getContentPane().add(lblDescrio);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(66, 336, 143, 34);
		btnNovo.setBackground(Color.BLUE);
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovo.setForeground(Color.WHITE);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = txtNome.getText();
				String descricao = txtDescricao.getText();
				
				Servico servico = new Servico(nome, descricao);
				
				CsiFacade facade = new CsiFacade();
				ServicoDao ser = ServicoDaoImpl.getInstance();
				
				try {
					ser.create(servico);
					if(txtNome.getText().trim().equals("") || txtDescricao.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Tela de cadastro de serviço", JOptionPane.WARNING_MESSAGE);
					}
					ser.salvarArquivo();
					JOptionPane.showMessageDialog(null, "Serviço cadastrado", "Tela de cadastro de serviço", JOptionPane.INFORMATION_MESSAGE);
				} catch (ServicoException e) {
					JOptionPane.showMessageDialog(null, "Serviço já foi cadastrado", "Tela de cadastro de serviço", JOptionPane.ERROR_MESSAGE);
				}
				
	
			/*	if(checkExistencia(txtNome.getText(), txtDescricao.getText())) {
		
					JOptionPane.showMessageDialog(null, "Serviço já foi cadastrado", "Tela de cadastro de serviço", JOptionPane.ERROR_MESSAGE);
				} else {
					
					JOptionPane.showMessageDialog(null, "Serviço cadastrado", "Tela de cadastro de serviço", JOptionPane.INFORMATION_MESSAGE);
					
				}*/
			}
		});
		ServicoView.getContentPane().add(btnNovo);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(203, 287, 217, 27);
		txtDescricao.setColumns(10);
		ServicoView.getContentPane().add(txtDescricao);
		
		JButton button = new JButton("Atualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CsiFacade facade = new CsiFacade();
				// Servico servico = new Servico();
				// ServicoDao ser = ServicoDaoImpl.getInstance();
				Servico[] se = facade.findAllServico();
				// ser.update(servico);
				 for (int i = 0; i < se.length; i++) {
					//System.out.println(se[i]);
					JOptionPane.showInputDialog(se[i]);
					} 
			}
		});
		button.setBounds(398, 336, 143, 34);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.BLUE);
		ServicoView.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 604, 162);
		panel.setBackground(Color.BLUE);
		ServicoView.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
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
				
				CsiFacade facade = new CsiFacade();
				String nome = txtNome.getText();
				ServicoDao ser = ServicoDaoImpl.getInstance();
				
				try {
					ser.findByNome(nome);
					JOptionPane.showMessageDialog(null, "Serviço achado e removido com sucesso", "Tela de cadastro de serviço", JOptionPane.INFORMATION_MESSAGE);
					ser.delete(nome);
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Serviço não foi achado", "Tela de cadastro de serviço", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}		
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(235, 336, 143, 34);
		ServicoView.getContentPane().add(button_1);
	}
	

}
