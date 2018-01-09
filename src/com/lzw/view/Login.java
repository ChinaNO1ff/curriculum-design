package com.lzw.view;

import java.awt.*;
import javax.swing.*;
import com.lzw.dao.Dao;
import com.lzw.util.GetModel;

import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;//顶层面板
	private static Login login;//登录窗口
	private static MainFrame main_frame;//主窗口
	private JPanel panel;//主面板
	private JProgressBar loading;//进度条
	private JTextField username;//账号输入框
	private JPasswordField password;//密码输入框

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/res/g3.png")));
		setTitle("\u7528\u6237\u767B\u5F55");
		setResizable(false);
		setFont(new Font("宋体", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 358, 215);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel name = new JLabel("\u7528\u6237\u540D");
		name.setFont(new Font("宋体", Font.PLAIN, 18));
		name.setBounds(39, 25, 71, 31);
		panel.add(name);
		
		JLabel pass = new JLabel("\u5BC6\u7801");
		pass.setFont(new Font("宋体", Font.PLAIN, 18));
		pass.setBounds(39, 70, 71, 31);
		panel.add(pass);
		
		username = new JTextField();
		username.setFont(new Font("宋体", Font.PLAIN, 18));
		username.setBounds(120, 25, 183, 31);
		panel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		//添加键盘回车事件;
		password.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					load();
				}
			}
		});
		password.setFont(new Font("宋体", Font.PLAIN, 18));
		password.setBounds(120, 70, 183, 32);
		panel.add(password);
		
		JButton info = new JButton("\u767B\u5F55");
		info.setForeground(Color.BLACK);
		//登录按钮事件;
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		info.setFont(new Font("宋体", Font.PLAIN, 20));
		info.setBounds(59, 125, 93, 31);
		panel.add(info);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.setForeground(Color.BLACK);
		reset.setFont(new Font("宋体", Font.PLAIN, 20));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username.setText("");
				password.setText("");
				username.requestFocus();
			}
		});
		reset.setBounds(199, 125, 93, 31);
		panel.add(reset);
	}
	
	//执行登录动作;
	/*
	 * 登录成功显示主窗口,登录失败显示提示窗口;
	 * 隐藏进度条;
	 */
	@SuppressWarnings("deprecation")
	private void inf(){
		if(GetModel.getLogin(username.getText().trim(),password.getText().trim())){
			showFrame();
		}else{
			JOptionPane.showMessageDialog(null, "登录失败");
			username.requestFocus();
		}
		loading.setVisible(false);
		panel.remove(loading);
	}
	//加载进度条并登录;
	@SuppressWarnings("deprecation")
	private void load(){
		if(username.getText().trim().length()==0||password.getText().trim().length()==0){
			JOptionPane.showMessageDialog(null, "请输入用户名和密码");
			username.requestFocus();
		}else{
			loading = new JProgressBar();
			loading.setBounds(10, 167, 335, 14);
			panel.add(loading);
			Thread t = new Thread(new Runnable(){
				int count = 0;
				public void run() {
					while(true){
						loading.setValue(++count);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(count == 100){
							break;
						}
					}
					//进度条完成后弹出登录状态;
					inf();
				}
			});
			t.start();
		}
	}
	//登录成功后的登录窗隐藏和主窗口显示;
	private void showFrame(){
		main_frame.setVisible(true);
		login.setVisible(false);
		login = null;
	}
}
