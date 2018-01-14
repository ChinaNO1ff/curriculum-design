/*
 * �ɹ���������;
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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Buy_add extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> name;
	private JTextField count;
	private JTextField unit;
	private JTextField person;
	

	public Buy_add(JFrame root) {//�����ڵ�����;
		setResizable(false);
		setTitle("\u91C7\u8D2D\u8BA2\u5355");
		setBounds(480, 180, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		btnNewButton.setBounds(240, 208, 93, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u751F\u6210\u8BA2\u5355");
		button.setFont(new Font("����", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					GetModel.getAllPro();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "�������ݿⳬʱ");
				}
				if(count.getText().trim().equals("")||unit.getText().trim().equals("")||person.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "��������������Ϣ!");
				}else{
					if(Patt.isCount(count.getText().trim())&&Patt.isUnit(unit.getText().trim())){
						submit();
					}else{
						JOptionPane.showMessageDialog(null, "�������Ϣ���Ϸ�!");
					}
				}
			}
		});
		button.setBounds(75, 208, 93, 23);
		panel.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(91, 36, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u6570\u91CF");
		label.setFont(new Font("����", Font.PLAIN, 12));
		label.setBounds(91, 79, 54, 15);
		panel.add(label);
		
		count = new JTextField();
		count.setBounds(170, 76, 121, 21);
		panel.add(count);
		count.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u4EF7");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(91, 116, 54, 15);
		panel.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u91C7\u8D2D\u5458");
		label_1.setFont(new Font("����", Font.PLAIN, 12));
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
		
		name = new JComboBox<String>();
		name.setFont(new Font("����", Font.PLAIN, 12));
		name.setBounds(170, 33, 121, 21);
		panel.add(name);
		fillDrop();
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
	/*
	 * 	���ö�����;
	 */
	private void reset(){
		unit.setText("");
		count.setText("");
		person.setText("");
	}
	/*
	 * 	�ύ������
	 */
	private void submit(){
		TbBuy tb = new TbBuy();
		tb.setNumber(Timer.getNum());
		String name_value = (String) name.getSelectedItem();
		tb.setName(name_value);
		tb.setType(GetModel.getTypeByName(name_value));
		int count_value = Integer.parseInt(count.getText().trim());
		tb.setCount(count_value);
		float unit_value = Float.parseFloat(unit.getText().trim());
		tb.setUnit(unit_value);
		float total_value = count_value*unit_value;
		tb.setTotal(total_value);
		tb.setPerson(person.getText().trim());
		InsertModel.insertBuy(tb);
		JOptionPane.showMessageDialog(null, "��Ӷ����ɹ�");
		reset();
	}
	/*
	 * 	��������˵�;
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
