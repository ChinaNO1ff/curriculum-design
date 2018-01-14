package com.lzw.view;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;//������������;
	
	private Buy_record buy_record=new Buy_record(this);//��ѯ�ɹ���¼����;
	private Buy_add buy_add=new Buy_add(this);//�����ɹ���������;
	private Buy_change buy_change=new Buy_change(this);//�޸Ĳɹ������Ĵ���;
	
	private Sell_add sell_add=new Sell_add(this);//�������ۼ�¼����;
	private Sell_record sell_record=new Sell_record(this);//��ѯ���۶�������;
	private Sell_change sell_change=new Sell_change(this);//�޸����۶�������;
	
	private Pro_add pro_add=new Pro_add(this);//���ӹ�Ӧ����Ϣ����;
	private Pro_record pro_record=new Pro_record(this);//��Ӧ�̲�ѯ����;
	private Pro_change pro_change=new Pro_change(this);//��Ӧ�̸��´���;
	
	private User_add user_add=new User_add(this);//�����û�����;
	private User_change user_change=new User_change(this);//�û��޸����봰��;
	private User_record user_record=new User_record(this);//�˺���Ϣ����;
	
	private Store_record store_record=new Store_record(this);//����̵㴰��;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/res/g5.png")));
		setTitle("\u5EFA\u6750\u7269\u8D44\u7BA1\u7406\u4FE1\u606F\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu jhgl = new JMenu("\u8FDB\u8D27\u7BA1\u7406");
		jhgl.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(jhgl);
		
		JMenuItem new_buy = new JMenuItem("\u65B0\u8BA2\u5355");
		new_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buy_add.fillDrop()){
					setEnabled(false);//������������ڽ�ֹ���;
					buy_add.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "�������ݿⳬʱ��");
				}
			}
		});
		new_buy.setFont(new Font("����", Font.PLAIN, 12));
		jhgl.add(new_buy);
		
		JMenuItem buy_date = new JMenuItem("\u67E5\u8BE2\u8BB0\u5F55");
		buy_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(buy_record.fillTable()==2||buy_record.fillTable()==1){
					buy_record.fillTable();
					setEnabled(false);//������������ڽ�ֹ���;
					buy_record.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "�������ݿⳬʱ��");
				}
			}
		});
		
		JMenuItem change_buy = new JMenuItem("\u4FEE\u6539\u8BA2\u5355");
		change_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_change.setVisible(true);
				setEnabled(false);//������������ڽ�ֹ���;
			}
		});
		change_buy.setFont(new Font("����", Font.PLAIN, 12));
		jhgl.add(change_buy);
		
		buy_date.setFont(new Font("����", Font.PLAIN, 12));
		jhgl.add(buy_date);
		
		JMenu xsgl = new JMenu("\u9500\u552E\u7BA1\u7406");
		xsgl.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(xsgl);
		
		JMenuItem new_sell = new JMenuItem("\u65B0\u8BB0\u5F55");
		new_sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sell_add.fillDrop()){
					sell_add.fillDrop();
					setEnabled(false);//������������ڽ�ֹ���;
					sell_add.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "�������ݿⳬʱ��");
				}
			}
		});
		new_sell.setFont(new Font("����", Font.PLAIN, 12));
		xsgl.add(new_sell);
		
		JMenuItem sell_date = new JMenuItem("\u9500\u552E\u8BB0\u5F55");
		sell_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sell_record.fillTable()==2||buy_record.fillTable()==1){
					sell_record.fillTable();
					setEnabled(false);//������������ڽ�ֹ���;
					sell_record.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "�������ݿⳬʱ��");
				}
			}
		});
		
		JMenuItem sell_btn = new JMenuItem("\u4FEE\u6539\u8BB0\u5F55");
		sell_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sell_change.setVisible(true);
				setEnabled(false);//������������ڽ�ֹ���;
			}
		});
		sell_btn.setFont(new Font("����", Font.PLAIN, 12));
		xsgl.add(sell_btn);
		sell_date.setFont(new Font("����", Font.PLAIN, 12));
		xsgl.add(sell_date);
		
		JMenu kcgl = new JMenu("\u5E93\u5B58\u7BA1\u7406");
		kcgl.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(kcgl);
		
		JMenuItem store_date = new JMenuItem("\u5E93\u5B58\u76D8\u70B9");
		store_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(store_record.fillTable()==2||buy_record.fillTable()==1){
					store_record.fillTable();
					setEnabled(false);//������������ڽ�ֹ���;
					store_record.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "�������ݿⳬʱ��");
				}
			}
		});
		store_date.setFont(new Font("����", Font.PLAIN, 12));
		kcgl.add(store_date);
		
		JMenu user_date = new JMenu("\u7528\u6237\u7BA1\u7406");
		user_date.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(user_date);
		
		JMenuItem user_new = new JMenuItem("\u65B0\u589E\u7528\u6237");
		user_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_add.setVisible(true);
				setEnabled(false);//������������ڽ�ֹ���;
			}
		});
		user_new.setFont(new Font("����", Font.PLAIN, 12));
		user_date.add(user_new);
		
		JMenuItem change_btn = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		change_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_change.setVisible(true);
				setEnabled(false);
			}
		});
		user_date.add(change_btn);
		change_btn.setFont(new Font("����", Font.PLAIN, 12));
		
		JMenuItem user_message = new JMenuItem("\u7528\u6237\u4FE1\u606F");
		user_message.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(user_record.fillTable()==2||user_record.fillTable()==1){
					user_record.fillTable();
					setEnabled(false);//������������ڽ�ֹ���;
					user_record.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "�������ݿⳬʱ��");
				}
			}
		});
		user_message.setFont(new Font("����", Font.PLAIN, 12));
		user_date.add(user_message);
		
		JMenu xxcx = new JMenu("\u4F9B\u5E94\u5546\u7BA1\u7406");
		xxcx.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(xxcx);
		
		JMenuItem sell_record = new JMenuItem("\u65B0\u589E\u4F9B\u5E94\u5546");
		sell_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pro_add.setVisible(true);
				setEnabled(false);//������������ڽ�ֹ���;
			}
		});
		sell_record.setFont(new Font("����", Font.PLAIN, 12));
		xxcx.add(sell_record);
		
		JMenuItem change_pro = new JMenuItem("\u66F4\u6539\u4F9B\u5E94\u5546");
		change_pro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pro_change.setVisible(true);
				setEnabled(false);
			}
		});
		change_pro.setFont(new Font("����", Font.PLAIN, 12));
		xxcx.add(change_pro);
		
		JMenuItem provide_check = new JMenuItem("\u4F9B\u5E94\u5546\u67E5\u8BE2");
		provide_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pro_record.fillTable()==2||buy_record.fillTable()==1){
					pro_record.fillTable();
					setEnabled(false);//������������ڽ�ֹ���;
					pro_record.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "�������ݿⳬʱ��");
				}
			}
		});
		provide_check.setFont(new Font("����", Font.PLAIN, 12));
		xxcx.add(provide_check);
		
		JMenu xtwh = new JMenu("\u7CFB\u7EDF\u7EF4\u62A4");
		xtwh.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(xtwh);
		
		JMenuItem system_out = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		system_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		system_out.setFont(new Font("����", Font.PLAIN, 12));
		xtwh.add(system_out);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon(MainFrame.class.getResource("/res/bg.jpg")));
		bg.setBounds(0, 0, 794, 401);
		desktopPane.add(bg);
	}
}
