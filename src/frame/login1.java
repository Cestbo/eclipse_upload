package frame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class login1 extends JDialog {

	private static final long serialVersionUID = 1L;
		private JLabel lblUn;
	    private JLabel lblPw;
	    
	    private JTextField txtUn; 
	    private JPasswordField txtPw;
	    
	    private JButton btnLogin; 
	    private JButton btnReset; 

	    private JPanel pnlLogin; // ��¼���
	    private JPanel pnlInput; // ���û������͡�����"�ı������
	    private JPanel pnlButton; // ����¼���͡����á���ť�� ��
	

		public static void main(String[] args) {
	
			new login1();
				}
   
		public login1() {	
//�������	
			setTitle("��ӭʹ�ñ�������Ϣ����ϵͳ��");
			JLabel label = new JLabel("���¼",JLabel.CENTER);
			label.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			setSize(400,250);
			setResizable(false);
			setLocationRelativeTo(null);
			setModalityType(ModalityType.APPLICATION_MODAL);
			setModal(rootPaneCheckingEnabled);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			lblUn =new JLabel("��    ��:");
			lblPw =new JLabel("��    ��:");
			
			txtUn =new JTextField(20);
			txtPw =new JPasswordField(20);
			
			btnLogin =new JButton("��¼");
			btnReset =new JButton("����");
			
			pnlLogin =new JPanel();
			pnlLogin.setLayout(new BorderLayout());
			
			pnlInput =new JPanel();
			pnlInput.add(lblUn);
			pnlInput.add(txtUn);
			pnlInput.add(lblPw);
			pnlInput.add(txtPw);
			pnlInput.setLayout(new FlowLayout(FlowLayout.LEFT,35,20));
			pnlLogin.add(pnlInput, BorderLayout.CENTER);
			
			pnlButton=new JPanel();
			pnlButton.add(btnLogin);
			pnlButton.add(btnReset);
			pnlLogin.add(pnlButton,BorderLayout.SOUTH);
			
			pnlLogin.add(label,BorderLayout.NORTH);
			getContentPane().add(pnlLogin, BorderLayout.CENTER);
			
			
	//�¼�����
			btnReset.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent e) {		
						txtUn.setText("");
						txtPw.setText("");
				}
			});
			
			btnLogin.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				
						String name=txtUn.getText();
						String psw=String.valueOf(txtPw.getPassword());
						
						if (!name.equals("") && !psw.equals("")) {				
							if (name.equals("abc")) {
								new admin();
							} else {
								new user();
							}
						} else {
							JOptionPane.showMessageDialog(login1.this, "�ʺŻ��������", "����", 
																			JOptionPane.ERROR_MESSAGE);
						}
					
				}
			});
		
	this.addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(login1.this,
										"�Ƿ��˳���", "ѯ��", JOptionPane.YES_NO_OPTION))
			{
				login1.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			else
			{
				login1.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
	});
	
    	super.setVisible(true);
    }
}





