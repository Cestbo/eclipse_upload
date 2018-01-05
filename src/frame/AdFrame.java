package frame;



import javax.swing.ImageIcon;
import javax.swing.JFrame;


import cn.company.vo.Administrator;
import javafx.scene.layout.Background;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class AdFrame extends JFrame {
	//private JTextField inputSNo;

     Administrator administrator;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdFrame(Administrator ad) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdFrame.class.getResource("/frame/123.jpg")));
		
		administrator=ad;
		getContentPane().setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 17));
		setTitle("\u7BA1\u7406\u5458\u7528\u6237\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 391);
        
        
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		JMenu menu = new JMenu("\u5F55\u5165\u5B66\u751F\u4FE1\u606F");
		menuBar_1.add(menu);
		JMenuItem j1=new JMenuItem("\u5B66\u751F\u57FA\u672C\u4FE1\u606F");
		//Â¼Èë»ù±¾ÐÅÏ¢
		j1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddBaseinfo().setVisible(true);
			}
		});
		menu.add(j1);menu.add(j1);
JMenuItem mntmNewMenuItem = new JMenuItem("\u5B66\u751F\u5956\u60E9\u60C5\u51B5");
mntmNewMenuItem.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		new AddAwardOrPunish().setVisible(true);
	}
});
menu.add(mntmNewMenuItem);
JMenuItem menuItem = new JMenuItem("\u5B66\u751F\u5BB6\u5EAD\u60C5\u51B5");
menuItem.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		new AddFamily().setVisible(true);
	}
});
menu.add(menuItem);
		JMenu menu_1 = new JMenu("\u67E5\u8BE2\u5B66\u751F\u4FE1\u606F");
		
		menuBar_1.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u67E5\u8BE2");
		//²éÑ¯
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentInfo().setVisible(true);
				
//				p1.updateUI();
//				p1.removeAll();
//				JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5B66\u53F7");
//				label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 17));
//				label.setBounds(227, 51, 138, 34);
//				p1.add(label);
//				label.setVisible(true);
//				inputSNo = new JTextField();
//				inputSNo.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
//				inputSNo.setBounds(227, 109, 170, 34);
//				p1.add(inputSNo);
//				inputSNo.setColumns(10);
//				
//				JButton button = new JButton("\u786E\u5B9A");
//				button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
//				button.setBounds(264, 189, 101, 34);
//				p1.add(button);
			}
		});
		menu_1.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		menuBar_1.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5B66\u751F\u57FA\u672C\u4FE1\u606F");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBaseinfo().setVisible(true);
			}
		});
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5B66\u751F\u5BB6\u5EAD\u60C5\u51B5");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateFamily().setVisible(true);
			}
		});
		menu_2.add(menuItem_5);
		
		JMenu menu_3 = new JMenu("\u5220\u9664");
		menuBar_1.add(menu_3);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5220\u9664\u5956\u60E9");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteAwardorPunish().setVisible(true);
			}
		});
		menu_3.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5220\u9664\u5B66\u751F");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStu().setVisible(true);
			}
		});
		menu_3.add(menuItem_2);
		
		JMenu menu_4 = new JMenu("\u5176\u5B83");
		
		menuBar_1.add(menu_4);
		
		JMenuItem menuItem_6 = new JMenuItem("\u66F4\u6539\u5BC6\u7801");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdatePassword(administrator).setVisible(true);
			}
		});
		menu_4.add(menuItem_6);
		getContentPane().setLayout(null);
		
		ImageIcon imageIcon=new ImageIcon(Toolkit.getDefaultToolkit().getImage(AdFrame.class.getResource("/frame/123.jpg")));
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(0, 0, 613, 331);
		getContentPane().add(lblNewLabel);
	//²éÑ¯ÊäÈë×é¼þ	
		
		
		
		
	}
}
