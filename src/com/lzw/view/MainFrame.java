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
	private JDesktopPane desktopPane;//顶层虚拟桌面;
	private Buy_record buy_record=new Buy_record(this);//查询进货记录窗口;
	private Buy_add buy_add=new Buy_add(this);//新增采购订单窗口
	
	
	private Buy_delete buy_delete=new Buy_delete(this);//删除采购订单的窗口;
	private Buy_change buy_change=new Buy_change(this);//更新采购订单的窗口;
	
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
		jhgl.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(jhgl);
		
		JMenuItem new_buy = new JMenuItem("\u65B0\u8BA2\u5355");
		new_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buy_add.fillDrop()){
					setEnabled(false);//点击后让主窗口禁止点击;
					buy_add.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "连接数据库超时！");
				}
			}
		});
		new_buy.setFont(new Font("宋体", Font.PLAIN, 12));
		jhgl.add(new_buy);
		
		JMenuItem buy_date = new JMenuItem("\u67E5\u8BE2\u8BB0\u5F55");
		buy_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(buy_record.fillTable()){
					setEnabled(false);//点击后让主窗口禁止点击;
					buy_record.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "连接数据库超时！");
				}
			}
		});
		
		JMenuItem remove_buy = new JMenuItem("\u5220\u9664\u8BB0\u5F55");
		remove_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_delete.setVisible(true);
				setEnabled(false);//点击后让主窗口禁止点击;
			}
		});
		remove_buy.setFont(new Font("宋体", Font.PLAIN, 12));
		jhgl.add(remove_buy);
		
		JMenuItem change_buy = new JMenuItem("\u66F4\u6539\u8BB0\u5F55");
		change_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_change.setVisible(true);
				setEnabled(false);//点击后让主窗口禁止点击;
			}
		});
		change_buy.setFont(new Font("宋体", Font.PLAIN, 12));
		jhgl.add(change_buy);
		buy_date.setFont(new Font("宋体", Font.PLAIN, 12));
		jhgl.add(buy_date);
		
		JMenu xsgl = new JMenu("\u9500\u552E\u7BA1\u7406");
		xsgl.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(xsgl);
		
		JMenuItem menuItem_1 = new JMenuItem("\u65B0\u8BB0\u5F55");
		menuItem_1.setFont(new Font("宋体", Font.PLAIN, 12));
		xsgl.add(menuItem_1);
		
		JMenuItem sell_date = new JMenuItem("\u9500\u552E\u8BB0\u5F55");
		sell_date.setFont(new Font("宋体", Font.PLAIN, 12));
		xsgl.add(sell_date);
		
		JMenu kcgl = new JMenu("\u5E93\u5B58\u7BA1\u7406");
		kcgl.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(kcgl);
		
		JMenuItem unit_date = new JMenuItem("\u8C03\u6574\u5E93\u5B58");
		unit_date.setFont(new Font("宋体", Font.PLAIN, 12));
		kcgl.add(unit_date);
		
		JMenuItem store_date = new JMenuItem("\u5E93\u5B58\u76D8\u70B9");
		store_date.setFont(new Font("宋体", Font.PLAIN, 12));
		kcgl.add(store_date);
		
		JMenu user_date = new JMenu("\u7528\u6237\u7BA1\u7406");
		user_date.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(user_date);
		
		JMenuItem user_add = new JMenuItem("\u65B0\u589E\u7528\u6237");
		user_add.setFont(new Font("宋体", Font.PLAIN, 12));
		user_date.add(user_add);
		
		JMenuItem user_message = new JMenuItem("\u7528\u6237\u4FE1\u606F");
		user_message.setFont(new Font("宋体", Font.PLAIN, 12));
		user_date.add(user_message);
		
		JMenuItem password_change = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		user_date.add(password_change);
		password_change.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JMenuItem user_remove = new JMenuItem("\u5220\u9664\u7528\u6237");
		user_remove.setFont(new Font("宋体", Font.PLAIN, 12));
		user_date.add(user_remove);
		
		JMenu xxcx = new JMenu("\u4F9B\u5E94\u5546\u7BA1\u7406");
		xxcx.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(xxcx);
		
		JMenuItem sell_record = new JMenuItem("\u65B0\u589E\u4F9B\u5E94\u5546");
		sell_record.setFont(new Font("宋体", Font.PLAIN, 12));
		xxcx.add(sell_record);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5220\u9664\u4F9B\u5E94\u5546");
		menuItem_2.setFont(new Font("宋体", Font.PLAIN, 12));
		xxcx.add(menuItem_2);
		
		JMenuItem provide_check = new JMenuItem("\u4F9B\u5E94\u5546\u67E5\u8BE2");
		provide_check.setFont(new Font("宋体", Font.PLAIN, 12));
		xxcx.add(provide_check);
		
		JMenuItem provide_update = new JMenuItem("\u66F4\u65B0\u4FE1\u606F");
		provide_update.setFont(new Font("宋体", Font.PLAIN, 12));
		xxcx.add(provide_update);
		
		JMenu xtwh = new JMenu("\u7CFB\u7EDF\u7EF4\u62A4");
		xtwh.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(xtwh);
		
		JMenuItem system_out = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		system_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		system_out.setFont(new Font("宋体", Font.PLAIN, 12));
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
