package Phone;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class LoginKH extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tftensignin;
    private ServerSocket serversocket;
    private Socket socket;
    private PrintWriter Output;
    private JPasswordField tfpasssignin;
    private JTextField tftensignup;
    private JPasswordField passsingup1;
    private JPasswordField passsignup2;
    private JButton btnNewButton;
    private JButton btnNewButton_2_1;
    private JTextField txtUsername;
    private JTextField txtPass;
    private JTextField txtUsername_sign;
    private JTextField txtPass_sign;
    private JTextField txtRePass;
    
    private String host = "localhost";
    private int port = 12345;
    	

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginKH frame = new LoginKH();
                    frame.setLocationRelativeTo(null);
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
    public LoginKH() {
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 761, 477);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_signin = new JPanel();
        panel_signin.setBackground(SystemColor.window);
        panel_signin.setBounds(276, 0, 473, 442);
        contentPane.add(panel_signin);
        panel_signin.setLayout(null);
     

        
        
        JLabel lblNewLabel_2 = new JLabel("Sign in");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_2.setForeground(new Color(46, 139, 87));
        lblNewLabel_2.setBounds(195, 79, 115, 41);
        panel_signin.add(lblNewLabel_2);
        
        
        
        JButton btsignin = new JButton("Sign in");
        btsignin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		   Dash dash = new Dash();
        	        dash.setVisible(true);
        	}
        });
        btsignin.setBackground(new Color(46, 139, 87));
        btsignin.setForeground(new Color(255, 255, 255));
        btsignin.setBounds(183, 309, 108, 41);
        panel_signin.add(btsignin);
        
        txtUsername = new JTextField();
        txtUsername.setText("Tên đăng nhập");
        txtUsername.setBounds(93, 150, 299, 28);
        panel_signin.add(txtUsername);
        txtUsername.setColumns(10);
        
        txtPass = new JTextField();
        txtPass.setText("Mật khẩu");
        txtPass.setBounds(93, 222, 299, 28);
        panel_signin.add(txtPass);
        txtPass.setColumns(10);

        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(46, 139, 87));
        panel.setBounds(0, 0, 277, 442);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblWelcome = new JLabel("Welcome Store!");
        lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblWelcome.setForeground(new Color(255, 255, 255));
        lblWelcome.setBounds(54, 159, 169, 48);
        panel.add(lblWelcome);
        
        JPanel panel_signup = new JPanel();
        panel_signup.setBackground(new Color(255, 255, 255));
        panel_signup.setBounds(279, 0, 470, 442);
        panel_signup.setVisible(false);  // Ban đầu đặt nó là vô hình
        contentPane.add(panel_signup);
        panel_signup.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Create Account");
        lblNewLabel.setForeground(new Color(46, 139, 87));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(162, 65, 210, 40);
        panel_signup.add(lblNewLabel);     
        
        JButton btsignup = new JButton("Sign up");
        btsignup.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println(hashPassword(txtPass_sign.getText()));
        		try {
        			socket = new Socket(host, port);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	            
        	            String username = txtUsername_sign.getText();
        	            String password = txtPass_sign.getText();
        	            String hashpass = hashPassword(password);

        	            out.println("LOGIN");
        	            out.println(username);
        	            out.println(hashpass);

        	            // Đọc và in phản hồi từ máy chủ
        	            String response = in.readLine();
        	            JOptionPane.showMessageDialog(null, response);
        	        } catch (IOException ex) {
        	            ex.printStackTrace();
        	        }
        	}
        });
        btsignup.setForeground(new Color(255, 255, 255));
        btsignup.setBackground(new Color(46, 139, 87));
        btsignup.setFont(new Font("Tahoma", Font.BOLD, 15));
        btsignup.setBounds(202, 321, 106, 40);
        panel_signup.add(btsignup);
        
        txtUsername_sign = new JTextField();
        txtUsername_sign.setText("Tên đăng nhập");
        txtUsername_sign.setColumns(10);
        txtUsername_sign.setBounds(104, 126, 299, 28);
        panel_signup.add(txtUsername_sign);
        
        txtPass_sign = new JTextField();
        txtPass_sign.setText("Mật khẩu");
        txtPass_sign.setColumns(10);
        txtPass_sign.setBounds(104, 193, 299, 28);
        panel_signup.add(txtPass_sign);
        
        txtRePass = new JTextField();
        txtRePass.setText("Xác nhận mật khẩu");
        txtRePass.setColumns(10);
        txtRePass.setBounds(104, 262, 299, 28);
        panel_signup.add(txtRePass);
		
        btnNewButton = new JButton("Sign up");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel_signup.setVisible(true);
                panel_signin.setVisible(false);
                btnNewButton.setVisible(false);
                btnNewButton_2_1.setVisible(true);
            }
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(46, 139, 87));
        btnNewButton.setBounds(76, 241, 110, 28);
        // Tạo một viền màu trắng
        btnNewButton.setBorder(new LineBorder(Color.WHITE));
        panel.add(btnNewButton);
        
        btnNewButton_2_1 = new JButton("Sign in");
        btnNewButton_2_1.setBounds(76, 241, 110, 28);
        panel.add(btnNewButton_2_1);
        btnNewButton_2_1.setForeground(new Color(255, 255, 255));
        btnNewButton_2_1.setBackground(new Color(46, 139, 87));
        btnNewButton_2_1.setVisible(false);
        btnNewButton_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_signup.setVisible(false);
        		panel_signin.setVisible(true);
        		btnNewButton_2_1.setVisible(false);
        		 btnNewButton.setVisible(true);
        	}
        });
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_2_1.setBorder(new LineBorder(Color.WHITE));
        panel.add(btnNewButton);
        

        
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
