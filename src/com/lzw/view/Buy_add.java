/*
 * 采购订单窗口;
 */
package com.lzw.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.lzw.dao.model.*;
import com.lzw.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

@SuppressWarnings("serial")
public class Buy_add extends JFrame {

	private JPanel contentPane;
	private JTextField type;
	private JTextField name;
	private JTextField count;
	private JTextField unit;
	private JTextField person;

	public Buy_add(JFrame root) {//主窗口的引用;
		setResizable(false);
		setTitle("\u8FDB\u8D27\u8BA2\u5355");
		setBounds(460, 180, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		btnNewButton.setBounds(240, 208, 93, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u751F\u6210\u8BA2\u5355");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type.getText().trim().equals("")||name.getText().trim().equals("")||count.getText().trim().equals("")||
						unit.getText().trim().equals("")||person.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的信息!");
				}else{
					if(isNumber(count.getText().trim())&&isNumber(unit.getText().trim())){
						submit();
					}else{
						JOptionPane.showMessageDialog(null, "输入的信息不合法!");
					}
				}
			}
		});
		button.setBounds(75, 208, 93, 23);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("\u7C7B\u578B");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel.setBounds(91, 13, 54, 15);
		panel.add(lblNewLabel);
		
		type = new JTextField();
		type.setBounds(170, 10, 121, 21);
		panel.add(type);
		type.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(91, 48, 54, 15);
		panel.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(170, 45, 121, 21);
		panel.add(name);
		name.setColumns(10);
		
		JLabel label = new JLabel("\u6570\u91CF");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(91, 79, 54, 15);
		panel.add(label);
		
		count = new JTextField();
		count.setBounds(170, 79, 121, 21);
		panel.add(count);
		count.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u4EF7");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(91, 116, 54, 15);
		panel.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u91C7\u8D2D\u5458");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(91, 150, 54, 15);
		panel.add(label_1);
		
		unit = new JTextField();
		unit.setBounds(170, 113, 121, 21);
		panel.add(unit);
		unit.setColumns(10);
		
		person = new JTextField();
		person.setBounds(170, 147, 121, 21);
		panel.add(person);
		person.setColumns(10);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				root.setEnabled(true);
	        }
	    });
	}
	/*
	 * 	重置订单表;
	 */
	private void reset(){
		type.setText("");
		name.setText("");
		unit.setText("");
		count.setText("");
		person.setText("");
	}
	/*
	 * 	提交订单表
	 */
	private void submit(){
		TbBuy tb = new TbBuy();
		tb.setNumber(Timer.getNum());
		tb.setName(name.getText().trim());
		tb.setType(type.getText().trim());
		int count_value = Integer.parseInt(count.getText().trim());
		tb.setCount(count_value);
		float unit_value = Float.parseFloat(unit.getText().trim());
		tb.setUnit(unit_value);
		float total = count_value*unit_value;
		tb.setTotal(total);
		tb.setPerson(person.getText().trim());
		InsertModel.insertBuy(tb);
		JOptionPane.showMessageDialog(null, "添加订单成功");
		reset();
	}
	/*
	 * 	正则表达式判断输入的数量和单价是否合法;
	 */
	private boolean isNumber(String str){ 
		Pattern pattern = Pattern.compile("[0-9]+\\.?[0-9]+");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
}
