package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.util.Enumeration;
import java.awt.Font;

public class user extends JFrame {
	
	private JButton btn_myInfo;
	private JButton btn_modifyPsw;
	private JButton btn_myPrize;
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
	
	public user() {
		
		setTitle("用户--");
		setSize(700,400);
		setLocationRelativeTo(null);
		setResizable(false);
		InitGlobalFont(new Font("微软雅黑",Font.BOLD, 13));
				
		menu=new JPanel();
		input=new JPanel();
		panel=new JPanel();
		panel.setLayout(new BorderLayout());
		input.setLayout(null);
		
		btn_myInfo =new JButton("我的信息");		
		btn_modifyPsw =new JButton("更改密码");		
		btn_myPrize =new JButton("我的奖惩情况");	
		btn_logout = new JButton("注销");
	
		menu.add(btn_myInfo);
		menu.add(btn_modifyPsw);
		menu.add(btn_myPrize);
		menu.add(btn_logout);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.add(menu,BorderLayout.NORTH);
		panel.add(input,BorderLayout.CENTER);
		
		btn_myInfo.addActionListener(new ActionListener() {		//我的信息
			private void showMyInfo() {
				 JTable table = new JTable();
                 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);        
                 table.setFillsViewportHeight(true);
             
				setVisible(true);
		
			}
			public void actionPerformed(ActionEvent arg0) {
				panel.updateUI();
				input.removeAll();
				showMyInfo();
			}
		});
		
		btn_modifyPsw.addActionListener(new ActionListener() {		//更改密码
			public void modifyPassword(){				
				JLabel label1=new JLabel("请输入新密码：");
				JLabel label2=new JLabel("请再次输入新密码：");
				JPasswordField psw1=new JPasswordField(20);
				JPasswordField psw2=new JPasswordField(20);
				JButton btn_modify=new JButton("确认更改");
												
				input.add(label1);label1.setBounds(180, 50,100, 20);				
				input.add(psw1);psw1.setBounds(280,50, 150,20);
				input.add(label2);label2.setBounds(180,80,100,20);
				input.add(psw2);psw2.setBounds(280,80,150,20);
				input.add(btn_modify);btn_modify.setBounds(280,120,100,20);
				setVisible(true);
				
				btn_modify.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				
				
			}
		
			public void actionPerformed(ActionEvent arg0) {
				panel.updateUI();
				input.removeAll();
				modifyPassword();
			}
		});

		btn_myPrize.addActionListener(new ActionListener() {	//我的奖惩情况
			
			void showMyPrize(){
				
			}
			
			public void actionPerformed(ActionEvent e) {
				panel.updateUI();
				input.removeAll();
				showMyPrize();
			}
		});
		
		btn_logout.addActionListener(new ActionListener() {		//注销
			
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(user.this,
						"是否注销？", "询问", JOptionPane.YES_NO_OPTION))
					{
						user.this.dispose();
						new login1();
					}
			}
		});
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	super.setVisible(true);
	}
}
