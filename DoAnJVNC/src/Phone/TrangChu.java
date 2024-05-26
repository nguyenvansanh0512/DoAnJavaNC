package Phone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import DTO.Account;
import DTO.Phone;
import DataBase.AccountDAO;
import DataBase.AccountKHDAO;
import DataBase.ConnectionDB;
import DataBase.PhoneDAO;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TrangChu extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	private ServerSocket serversocket;
	private BufferedReader in;
	private PrintWriter out;
	private Thread t;
	private JTable table_nv;
	private JTable table_phone;
	private JTextField txttensp;
	private JTextField txtgia;
	DefaultTableModel tableModel_nv, tableModel_phone;
	private JComboBox<String> comboBox;
	int idSave = -1;
	private JTextField txtName;
	private JTextField txtPass;
	private JTextField txtUserName;
	private JTextField txtngay;
	private JTextField txtsl;

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
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
	public TrangChu() {

		tableModel_nv = new DefaultTableModel(new Object[] { "STT", "Tên", "Tài khoản" }, 0);
		table_nv = new JTable();
		table_nv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_nv.getSelectedRow();
				List<Account> list = AccountDAO.getInstance().listAccount();
				idSave = list.get(row).getId();

				txtName.setText(table_nv.getValueAt(row, 1) + "");
				txtUserName.setText(table_nv.getValueAt(row, 2) + "");

				txtPass.setText(list.get(row).getPassword());
			}
		});
		table_nv.setModel(tableModel_nv);
		LoadTable();

		tableModel_phone = new DefaultTableModel(new Object[] { "STT", "Tên", "Giá", "Loại", "Số lượng" }, 0);
		table_phone = new JTable();
		table_phone.setModel(tableModel_phone);
		displayTable();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1432, 876);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1418, 46);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbTNV = new JLabel("");
		lbTNV.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbTNV.setBounds(10, 11, 241, 24);
		lbTNV.setText("NV." + AccountDAO.getInstance().GetAccount().getName());
		panel.add(lbTNV);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setForeground(SystemColor.window);
		panel_1.setBounds(0, 46, 115, 791);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_tv = new JPanel();
		panel_tv.setBounds(113, 46, 1301, 791);
		contentPane.add(panel_tv);
		panel_tv.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(105, 77, 1035, 651);
		panel_tv.add(tabbedPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBounds(10, 0, 1291, 39);
		panel_tv.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Chat");
		lblNewLabel_2.setForeground(new Color(255, 102, 102));
		lblNewLabel_2.setBounds(10, 0, 111, 42);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));

		JPanel panel_kho = new JPanel();
		panel_kho.setBounds(117, 46, 1301, 784);
		contentPane.add(panel_kho);
		panel_kho.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.inactiveCaptionBorder);
		panel_6.setBounds(10, 505, 1281, 268);
		panel_kho.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Tên điện thoại:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(65, 60, 123, 19);
		panel_6.add(lblNewLabel_5);

		JLabel lblNewLabel_11 = new JLabel("Quản lý kho");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_11.setBounds(555, 11, 209, 19);
		panel_6.add(lblNewLabel_11);

		JLabel lblNewLabel_5_1 = new JLabel("Ngày nhập:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(710, 60, 100, 19);
		panel_6.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("Số lượng: ");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2.setBounds(995, 60, 123, 19);
		panel_6.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("Giá:");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_3.setBounds(420, 60, 77, 19);
		panel_6.add(lblNewLabel_5_3);

		txttensp = new JTextField();
		txttensp.setBounds(198, 59, 160, 20);
		panel_6.add(txttensp);
		txttensp.setColumns(10);

		txtgia = new JTextField();
		txtgia.setBounds(490, 58, 132, 20);
		panel_6.add(txtgia);
		txtgia.setColumns(10);

		JButton btadd = new JButton("Add");
		btadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					con = ConnectionDB.openConnection();
					stmt = con.createStatement();

					String phoneName = txttensp.getText();
					float price = Float.parseFloat(txtgia.getText());
					String day = txtngay.getText();
					int quantity = Integer.parseInt(txtsl.getText());

					String checkQuery = "SELECT * FROM phone WHERE name = '" + phoneName + "' AND price = " + price;
					rs = stmt.executeQuery(checkQuery);

					if (rs.next()) {
						int existingQuantity = rs.getInt("quantity");
						int newQuantity = existingQuantity + quantity;

						String updateQuery = "UPDATE phone SET quantity = " + newQuantity + ", price = " + price
								+ ", day = '" + day + "' WHERE name = '" + phoneName + "'";

						int i = stmt.executeUpdate(updateQuery);

						if (i > 0) {
							displayTable();
							JOptionPane.showMessageDialog(null, "Update Successful!!");
						} else {
							JOptionPane.showMessageDialog(null, "Update failed!!");
						}
					} else {

						String insertQuery = "INSERT INTO phone(name, price, day, quantity) VALUES ('" + phoneName
								+ "', " + price + ", '" + day + "', '" + quantity + "')";
						int i = stmt.executeUpdate(insertQuery);

						if (i > 0) {
							displayTable();
							JOptionPane.showMessageDialog(null, "Insert Successful!!");
						} else {
							JOptionPane.showMessageDialog(null, "Insert failed!!");
						}
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();
						if (con != null)
							con.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btadd.setBackground(new Color(64, 224, 208));
		btadd.setBounds(362, 169, 100, 35);
		panel_6.add(btadd);

		JButton btdelete = new JButton("Delete");
		btdelete.setBackground(new Color(64, 224, 208));
		btdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idSave >= 0) {
					con = ConnectionDB.openConnection();
					try {
						pstmt = con.prepareStatement("Delete from phone where ID=?");
						pstmt.setInt(1, idSave);
						int i = pstmt.executeUpdate();
						if (i > 0) {
							displayTable();
							idSave = -1;
							txttensp.setText("");
							txtgia.setText("");
							txtngay.setText("");
							txtsl.setText("");
							JOptionPane.showMessageDialog(null, "Delete Succesful!!");
						} else {
							JOptionPane.showMessageDialog(null, "Delete fail!!");
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Seletet to Delete!!");
				}
			}
		});
		btdelete.setBounds(710, 169, 100, 35);
		panel_6.add(btdelete);

		JButton btupdate = new JButton("Update");
		btupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idSave >= 0) {
					Connection con = ConnectionDB.openConnection();
					try {
						PreparedStatement pstmt = con
								.prepareStatement("update phone set name=?, price=?, day=?, quantity=? where ID=?");
						pstmt.setString(1, txttensp.getText());
						pstmt.setString(2, txtgia.getText());
						pstmt.setString(3, txtngay.getText());
						pstmt.setString(4, txtsl.getText());
						pstmt.setInt(5, idSave);
						int i = pstmt.executeUpdate();
						if (i > 0) {
							displayTable();
							JOptionPane.showMessageDialog(null, "Update Succesful!!");
						} else {
							JOptionPane.showMessageDialog(null, "Update fail!!");
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Seletet ID to update");
				}
			}
		});
		btupdate.setBackground(new Color(64, 224, 208));
		btupdate.setBounds(539, 169, 89, 35);
		panel_6.add(btupdate);

		txtngay = new JTextField();
		txtngay.setBounds(815, 59, 130, 20);
		panel_6.add(txtngay);
		txtngay.setColumns(10);

		txtsl = new JTextField();
		txtsl.setBounds(1086, 61, 30, 20);
		panel_6.add(txtsl);
		txtsl.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.inactiveCaptionBorder);
		panel_7.setBounds(10, 11, 1281, 444);
		panel_kho.add(panel_7);
		panel_7.setLayout(null);

		table_phone = new JTable();
		tableModel_phone = new DefaultTableModel(new Object[] { "STT", "Tên", "Giá", "Loại", "Số lượng" }, 0);
		table_phone.setModel(tableModel_phone);
		displayTable();
		table_phone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_phone.getSelectedRow();
				con = ConnectionDB.openConnection();
				List<Phone> list = PhoneDAO.getInstance().GetListphone();
				idSave = list.get(row).getId();
				txttensp.setText(table_phone.getValueAt(row, 1) + "");
				txtgia.setText(table_phone.getValueAt(row, 2) + "");
				txtngay.setText(table_phone.getValueAt(row, 3) + "");
				txtsl.setText(table_phone.getValueAt(row, 4) + "");
			}
		});
		table_phone.setBounds(31, 22, 1225, 400);
		panel_7.add(table_phone);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 479, 1281, 2);
		panel_kho.add(separator);

		JPanel panel_tc = new JPanel();
		panel_tc.setBounds(118, 46, 1300, 791);
		contentPane.add(panel_tc);
		panel_tc.setLayout(null);

		table_nv.setBounds(20, 60, 1006, 484);
		panel_tc.add(table_nv);

		JLabel lblNewLabel_7 = new JLabel("Danh sách Nhân viên");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(10, 16, 231, 33);
		panel_tc.add(lblNewLabel_7);
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/Tích2.png")); // Tải biểu tượng
		Image scaledIcon = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // Thay đổi kích
																									// thước của biểu
																									// tượng

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 153, 51));
		panel_4.setBounds(914, 11, 112, 38);
		panel_tc.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Cập nhật");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!AccountDAO.getInstance().GetAccount().getUsername().equals("admin")) {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập chức năng này!");
					return;
				}
				sign_up_nv();
			}
		});
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(10, 0, 91, 36);
		panel_4.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setIcon(new ImageIcon(scaledIcon));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 0, 51));
		panel_5.setBounds(1107, 495, 119, 38);
		panel_tc.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("Xóa ");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!AccountDAO.getInstance().GetAccount().getUsername().equals("admin")) {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập chức năng này!");
					return;
				}
				if (idSave >= 0) {
					if (AccountDAO.getInstance().Delete(idSave)) {
						LoadTable();
						idSave = -1;
						txtName.setText("");
						txtUserName.setText("");
						txtPass.setText("");

						JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công!!");
					} else {
						JOptionPane.showMessageDialog(null, "Xóa tài khoản không thành công!!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Seletet to Delete!!");
				}
			}
		});
		lblNewLabel_10.setBounds(10, 0, 129, 38);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));

		ImageIcon icon1 = new ImageIcon(getClass().getResource("/img/thungrac.png")); // Tải biểu tượng mới
		Image scaledIcon1 = icon1.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // Thay đổi kích
																										// thước của
																										// biểu tượng
		lblNewLabel_10.setIcon(new ImageIcon(scaledIcon1)); // Đặt biểu tượng vào JLabel

		panel_5.add(lblNewLabel_10);

		JLabel lblNewLabel_1_1 = new JLabel("Tên hiển thị:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(1066, 115, 89, 23);
		panel_tc.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(1066, 200, 109, 23);
		panel_tc.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(1066, 282, 89, 23);
		panel_tc.add(lblNewLabel_1_2);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(1066, 143, 196, 20);
		panel_tc.add(txtName);

		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(1066, 309, 196, 20);
		panel_tc.add(txtPass);

		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(1066, 227, 196, 20);
		panel_tc.add(txtUserName);

		JLabel lblNewLabel_1 = new JLabel("Kho hàng");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_kho.setVisible(true);
				panel_tv.setVisible(false);
				panel_tc.setVisible(false);

			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 88, 125, 42);
		panel_1.add(lblNewLabel_1);

		JLabel lblTVn = new JLabel("Tư vấn");
		lblTVn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tv.setVisible(true);
				panel_kho.setVisible(false);
				panel_tc.setVisible(false);

			}
		});

		lblTVn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTVn.setBounds(10, 164, 125, 42);
		panel_1.add(lblTVn);

		JLabel lblNewLabel_6 = new JLabel("Trang chủ");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tc.setVisible(true);
				panel_tv.setVisible(false);
				panel_kho.setVisible(false);

			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 23, 125, 42);
		panel_1.add(lblNewLabel_6);

		
		 this.setSize(1432, 876);
		 try {
			serversocket = new ServerSocket(12345);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		 t = new Thread(this);
		 t.start();
		

	}

	public void run() {
		while (true) {
			try {
				Socket socket = serversocket.accept();
				if (socket != null) {
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					out = new PrintWriter(socket.getOutputStream(), true);
					String S = in.readLine();
					if ("SIGN".equals(S)) {
						String username = in.readLine();
						String password = in.readLine();
						
						saveInformation(username, password);
					}
					if("LOGIN".equals(S)){
						String username = in.readLine();
						String password = in.readLine();

						if (!AccountKHDAO.getInstance().Login(username, password)) {
							out.println("Không thành công");
							return;
						}
						else{
							out.println(username);
							out.println(password);
						}
					}
					else{
					int pos = S.indexOf(":");
					String staffName = AccountKHDAO.getInstance().GetAccountKH().getUsername();
					ChatPanel p = new ChatPanel(socket, "Manager", staffName);
					tabbedPane.add(staffName, p);
					p.updateUI();
					}
				}
				
				Thread.sleep(100);
			} catch (Exception e) {

				
				e.printStackTrace();


			}
		}
	}

	private void LoadTable() {
		tableModel_nv.setRowCount(0);
		List<Account> list = AccountDAO.getInstance().listAccount();
		for (int i = 0; i < list.size(); i++) {
			Account account = list.get(i);
			Object[] dt = { i + 1, account.getName(), account.getUsername() };
			tableModel_nv.addRow(dt);
		}

	}

	private void displayTable() {
		tableModel_phone.setRowCount(0);
		List<Phone> list = PhoneDAO.getInstance().GetListphone();
		for (int i = 0; i < list.size(); i++) {
			Phone phone = list.get(i);
			Object[] dt = { i + 1, phone.getName(), phone.getPrice(), phone.getDay(), phone.getQuantity() };
			tableModel_phone.addRow(dt);
		}
	}
	
	private void displayTable_nv() {
		tableModel_nv.setRowCount(0);
		List<Account> list = AccountDAO.getInstance().listAccount();
		for (int i = 0; i < list.size(); i++) {
			Account account = list.get(i);
			Object[] dt = { i + 1, account.getName(), account.getUsername()};
			tableModel_nv.addRow(dt);
		}
	}
	
	private void sign_up_nv() {
        // Tạo JDialog cho giao diện con
        JDialog childDialog = new JDialog(this, true);
        childDialog.setSize(512, 393);
        childDialog.setLocationRelativeTo(this);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        childDialog.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Quản lý tài khoản (Con)");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblNewLabel.setBounds(147, 23, 217, 37);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Tên hiển thị:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(89, 88, 89, 23);
        contentPane.add(lblNewLabel_1);

        JTextField txtName = new JTextField();
        txtName.setBounds(216, 91, 196, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(216, 141, 196, 20);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);

        JTextField txtPass = new JTextField();
        txtPass.setBounds(216, 190, 196, 20);
        contentPane.add(txtPass);
        txtPass.setColumns(10);

        JTextField txtRePass = new JTextField();
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
                    displayTable_nv();
                    childDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi!!");
                }
            }
        });
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnNewButton.setBounds(187, 295, 122, 37);
        contentPane.add(btnNewButton);

        childDialog.setVisible(true);
    }

	private void saveInformation(String username, String password) {
		String insertSQL = "INSERT INTO `accountkh` (`username`, `password`) VALUES (?, ?)";
		try {
			con = ConnectionDB.openConnection();
			
			pstmt = con.prepareStatement(insertSQL);

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			int i = pstmt.executeUpdate();
            if (i > 0) {
            	System.out.println("Thông tin tài khoản đã được lưu vào CSDL.");
            }
            else {
                System.out.println("Lưu thông tin tài khoản không thành công.");
            }
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
