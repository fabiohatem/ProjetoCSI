package br.ufrpe.app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class EquipamentoViewTeste {

	private JFrame EquipamentoView;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
					EquipamentoViewTeste window = new EquipamentoViewTeste();
					window.EquipamentoView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EquipamentoViewTeste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		EquipamentoView = new JFrame();
		EquipamentoView.setTitle("Equipamento View");
		EquipamentoView.getContentPane().setBackground(Color.WHITE);
		EquipamentoView.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 604, 162);
		EquipamentoView.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ricardo\\Downloads\\computer_pc_10894.png"));
		lblNewLabel.setBounds(259, 30, 83, 72);
		panel.add(lblNewLabel);
		
		JLabel lblEquipamentos = new JLabel("Equipamentos");
		lblEquipamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipamentos.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblEquipamentos.setForeground(Color.WHITE);
		lblEquipamentos.setBounds(229, 114, 127, 23);
		panel.add(lblEquipamentos);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrio.setBounds(10, 182, 69, 14);
		EquipamentoView.getContentPane().add(lblDescrio);
		
		textField = new JTextField();
		textField.setBounds(10, 207, 207, 27);
		EquipamentoView.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setBounds(10, 250, 46, 14);
		EquipamentoView.getContentPane().add(lblCdigo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 275, 207, 27);
		EquipamentoView.getContentPane().add(textField_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(10, 318, 46, 14);
		EquipamentoView.getContentPane().add(lblTipo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 343, 207, 27);
		EquipamentoView.getContentPane().add(textField_2);
		
		JButton button = new JButton("Adicionar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.BLUE);
		button.setBounds(264, 291, 143, 34);
		EquipamentoView.getContentPane().add(button);
		
		JButton button_1 = new JButton("Procurar");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(264, 336, 143, 34);
		EquipamentoView.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Remover");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBackground(Color.BLUE);
		button_2.setBounds(432, 291, 143, 34);
		EquipamentoView.getContentPane().add(button_2);
		EquipamentoView.setBounds(100, 100, 620, 429);
		EquipamentoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
