package frame;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.company.factory.DAOFactory;
import cn.company.vo.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DeleteStu extends JDialog {

	private JPanel contentPane;
	private JTextField SNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStu frame = new DeleteStu();
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
	public DeleteStu() {
		setTitle("\u5220\u9664\u5B66\u751F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setModal(true);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(92, 59, 240, 137);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5B66\u53F7");
		label.setBounds(30, 28, 81, 15);
		panel.add(label);

		SNo = new JTextField();
		SNo.setBounds(56, 63, 129, 21);
		panel.add(SNo);
		SNo.setColumns(10);

		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = SNo.getText();
				Student student = null;
				try {
					student = DAOFactory.getIStudentDAOInstance().getStudentBySNo(sno);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();

				}
				// 获取学生信息
				if (student.getSNo() == null)
					JOptionPane.showMessageDialog(DeleteStu.this, "不存在该学生", "提示", JOptionPane.INFORMATION_MESSAGE);
				else {
					contentPane.updateUI();
					contentPane.removeAll();

					Object[][] objects = new Object[1][14];
					objects[0][0] = student.getSNo();
					objects[0][1] = student.getName();
					objects[0][2] = student.getSex();
					objects[0][3] = student.getANo();
					objects[0][4] = student.getDNo();
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
					JTable table = new JTable(model);
					JScrollPane jScrollPane = new JScrollPane(table);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					jScrollPane.setBounds(57, 73, 327, 100);
					contentPane.add(jScrollPane);

					JButton button1 = new JButton("\u786E\u8BA4\u5220\u9664");
					button1.setBounds(174, 210, 93, 23);
					contentPane.add(button1);
					button1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							try {
								DAOFactory.getIStudentDAOInstance().deleteById(sno);
								DAOFactory.getIUserDAOInstance().delete(sno);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							model.removeRow(0);
							JOptionPane.showMessageDialog(DeleteStu.this, "删除成功", "提示",
									JOptionPane.INFORMATION_MESSAGE);
						}
					});

					JLabel label1 = new JLabel("\u8BE5\u7528\u6237\u4FE1\u606F");
					label1.setFont(new Font("宋体", Font.PLAIN, 18));
					label1.setBounds(33, 22, 164, 41);
					contentPane.add(label1);
				}
			}
		});
		button.setBounds(88, 104, 71, 23);
		panel.add(button);
	}
}
