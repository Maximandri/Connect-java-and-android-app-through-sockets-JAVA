package com.apiplayer.forms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.apiplayer.db.ConexionDB;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textPassword2;

	/**
	 * Create the frame.
	 */
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(132, 122, 283, 31);
		textFieldUsername.setColumns(10);
		contentPane.add(textFieldUsername);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(132, 199, 283, 31);
		contentPane.add(textFieldPassword);

		textPassword2 = new JTextField();
		textPassword2.setColumns(10);
		textPassword2.setBounds(132, 279, 283, 31);
		contentPane.add(textPassword2);

		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(132, 11, 283, 65);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(132, 87, 134, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(132, 164, 134, 24);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Confirm password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(132, 244, 134, 24);
		contentPane.add(lblNewLabel_1_2);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (textFieldUsername.getText().length() > 20) {
					JOptionPane.showMessageDialog(null, "Username has a limit of 20 characters");
				} else if (textFieldPassword.getText().length() > 20) {
					JOptionPane.showMessageDialog(null, "Password has a limit of 20 characters");
				} else if (!textFieldPassword.getText().equals(textPassword2.getText())) {
					JOptionPane.showMessageDialog(null, "The passwords doesnt match");
				} else {

					try {

						String query = "select * from users where username = ?";
						Connection connection = ConexionDB.getConnection();
						PreparedStatement ps = connection.prepareStatement(query);
						ps.setString(1, textFieldUsername.getText());

						ResultSet rs = ps.executeQuery();
						int count = 0;
						while (rs.next()) {
							count++;
						}

						if (count > 0) {
							JOptionPane.showMessageDialog(null, "Username already exist");
						} else {
							JOptionPane.showMessageDialog(null, "Username has been created");
							String query2 = "INSERT INTO users (username, password_) values (?,?);";
							PreparedStatement ps2 = connection.prepareStatement(query2);
							ps2.setString(1, textFieldUsername.getText());
							ps2.setString(2, textFieldPassword.getText());

							ps2.execute();
						}

						ps.close();
						rs.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(184, 365, 159, 47);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBorder(null);
		btnExit.setBounds(184, 481, 159, 47);
		contentPane.add(btnExit);

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginForm frame = new LoginForm();
				frame.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setBounds(184, 423, 159, 47);
		contentPane.add(btnLogin);
	}
}
