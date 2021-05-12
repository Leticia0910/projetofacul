

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ConsultaCidadao extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField telefoneField;
	private JTextField txtData;
	private JTextField emailField;
	private JTextField cpfField;
	private JTextField susField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCidadao frame = new ConsultaCidadao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaCidadao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		susField = new JTextField();
		susField.setColumns(10);
		susField.setBounds(265, 65, 158, 20);
		contentPane.add(susField);
		
		cpfField = new JTextField();
		cpfField.setColumns(10);
		cpfField.setBounds(265, 220, 161, 20);
		contentPane.add(cpfField);
		
		telefoneField = new JTextField();
		telefoneField.setColumns(10);
		telefoneField.setBounds(265, 189, 161, 20);
		contentPane.add(telefoneField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(265, 158, 158, 20);
		contentPane.add(emailField);
		
		
		txtData = new TextDataChooser();
		txtData.setBounds(267, 127, 158, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		nomeField.setBounds(267, 96, 158, 20);
		contentPane.add(nomeField);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(171, 160, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(156, 190, 78, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF/RNE");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(156, 222, 63, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(171, 100, 46, 14);
		contentPane.add(lblNewLabel);
		
		Button button = new Button("CONSULTAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sus =JOptionPane.showInputDialog("Qual o número do sus?");
				String nome = nomeField.getText();
				int telefone = Integer.parseInt(telefoneField.getText());
				String email = emailField.getText();
				String cpf = cpfField.getText();
				String dataDeNacimento = txtData.getText();
				Cidadao p = new Cidadao(sus, nome, telefone, email, cpf, dataDeNacimento);
				p.setSus(sus);
				p.consultar();
				dispose();
			}
		});
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.setBounds(253, 279, 170, 31);
		contentPane.add(button);
		
		
		JLabel lblNewLabel_1 = new JLabel("N\u00DAMERO DO SUS");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(130, 64, 142, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(99, 131, 147, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel btnConsultar = new JLabel("consultar");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\lu99-\\eclipse-workspace\\projetoTelas\\icons\\fundo-abstrato-colorido_23-2148807053.jpg"));
		btnConsultar.setBounds(0, 0, 586, 333);
		contentPane.add(btnConsultar);
	}
}
