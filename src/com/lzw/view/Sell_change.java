package com.lzw.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzw.dao.model.TbSell;
import com.lzw.item.Item;
import com.lzw.util.DeleteModel;
import com.lzw.util.GetModel;
import com.lzw.util.Patt;
import com.lzw.util.UpdateModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Sell_change extends JFrame {

	private JPanel contentPane;
	private JTextField number;
	private JTextField count;
	private JTextField unit;
	private String num = "";

	public Sell_change(JFrame root) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sell_change.class.getResource("/res/g7.png")));
		setTitle("\u4FEE\u6539\u8BA2\u5355");
		setResizable(false);
		setBounds(480, 220, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u7F16\u8F91\u7684\u8BA2\u5355\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 43, 135, 15);
		panel.add(lblNewLabel);
		
		number = new JTextField();
		number.setFont(new Font("宋体", Font.PLAIN, 12));
		number.setBounds(165, 40, 120, 21);
		panel.add(number);
		number.setColumns(10);
		
		JButton check = new JButton("\u67E5\u8BE2");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		check.setFont(new Font("宋体", Font.PLAIN, 12));
		check.setBounds(316, 39, 108, 23);
		panel.add(check);
		
		count = new JTextField();
		count.setFont(new Font("宋体", Font.PLAIN, 12));
		count.setBounds(165, 86, 120, 21);
		panel.add(count);
		count.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 89, 54, 15);
		panel.add(lblNewLabel_1);
		
		unit = new JTextField();
		unit.setFont(new Font("宋体", Font.PLAIN, 12));
		unit.setBounds(165, 128, 120, 21);
		panel.add(unit);
		unit.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u4EF7");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 131, 54, 15);
		panel.add(lblNewLabel_2);
		
		JButton update = new JButton("\u4FEE\u6539\u8BA2\u5355");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update();
			}
		});
		update.setFont(new Font("宋体", Font.PLAIN, 12));
		update.setBounds(316, 82, 108, 23);
		panel.add(update);
		
		JButton delete = new JButton("\u5220\u9664\u6B64\u8BA2\u5355");
		delete.setFont(new Font("宋体", Font.PLAIN, 12));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drop();
			}
		});
		delete.setBounds(316, 127, 108, 23);
		panel.add(delete);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				root.setEnabled(true);
	        }
	    });
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
					TbSell tb = GetModel.getSell(new Item(number.getText().trim()));
					if(tb.getNumber() == null){
						JOptionPane.showMessageDialog(null, "该销售订单不存在!");
					}else{
						num = number.getText().trim();
						unit.setText(tb.getUnit()+"");
						count.setText(tb.getCount()+"");
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
			GetModel.getAllSell();
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "连接数据库超时");
		}
		if(number.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入订单号");
		}else{
			if(Patt.isCount(count.getText().trim())&&Patt.isUnit(unit.getText().trim())){
				try{
					Item item = new Item(num);
					TbSell tb = GetModel.getSell(item);
					float unit_value = Float.parseFloat(unit.getText().trim());
					int count_value = Integer.parseInt(count.getText().trim());
					tb.setUnit(unit_value);
					tb.setCount(count_value);
					tb.setTotal(unit_value*count_value);
					UpdateModel.updateSell(tb);
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
			GetModel.getAllSell();
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "连接数据库超时");
		}
		if(number.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "请输入订单号");
		}else{
			DeleteModel.deleteSell(new Item(num));
			JOptionPane.showMessageDialog(null, "删除成功!");
			number.setText("");
			unit.setText("");
			count.setText("");
			number.requestFocus();
		}
	}
}
