package com.apiplayer.forms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.apiplayer.db.ConexionDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(177, 25, 222, 49);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setVerticalAlignment(JLabel.CENTER);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(177, 118, 222, 55);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(177, 184, 222, 55);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					String query = "select * from users where username = ? and password_ = ?";
					Connection connection = ConexionDB.getConnection();
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, textField.getText());
					ps.setString(2, String.valueOf(passwordField.getPassword()));

					ResultSet rs = ps.executeQuery();
					int count = 0;
					while (rs.next()) {
						count++;
					}

					if (count > 0) {
						dispose();
						ServerForm frame = new ServerForm();
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					}

					ps.close();
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(107, 262, 124, 55);
		contentPane.add(btnNewButton);

		JButton btnClose = new JButton("Close");
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClose.setBounds(336, 262, 124, 55);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnClose);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dispose();
					RegisterForm frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(221, 328, 124, 49);
		contentPane.add(btnNewButton_1);

	}
}
