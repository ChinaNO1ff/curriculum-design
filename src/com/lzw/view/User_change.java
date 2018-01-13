package com.lzw.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzw.dao.model.TbUser;
import com.lzw.util.GetModel;
import com.lzw.util.UpdateModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class User_change extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField old_pass;
	private JTextField new_pass;
	private JTextField repeat;
	private String name = "";
	private String oldpwd = "";
	
	public User_change(JFrame root) {
		setTitle("\u4FEE\u6539\u7528\u6237");
		setResizable(false);
		setBounds(460, 220, 480, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("宋体", Font.PLAIN, 12));
		username.setBounds(190, 24, 100, 21);
		panel.add(username);
		username.setColumns(10);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u8D26\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(45, 27, 117, 15);
		panel.add(label);
		
		JButton check = new JButton("\u67E5\u8BE2");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		check.setFont(new Font("宋体", Font.PLAIN, 12));
		check.setBounds(320, 23, 93, 23);
		panel.add(check);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(43, 64, 119, 15);
		panel.add(label_1);
		
		old_pass = new JTextField();
		old_pass.setEditable(false);
		old_pass.setFont(new Font("宋体", Font.PLAIN, 12));
		old_pass.setBounds(190, 61, 100, 21);
		panel.add(old_pass);
		old_pass.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel.setBounds(45, 104, 117, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u786E\u8BA4\u65B0\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(45, 146, 117, 15);
		panel.add(lblNewLabel_1);
		
		new_pass = new JTextField();
		new_pass.setEditable(false);
		new_pass.setFont(new Font("宋体", Font.PLAIN, 12));
		new_pass.setBounds(190, 101, 100, 21);
		panel.add(new_pass);
		new_pass.setColumns(10);
		
		repeat = new JTextField();
		repeat.setEditable(false);
		repeat.setFont(new Font("宋体", Font.PLAIN, 12));
		repeat.setBounds(190, 143, 100, 21);
		panel.add(repeat);
		repeat.setColumns(10);
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(old_pass.getText().trim().equals("")||new_pass.getText().trim().equals("")||repeat.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的信息");
				}else{
					if(old_pass.getText().trim().equals(new_pass.getText().trim())){
						JOptionPane.showMessageDialog(null, "输入的新密码与旧密码相同");
						new_pass.setText("");
						repeat.setText("");
					}else{
						if(!new_pass.getText().trim().equals(repeat.getText().trim())){
							JOptionPane.showMessageDialog(null, "两次输入的新密码不相同");
						}else{
							try{
								submit();
							}catch(Exception e1){
								JOptionPane.showMessageDialog(null, "连接数据库超时");
							}
						}
					}
				}
			}
		});
		submit.setFont(new Font("宋体", Font.PLAIN, 12));
		submit.setBounds(320, 142, 93, 23);
		panel.add(submit);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				root.setEnabled(true);
	        }
	    });
	}
	private void check(){
		if(username.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入要修改的用户名");
		}else{
			try{
				TbUser tb = GetModel.getUser(username.getText().trim());
				System.out.println(tb);
				if(tb.getName() == null){
					JOptionPane.showMessageDialog(null, "该用户不存在!");
				}else{
					name = tb.getName();
					oldpwd = tb.getPassword();
					old_pass.setEditable(true);
					new_pass.setEditable(true);
					repeat.setEditable(true);
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "连接超时!");
			}
		}
	}
	private void submit(){
		TbUser tb = new TbUser(name);
		tb.setPassword(new_pass.getText().trim());
		System.out.println(tb);
		if(!old_pass.getText().trim().equals(oldpwd)){
			JOptionPane.showMessageDialog(null, "原密码错误");
		}else{
			UpdateModel.updateUser(tb);
			JOptionPane.showMessageDialog(null, "修改成功");
		}
	}
}
