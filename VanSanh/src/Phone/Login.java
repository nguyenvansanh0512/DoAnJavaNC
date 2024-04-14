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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tftdn;
	private JPasswordField tfmk;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 0, 438, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Login To Store Phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(130, 11, 207, 21);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(0, 44, 438, 221);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton login = new JButton("Login");
		login.setBackground(new Color(100, 149, 237));
		login.setBounds(115, 174, 84, 23);
		panel_1.add(login);
		
		JLabel lblNewLabel = new JLabel("UserName :");
		lblNewLabel.setBounds(10, 35, 84, 23);
		panel_1.add(lblNewLabel);
		
		tftdn = new JTextField();
		tftdn.setBounds(169, 35, 214, 23);
		panel_1.add(tftdn);
		tftdn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(10, 71, 92, 23);
		panel_1.add(lblNewLabel_1);
		
		tfmk = new JPasswordField();
		tfmk.setBounds(169, 75, 214, 20);
		panel_1.add(tfmk);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 0, 418, 2);
		panel_1.add(separator);
		
		JCheckBox remember = new JCheckBox("Remember Me?");
		remember.setBackground(SystemColor.window);
		remember.setBounds(169, 102, 151, 23);
		panel_1.add(remember);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 147, 438, 2);
		panel_1.add(separator_1);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBackground(new Color(240, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tftdn.setText("");
				tfmk.setText("");
				remember.setSelected(false);
			}
		});
		btnNewButton_1.setBounds(234, 174, 84, 23);
		panel_1.add(btnNewButton_1);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToXML();
                // String name = tften.getText();
                // sendName(name);
                dispose();
                TrangChu r = new TrangChu();
                r.setLocationRelativeTo(null);
                r.setVisible(true);
				
			}

		});
	}
	
	private void saveToXML() {
        String name = tftdn.getText();
        String sdt = tfmk.getText();

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
            ageElement.appendChild(doc.createTextNode(sdt));
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
}
