package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.company.factory.DAOFactory;
import cn.company.vo.Award;
import cn.company.vo.Family;
import cn.company.vo.Punishment;
import cn.company.vo.Student;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentInfo extends JDialog {

	private JPanel contentPane;
	private JTable infotable;
	private JTable familytable;
	private JTable awardtable;
	private JTextField SNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo frame = new StudentInfo();
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
	public StudentInfo() {
		setTitle("\u67E5\u8BE2\u5B66\u751F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setModal(true);

		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 先保存学号
				String SNo3 = null;
				SNo3 = SNo.getText();
				Student student = null;
				try {
					student = DAOFactory.getIStudentDAOInstance().getStudentBySNo(SNo3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
                     System.out.println(e1);
				}
				if (student.getSNo() == null) {
					JOptionPane.showMessageDialog(StudentInfo.this, "不存在该学生", "提示", JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					contentPane.updateUI();
					contentPane.removeAll();
					JLabel label = new JLabel("\u5B66\u751F\u57FA\u672C\u4FE1\u606F");
					label.setBounds(39, 24, 99, 15);
					contentPane.add(label);

					// 学生基本信息显示

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
					String header[] = { "学号", "姓名", "性别", "所属学院", "专业", "电话", "入学日期", "生日", "毕业高校", "高考分数", "身份证号",
							"楼栋号", "门牌号", "QQ" };
					DefaultTableModel model = new DefaultTableModel(objects, header) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};

					infotable = new JTable(model);
					JScrollPane info = new JScrollPane(infotable);
					info.setBounds(39, 61, 550, 60);
					infotable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					contentPane.add(info);

					JLabel label_1 = new JLabel("\u5B66\u751F\u5BB6\u5EAD\u60C5\u51B5");
					label_1.setBounds(39, 150, 80, 15);
					contentPane.add(label_1);

					// 家庭信息
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
						objects1[0][7] = "是";
					else
						objects1[0][7] = "否";
					}
					String header1[] = { "家庭地址", "父亲", "母亲", "父亲电话", "母亲电话", "父亲工作", "母亲工作", "是否独生" };
					DefaultTableModel model1 = new DefaultTableModel(objects1, header1) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};

					familytable = new JTable(model1);
					familytable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					JScrollPane family = new JScrollPane(familytable);
					family.setBounds(39, 182, 550, 63);
					contentPane.add(family);

					// 奖惩
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
					String header2[] = { "奖励编号", "奖励描述", "奖励金额", "获奖日期", "惩罚编号", "惩罚描述", "惩罚日期" };
					DefaultTableModel model2 = new DefaultTableModel(objects2, header2) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					awardtable = new JTable(model2);
					awardtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					JScrollPane award1 = new JScrollPane(awardtable);
					award1.setBounds(39, 290, 550, 80);
					contentPane.add(award1);
				}
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		button.setBounds(264, 288, 96, 43);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(149, 78, 353, 269);
		contentPane.add(panel);
		panel.setLayout(null);
		
				SNo = new JTextField();
				SNo.setFont(new Font("宋体", Font.PLAIN, 17));
				SNo.setBounds(51, 99, 272, 61);
				panel.add(SNo);
				SNo.setColumns(10);
				
						JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5B66\u53F7");
						lblNewLabel.setBounds(51, 22, 272, 61);
						panel.add(lblNewLabel);
						lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 26));

	}
}
