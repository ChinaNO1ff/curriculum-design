package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.lzw.dao.model.TbSell;
import com.lzw.util.GetModel;
import com.lzw.util.MyTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Sell_record extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Sell_record(JFrame root) {
		setTitle("\u9500\u552E\u8BB0\u5F55");
		setResizable(false);
		setBounds(480, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		fillTable();
		table.setRowHeight(24);
		DefaultTableCellRenderer row = new DefaultTableCellRenderer();   
		row.setHorizontalAlignment(JLabel.CENTER); //单元格居中对齐;
		table.setDefaultRenderer(Object.class,row);
		table.setFillsViewportHeight(true);
		
		scrollPane.setViewportView(table);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				root.setEnabled(true);
	        }
	    });
	}
	public JTable getTable() {
		return table;
	}
	@SuppressWarnings("unused")
	public int fillTable(){
		List<TbSell> list = GetModel.getAllSell();
		if(list.size() == 0){
			return 1;
		}else if(list == null){
			return 0;
		}else{
			getTable().setModel(new MyTableModel<TbSell>(list,new String[] {
			"订单号", "名称", "单价", "数量", "总价"}));
			getTable().getColumnModel().getColumn(0).setPreferredWidth(150);//自定义第一列的列宽;
			getTable().getColumnModel().getColumn(1).setPreferredWidth(140);//自定义第二列的列宽;
			return 2;
		}
	}
}
