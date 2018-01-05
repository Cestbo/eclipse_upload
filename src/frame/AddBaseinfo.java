package frame;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import cn.company.factory.DAOFactory;
import cn.company.formBean.StudentRegist;
import cn.company.vo.Academy;
import cn.company.vo.Department;
import cn.company.vo.Student;
import cn.company.vo.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class AddBaseinfo extends JDialog {

	private JPanel contentPane;
	private JTextField SNoText;
	private JTextField SNameText;
	private JComboBox<String> SexText;
	private JTextField SPhoneNumText;
	private JTextField Enter_DateText;
	private JTextField BirthdayText;
	private JTextField MidSchText;
	private JTextField ExaScoreText;
	private JTextField IdcardText;
	private JLabel ANo;
	private JLabel DNo;
	private JLabel BuildingNum;
	private JComboBox<String> BuildingText;
	private JComboBox<String> RoomText;
	private JLabel qqNum;
	private JTextField QQText;
	private JComboBox<String> DName;
	private JComboBox<String> AName;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public AddBaseinfo() {
		setTitle("\u5F55\u5165\u57FA\u672C\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setModal(true);

		JLabel SNo = new JLabel("\u5B66\u53F7");
		SNo.setBounds(30, 31, 54, 15);
		contentPane.add(SNo);

		JLabel name = new JLabel("\u59D3\u540D");
		name.setBounds(30, 56, 54, 15);
		contentPane.add(name);

		JLabel sex = new JLabel("\u6027\u522B");
		sex.setBounds(30, 81, 54, 15);
		contentPane.add(sex);

		JLabel SPhoneNum = new JLabel("\u7535\u8BDD");
		SPhoneNum.setBounds(30, 156, 54, 15);
		contentPane.add(SPhoneNum);

		JLabel Enter_Date = new JLabel("\u5165\u5B66\u65E5\u671F");
		Enter_Date.setBounds(30, 181, 54, 15);
		contentPane.add(Enter_Date);

		JLabel birthday = new JLabel("\u751F\u65E5");
		birthday.setBounds(30, 206, 54, 15);
		contentPane.add(birthday);

		JLabel MidSch = new JLabel("\u6BD5\u4E1A\u9AD8\u6821");
		MidSch.setBounds(30, 231, 54, 15);
		contentPane.add(MidSch);

		JLabel ExScore = new JLabel("\u9AD8\u8003\u5206\u6570");
		ExScore.setBounds(30, 256, 54, 15);
		contentPane.add(ExScore);

		JLabel idcard = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		idcard.setBounds(30, 284, 54, 15);
		contentPane.add(idcard);

		JLabel RoomNum = new JLabel("门牌号");
		RoomNum.setBounds(30, 334, 54, 15);
		contentPane.add(RoomNum);

		SNoText = new JTextField();
		SNoText.setBounds(121, 28, 126, 21);
		contentPane.add(SNoText);
		SNoText.setColumns(10);

		SNameText = new JTextField();
		SNameText.setColumns(10);
		SNameText.setBounds(121, 53, 126, 21);
		contentPane.add(SNameText);

		SexText = new JComboBox<String>();
		SexText.addItem("男");
		SexText.addItem("女");
		SexText.setBounds(121, 78, 126, 21);
		contentPane.add(SexText);

		SPhoneNumText = new JTextField();
		SPhoneNumText.setColumns(10);
		SPhoneNumText.setBounds(121, 153, 126, 21);
		contentPane.add(SPhoneNumText);

		Enter_DateText = new JTextField("1990-01-01");
		Enter_DateText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Enter_DateText.setText(null);
			}
		});
		Enter_DateText.setColumns(10);
		Enter_DateText.setBounds(121, 178, 126, 21);
		contentPane.add(Enter_DateText);

		BirthdayText = new JTextField("1990-01-01");
		BirthdayText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				BirthdayText.setText(null);
			}
		});
		BirthdayText.setColumns(10);
		BirthdayText.setBounds(121, 203, 126, 21);
		contentPane.add(BirthdayText);

		MidSchText = new JTextField();
		MidSchText.setColumns(10);
		MidSchText.setBounds(121, 228, 126, 21);
		contentPane.add(MidSchText);

		ExaScoreText = new JTextField();
		ExaScoreText.setColumns(10);
		ExaScoreText.setBounds(121, 253, 126, 21);
		contentPane.add(ExaScoreText);

		IdcardText = new JTextField();
		IdcardText.setColumns(10);
		IdcardText.setBounds(121, 281, 126, 21);
		contentPane.add(IdcardText);

		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 添加用户

				String DNo2 = null;
				String ANo2 = null;
				try {
					DNo2 = DAOFactory.getIDepartmentDAOInstance().getDNoByDname((String) DName.getSelectedItem());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ANo2 = DAOFactory.getIAcademyDAOInstance().getANoByAName((String) AName.getSelectedItem());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

//				if (SNoText.getText().length() > 5 || !isNumeric(SNoText.getText()))
//					JOptionPane.showMessageDialog(AddBaseinfo.this, "格式存在错误", "提示", JOptionPane.INFORMATION_MESSAGE);
//				else {
					StudentRegist regist = new StudentRegist(SNoText.getText(), null, DNo2, (String)RoomText.getSelectedItem(),
							(String)BuildingText.getSelectedItem(), ANo2, (String) SexText.getSelectedItem(), SNameText.getText(),
							Enter_DateText.getText(), SPhoneNumText.getText(), BirthdayText.getText(),
							MidSchText.getText(), ExaScoreText.getText(), IdcardText.getText(), "", QQText.getText());
					if (!regist.isLeagal()) {
						String message = "";
						
							message = regist.getErrors().toString();
						
						JOptionPane.showMessageDialog(AddBaseinfo.this, message, "提示", JOptionPane.INFORMATION_MESSAGE);
					} else {

						
							Student student = null;

							student = new Student(SNoText.getText(), null, DNo2, (String)RoomText.getSelectedItem(),
									(String)BuildingText.getSelectedItem(), ANo2, (String) SexText.getSelectedItem(),
									SNameText.getText(), Date.valueOf(Enter_DateText.getText()),
									SPhoneNumText.getText(), Date.valueOf(BirthdayText.getText()), MidSchText.getText(),
									ExaScoreText.getText(), IdcardText.getText(), "", QQText.getText());

							User user = new User(SNoText.getText(), "888888");
							
								try {
									
									DAOFactory.getIStudentDAOInstance().add(student);
									DAOFactory.getIUserDAOInstance().add(user);

JOptionPane.showMessageDialog(AddBaseinfo.this, "添加成功", "提示",
										JOptionPane.INFORMATION_MESSAGE);
								} 
								 catch (Exception e1) {
									// TODO Auto-generated catch block
									 JOptionPane.showMessageDialog(AddBaseinfo.this, "存在该学生", "提示",
												JOptionPane.INFORMATION_MESSAGE);
								}
						
					}
				//}
			}
		});
		button.setBounds(84, 401, 93, 23);
		contentPane.add(button);

		ANo = new JLabel("\u6240\u5C5E\u5B66\u9662");
		ANo.setBounds(30, 106, 54, 15);
		contentPane.add(ANo);

		DNo = new JLabel("\u4E13\u4E1A");
		DNo.setBounds(30, 131, 54, 15);
		contentPane.add(DNo);

		BuildingNum = new JLabel("\u697C\u680B\u53F7");
		BuildingNum.setBounds(30, 309, 54, 15);
		contentPane.add(BuildingNum);

		BuildingText = new JComboBox<String>();
		
		BuildingText.setBounds(121, 306, 126, 21);
		contentPane.add(BuildingText);
		List<String> bnum=null;
		try {
			bnum=DAOFactory.getIDormitoryDAOInstance().getBuildingNums();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		for(int i=0;i<bnum.size();i++)
			BuildingText.addItem(bnum.get(i));
		BuildingText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RoomText.removeAllItems();
				List<String> rnum=null;
				try {
					rnum=DAOFactory.getIDormitoryDAOInstance().getRoomNumByBuildingNum((String)BuildingText.getSelectedItem());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=0;i<rnum.size();i++)
				{
					RoomText.addItem(rnum.get(i));
				}
			}
		});

		RoomText = new JComboBox<String>();
		RoomText.setBounds(121, 331, 126, 21);
		contentPane.add(RoomText);
		List<String> rnum=null;
		try {
			rnum=DAOFactory.getIDormitoryDAOInstance().getRoomNumByBuildingNum((String)BuildingText.getSelectedItem());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<rnum.size();i++)
		{
			RoomText.addItem(rnum.get(i));
		}

		qqNum = new JLabel("QQ");
		qqNum.setBounds(30, 359, 54, 15);
		contentPane.add(qqNum);

		QQText = new JTextField();
		QQText.setColumns(10);
		QQText.setBounds(121, 356, 126, 21);
		contentPane.add(QQText);

		AName = new JComboBox<String>();
		AName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 专业选项,由所选择的学院确定专业
				DName.removeAllItems();
				String ANo1 = null;
				try {

					ANo1 = DAOFactory.getIAcademyDAOInstance().getANoByAName((String) AName.getSelectedItem());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				List<Department> allDepart = null;
				try {
					allDepart = DAOFactory.getIDepartmentDAOInstance().findByANo(ANo1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (allDepart != null) {
					for (int i = 0; i < allDepart.size(); i++) {
						DName.addItem(allDepart.get(i).getDname());
					}

				}
			}
		});
		AName.setBounds(121, 103, 126, 21);
		contentPane.add(AName);

		DName = new JComboBox<String>();
		DName.setBounds(121, 128, 126, 21);
		contentPane.add(DName);
		// 学院选项
		List<Academy> allAcad = null;
		try {
			allAcad = DAOFactory.getIAcademyDAOInstance().findAll("");

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (allAcad != null) {
			for (int i = 0; i < allAcad.size(); i++) {
				AName.addItem(allAcad.get(i).getAName());
			}

		}

	}
}
