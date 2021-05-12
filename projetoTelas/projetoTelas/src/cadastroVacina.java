import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.TextField;
import javax.swing.SwingConstants;

public class cadastroVacina extends JFrame {

	private JPanel contentPane;
	private JTextField vacinaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroVacina frame = new cadastroVacina();
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
	public cadastroVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox qtdDosesBox_1_1 = new JComboBox();
		qtdDosesBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		qtdDosesBox_1_1.setBounds(341, 146, 83, 28);
		contentPane.add(qtdDosesBox_1_1);
		Integer.parseInt((String)qtdDosesBox_1_1.getSelectedItem());
		
		JLabel lblDataDeVacinacao = new JLabel("Periodo");
		lblDataDeVacinacao.setForeground(new Color(255, 255, 255));
		lblDataDeVacinacao.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataDeVacinacao.setBounds(204, 101, 83, 20);
		contentPane.add(lblDataDeVacinacao);
		
		JLabel lblVacina = new JLabel("Vacina");
		lblVacina.setBackground(new Color(255, 255, 255));
		lblVacina.setForeground(new Color(255, 255, 255));
		lblVacina.setFont(new Font("Arial", Font.BOLD, 14));
		lblVacina.setBounds(204, 50, 69, 20);
		contentPane.add(lblVacina);
		
		vacinaField = new JTextField();
		vacinaField.setColumns(10);
		vacinaField.setBounds(283, 52, 141, 20);
		contentPane.add(vacinaField);
		
		JLabel lblQuantidadeDeDoses = new JLabel("Quantidade de Doses");
		lblQuantidadeDeDoses.setForeground(new Color(255, 255, 255));
		lblQuantidadeDeDoses.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuantidadeDeDoses.setBounds(155, 150, 158, 20);
		contentPane.add(lblQuantidadeDeDoses);
		
		JComboBox periodoBox_1 = new JComboBox();
		periodoBox_1.setModel(new DefaultComboBoxModel(new String[] {"14","28", "21", "0"}));
		periodoBox_1.setBounds(283, 98, 66, 28);
		contentPane.add(periodoBox_1);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroVacina.this.dispose();
				
			}
		});
		btnSair.setFont(new Font("Arial", Font.BOLD, 12));
		btnSair.setBackground(SystemColor.textHighlightText);
		btnSair.setBounds(101, 250, 115, 29);
		contentPane.add(btnSair);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idvacina =Integer.parseInt(JOptionPane.showInputDialog("Carteira do Sus?"));
				String vacina = vacinaField.getText();
				int periodo=Integer.parseInt((String)periodoBox_1 .getSelectedItem());
				int doses= Integer.parseInt((String)qtdDosesBox_1_1.getSelectedItem());
				Vacina v = new Vacina(vacina, periodo, doses,idvacina);
					v.setIdvacina(idvacina);
					v.setVacina(vacina);
					v.setPeriodo(periodo);
					v.setQtdDoses(doses);
					v.atualizar();
					dispose();
				
	
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(246, 250, 103, 29);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vacina = vacinaField.getText();
				int periodo=Integer.parseInt((String)periodoBox_1 .getSelectedItem());
				int doses= Integer.parseInt((String)qtdDosesBox_1_1.getSelectedItem());
				Vacina v = new Vacina(vacina, periodo, doses, doses);
					v.setVacina(vacina);
					v.setPeriodo(periodo);
					v.setQtdDoses(doses);
					v.inserir();
					JOptionPane.showMessageDialog(btnCadastrar,"Vacina cadastrada com sucesso!");
					
					
					
			}
		});
		btnCadastrar.setBounds(374, 250, 115, 29);
		contentPane.add(btnCadastrar);
		
		TextField idvacina = new TextField();
		idvacina.setEditable(false);
		idvacina.setBounds(283, 10, 24, 22);
		contentPane.add(idvacina);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("Arial", Font.BOLD, 12));
		id.setForeground(new Color(255, 255, 255));
		id.setBounds(218, 10, 46, 14);
		contentPane.add(id);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lu99-\\eclipse-workspace\\icons\\fundo-abstrato-colorido_23-2148807053.jpg"));
		lblNewLabel.setBounds(0, -11, 609, 373);
		contentPane.add(lblNewLabel);
	}
}
