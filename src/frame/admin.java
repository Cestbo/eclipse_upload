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
		
		setTitle("����Ա--");
		
		setSize(720,400);
		setLocationRelativeTo(null);						//������ʾ
		setResizable(false);								//���ɸ��Ĵ�С
		InitGlobalFont(new Font("΢���ź�",Font.BOLD, 13));  //ͳһ��������
	
		menu=new JPanel();
		input=new JPanel();
		panel=new JPanel();
		panel.setLayout(new BorderLayout());
		input.setLayout(null);
		
		Userlist =new JButton("�û��б�");
		UserInfo =new JButton("�û���Ϣ");	
		AddUser = new JButton("����û�");
		ModiUser = new JButton("�����û�");
		DelUser = new JButton("ɾ���û�");
		btn_logout =new JButton("ע��");
				
		menu.add(Userlist);	
		menu.add(UserInfo);
		menu.add(DelUser);
		menu.add(AddUser);
		menu.add(ModiUser);			
		menu.add(btn_logout);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.add(menu,BorderLayout.NORTH);
		panel.add(input,BorderLayout.CENTER);
		
		Userlist.addActionListener(new ActionListener() {   //�û��б�
			private void userlist() {
				JTable table;
				JScrollPane scrollPane;
				JButton button1=new JButton("ɾ��");
				JButton button2=new JButton("����");
							
                 int uIndex = 20;
               
                 Object[][] list = new Object[uIndex][14];
                 for (int i = 0; i < uIndex; i++) {
                     list[i][0] = "getName()";
                     list[i][1] = "getPassword()";
                     list[i][2] = "getRole()";
                     
                 }
                 String header[] = {"�û���", "����", "���","sa","s","s","s","s","s","s","s","s","s","s"};
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
									JOptionPane.showMessageDialog(admin.this, "����ѡ��һ��", "��ʾ", 
																			JOptionPane.INFORMATION_MESSAGE);								
								} else {//�û�Ϊ����Ա
									JOptionPane.showMessageDialog(admin.this, "���û��޷�ɾ����","��ʾ",
																				JOptionPane.INFORMATION_MESSAGE);
								}
							}
							 catch (Exception e1) {
								JOptionPane.showMessageDialog(admin.this, "���ݿ����","����",
																		JOptionPane.ERROR_MESSAGE);
							}
						} 					
				});
				
				button2.addActionListener(new ActionListener() {
					public void modiuser(){
						int currentRow = table.getSelectedRow();
						if(currentRow == -1)
						{
							JOptionPane.showMessageDialog(admin.this, "����ѡ��һ���û���", "��ʾ", 
																	JOptionPane.INFORMATION_MESSAGE);								
							userlist();
						}
						else {	
						
						JLabel label1=new JLabel("����ĵ��û�����");
						JLabel label2=new JLabel("�� �� �� �� ���룺");
						JLabel label3=new JLabel("�� �� �� �� ��ݣ�");
						
						JTextField textField1=new JTextField(20);
						textField1.setText("");		//����Ϊѡ���е��û���					
						JTextField textField2=new JTextField(20);
						JComboBox<String> comboBox=new JComboBox<String>();
						comboBox.addItem("administrator");
						comboBox.addItem("user");
						comboBox.setSelectedItem("administrator");
									
						JButton modi=new JButton("����");
						
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
									JOptionPane.showMessageDialog(admin.this, "����ѡ��һ���û���", "��ʾ", 
																			JOptionPane.INFORMATION_MESSAGE);								
								}else if (textField1.equals("")||textField2.equals("")) {
									JOptionPane.showMessageDialog(admin.this,"������������Ϣ��","��ʾ",
																					JOptionPane.INFORMATION_MESSAGE);}
								else {							
								String password=textField2.getText();								
								String role=(String) comboBox.getSelectedItem();
								try {
									if (name.equals("kate")&&!role.equals("administrator")) {
										comboBox.setSelectedItem("administrator");
										JOptionPane.showMessageDialog(admin.this, "���û�Ȩ���޷��޸�","��ʾ",
																					JOptionPane.INFORMATION_MESSAGE);
									} else {
										//������Ϣ
										JOptionPane.showMessageDialog(admin.this,"�����û���Ϣ�ɹ���", "��ʾ",
											JOptionPane.INFORMATION_MESSAGE);
									}
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(admin.this, "�����û���Ϣʧ�ܣ�","����",
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
		
		DelUser.addActionListener(new ActionListener() {    			//ɾ���û�
			private void deluser() {
				JLabel label=new JLabel("������Ҫɾ�����ʺţ�");
				JTextField text=new JTextField(20);
				JButton del=new JButton("ɾ��");
				
				input.add(label);label.setBounds(150, 50,130, 20);
				input.add(text);text.setBounds(280,50, 150,20);				
				input.add(del);del.setBounds(450,50,80,20);
				
				setVisible(true);
				
				del.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						String name=text.getText();
						try {	
						if (name.equals("kate")) {
							JOptionPane.showMessageDialog(admin.this, "���û��޷�ɾ����","����",
																		JOptionPane.ERROR_MESSAGE);
						} 
						else if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(admin.this,
							"ȷ��ɾ����", "ѯ��", JOptionPane.YES_NO_OPTION)) {
						
							//deleteUser
JOptionPane.showMessageDialog(admin.this, "ɾ���û��ɹ���", "��ʾ",
																	JOptionPane.INFORMATION_MESSAGE);
}	
						}				
						catch (Exception e) {
							JOptionPane.showMessageDialog(admin.this, "ɾ���û�ʧ�ܣ�","����",
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
		
		AddUser.addActionListener(new ActionListener() {					//����û�
			public void adduser(){
				JLabel label1=new JLabel("�� �� �� �� �� ��:");
				JLabel label2=new JLabel("�� �� �� �� �� ��:");
				JLabel label3=new JLabel("�� ѡ �� �� �� ��:");
				
				JTextField textField1=new JTextField(20);
				JTextField textField2=new JTextField(20);
				JComboBox<String> comboBox=new JComboBox<String>();
				comboBox.addItem("administrator");
				comboBox.addItem("user");
				comboBox.setSelectedItem("administrator");
				
				JButton add=new JButton("���");
				
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
								JOptionPane.showMessageDialog(admin.this,"������������Ϣ��","����",
																			JOptionPane.ERROR_MESSAGE);
							} else {
									JOptionPane.showMessageDialog(admin.this, "�û��Ѵ��ڣ�","����",
																				JOptionPane.ERROR_MESSAGE);
							}								
						} catch (Exception e) {
							JOptionPane.showMessageDialog(admin.this, "�û����ʧ�ܣ�","����",
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
				JLabel label1=new JLabel("����ĵ��û�����");
				JLabel label2=new JLabel("�� �� �� �� ���룺");
				JLabel label3=new JLabel("�� �� �� �� ��ݣ�");
				
				JTextField textField1=new JTextField(20);
				JTextField textField2=new JTextField(20);
				JComboBox<String> comboBox=new JComboBox<String>();
				comboBox.addItem("administrator");
				comboBox.addItem("user");
				comboBox.setSelectedItem("administrator");
							
				JButton modi=new JButton("����");
				
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
								JOptionPane.showMessageDialog(admin.this, "���û�Ȩ���޷��޸�","��ʾ",
																			JOptionPane.INFORMATION_MESSAGE);
							}
							else if (true) {
								//modifyuser
								
								JOptionPane.showMessageDialog(admin.this,"�����û���Ϣ�ɹ���", "��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
							}
							 else JOptionPane.showMessageDialog(admin.this, "�û������ڣ�", "����",
										JOptionPane.ERROR_MESSAGE);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(admin.this, "�����û���Ϣʧ�ܣ�","����",
										JOptionPane.ERROR_MESSAGE);
							}}											
						else{JOptionPane.showMessageDialog(admin.this,"������������Ϣ��","����",
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
						"�Ƿ�ע����", "ѯ��", JOptionPane.YES_NO_OPTION))
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
