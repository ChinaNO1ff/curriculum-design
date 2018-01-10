package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

@SuppressWarnings("serial")
public class Buy_delete extends JFrame {

	private JPanel contentPane;
	private JTextField number;

	public Buy_delete(JFrame root) {
		setTitle("\u5220\u9664\u8BA2\u5355");
		setBounds(400, 200, 580, 260);
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
		
		JLabel tip = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u91C7\u8D2D\u8BA2\u5355\u7F16\u53F7\uFF1A");
		tip.setFont(new Font("ËÎÌו", Font.PLAIN, 12));
		tip.setBounds(70, 67, 183, 15);
		panel.add(tip);
		
		number = new JTextField();
		number.setBounds(263, 64, 211, 21);
		panel.add(number);
		number.setColumns(10);
	}

}
