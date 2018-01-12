package com.lzw.util;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/*
 * 下拉列表数据模型,用来填充下拉列表;
 */
@SuppressWarnings("serial")
public class MyComboModel<T> extends AbstractListModel<String> implements ComboBoxModel<String> {
	private List<T> list;
	private String item;
	
	public MyComboModel(List<T> list) {
		this.list = list;
		this.item = getElementAt(0);
	}

	public String getElementAt(int index) {
		String ele = list.get(index).toString();
		return ele.substring(1, ele.length()-1);
	}

	public int getSize() {
		return list.size();
	}
	public Object getSelectedItem() {
		return this.item;
	}

	public void setSelectedItem(Object anItem) {
		this.item = (String) anItem;
	}
}
