

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRelatorio {

	private JFrame frame;
	private JTable table;
	private JButton btnSair;
	private JButton btnOK;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio window = new TelaRelatorio();
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
	public TelaRelatorio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "E-mail", "N\u00BA Celular", "N\u00BA Dose", "Data de Vacina\u00E7\u00E3o"},
				{"Jo\u00E3o Batista da Silva", "joao@gmail.com", "(11) 93244-3422", "1", "19/05/2021"},
				{"Cristina Maria Santos", "cristina@gmail.com", "(11) 93442-4323", "1", "19/05/2021"},
				{"Ismael  Jose Santato", "ismael@hotmail.com", "(11) 93445-6421", "2", "01/06/2021"},
				{"Emanuel de Lima Silva", "emanuel@gmail.com", "(11) 96753-0943", "2", "01/06/2021"},
				{"Claudio Andrade Bento", "claudio33@hotmail.com", "(11)98943-4523", "1", "20/06/2021"},
				{"Maria Rosalina Batista", "marirosalina@gmail.com", "(11)95454-0084", "2", "20/06/2021"},
				{"Rogerio Santos Lins", "rogerio@hotmail.com", "(11)96647-9453", "1", "01/07/2021"},
			},
			new String[] {
				"Nome", "E-mail", "N\u00BA Celular", "1\u00BA ou 2\u00BA Dose", "Data"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setBounds(10, 87, 582, 128);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Relat\u00F3rio de Vacina\u00E7\u00E3o");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 56, 218, 20);
		frame.getContentPane().add(lblNewLabel);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSair.setFont(new Font("Arial", Font.BOLD, 12));
		btnSair.setBounds(113, 287, 115, 29);
		frame.getContentPane().add(btnSair);
		
		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Arial", Font.BOLD, 12));
		btnOK.setBounds(333, 287, 115, 29);
		frame.getContentPane().add(btnOK);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lu99-\\eclipse-workspace\\icons\\fundo-abstrato-colorido_23-2148807053.jpg"));
		lblNewLabel_1.setBounds(0, 0, 635, 357);
		frame.getContentPane().add(lblNewLabel_1);
	}
}