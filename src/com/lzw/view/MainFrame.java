package com.lzw.view;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
