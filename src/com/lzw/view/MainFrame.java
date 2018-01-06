package com.lzw.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/res/g5.png")));
		setTitle("\u5EFA\u6750\u7269\u8D44\u7BA1\u7406\u4FE1\u606F\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon(MainFrame.class.getResource("/res/bg.jpg")));
		bg.setBounds(0, 0, 794, 422);
		desktopPane.add(bg);
	}
}
