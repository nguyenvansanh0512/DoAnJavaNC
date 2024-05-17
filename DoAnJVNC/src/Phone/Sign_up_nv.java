package Phone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.Account;
import DataBase.AccountDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Sign_up_nv extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtPass;
	private JTextField txtRePass;
	
	 DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up_nv frame = new Sign_up_nv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sign_up_nv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý tài khoản");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel.setBounds(147, 23, 217, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên hiển thị:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(89, 88, 89, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Đăng kí");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Chưa nhập tên!");
		            return;
		        }
		        if (txtUsername.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Chưa nhập tài khoản!");
		            return;
		        }
		        if (txtPass.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!");
		            return;
		        }
		        if (txtRePass.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Chưa nhập xác nhận mật khẩu!");
		            return;
		        }
		        if (!txtPass.getText().equals(txtRePass.getText())) {
		            JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu chưa chính xác!");
		            return;
		        }

		        if (AccountDAO.getInstance().Add(txtName.getText(), txtUsername.getText(), txtPass.getText())) {
		            JOptionPane.showMessageDialog(null, "Thêm mới thành công!!");

		        } else {
		            JOptionPane.showMessageDialog(null, "Lỗi!!");
		        }
		    }                                      


		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton.setBounds(187, 295, 122, 37);
		contentPane.add(btnNewButton);
		
		txtName = new JTextField();
		txtName.setBounds(216, 91, 196, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(216, 141, 196, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(216, 190, 196, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		txtRePass = new JTextField();
		txtRePass.setBounds(216, 243, 196, 20);
		contentPane.add(txtRePass);
		txtRePass.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(89, 138, 109, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(89, 187, 89, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nhập lại mật khẩu:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(89, 240, 122, 23);
		contentPane.add(lblNewLabel_1_3);
	}

}
