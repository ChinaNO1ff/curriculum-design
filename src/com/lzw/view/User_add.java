package com.lzw.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzw.dao.model.TbUser;
import com.lzw.util.InsertModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class User_add extends JFrame {

	private JPanel contentPane;
	private JTextField code;
	private JTextField username;
	private JTextField in_code;
	private JPasswordField password;
	private JPasswordField repeat;
	private String rand="";
	
	public User_add(JFrame root) {
		rand = createCode();
		setResizable(false);
		setTitle("\u6CE8\u518C\u8D26\u53F7");
		setBounds(480, 200, 420, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		code = new JTextField();
		code.setHorizontalAlignment(SwingConstants.CENTER);
		code.setText(rand);
		code.setFont(new Font("宋体", Font.PLAIN, 12));
		code.setEditable(false);
		code.setBounds(120, 129, 54, 21);
		panel.add(code);
		code.setColumns(10);
		
		username = new JTextField();
		username.setBounds(260, 23, 66, 21);
		panel.add(username);
		username.setColumns(10);
		
		JButton fresh = new JButton("\u5237\u65B0");
		fresh.setFont(new Font("宋体", Font.PLAIN, 12));
		fresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rand = createCode();
				code.setText(rand);
			}
		});
		fresh.setBounds(260, 128, 66, 23);
		panel.add(fresh);
		
		JLabel account_msg = new JLabel("\u8D26\u53F7");
		account_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		account_msg.setBounds(67, 26, 54, 15);
		panel.add(account_msg);
		
		JLabel password_msg = new JLabel("\u5BC6\u7801");
		password_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		password_msg.setBounds(67, 66, 54, 15);
		panel.add(password_msg);
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(username.getText().trim().equals("")||password.getText().trim().equals("")||repeat.getText().trim().equals("")||in_code.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的信息!");
				}else{
					if(!password.getText().trim().equals(repeat.getText().trim())){
						JOptionPane.showMessageDialog(null, "两次输入的密码不相同!");
					}else{
						if(!code.getText().trim().equals(in_code.getText().trim())){
							JOptionPane.showMessageDialog(null, "验证码错误");
						}else{
							submit();
						}
					}
				}
			}
		});
		submit.setFont(new Font("宋体", Font.PLAIN, 12));
		submit.setBounds(67, 206, 93, 23);
		panel.add(submit);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		reset.setFont(new Font("宋体", Font.PLAIN, 12));
		reset.setBounds(233, 206, 93, 23);
		panel.add(reset);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(67, 100, 54, 15);
		panel.add(lblNewLabel_2);
		
		in_code = new JTextField();
		in_code.setFont(new Font("宋体", Font.PLAIN, 12));
		in_code.setBounds(260, 160, 66, 21);
		panel.add(in_code);
		in_code.setColumns(10);
		
		JLabel code_msg = new JLabel("\u8F93\u5165\u9A8C\u8BC1\u7801");
		code_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		code_msg.setBounds(67, 163, 66, 15);
		panel.add(code_msg);
		
		password = new JPasswordField();
		password.setBounds(260, 63, 66, 21);
		panel.add(password);
		
		repeat = new JPasswordField();
		repeat.setBounds(260, 97, 66, 21);
		panel.add(repeat);
		
		JLabel label = new JLabel("\u9A8C\u8BC1\u7801");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(67, 132, 54, 15);
		panel.add(label);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				reset();
				root.setEnabled(true);
	        }
	    });
	}
	/*
	 * 重置按钮
	 */
	private void reset(){
		rand = createCode();
		username.setText("");
		password.setText("");
		code.setText(rand);
		repeat.setText("");
		in_code.setText("");
	}
	private static String createCode(){
		String str = "";
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		for(int i=0;i<6;i++){
			str+=arr[(int)(Math.random()*arr.length)];
		}
		return str;
	}
	/*
	 * 	提交按钮;
	 */
	@SuppressWarnings("deprecation")
	private void submit(){
		TbUser tb = new TbUser();
		tb.setName(username.getText().trim());
		tb.setPassword(password.getText().trim());
		InsertModel.insertUser(tb);
		JOptionPane.showMessageDialog(null, "添加用户成功");
		reset();
	}
}
