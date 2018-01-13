package com.lzw.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzw.dao.model.TbPro;
import com.lzw.item.Item;
import com.lzw.util.DeleteModel;
import com.lzw.util.GetModel;
import com.lzw.util.Patt;
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
public class Pro_change extends JFrame {

	private JPanel contentPane;
	private JTextField number;
	private JTextField name;
	private JTextField phone;
	private JTextField mail;
	private JTextField address;
	private String num;
	
	public Pro_change(JFrame root) {
		setTitle("\u66F4\u6539\u5382\u5546\u4FE1\u606F");
		setResizable(false);
		setBounds(480, 230, 450, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		number = new JTextField();
		number.setFont(new Font("宋体", Font.PLAIN, 12));
		number.setBounds(179, 22, 120, 21);
		panel.add(number);
		number.setColumns(10);
		
		JLabel number_msg = new JLabel("\u8BF7\u8F93\u5165\u8981\u64CD\u4F5C\u7684\u4F9B\u5E94\u5546\u7F16\u53F7\uFF1A");
		number_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		number_msg.setBounds(10, 25, 165, 15);
		panel.add(number_msg);
		
		JButton check = new JButton("\u67E5\u8BE2");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		check.setFont(new Font("宋体", Font.PLAIN, 12));
		check.setBounds(321, 21, 93, 23);
		panel.add(check);
		
		JLabel name_msg = new JLabel("\u5382\u5546");
		name_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		name_msg.setBounds(26, 73, 54, 15);
		panel.add(name_msg);
		
		name = new JTextField();
		name.setEditable(false);
		name.setFont(new Font("宋体", Font.PLAIN, 12));
		name.setBounds(80, 70, 120, 21);
		panel.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("宋体", Font.PLAIN, 12));
		phone.setBounds(294, 70, 120, 21);
		panel.add(phone);
		phone.setColumns(10);
		
		JLabel phone_msg = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		phone_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		phone_msg.setBounds(224, 73, 54, 15);
		panel.add(phone_msg);
		
		JLabel mail_msg = new JLabel("\u90AE\u7BB1");
		mail_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		mail_msg.setBounds(26, 124, 54, 15);
		panel.add(mail_msg);
		
		mail = new JTextField();
		mail.setFont(new Font("宋体", Font.PLAIN, 12));
		mail.setBounds(80, 121, 120, 21);
		panel.add(mail);
		mail.setColumns(10);
		
		JLabel address_msg = new JLabel("\u5730\u5740");
		address_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		address_msg.setBounds(224, 124, 54, 15);
		panel.add(address_msg);
		
		address = new JTextField();
		address.setFont(new Font("宋体", Font.PLAIN, 12));
		address.setBounds(294, 121, 120, 21);
		panel.add(address);
		address.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u8BA2\u5355");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnNewButton.setBounds(82, 169, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u6B64\u8BA2\u5355");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drop();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_1.setBounds(257, 169, 110, 23);
		panel.add(btnNewButton_1);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				root.setEnabled(true);
	        }
	    });
	}
	/*
	 * 	检测订单并显示内容;
	 */
	private void check(){
		if(number.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入订单号");
		}else{
			if(!Patt.isNumber(number.getText().trim())){
				JOptionPane.showMessageDialog(null, "输入的订单号不合法！");
			}else{
				try{
					TbPro tb = GetModel.getPro(new Item(number.getText().trim()));
					if(tb.getNumber() == null){
						JOptionPane.showMessageDialog(null, "该供应商不存在!");
					}else{
						num = number.getText().trim();
						name.setText(tb.getName());
						phone.setText(tb.getPhone()+"");
						mail.setText(tb.getMail()+"");
						address.setText(tb.getAddress());
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "连接超时!");
				}
			}
		}
	}
	/*
	 * 更新供应商内容
	 */
	private void update(){
		if(number.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入订单号");
		}else{
			if(Patt.isPhone(phone.getText().trim())&&Patt.isMail(mail.getText().trim())){
				try{
					Item item = new Item(num);
					TbPro tb = GetModel.getPro(item);
					tb.setPhone(phone.getText().trim());
					tb.setMail(mail.getText().trim());
					tb.setAddress(address.getText().trim());
					UpdateModel.updatePro(tb);
					JOptionPane.showMessageDialog(null, "修改成功！");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "连接超时!");
				}
			}else{
				JOptionPane.showMessageDialog(null, "修改的数据不合法");
			}
		}
	}
	/*
	 * 	删除此订单;
	 */
	private void drop(){
		if(number.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入订单号");
		}else{
			DeleteModel.deletePro(new Item(num));
			JOptionPane.showMessageDialog(null, "删除成功!");
			number.setText("");
			name.setText("");
			phone.setText("");
			mail.setText("");
			address.setText("");
			number.requestFocus();
		}
	}
}
