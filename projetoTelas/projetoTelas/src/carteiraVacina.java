import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class carteiraVacina extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carteiraVacina frame = new carteiraVacina();
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
	public carteiraVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaVacina = new JLabel("NOME DA VACINA");
		lblNomeDaVacina.setForeground(new Color(255, 255, 255));
		lblNomeDaVacina.setBackground(Color.WHITE);
		lblNomeDaVacina.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeDaVacina.setBounds(143, 63, 127, 20);
		contentPane.add(lblNomeDaVacina);
		
		JLabel lblNumerodeDoses = new JLabel("N\u00DAMERO DE DOSES");
		lblNumerodeDoses.setForeground(new Color(255, 255, 255));
		lblNumerodeDoses.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumerodeDoses.setBounds(143, 115, 184, 20);
		contentPane.add(lblNumerodeDoses);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 2, 1));
		spinner.setBounds(326, 113, 37, 26);
		contentPane.add(spinner);
		
		JButton btnCadastrarVacina = new JButton("Cadastrar");
		btnCadastrarVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrarVacina.setBackground(SystemColor.textHighlightText);
		btnCadastrarVacina.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrarVacina.setBounds(72, 265, 151, 29);
		contentPane.add(btnCadastrarVacina);
		
		JButton bntSair = new JButton("Sair");
		bntSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carteiraVacina.this.dispose();
			}
		});
		bntSair.setBackground(SystemColor.textHighlightText);
		bntSair.setFont(new Font("Arial", Font.BOLD, 12));
		bntSair.setBounds(417, 264, 120, 30);
		contentPane.add(bntSair);
		
		JComboBox TipoVacina = new JComboBox();
		TipoVacina.setModel(new DefaultComboBoxModel(new String[] {"Pfizer    ", "CoronaVac   ", "AstraZeneca", "Jhonson&Jhonson", "Janssen", "Moderna", "Sputnik V", "Covaxin"}));
		TipoVacina.setBounds(312, 60, 127, 28);
		contentPane.add(TipoVacina);
		
		JLabel lblDataDeVacinacao = new JLabel("Data da  1\u00BA vacina");
		lblDataDeVacinacao.setForeground(new Color(255, 255, 255));
		lblDataDeVacinacao.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataDeVacinacao.setBounds(155, 161, 140, 20);
		contentPane.add(lblDataDeVacinacao);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1620097200000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(190, 192, 80, 26);
		contentPane.add(spinner_1);
		
		JLabel lblDataProximaDose = new JLabel("Data da 2\u00BA vacina");
		lblDataProximaDose.setForeground(new Color(255, 255, 255));
		lblDataProximaDose.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataProximaDose.setBounds(347, 162, 140, 20);
		contentPane.add(lblDataProximaDose);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerDateModel(new Date(1620097200000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_2.setBounds(358, 192, 81, 26);
		contentPane.add(spinner_2);
		
		JButton btnAlterar_1 = new JButton("Alterar");
		btnAlterar_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlterar_1.setBackground(Color.WHITE);
		btnAlterar_1.setBounds(261, 264, 120, 30);
		contentPane.add(btnAlterar_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lu99-\\eclipse-workspace\\icons\\fundo-abstrato-colorido_23-2148807053.jpg"));
		lblNewLabel.setBounds(0, 0, 607, 356);
		contentPane.add(lblNewLabel);
	}
}
