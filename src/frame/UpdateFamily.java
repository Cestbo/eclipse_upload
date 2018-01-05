package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.company.factory.DAOFactory;
import cn.company.vo.Family;
import cn.company.vo.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

public class UpdateFamily extends JDialog {

	private JPanel contentPane;
	private JTextField SNo;
	private JTextField father;
	private JTextField mother;
	private JTextField F_PNum;
	private JTextField M_PNum;
	private JTextField F_job;
	private JTextField textField_7;
	private JTextField M_job;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UpdateFamily() {
		setTitle("修改家庭信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setModal(true);

		JLabel SNo1 = new JLabel("请输入学号");
		JTextField SNoText1 = new JTextField();
		SNo1.setBounds(30, 31, 100, 15);
		SNoText1.setBounds(30, 56, 120, 20);
		JButton button = new JButton("确定");
		button.setBounds(120, 88, 60, 25);
		contentPane.add(SNo1);
		contentPane.add(SNoText1);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 根据学号获得家庭
				Family family = null;
				System.out.println(SNoText1.getText());
				try {
					family = DAOFactory.getIFamilyDAOInstance().findById(SNoText1.getText());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (family.getFamilyNum() == null) {
					JOptionPane.showMessageDialog(UpdateFamily.this, "不存在该学生或该学生是孤儿", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				} else

				{
					contentPane.updateUI();
					contentPane.removeAll();
					JLabel label = new JLabel("\u5B66\u53F7");
					label.setBounds(51, 30, 54, 15);
					contentPane.add(label);

					JLabel label_2 = new JLabel("\u5BB6\u5EAD\u5730\u5740");
					label_2.setBounds(51, 66, 54, 15);
					contentPane.add(label_2);

					JLabel label_3 = new JLabel("\u7236\u4EB2");
					label_3.setBounds(51, 170, 54, 15);
					contentPane.add(label_3);

					JLabel label_4 = new JLabel("\u6BCD\u4EB2");
					label_4.setBounds(51, 200, 54, 15);
					contentPane.add(label_4);

					JLabel label_5 = new JLabel("\u7236\u4EB2\u7535\u8BDD");
					label_5.setBounds(51, 230, 54, 15);
					contentPane.add(label_5);

					JLabel label_6 = new JLabel("\u6BCD\u4EB2\u7535\u8BDD");
					label_6.setBounds(51, 260, 54, 15);
					contentPane.add(label_6);

					JLabel label_7 = new JLabel("\u7236\u4EB2\u5DE5\u4F5C");
					label_7.setBounds(51, 290, 54, 15);
					contentPane.add(label_7);

					JLabel label_8 = new JLabel("\u6BCD\u4EB2\u5DE5\u4F5C");
					label_8.setBounds(51, 320, 54, 15);
					contentPane.add(label_8);

					JLabel lblNewLabel = new JLabel("\u662F\u5426\u72EC\u751F");
					lblNewLabel.setBounds(51, 350, 54, 15);
					contentPane.add(lblNewLabel);

					SNo = new JTextField();
					SNo.setBounds(143, 27, 122, 21);
					contentPane.add(SNo);
					SNo.setColumns(10);
					SNo.setText(family.getSNo());
					SNo.setEnabled(false);

					father = new JTextField();
					father.setColumns(10);
					father.setBounds(143, 167, 122, 21);
					contentPane.add(father);
					father.setText(family.getFather());

					mother = new JTextField();
					mother.setColumns(10);
					mother.setBounds(143, 197, 122, 21);
					contentPane.add(mother);
					mother.setText(family.getMother());

					F_PNum = new JTextField();
					F_PNum.setColumns(10);
					F_PNum.setBounds(143, 227, 122, 21);
					contentPane.add(F_PNum);
					F_PNum.setText(family.getF_PNum());

					M_PNum = new JTextField();
					M_PNum.setColumns(10);
					M_PNum.setBounds(143, 257, 122, 21);
					contentPane.add(M_PNum);
					M_PNum.setText(family.getM_PNum());

					F_job = new JTextField();
					F_job.setColumns(10);
					F_job.setBounds(143, 287, 122, 21);
					contentPane.add(F_job);
					F_job.setText(family.getF_job());

					M_job = new JTextField();
					M_job.setColumns(10);
					M_job.setBounds(143, 317, 122, 21);
					contentPane.add(M_job);
					M_job.setText(family.getM_job());

					JTextArea address = new JTextArea();
					address.setBounds(51, 91, 213, 66);
					contentPane.add(address);
					address.setText(family.getAddress());

					JRadioButton isalone = new JRadioButton("\u662F");
					isalone.setBounds(144, 346, 46, 23);
					contentPane.add(isalone);

					JRadioButton notalone = new JRadioButton("\u5426");
					notalone.setBounds(201, 346, 63, 23);
					contentPane.add(notalone);

					ButtonGroup buttonGroup = new ButtonGroup();
					buttonGroup.add(notalone);
					buttonGroup.add(isalone);

					if (family.isIsAlone())
						isalone.setSelected(true);
					else
						notalone.setSelected(true);

					JButton button = new JButton("\u786E\u5B9A");
					button.setBounds(117, 396, 93, 23);
					contentPane.add(button);
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO 修改家庭信息
							Family family = new Family(SNo.getText(), SNo.getText(), father.getText(), mother.getText(),
									address.getText(), F_PNum.getText(), M_PNum.getText(), F_job.getText(),
									M_job.getText(), isalone.isSelected());
							try {
								DAOFactory.getIFamilyDAOInstance().update(family);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(UpdateFamily.this, "修改成功", "提示",
									JOptionPane.INFORMATION_MESSAGE);
						}

					});
				}
			}
		});

	}
}
