package frame;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;


public class admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton Userlist;
	private JButton AddUser;
	private JButton ModiUser;
	private JButton DelUser;
	private JButton UserInfo;
	private JButton btn_logout;
	private JPanel menu;
	private JPanel input;
	private JPanel panel;
	
	private static void InitGlobalFont(Font font) {  
		  FontUIResource fontRes = new FontUIResource(font);  
		  for (Enumeration<Object> keys = UIManager.getDefaults().keys();  
		  keys.hasMoreElements(); ) {  
		  Object key = keys.nextElement();  
		  Object value = UIManager.get(key);  
		  if (value instanceof FontUIResource)
		 	UIManager.put(key, fontRes);}
		  }	  
		  
	public admin(){
		
		setTitle("管理员--");
		
		setSize(720,400);
		setLocationRelativeTo(null);						//居中显示
		setResizable(false);								//不可更改大小
		InitGlobalFont(new Font("微软雅黑",Font.BOLD, 13));  //统一设置字体
	
		menu=new JPanel();
		input=new JPanel();
		panel=new JPanel();
		panel.setLayout(new BorderLayout());
		input.setLayout(null);
		
		Userlist =new JButton("用户列表");
		UserInfo =new JButton("用户信息");	
		AddUser = new JButton("添加用户");
		ModiUser = new JButton("更改用户");
		DelUser = new JButton("删除用户");
		btn_logout =new JButton("注销");
				
		menu.add(Userlist);	
		menu.add(UserInfo);
		menu.add(DelUser);
		menu.add(AddUser);
		menu.add(ModiUser);			
		menu.add(btn_logout);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.add(menu,BorderLayout.NORTH);
		panel.add(input,BorderLayout.CENTER);
		
		Userlist.addActionListener(new ActionListener() {   //用户列表
			private void userlist() {
				JTable table;
				JScrollPane scrollPane;
				JButton button1=new JButton("删除");
				JButton button2=new JButton("更改");
							
                 int uIndex = 20;
               
                 Object[][] list = new Object[uIndex][14];
                 for (int i = 0; i < uIndex; i++) {
                     list[i][0] = "getName()";
                     list[i][1] = "getPassword()";
                     list[i][2] = "getRole()";
                     
                 }
                 String header[] = {"用户名", "密码", "身份","sa","s","s","s","s","s","s","s","s","s","s"};
                 DefaultTableModel model = new DefaultTableModel(list,header) {
                     public boolean isCellEditable(int row, int column) {
                         return false;
                     }
                 };
                 table = new JTable(model);
                 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 scrollPane = new JScrollPane(table);          
                 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                 for(int i=0;i<14;i++)
                	 table.getColumnModel().getColumn(i).setPreferredWidth(100);
                 
                           	 
                 input.add(scrollPane);scrollPane.setBounds(150, 50, 400, 200);					
                 input.add(button1);button1.setBounds(250,280,80,30);
                 input.add(button2);button2.setBounds(350,280,80,30);
				
				setVisible(true);
				
					
				button1.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent e) {						
							try {
								int currentRow = table.getSelectedRow();
								if(currentRow == -1)
								{
									JOptionPane.showMessageDialog(admin.this, "请先选择一行", "提示", 
																			JOptionPane.INFORMATION_MESSAGE);								
								} else {//用户为管理员
									JOptionPane.showMessageDialog(admin.this, "此用户无法删除！","提示",
																				JOptionPane.INFORMATION_MESSAGE);
								}
							}
							 catch (Exception e1) {
								JOptionPane.showMessageDialog(admin.this, "数据库出错！","错误",
																		JOptionPane.ERROR_MESSAGE);
							}
						} 					
				});
				
				button2.addActionListener(new ActionListener() {
					public void modiuser(){
						int currentRow = table.getSelectedRow();
						if(currentRow == -1)
						{
							JOptionPane.showMessageDialog(admin.this, "请先选择一个用户！", "提示", 
																	JOptionPane.INFORMATION_MESSAGE);								
							userlist();
						}
						else {	
						
						JLabel label1=new JLabel("需更改的用户名：");
						JLabel label2=new JLabel("请 输 入 新 密码：");
						JLabel label3=new JLabel("请 输 入 新 身份：");
						
						JTextField textField1=new JTextField(20);
						textField1.setText("");		//设置为选择行的用户名					
						JTextField textField2=new JTextField(20);
						JComboBox<String> comboBox=new JComboBox<String>();
						comboBox.addItem("administrator");
						comboBox.addItem("user");
						comboBox.setSelectedItem("administrator");
									
						JButton modi=new JButton("更改");
						
						input.add(label1);label1.setBounds(200, 50, 120,20);
						input.add(textField1);textField1.setBounds(330, 50, 150,20);
						input.add(label2);label2.setBounds(200,80,120,20);
						input.add(textField2);textField2.setBounds(330, 80, 150,20);
						input.add(label3);label3.setBounds(200,110,120,20);
						input.add(comboBox);comboBox.setBounds(330, 110, 150,20);
						input.add(modi);modi.setBounds(300, 140, 100,30);
						setVisible(true);
						
						modi.addActionListener(new ActionListener() {
											 
							public void actionPerformed(ActionEvent e) {
								String name=textField1.getText();
								int currentRow = table.getSelectedRow();
								if(currentRow == -1){
									userlist();
									JOptionPane.showMessageDialog(admin.this, "请先选择一个用户！", "提示", 
																			JOptionPane.INFORMATION_MESSAGE);								
								}else if (textField1.equals("")||textField2.equals("")) {
									JOptionPane.showMessageDialog(admin.this,"请输入完整信息！","提示",
																					JOptionPane.INFORMATION_MESSAGE);}
								else {							
								String password=textField2.getText();								
								String role=(String) comboBox.getSelectedItem();
								try {
									if (name.equals("kate")&&!role.equals("administrator")) {
										comboBox.setSelectedItem("administrator");
										JOptionPane.showMessageDialog(admin.this, "此用户权限无法修改","提示",
																					JOptionPane.INFORMATION_MESSAGE);
									} else {
										//更改信息
										JOptionPane.showMessageDialog(admin.this,"更改用户信息成功！", "提示",
											JOptionPane.INFORMATION_MESSAGE);
									}
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(admin.this, "更改用户信息失败！","错误",
												JOptionPane.ERROR_MESSAGE);
									}					
							}}
						});
					}
					}
					public void actionPerformed(ActionEvent e) {																	
							panel.updateUI();
							input.removeAll();	
							modiuser();					
					}
				});
				
			}
			public void actionPerformed(ActionEvent e) {
				panel.updateUI();;
				input.removeAll();
				userlist();
			}
		});
		
		DelUser.addActionListener(new ActionListener() {    			//删除用户
			private void deluser() {
				JLabel label=new JLabel("请输入要删除的帐号：");
				JTextField text=new JTextField(20);
				JButton del=new JButton("删除");
				
				input.add(label);label.setBounds(150, 50,130, 20);
				input.add(text);text.setBounds(280,50, 150,20);				
				input.add(del);del.setBounds(450,50,80,20);
				
				setVisible(true);
				
				del.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						String name=text.getText();
						try {	
						if (name.equals("kate")) {
							JOptionPane.showMessageDialog(admin.this, "此用户无法删除！","错误",
																		JOptionPane.ERROR_MESSAGE);
						} 
						else if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(admin.this,
							"确认删除？", "询问", JOptionPane.YES_NO_OPTION)) {
						
							//deleteUser
JOptionPane.showMessageDialog(admin.this, "删除用户成功！", "提示",
																	JOptionPane.INFORMATION_MESSAGE);
}	
						}				
						catch (Exception e) {
							JOptionPane.showMessageDialog(admin.this, "删除用户失败！","错误",
																		JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
			}	
			public void actionPerformed(ActionEvent e) {
				panel.updateUI();
				input.removeAll();
				deluser();
			}
		});
		
		AddUser.addActionListener(new ActionListener() {					//添加用户
			public void adduser(){
				JLabel label1=new JLabel("请 输 入 新 账 号:");
				JLabel label2=new JLabel("请 输 入 新 密 码:");
				JLabel label3=new JLabel("请 选 择 新 身 份:");
				
				JTextField textField1=new JTextField(20);
				JTextField textField2=new JTextField(20);
				JComboBox<String> comboBox=new JComboBox<String>();
				comboBox.addItem("administrator");
				comboBox.addItem("user");
				comboBox.setSelectedItem("administrator");
				
				JButton add=new JButton("添加");
				
				input.add(label1);label1.setBounds(200, 50, 120,20);
				input.add(textField1);textField1.setBounds(330, 50, 150,20);
				input.add(label2);label2.setBounds(200,80,120,20);
				input.add(textField2);textField2.setBounds(330, 80, 150,20);
				input.add(label3);label3.setBounds(200,110,120,20);
				input.add(comboBox);comboBox.setBounds(330, 110, 150,20);
				input.add(add);add.setBounds(300, 140,100, 30);
				setVisible(true);
				
				add.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						String name=textField1.getText();
						String password=textField2.getText();
						String role=(String) comboBox.getSelectedItem();
						try {
							if (name.equals("")||password.equals("")) {
								JOptionPane.showMessageDialog(admin.this,"请输入完整信息！","错误",
																			JOptionPane.ERROR_MESSAGE);
							} else {
									JOptionPane.showMessageDialog(admin.this, "用户已存在！","错误",
																				JOptionPane.ERROR_MESSAGE);
							}								
						} catch (Exception e) {
							JOptionPane.showMessageDialog(admin.this, "用户添加失败！","错误",
																			JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						}
					}
				});
			}
			
			public void actionPerformed(ActionEvent e) {
				panel.updateUI();
				input.removeAll();
				adduser();
			}
		});
		
		ModiUser.addActionListener(new ActionListener() {
			public void modiuser(){
				JLabel label1=new JLabel("需更改的用户名：");
				JLabel label2=new JLabel("请 输 入 新 密码：");
				JLabel label3=new JLabel("请 输 入 新 身份：");
				
				JTextField textField1=new JTextField(20);
				JTextField textField2=new JTextField(20);
				JComboBox<String> comboBox=new JComboBox<String>();
				comboBox.addItem("administrator");
				comboBox.addItem("user");
				comboBox.setSelectedItem("administrator");
							
				JButton modi=new JButton("更改");
				
				input.add(label1);label1.setBounds(200, 50, 120,20);
				input.add(textField1);textField1.setBounds(330, 50, 150,20);
				input.add(label2);label2.setBounds(200,80,120,20);
				input.add(textField2);textField2.setBounds(330, 80, 150,20);
				input.add(label3);label3.setBounds(200,110,120,20);
				input.add(comboBox);comboBox.setBounds(330, 110, 150,20);
				input.add(modi);modi.setBounds(300, 140, 100,30);
				setVisible(true);
				
				modi.addActionListener(new ActionListener() {
								 
					public void actionPerformed(ActionEvent e) {
						String name=textField1.getText();
						if (!textField1.getText().equals("")&&!textField2.equals("")) {							
							String password=textField2.getText();
							String role=(String) comboBox.getSelectedItem();
						try {
							if (name.equals("111")&&!role.equals("administrator")) {
								JOptionPane.showMessageDialog(admin.this, "此用户权限无法修改","提示",
																			JOptionPane.INFORMATION_MESSAGE);
							}
							else if (true) {
								//modifyuser
								
								JOptionPane.showMessageDialog(admin.this,"更改用户信息成功！", "提示",
									JOptionPane.INFORMATION_MESSAGE);
							}
							 else JOptionPane.showMessageDialog(admin.this, "用户不存在！", "错误",
										JOptionPane.ERROR_MESSAGE);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(admin.this, "更改用户信息失败！","错误",
										JOptionPane.ERROR_MESSAGE);
							}}											
						else{JOptionPane.showMessageDialog(admin.this,"请输入完整信息！","错误",
																		JOptionPane.ERROR_MESSAGE);}}
				});
			}
			public void actionPerformed(ActionEvent e) {
				panel.updateUI();
				input.removeAll();
				modiuser();
			}
		});
					
		UserInfo.addActionListener(new ActionListener() {
			void showUserInfo(){
				//
			}
			
			public void actionPerformed(ActionEvent arg0) {
				panel.updateUI();
				input.removeAll();
				showUserInfo();
			}
		});
		
		
		btn_logout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(admin.this,
						"是否注销？", "询问", JOptionPane.YES_NO_OPTION))
					{
						admin.this.dispose();
						new login1();
					}
			}
		});
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	super.setVisible(true);
	}
}
