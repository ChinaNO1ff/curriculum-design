package com.lzw.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private static Login login;
	private static MainFrame main_frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_frame = new MainFrame();
					login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/res/g2.png")));
		setTitle("\u7528\u6237\u767B\u5F55");
		setResizable(false);
		setFont(new Font("宋体", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 180, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel name = new JLabel("\u7528\u6237\u540D");
		name.setFont(new Font("宋体", Font.PLAIN, 20));
		name.setBounds(58, 57, 71, 31);
		panel.add(name);
		
		JLabel pass = new JLabel("\u5BC6\u7801");
		pass.setFont(new Font("宋体", Font.PLAIN, 20));
		pass.setBounds(58, 114, 71, 31);
		panel.add(pass);
		
		username = new JTextField();
		username.setBounds(153, 56, 219, 32);
		panel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(153, 116, 219, 32);
		panel.add(password);
		
		JButton info = new JButton("\u767B\u5F55");
		info.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(username.getText().trim().length()==0||password.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null, "请输入用户名和密码");
				}else{
					if(isRight(username.getText().trim(),password.getText().trim())){
						showFrame();
					}else{
						JOptionPane.showMessageDialog(null, "登录失败");
					}
				}
				
			}
		});
		info.setFont(new Font("宋体", Font.PLAIN, 20));
		info.setBounds(100, 198, 93, 31);
		panel.add(info);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.setFont(new Font("宋体", Font.PLAIN, 20));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username.setText("");
				password.setText("");
				username.requestFocus();
			}
		});
		reset.setBounds(248, 198, 93, 31);
		panel.add(reset);
	}
	
	private boolean isRight(String name,String password){
		
		
		return true;
	}
	private void showFrame(){
		main_frame.setVisible(true);
		login.setVisible(false);
		login = null;
	}
}
