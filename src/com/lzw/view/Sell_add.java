package com.lzw.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzw.dao.model.TbSell;
import com.lzw.dao.model.TbType;
import com.lzw.util.GetModel;
import com.lzw.util.InsertModel;
import com.lzw.util.MyComboModel;
import com.lzw.util.Patt;
import com.lzw.util.Timer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Sell_add extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> name;
	private JTextField count;
	private JTextField unit;

	public Sell_add(JFrame root) {
		setResizable(false);
		setFont(new Font("宋体", Font.PLAIN, 12));
		setTitle("\u9500\u552E\u8BA2\u5355");
		setBounds(560, 200, 300, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel name_msg = new JLabel("\u540D\u79F0");
		name_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		name_msg.setBounds(53, 33, 54, 15);
		panel.add(name_msg);
		
		name = new JComboBox<String>();
		name.setFont(new Font("宋体", Font.PLAIN, 12));
		name.setBounds(117, 30, 120, 21);
		panel.add(name);
		
		JLabel count_msg = new JLabel("\u6570\u91CF");
		count_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		count_msg.setBounds(53, 80, 54, 15);
		panel.add(count_msg);
		
		count = new JTextField();
		count.setFont(new Font("宋体", Font.PLAIN, 12));
		count.setBounds(117, 77, 120, 21);
		panel.add(count);
		count.setColumns(10);
		
		JLabel unit_msg = new JLabel("\u5355\u4EF7");
		unit_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		unit_msg.setBounds(53, 128, 54, 15);
		panel.add(unit_msg);
		
		unit = new JTextField();
		unit.setFont(new Font("宋体", Font.PLAIN, 12));
		unit.setBounds(117, 125, 120, 21);
		panel.add(unit);
		unit.setColumns(10);
		
		JButton submit = new JButton("\u751F\u6210\u8BA2\u5355");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					GetModel.getAllSell();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "连接数据库超时");
				}
				if(count.getText().trim().equals("")||unit.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的信息!");
				}else{
					if(Patt.isCount(count.getText().trim())&&Patt.isUnit(unit.getText().trim())){
						submit();
					}else{
						JOptionPane.showMessageDialog(null, "输入的信息不合法!");
					}
				}
			}
		});
		submit.setFont(new Font("宋体", Font.PLAIN, 12));
		submit.setBounds(42, 188, 93, 23);
		panel.add(submit);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.setFont(new Font("宋体", Font.PLAIN, 12));
		reset.setBounds(145, 188, 93, 23);
		panel.add(reset);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				reset();
				root.setEnabled(true);
	        }
	    });
	}
	public JComboBox<String> getDropName(){
		return name;
	}
	private void reset(){
		unit.setText("");
		count.setText("");
		count.requestFocus();
	}
	private void submit(){
		TbSell tb = new TbSell();
		tb.setNumber(Timer.getNum());
		String name_value = (String) name.getSelectedItem();
		tb.setName(name_value);
		int count_value = Integer.parseInt(count.getText().trim());
		tb.setCount(count_value);
		float unit_value = Float.parseFloat(unit.getText().trim());
		tb.setUnit(unit_value);
		float total_value = count_value*unit_value;
		tb.setTotal(total_value);
		InsertModel.insertSell(tb);
		JOptionPane.showMessageDialog(null, "新增销售订单成功");
		reset();
	}
	/*
	 * 	填充下拉菜单;
	 */
	public boolean fillDrop(){
		List<TbType> name_list = GetModel.getAllName();
		if(name_list.size()==0){
			return false;
		}else{
			getDropName().setModel(new MyComboModel<TbType>(name_list));
			return true;
		}
	}
}
