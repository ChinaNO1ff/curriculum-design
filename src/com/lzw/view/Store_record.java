package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbStore;
import com.lzw.util.GetModel;
import com.lzw.util.MyTableModel;
import com.lzw.util.UpdateModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Store_record extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Store_record(JFrame root) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Store_record.class.getResource("/res/g3.png")));
		setResizable(false);
		setTitle("\u5E93\u5B58\u76D8\u70B9");
		setBounds(480, 200, 450, 300);
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
	@SuppressWarnings("unused")
	public int fillTable(){
		updateCount();
		List<TbStore> list = GetModel.getAllStore();
		if(list.size() == 0){
			return 1;
		}else if(list == null){
			return 0;
		}else{
			getTable().setModel(new MyTableModel<TbStore>(list,new String[]{"名称", "数量"}));
			return 2;
		}
	}
	private void updateCount(){
		TbStore store = new TbStore();
		String name_value = "";
		ResultSet name = Dao.findForResultSet("select name from tb_type");
		try {
			while(name.next()){
				name_value = name.getString(1);
				store.setName(name_value);
				store.setCount(GetModel.getCountByName(name_value));
				UpdateModel.updateStore(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
