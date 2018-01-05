package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.company.factory.DAOFactory;
import cn.company.vo.Award;
import cn.company.vo.Punishment;
import cn.company.vo.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DeleteAwardorPunish extends JDialog {

	private JPanel contentPane;
	private JTextField SNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAwardorPunish frame = new DeleteAwardorPunish();
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
	public DeleteAwardorPunish() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("删除奖惩");
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
				// 获取学生信息
				Student stu1 = null;
				try {
					stu1 = DAOFactory.getIStudentDAOInstance().getStudentBySNo(sno);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (stu1.getSNo() == null)
					JOptionPane.showMessageDialog(DeleteAwardorPunish.this, "不存在该学生", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				else {
					contentPane.updateUI();
					contentPane.removeAll();

					JLabel label = new JLabel("\u5956\u52B1");
					label.setBounds(10, 21, 31, 15);
					contentPane.add(label);

					List<Award> award1 = null;
					try {
						award1 = DAOFactory.getIAwardDAOInstance().findBySNo(sno);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int index = award1.size();

					Object[][] objects1 = new Object[index][4];
					if (award1 != null) {
						for (int i = 0; i < award1.size(); i++) {
							objects1[i][0] = award1.get(i).getAwardNum();
							objects1[i][1] = award1.get(i).getAwardText();
							objects1[i][2] = award1.get(i).getMoney();
							objects1[i][3] = award1.get(i).getA_Date();
						}
					}
					String header1[] = { "编号", "描述", "金额", "获奖日期" };
					DefaultTableModel model = new DefaultTableModel(objects1, header1) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					JTable table = new JTable(model);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					JScrollPane aw = new JScrollPane(table);
					aw.setBounds(51, 21, 296, 86);
					contentPane.add(aw);

					JButton award = new JButton("\u00D7");
					award.setBounds(357, 54, 45, 30);
					contentPane.add(award);
					award.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub

							int currentRow = table.getSelectedRow();
							if (currentRow == -1) {
								JOptionPane.showMessageDialog(DeleteAwardorPunish.this, "请先选择一行", "提示",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								try {
									DAOFactory.getIAwardDAOInstance()
											.deleteById((String) table.getValueAt(currentRow, 0));
									System.out.println(table.getValueAt(currentRow, 0));
									model.removeRow(currentRow);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					});

					JLabel label_1 = new JLabel("\u60E9\u7F5A");
					label_1.setBounds(10, 134, 31, 15);
					contentPane.add(label_1);

					List<Punishment> punishment = null;
					try {
						punishment = DAOFactory.getIPunishmentDAOInstance().findAll(sno);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int index1 = punishment.size();

					Object[][] objects2 = new Object[index1][3];

					if (punishment != null) {
						for (int j = 0; j < punishment.size(); j++) {
							objects2[j][0] = punishment.get(j).getPno();
							objects2[j][1] = punishment.get(j).getPText();
							objects2[j][2] = punishment.get(j).getP_Date();
						}
					}
					String header2[] = { "编号", "描述", "获奖日期" };
					DefaultTableModel model2 = new DefaultTableModel(objects2, header2) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					JTable table_1 = new JTable(model2);
					table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					JScrollPane pu = new JScrollPane(table_1);
					pu.setBounds(51, 134, 296, 86);
					contentPane.add(pu);

					JButton punish = new JButton("\u00D7");
					punish.setBounds(357, 162, 45, 30);
					contentPane.add(punish);
					punish.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub

							int currentRow = table_1.getSelectedRow();
							if (currentRow == -1) {
								JOptionPane.showMessageDialog(DeleteAwardorPunish.this, "请先选择一行", "提示",
										JOptionPane.INFORMATION_MESSAGE);
							} else {// 用户为管理员
								try {
									DAOFactory.getIPunishmentDAOInstance()
											.deleteById((String) table_1.getValueAt(currentRow, 0));
									System.out.println(table_1.getValueAt(currentRow, 0));
									model2.removeRow(currentRow);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					});

				}
			}
		});

		button.setBounds(88, 104, 71, 23);
		panel.add(button);
	}
}
