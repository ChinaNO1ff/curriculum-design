package com.lzw.view;

import java.awt.*;
import javax.swing.*;
import com.lzw.dao.Dao;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private static Login login;
	private static MainFrame main_frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * 	程序入口main函数
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

	/*
	 * 	登录窗口初始化;
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/res/g2.png")));
		setTitle("\u7528\u6237\u767B\u5F55");
		setResizable(false);
		setFont(new Font("宋体", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 360, 200);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel name = new JLabel("\u7528\u6237\u540D");
		name.setFont(new Font("宋体", Font.PLAIN, 20));
		name.setBounds(39, 24, 71, 31);
		panel.add(name);
		
		JLabel pass = new JLabel("\u5BC6\u7801");
		pass.setFont(new Font("宋体", Font.PLAIN, 20));
		pass.setBounds(39, 65, 71, 31);
		panel.add(pass);
		
		username = new JTextField();
		username.setFont(new Font("宋体", Font.PLAIN, 18));
		username.setBounds(120, 24, 183, 31);
		panel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("宋体", Font.PLAIN, 18));
		password.setBounds(120, 65, 183, 32);
		panel.add(password);
		
		JButton info = new JButton("\u767B\u5F55");
		info.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(username.getText().trim().length()==0||password.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null, "请输入用户名和密码");
					username.requestFocus();
				}else{
					if(isRight(username.getText().trim(),password.getText().trim())){
						showFrame();
					}else{
						JOptionPane.showMessageDialog(null, "登录失败");
						username.requestFocus();
					}
				}
				
			}
		});
		info.setFont(new Font("宋体", Font.PLAIN, 20));
		info.setBounds(59, 126, 93, 31);
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
		reset.setBounds(200, 126, 93, 31);
		panel.add(reset);
	}
	
	private boolean isRight(String name,String password){
		try {
			PreparedStatement sql = Dao.conn.prepareStatement("select * from person where name = ? and password = ?");
			sql.setString(1, name);
			sql.setString(2, password);
			ResultSet res = sql.executeQuery();
			return res.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	private void showFrame(){
		main_frame.setVisible(true);
		login.setVisible(false);
		login = null;
	}
}
