package Phone;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TrangChu extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	
	
	private ServerSocket serversocket;
	private BufferedReader bf;
	private Thread t;
	private JTable table;

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
		
		JLabel lbTNV = new JLabel("Manage");
		lbTNV.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbTNV.setBounds(10, 11, 241, 24);
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
		
		JLabel lblNewLabel_4 = new JLabel("Tư vấn");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(609, 21, 84, 33);
		panel_tv.add(lblNewLabel_4);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(217, 95, 855, 651);
		panel_tv.add(tabbedPane);
		
		JPanel panel_kho = 	new JPanel();
		panel_kho.setBounds(117, 46, 1301, 784);
		contentPane.add(panel_kho);
		panel_kho.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("kho");
		lblNewLabel_5.setBounds(606, 34, 131, 40);
		panel_kho.add(lblNewLabel_5);
		
		table = new JTable();
		table.setBounds(224, 101, 743, 339);
		panel_kho.add(table);
		
		JPanel panel_tc = new JPanel();
		panel_tc.setBounds(118, 46, 1300, 791);
		contentPane.add(panel_tc);
		panel_tc.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Trang chủ");
		lblNewLabel_7.setBounds(541, 51, 195, 47);
		panel_tc.add(lblNewLabel_7);
		
		JPanel panel_nv = new JPanel();
		panel_nv.setBounds(118, 46, 1300, 791);
		contentPane.add(panel_nv);
		panel_nv.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhân viên");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_nv.setVisible(true);
				panel_tv.setVisible(false);
				panel_kho.setVisible(false);
				panel_tc.setVisible(false);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 239, 125, 42);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hàng tồn kho");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_kho.setVisible(true);
				panel_tv.setVisible(false);
				panel_tc.setVisible(false);
				panel_nv.setVisible(false);
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
					panel_nv.setVisible(false);

				}
		});
		
		lblTVn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTVn.setBounds(10, 164, 125, 42);
		panel_1.add(lblTVn);
		
		JLabel lblNewLabel_3 = new JLabel("....");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(10, 318, 125, 42);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Trang chủ");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tc.setVisible(true);
				panel_tv.setVisible(false);
				panel_kho.setVisible(false);
				panel_nv.setVisible(false);

			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 23, 125, 42);
		panel_1.add(lblNewLabel_6);
		
		
		
		Person p = new Person();
		p.informationNVXML();
		p.setNameToTextAreaTNV(lbTNV);

		this.setSize(1432,876);
		try {
			serversocket = new ServerSocket(12344);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t= new Thread(this);
		t.start();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		while (true) {
			try {
				Socket socket = serversocket.accept();
			if(socket != null) {
				bf= new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String S = bf.readLine();
				int pos = S.indexOf(":");
				String staffName = S.substring(pos+1);
				ChatPanel p = new ChatPanel(socket, "Manager", staffName);
				tabbedPane.add(staffName, p);
				p.updateUI();
			}
			Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


