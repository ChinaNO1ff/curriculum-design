package com.lzw.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.lzw.dao.model.*;
import com.lzw.util.*;
import com.lzw.util.Timer;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JDesktopPane desktopPane;//顶层虚拟桌面;
	private JInternalFrame buy_record;//采购记录窗口;
	
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
		
		JMenuItem buy_date = new JMenuItem("\u8FDB\u8D27");
		buy_date.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		buy_date.setFont(new Font("宋体", Font.PLAIN, 12));
		jhgl.add(buy_date);
		
		JMenu menu_5 = new JMenu("\u4F9B\u5E94\u5546\u7BA1\u7406");
		menu_5.setFont(new Font("宋体", Font.PLAIN, 12));
		jhgl.add(menu_5);
		
		JMenuItem menuItem_11 = new JMenuItem("\u4F9B\u5E94\u5546\u4FE1\u606F");
		menuItem_11.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_5.add(menuItem_11);
		
		JMenuItem person_date = new JMenuItem("\u91C7\u8D2D\u5458\u4FE1\u606F");
		person_date.setFont(new Font("宋体", Font.PLAIN, 12));
		jhgl.add(person_date);
		
		JMenu xsgl = new JMenu("\u9500\u552E\u7BA1\u7406");
		xsgl.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(xsgl);
		
		JMenuItem sell_date = new JMenuItem("\u9500\u552E\u8BA2\u5355");
		sell_date.setFont(new Font("宋体", Font.PLAIN, 12));
		xsgl.add(sell_date);
		
		JMenu kcgl = new JMenu("\u5E93\u5B58\u7BA1\u7406");
		kcgl.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(kcgl);
		
		JMenuItem unit_date = new JMenuItem("\u4EF7\u683C\u8C03\u6574");
		unit_date.setFont(new Font("宋体", Font.PLAIN, 12));
		kcgl.add(unit_date);
		
		JMenuItem store_date = new JMenuItem("\u5E93\u5B58\u76D8\u70B9");
		store_date.setFont(new Font("宋体", Font.PLAIN, 12));
		kcgl.add(store_date);
		
		JMenu user_date = new JMenu("\u7528\u6237\u7BA1\u7406");
		user_date.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(user_date);
		
		JMenuItem menuItem_8 = new JMenuItem("\u7528\u6237\u4FE1\u606F");
		menuItem_8.setFont(new Font("宋体", Font.PLAIN, 12));
		user_date.add(menuItem_8);
		
		JMenu xxcx = new JMenu("\u4FE1\u606F\u67E5\u8BE2");
		xxcx.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(xxcx);
		
		JMenuItem menuItem_3 = new JMenuItem("\u91C7\u8D2D\u8BB0\u5F55");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				show_buy_record();
			}
		});
		menuItem_3.setFont(new Font("宋体", Font.PLAIN, 12));
		xxcx.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u9500\u552E\u8BB0\u5F55");
		menuItem_4.setFont(new Font("宋体", Font.PLAIN, 12));
		xxcx.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u4F9B\u5E94\u5546\u67E5\u8BE2");
		menuItem_5.setFont(new Font("宋体", Font.PLAIN, 12));
		xxcx.add(menuItem_5);
		
		JMenu xtwh = new JMenu("\u7CFB\u7EDF\u7EF4\u62A4");
		xtwh.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(xtwh);
		
		JMenuItem password_date = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		password_date.setFont(new Font("宋体", Font.PLAIN, 12));
		xtwh.add(password_date);
		
		JMenuItem system_out = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
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
		
		buy_record = new JInternalFrame("\u91C7\u8D2D\u8BB0\u5F55");
		buy_record.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		buy_record.setClosable(true);
		buy_record.setMaximizable(true);
		buy_record.setBounds(100, 40, 586, 308);
		buy_record.setVisible(false);
		desktopPane.add(buy_record);
		buy_record.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		buy_record.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u540D\u79F0", "\u7C7B\u578B", "\u5355\u4EF7", "\u6570\u91CF", "\u91C7\u8D2D\u65E5\u671F", "\u91C7\u8D2D\u5458"
			}
		));
		scrollPane.setViewportView(table);
	}
	private void show_buy_record(){
		buy_record.setVisible(true);
		TbBuy tb = new TbBuy();
		GetModel.getAllBuy();
	}
}
