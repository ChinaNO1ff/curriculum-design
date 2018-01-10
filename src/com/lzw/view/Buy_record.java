/*
 * 采购记录窗口;
 */
package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Buy_record extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public Buy_record(JFrame root) {//主窗口的引用;
		setResizable(false);
		setTitle("\u91C7\u8D2D\u8BB0\u5F55");
		setBounds(400, 180, 560, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setRowHeight(24);
		DefaultTableCellRenderer row = new DefaultTableCellRenderer();   
		row.setHorizontalAlignment(JLabel.CENTER); //单元格居中对齐;
		table.setDefaultRenderer(Object.class,row);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(getTable());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				root.setEnabled(true);
	        }
	    });
	}

	public JTable getTable() {
		return table;
	}

}
