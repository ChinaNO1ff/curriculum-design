package com.lzw.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.lzw.dao.model.TbPro;
import com.lzw.util.GetModel;
import com.lzw.util.MyTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

@SuppressWarnings("serial")
public class Pro_record extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public Pro_record(JFrame root) {
		setTitle("\u4F9B\u5E94\u5546\u67E5\u8BE2");
		setResizable(false);
		setBounds(400, 200, 600, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 12));
		fillTable();
		table.setRowHeight(24);
		DefaultTableCellRenderer row = new DefaultTableCellRenderer();   
		row.setHorizontalAlignment(JLabel.CENTER); //单元格居中对齐;
		table.setDefaultRenderer(Object.class,row);
		table.setFillsViewportHeight(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				root.setEnabled(true);
	        }
	    });
	}
	/*
	 * 	填充供应商信息表格;
	 */
	@SuppressWarnings("unused")
	public int fillTable(){
		List<TbPro> list = GetModel.getAllPro();
		if(list.size() == 0){
			return 1;
		}else if(list == null){
			return 0;
		}else{
			getTable().setModel(new MyTableModel<TbPro>(list,new String[] {
			"编号", "厂商", "联系电话", "邮箱", "地址"}));
			return 2;
		}
	}
	public JTable getTable() {
		return table;
	}

}
