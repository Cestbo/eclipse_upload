package frame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.company.factory.DAOFactory;

import cn.company.vo.Award;
import cn.company.vo.Punishment;
import cn.company.vo.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class AddAwardOrPunish extends JDialog {

	private JPanel contentPane;
	private JTextField SNo;
	private JTextField MoneyText;
	private JTextField AWardDate;
	private JTextField PunishDate;
	private JTextArea AwardText;
	private JTextArea PunishText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAwardOrPunish frame = new AddAwardOrPunish();
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
	public AddAwardOrPunish() {
		setTitle("\u5F55\u5165\u5956\u60E9\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setModal(true);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setBounds(89, 60, 54, 15);
		contentPane.add(label);
		
		SNo = new JTextField();
		SNo.setBounds(209, 57, 117, 21);
		contentPane.add(SNo);
		SNo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5956\u52B1\u63CF\u8FF0");
		lblNewLabel_1.setBounds(89, 90, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u5956\u52B1\u91D1\u989D");
		label_1.setBounds(89, 150, 54, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5956\u52B1\u65E5\u671F");
		lblNewLabel_2.setBounds(89, 180, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("\u60E9\u7F5A\u63CF\u8FF0");
		label_2.setBounds(89, 210, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u60E9\u7F5A\u65E5\u671F");
		label_3.setBounds(89, 279, 54, 15);
		contentPane.add(label_3);
		
		MoneyText = new JTextField();
		MoneyText.setColumns(10);
		MoneyText.setBounds(209, 147, 117, 21);
		contentPane.add(MoneyText);
		
		AWardDate = new JTextField("1990-01-01");
		AWardDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				AWardDate.setText(null);
			}
		});
		AWardDate.setColumns(10);
		AWardDate.setBounds(209, 177, 117, 21);
		contentPane.add(AWardDate);
		
		
		PunishDate = new JTextField("1990-01-01");
		PunishDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PunishDate.setText(null);
			}
		});
		PunishDate.setColumns(10);
		PunishDate.setBounds(209, 276, 117, 21);
		contentPane.add(PunishDate);
		
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Student st=null;
				    try {
						st=DAOFactory.getIStudentDAOInstance().getStudentBySNo(SNo.getText());
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				    if(st.getSNo()==null)
				    	JOptionPane.showMessageDialog(AddAwardOrPunish.this, "没有该学生", "提示", 
								JOptionPane.INFORMATION_MESSAGE);
				    else{
				int i=0,j=0;
				try {
					i = DAOFactory.getIAwardDAOInstance().getAwardSize();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (!AwardText.getText().equals("")) {
					Award a = new Award(String.valueOf(i++), SNo.getText(), AwardText.getText(),
							Integer.valueOf(MoneyText.getText()), Date.valueOf(AWardDate.getText()));
					try {
						DAOFactory.getIAwardDAOInstance().add(a);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
				try {
					j=DAOFactory.getIPunishmentDAOInstance().getPunishmentSize();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    if (!PunishText.getText().equals("")) {
					Punishment punishment = new Punishment(String.valueOf(j++), SNo.getText(), PunishText.getText(),
							Date.valueOf(PunishDate.getText()));
					//添加惩罚
					try {
						DAOFactory.getIPunishmentDAOInstance().add(punishment);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
				JOptionPane.showMessageDialog(AddAwardOrPunish.this, "添加成功", "提示", 
						JOptionPane.INFORMATION_MESSAGE);
			}
				    }
		});
		button.setBounds(156, 343, 93, 23);
		contentPane.add(button);
		
		AwardText = new JTextArea();
		AwardText.setBounds(208, 90, 216, 48);
		contentPane.add(AwardText);
		
		PunishText = new JTextArea();
		PunishText.setBounds(209, 206, 216, 48);
		contentPane.add(PunishText);
	}
}
