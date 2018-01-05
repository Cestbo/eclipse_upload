package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class asd extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton award;
	private JLabel label_1;
	private JTable table_1;
	private JButton punish;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asd frame = new asd();
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
	public asd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5956\u52B1");
		label.setBounds(10, 21, 31, 15);
		contentPane.add(label);
		
		table = new JTable();
		table.setBounds(51, 21, 296, 86);
		contentPane.add(table);
		
		award = new JButton("\u00D7");
		award.setBounds(357, 54, 45, 30);
		contentPane.add(award);
		
		label_1 = new JLabel("\u60E9\u7F5A");
		label_1.setBounds(10, 134, 31, 15);
		contentPane.add(label_1);
		
		table_1 = new JTable();
		table_1.setBounds(51, 134, 296, 86);
		contentPane.add(table_1);
		
		punish = new JButton("\u00D7");
		punish.setBounds(357, 162, 45, 30);
		contentPane.add(punish);
	}
}
