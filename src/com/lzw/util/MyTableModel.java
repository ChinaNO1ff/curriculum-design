package com.lzw.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
/*
 * �������ģ��,���������;
 */
public class MyTableModel<T> extends AbstractTableModel{
	private int col;
	private List<T> list;
	private String[] name;
	public MyTableModel(List<T> list,String[] name){
		this.list = list;
		this.col = name.length;
		this.name = name;
	}
	public int getColumnCount() {
		return col;
	}
	public String getColumnName(int index){
        return name[index];
 }
	public int getRowCount() {
		return list.size();
	}

	public Object getValueAt(int rowIndex,int colIndex) {
		String str = (list.get(rowIndex)).toString();//��ȡָ���еļ���;
		String[] cols = str.substring(1, str.length()-1).split(",");//ȥ������������;
		return cols[colIndex];
	}

}
