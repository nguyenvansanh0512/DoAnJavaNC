package Phone;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class LoginKH extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tften;
    private JPasswordField tfsdt;
    private ServerSocket serversocket;
    private Socket socket;
    private PrintWriter Output;

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

        tften = new JTextField();
        tften.setBounds(169, 35, 214, 23);
        panel_1.add(tften);
        tften.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Phone number :");
        lblNewLabel_1.setBounds(10, 71, 92, 23);
        panel_1.add(lblNewLabel_1);

        tfsdt = new JPasswordField();
        tfsdt.setBounds(169, 75, 214, 20);
        panel_1.add(tfsdt);

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
                tften.setText("");
                tfsdt.setText("");
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
                Dash r = new Dash();
                r.setLocationRelativeTo(null);
                r.setVisible(true);

            }
        });
    }

    private void saveToXML() {
        String name = tften.getText();
        String sdt = tfsdt.getText();

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
            StreamResult result = new StreamResult(new File("imformation.xml"));
            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
