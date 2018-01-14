package com.lzw.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.lzw.dao.model.TbPro;
import com.lzw.util.GetModel;
import com.lzw.util.InsertModel;
import com.lzw.util.Patt;
import com.lzw.util.Timer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Pro_add extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField mail;
	private JTextArea address;
	
	public Pro_add(JFrame root) {
		setResizable(false);
		setTitle("\u589E\u52A0\u4F9B\u5E94\u5546");
		setBounds(540, 170, 360, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel name_msg = new JLabel("\u5382\u5546");
		name_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		name_msg.setBounds(47, 32, 54, 15);
		panel.add(name_msg);
		
		name = new JTextField();
		name.setBounds(146, 29, 160, 21);
		panel.add(name);
		name.setColumns(10);
		
		JLabel phone_msg = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		phone_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		phone_msg.setBounds(47, 71, 54, 15);
		panel.add(phone_msg);
		
		phone = new JTextField();
		phone.setBounds(146, 68, 160, 21);
		panel.add(phone);
		phone.setColumns(10);
		
		JLabel mail_msg = new JLabel("\u90AE\u7BB1");
		mail_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		mail_msg.setBounds(47, 112, 54, 15);
		panel.add(mail_msg);
		
		mail = new JTextField();
		mail.setBounds(146, 109, 160, 21);
		panel.add(mail);
		mail.setColumns(10);
		
		JLabel address_msg = new JLabel("\u5730\u5740");
		address_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		address_msg.setBounds(47, 161, 54, 15);
		panel.add(address_msg);
		
		JButton submit = new JButton("\u6DFB\u52A0");
		submit.setFont(new Font("宋体", Font.PLAIN, 12));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					GetModel.getAllPro();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "连接数据库超时");
				}
				if(name.getText().trim().equals("")||phone.getText().trim().equals("")||mail.getText().trim().equals("")||address.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的信息!");
				}else{
					if(Patt.isPhone(phone.getText().trim())&&Patt.isMail(mail.getText().trim())){
						submit();
					}else{
						JOptionPane.showMessageDialog(null, "输入的信息不合法!");
					}
				}
			}
		});
		submit.setBounds(47, 280, 93, 23);
		panel.add(submit);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.setFont(new Font("宋体", Font.PLAIN, 12));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		reset.setBounds(213, 280, 93, 23);
		panel.add(reset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 161, 160, 100);
		panel.add(scrollPane);
		
		address = new JTextArea();
		scrollPane.setViewportView(address);
		address.setLineWrap(true);
		address.setRows(4);
		address.setTabSize(4);
		address.setColumns(10);
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
		name.setText("");
		phone.setText("");
		mail.setText("");
		address.setText("");
		name.requestFocus();
	}
	/*
	 * 添加按钮;
	 */
	private void submit(){
		TbPro tp = new TbPro();
		tp.setName(name.getText().trim());
		tp.setPhone(phone.getText().trim());
		tp.setMail(mail.getText().trim());
		tp.setAddress(address.getText().trim());
		tp.setNumber(Timer.getNum());
		InsertModel.insertPro(tp);
		JOptionPane.showMessageDialog(null, "添加供应商成功");
		reset();
	}
}
