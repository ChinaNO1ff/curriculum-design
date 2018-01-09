package com.lzw.view;

import java.awt.*;
import javax.swing.*;
import com.lzw.dao.Dao;
import com.lzw.util.GetModel;

import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;//�������
	private static Login login;//��¼����
	private static MainFrame main_frame;//������
	private JPanel panel;//�����
	private JProgressBar loading;//������
	private JTextField username;//�˺������
	private JPasswordField password;//���������

	/**
	 * 	�������main����
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
	 * 	��¼���ڳ�ʼ��;
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/res/g3.png")));
		setTitle("\u7528\u6237\u767B\u5F55");
		setResizable(false);
		setFont(new Font("����", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 358, 215);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel name = new JLabel("\u7528\u6237\u540D");
		name.setFont(new Font("����", Font.PLAIN, 18));
		name.setBounds(39, 25, 71, 31);
		panel.add(name);
		
		JLabel pass = new JLabel("\u5BC6\u7801");
		pass.setFont(new Font("����", Font.PLAIN, 18));
		pass.setBounds(39, 70, 71, 31);
		panel.add(pass);
		
		username = new JTextField();
		username.setFont(new Font("����", Font.PLAIN, 18));
		username.setBounds(120, 25, 183, 31);
		panel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		//��Ӽ��̻س��¼�;
		password.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					load();
				}
			}
		});
		password.setFont(new Font("����", Font.PLAIN, 18));
		password.setBounds(120, 70, 183, 32);
		panel.add(password);
		
		JButton info = new JButton("\u767B\u5F55");
		info.setForeground(Color.BLACK);
		//��¼��ť�¼�;
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		info.setFont(new Font("����", Font.PLAIN, 20));
		info.setBounds(59, 125, 93, 31);
		panel.add(info);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.setForeground(Color.BLACK);
		reset.setFont(new Font("����", Font.PLAIN, 20));
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
	
	//ִ�е�¼����;
	/*
	 * ��¼�ɹ���ʾ������,��¼ʧ����ʾ��ʾ����;
	 * ���ؽ�����;
	 */
	@SuppressWarnings("deprecation")
	private void inf(){
		if(GetModel.getLogin(username.getText().trim(),password.getText().trim())){
			showFrame();
		}else{
			JOptionPane.showMessageDialog(null, "��¼ʧ��");
			username.requestFocus();
		}
		loading.setVisible(false);
		panel.remove(loading);
	}
	//���ؽ���������¼;
	@SuppressWarnings("deprecation")
	private void load(){
		if(username.getText().trim().length()==0||password.getText().trim().length()==0){
			JOptionPane.showMessageDialog(null, "�������û���������");
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
					//��������ɺ󵯳���¼״̬;
					inf();
				}
			});
			t.start();
		}
	}
	//��¼�ɹ���ĵ�¼�����غ���������ʾ;
	private void showFrame(){
		main_frame.setVisible(true);
		login.setVisible(false);
		login = null;
	}
}
