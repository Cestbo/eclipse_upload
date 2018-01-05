package frame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import cn.company.factory.DAOFactory;
import cn.company.vo.Administrator;
import cn.company.vo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("本科生信息管理系统");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5E10\u53F7");
		lblNewLabel.setBounds(134, 80, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(134, 129, 54, 15);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setBounds(198, 77, 111, 21);
		contentPane.add(id);
		id.setColumns(10);

		password = new JPasswordField();
		password.setBounds(198, 126, 111, 21);
		contentPane.add(password);
		password.setColumns(10);

		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = null;
				Administrator administrator = null;

				try {
					
					administrator = DAOFactory.IAdministratorDAO().getAdministratorByName(id.getText());
					String string=new String(password.getPassword());
					if (string.equals(administrator.getAd_password().trim()))
						{new AdFrame(administrator).setVisible(true);
						    
						}
					else JOptionPane.showMessageDialog(Login.this, "密码错误！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					try {
						user = DAOFactory.getIUserDAOInstance().getUserByUser_id(id.getText());
						if (String.valueOf(password.getPassword()).equals(user.getUser_password().trim())) 
							new UserFrame(user).setVisible(true);
						else JOptionPane.showMessageDialog(Login.this, "密码错误！", "提示", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(Login.this, "不存在该帐号！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}

				}
				
			}
		});
		btnNewButton.setBounds(172, 195, 93, 23);
		contentPane.add(btnNewButton);
	}
}
