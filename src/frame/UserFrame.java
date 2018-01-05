package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.company.factory.DAOFactory;
import cn.company.vo.Award;
import cn.company.vo.Family;
import cn.company.vo.Punishment;
import cn.company.vo.Student;
import cn.company.vo.User;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField NewPassword;
	private JTextField surePassword;
	private User u1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserFrame(User user) {
		setTitle("\u5B66\u751F\u7528\u6237\u754C\u9762");
		
	    u1 = user;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 480);
		

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u529F\u80FD\u83DC\u5355");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.updateUI();
				contentPane.removeAll();
				JLabel label = new JLabel("\u5B66\u751F\u57FA\u672C\u4FE1\u606F");
				label.setBounds(39, 24, 99, 15);
				contentPane.add(label);

				String SNo3 = null;
				SNo3 = user.getUser_id();
				// ѧ��������Ϣ��ʾ
				Student student = null;
				try {
					student = DAOFactory.getIStudentDAOInstance().getStudentBySNo(SNo3);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Object[][] objects = new Object[1][14];
				objects[0][0] = student.getSNo();
				objects[0][1] = student.getName();
				objects[0][2] = student.getSex();
				try {
					objects[0][3] = DAOFactory.getIAcademyDAOInstance().getANameByANo(student.getANo());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					objects[0][4] = DAOFactory.getIDepartmentDAOInstance().getDnameByDNo(student.getDNo());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				objects[0][5] = student.getSphoneNum();
				objects[0][6] = student.getEnter_Date();
				objects[0][7] = student.getBirthday();
				objects[0][8] = student.getMidSch();
				objects[0][9] = student.getExScore();
				objects[0][10] = student.getIdcard();
				objects[0][11] = student.getBuildingNum();
				objects[0][12] = student.getRoomNum();
				objects[0][13] = student.getQqNum();
				String header[] = { "ѧ��", "����", "�Ա�", "����ѧԺ", "רҵ", "�绰", "��ѧ����", "����", "��ҵ��У", "�߿�����", "���֤��", "¥����",
						"���ƺ�", "QQ" };
				DefaultTableModel model = new DefaultTableModel(objects, header) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};

				JTable infotable = new JTable(model);
				JScrollPane info = new JScrollPane(infotable);
				info.setBounds(39, 61, 550, 60);
				infotable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				contentPane.add(info);

				JLabel label_1 = new JLabel("\u5B66\u751F\u5BB6\u5EAD\u60C5\u51B5");
				label_1.setBounds(39, 150, 80, 15);
				contentPane.add(label_1);

				// ��ͥ��Ϣ
				Family family4 = null;
				try {
					family4 = DAOFactory.getIFamilyDAOInstance().findById(SNo3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Object[][] objects1 = new Object[1][8];
				if(family4.getFamilyNum()!=null)
				{
				objects1[0][0] = family4.getAddress();
				objects1[0][1] = family4.getFather();
				objects1[0][2] = family4.getMother();
				objects1[0][3] = family4.getF_PNum();
				objects1[0][4] = family4.getM_PNum();
				objects1[0][5] = family4.getF_job();
				objects1[0][6] = family4.getM_job();
				if (family4.isIsAlone())
					objects1[0][7] = "��";
				else
					objects1[0][7] = "��";
				}
				String header1[] = { "��ͥ��ַ", "����", "ĸ��", "���׵绰", "ĸ�׵绰", "���׹���", "ĸ�׹���", "�Ƿ����" };
				DefaultTableModel model1 = new DefaultTableModel(objects1, header1) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};

				JTable familytable = new JTable(model1);
				familytable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				JScrollPane family = new JScrollPane(familytable);
				family.setBounds(39, 182, 550, 63);
				contentPane.add(family);

				// ����
				JLabel label_2 = new JLabel("\u5B66\u751F\u5956\u60E9\u60C5\u51B5");
				label_2.setBounds(39, 260, 80, 15);
				contentPane.add(label_2);

				List<Award> award = null;
				List<Punishment> punishment = null;
				try {
					award = DAOFactory.getIAwardDAOInstance().findBySNo(SNo3);
					punishment = DAOFactory.getIPunishmentDAOInstance().findAll(SNo3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int index = award.size();
				if (index < punishment.size())
					index = punishment.size();

				Object[][] objects2 = new Object[index][7];
				if (award != null) {
					for (int i = 0; i < award.size(); i++) {
						objects2[i][0] = award.get(i).getAwardNum();
						objects2[i][1] = award.get(i).getAwardText();
						objects2[i][2] = award.get(i).getMoney();
						objects2[i][3] = award.get(i).getA_Date();
					}
				}
				if (punishment != null) {
					for (int j = 0; j < punishment.size(); j++) {
						objects2[j][4] = punishment.get(j).getPno();
						objects2[j][5] = punishment.get(j).getPText();
						objects2[j][6] = punishment.get(j).getP_Date();
					}
				}
				String header2[] = { "�������", "��������", "�������", "������", "�ͷ����", "�ͷ�����", "�ͷ�����" };
				DefaultTableModel model2 = new DefaultTableModel(objects2, header2) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				JTable awardtable = new JTable(model2);
				awardtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				JScrollPane award1 = new JScrollPane(awardtable);
				award1.setBounds(39, 290, 550, 80);
				contentPane.add(award1);
			}

		});
		menu.add(menuItem);
		// ��������
		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.updateUI();
				contentPane.removeAll();

				JPanel panel = new JPanel();
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBounds(140, 109, 329, 163);
				contentPane.add(panel);
				panel.setLayout(null);

				JLabel label = new JLabel("\u65B0\u5BC6\u7801");
				label.setBounds(34, 37, 73, 15);
				panel.add(label);

				JLabel label_1 = new JLabel("\u786E\u5B9A\u65B0\u5BC6\u7801");
				label_1.setBounds(34, 77, 73, 15);
				panel.add(label_1);

				NewPassword = new JPasswordField();
				NewPassword.setBounds(136, 34, 124, 21);
				panel.add(NewPassword);
				NewPassword.setColumns(10);

				surePassword = new JPasswordField();
				surePassword.setColumns(10);
				surePassword.setBounds(136, 74, 124, 21);
				panel.add(surePassword);

				JButton button = new JButton("\u786E\u5B9A");
				button.setBounds(126, 130, 93, 23);
				panel.add(button);
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						User u = user;
						user.setUser_password(NewPassword.getText());
						if (NewPassword.getText().equals(surePassword.getText())) {
							try {
								DAOFactory.getIUserDAOInstance().update(u);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(UserFrame.this, "���ĳɹ�", "��ʾ", 
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(UserFrame.this, "�������벻ͬ", "��ʾ", 
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
			}
		});
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
}
