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

import DataBase.AccountDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txtMessage;
	private JTextField txtUsername;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 2, 425, 423);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton login = new JButton("Login");
		login.setFont(new Font("Tahoma", Font.BOLD, 15));
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(0, 206, 209));
		login.setBounds(138, 272, 129, 34);
		panel_1.add(login);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(138, 43, 226));
		lblNewLabel.setForeground(new Color(255, 20, 147));

		// Load the original image
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/chandungreal1.png"));
		Image originalImage = originalIcon.getImage();

		// Resize the image
		int width = 120; // Kích thước mới cho chiều rộng
		int height = 100; // Kích thước mới cho chiều cao
		Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		// Tạo ImageIcon từ hình ảnh đã điều chỉnh kích thước
		ImageIcon resizedIcon = new ImageIcon(resizedImage);

		lblNewLabel.setIcon(resizedIcon);
		lblNewLabel.setBounds(146, 0, 115, 100); // Đặt kích thước mới cho JLabel
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN MANAGER");
		lblNewLabel_1.setForeground(new Color(169, 169, 169));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(111, 109, 198, 23);
		panel_1.add(lblNewLabel_1);
		
		txtMessage = new JLabel("");
		txtMessage.setForeground(new Color(255, 0, 0));
		txtMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMessage.setBounds(55, 322, 309, 28);
		panel_1.add(txtMessage);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(49, 165, 109, 23);
		panel_1.add(lblNewLabel_1_1);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(168, 168, 196, 20);
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            AuthenticateAndLogin();
		        }
			}
		});
		panel_1.add(txtUsername);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(49, 221, 89, 23);
		panel_1.add(lblNewLabel_1_2);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(168, 224, 196, 20);
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            AuthenticateAndLogin();
		        }
			}
		});
		panel_1.add(txtPass);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToXML();
                // String name = tften.getText();
                // sendName(name);
                AuthenticateAndLogin();
				
			}

		});
	}
	
	private void saveToXML() {
        String name = txtUsername.getText();
        String pass = txtPass.getText();

        try {
            // Tạo một tài liệu XML mới
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Tạo phần tử root
            Element rootElement = doc.createElement("person");
            doc.appendChild(rootElement);

            // Tạo các phần tử con
            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(name));
            rootElement.appendChild(nameElement);

            Element ageElement = doc.createElement("SDT");
            ageElement.appendChild(doc.createTextNode(pass));
            rootElement.appendChild(ageElement);

            // Lưu tài liệu XML vào tệp
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("imformationNV.xml"));
            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	

	    
	    private void AuthenticateAndLogin() {
	        if (txtUsername.getText().isEmpty()) {
	            txtMessage.setText("Bạn chưa nhập tên tài khoản!");
	            return;
	        }
	        if (txtPass.getText().isEmpty()) {
	            txtMessage.setText("Bạn chưa nhập mật khẩu!");
	            return;
	        }

	        if (!AccountDAO.getInstance().Login(txtUsername.getText(), txtPass.getText())) {
	            txtMessage.setText("Sai tên đăng nhập hoặc mật khẩu!!");
	            return;
	        }
	        TrangChu tc = new TrangChu();
	        tc.setVisible(true);
	        dispose();
	    }
	    
	}

