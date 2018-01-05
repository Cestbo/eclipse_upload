package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import cn.company.factory.DAOFactory;
import cn.company.vo.Administrator;
import cn.company.vo.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePassword extends JDialog {

	private JPanel contentPane;
	private JTextField newPass;
	private JTextField surePass;
	Administrator administrator;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UpdatePassword(Administrator ad) {
		setTitle("\u66F4\u6539\u5BC6\u7801");
		administrator=ad;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setModal(true);
		
		JLabel label = new JLabel("\u65B0\u5BC6\u7801");
		label.setBounds(99, 79, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u786E\u5B9A\u65B0\u5BC6\u7801");
		label_1.setBounds(99, 127, 71, 15);
		contentPane.add(label_1);
		
		newPass = new JPasswordField();
		newPass.setBounds(202, 76, 107, 21);
		contentPane.add(newPass);
		newPass.setColumns(10);
		
		surePass = new JPasswordField();
		surePass.setBounds(202, 124, 107, 21);
		contentPane.add(surePass);
		surePass.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newPass.getText().equals(surePass.getText()))
				{
				Administrator ad1=administrator;
				ad1.setAd_password(newPass.getText());
				try {
					DAOFactory.IAdministratorDAO().updatePassword(ad1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(UpdatePassword.this, "更改成功", "提示", 
						JOptionPane.INFORMATION_MESSAGE);
				}
				else
					
			    	JOptionPane.showMessageDialog(UpdatePassword.this, "两次输入不同", "提示", 
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setBounds(171, 197, 93, 23);
		contentPane.add(button);
	}
}
