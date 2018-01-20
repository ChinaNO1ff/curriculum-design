package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzw.dao.model.TbBuy;
import com.lzw.item.Item;
import com.lzw.util.DeleteModel;
import com.lzw.util.GetModel;
import com.lzw.util.Patt;
import com.lzw.util.UpdateModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Buy_change extends JFrame {

	private JPanel contentPane;
	private JTextField count;
	private JTextField unit;
	private JTextField person;
	private JTextField number;
	private JTextField name;
	private String num;

	public Buy_change(JFrame root) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Buy_change.class.getResource("/res/g7.png")));
		setResizable(false);
		setTitle("\u4FEE\u6539\u8BA2\u5355");
		setBounds(460, 200, 480, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				root.setEnabled(true);
	        }
	    });
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		count = new JTextField();
		count.setBounds(299, 127, 120, 21);
		panel.add(count);
		count.setColumns(10);
		
		unit = new JTextField();
		unit.setBounds(299, 80, 120, 21);
		panel.add(unit);
		unit.setColumns(10);
		
		person = new JTextField();
		person.setBounds(89, 127, 120, 21);
		panel.add(person);
		person.setColumns(10);
		
		JLabel count_msg = new JLabel("\u6570\u91CF");
		count_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		count_msg.setBounds(235, 130, 54, 15);
		panel.add(count_msg);
		
		JLabel unit_msg = new JLabel("\u5355\u4EF7");
		unit_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		unit_msg.setBounds(235, 83, 54, 15);
		panel.add(unit_msg);
		
		JButton change = new JButton("\u4FEE\u6539\u8BA2\u5355");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		change.setFont(new Font("宋体", Font.PLAIN, 12));
		change.setBounds(75, 166, 100, 23);
		panel.add(change);
		
		JButton delete = new JButton("\u5220\u9664\u6B64\u8BA2\u5355");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drop();
			}
		});
		delete.setFont(new Font("宋体", Font.PLAIN, 12));
		delete.setBounds(309, 166, 100, 23);
		panel.add(delete);
		
		JLabel person_msg = new JLabel("\u91C7\u8D2D\u5458");
		person_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		person_msg.setBounds(29, 130, 54, 15);
		panel.add(person_msg);
		
		JLabel number_msg = new JLabel("\u8BF7\u8F93\u5165\u5C06\u8981\u64CD\u4F5C\u7684\u8BA2\u5355\u53F7");
		number_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		number_msg.setBounds(10, 13, 137, 15);
		panel.add(number_msg);
		
		number = new JTextField();
		number.setBounds(172, 10, 151, 21);
		panel.add(number);
		number.setColumns(10);
		
		JLabel name_msg = new JLabel("\u540D\u79F0");
		name_msg.setFont(new Font("宋体", Font.PLAIN, 12));
		name_msg.setBounds(29, 83, 54, 15);
		panel.add(name_msg);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(89, 80, 120, 21);
		panel.add(name);
		name.setColumns(10);
		
		JButton check = new JButton("\u67E5\u8BE2");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		check.setFont(new Font("宋体", Font.PLAIN, 12));
		check.setBounds(351, 9, 93, 23);
		panel.add(check);
	}
	/*
	 * 	检测订单并显示内容;
	 */
	private void check(){
		if(number.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入订单号");
		}else{
			if(!Patt.isNumber(number.getText().trim())){
				JOptionPane.showMessageDialog(null, "输入的订单号不合法！");
			}else{
				try{
					TbBuy tb = GetModel.getBuy(new Item(number.getText().trim()));
					if(tb.getNumber() == null){
						JOptionPane.showMessageDialog(null, "该订单不存在!");
					}else{
						num = number.getText().trim();
						name.setText(tb.getName());
						unit.setText(tb.getUnit()+"");
						count.setText(tb.getCount()+"");
						person.setText(tb.getPerson());
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "连接超时!");
				}
			}
		}
	}
	/*
	 * 更新订单内容
	 */
	private void update(){
		try{
			GetModel.getAllBuy();
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "连接数据库超时");
		}
		if(number.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入订单号");
		}else{
			if(Patt.isCount(count.getText().trim())&&Patt.isUnit(unit.getText().trim())){
				try{
					Item item = new Item(num);
					TbBuy tb = GetModel.getBuy(item);
					float unit_value = Float.parseFloat(unit.getText().trim());
					int count_value = Integer.parseInt(count.getText().trim());
					tb.setUnit(unit_value);
					tb.setCount(count_value);
					tb.setTotal(unit_value*count_value);
					tb.setPerson(person.getText().trim());
					UpdateModel.updateBuy(tb);
					JOptionPane.showMessageDialog(null, "修改成功！");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "连接超时!");
				}
			}else{
				JOptionPane.showMessageDialog(null, "修改的数据不合法");
			}
		}
	}
	/*
	 * 	删除此订单;
	 */
	private void drop(){
		try{
			GetModel.getAllBuy();
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "连接数据库超时");
		}
		if(number.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入订单号");
		}else{
			DeleteModel.deleteBuy(new Item(num));
			JOptionPane.showMessageDialog(null, "删除成功!");
			number.setText("");
			name.setText("");
			unit.setText("");
			count.setText("");
			person.setText("");
			number.requestFocus();
		}
	}
}
