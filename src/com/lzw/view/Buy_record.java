/*
 * 采购记录窗口;
 */
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
import com.lzw.dao.model.TbBuy;
import com.lzw.util.GetModel;
import com.lzw.util.MyTableModel;
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
		fillTable();
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
	/*
	 * 	填充采购订单信息表格;
	 */
	public boolean fillTable(){
		List<TbBuy> list = GetModel.getAllBuy();
		if(list.size() == 0){
			return false;
		}else{
			getTable().setModel(new MyTableModel<TbBuy>(list,new String[] {
			"订单号", "名称", "单价", "数量", "总价", "采购员", "类型"}));
			getTable().getColumnModel().getColumn(0).setPreferredWidth(150);//自定义第一列的列宽;
			getTable().getColumnModel().getColumn(1).setPreferredWidth(140);//自定义第二列的列宽;
			return true;
		}
	}

	public JTable getTable() {
		return table;
	}

}
