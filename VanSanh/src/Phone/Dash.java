package Phone;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dash extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private JLabel jtxtime;
	private JLabel jtxdate;
	private JLabel lbdh;
	private JLabel lbngay;
	private JTextArea textAreatong;
	private JTextArea textArea;
	private JTextArea textAreaTKH;
	private static JTextArea textAreachat;
	private Panel panechat;
	private static JTextField tfchat;

	private ServerSocket serversocket;
	private Socket socket;
	private BufferedReader Input;
	private PrintWriter Output;
	private DataOutputStream os;
	

	private static File xmlFile;
	private static DocumentBuilderFactory dbFactory;
	private static DocumentBuilder dBuilder;
	private static Document doc;
	private static NodeList nodeList;
	private static String name;

	int x = 0;
	private int total = 0;
	boolean isRoyalIphoneCalled = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dash frame = new Dash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1415, 879);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel chatPanel = createChatPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 0, 1447, 35);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Store Iphone");
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 211, 41);
		panel.add(lblNewLabel);

		jtxtime = new JLabel("");
		jtxtime.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jtxtime.setBounds(1062, 0, 124, 33);
		panel.add(jtxtime);

		jtxdate = new JLabel("");
		jtxdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jtxdate.setBounds(1235, 0, 219, 33);
		panel.add(jtxdate);

		// JButton btnmess = new JButton("");
		// btnmess.setBounds(14, 11, 55, 37);
		// panel.add(btnmess);
		// ImageIcon iconlbanh = new
		// ImageIcon(Dash.class.getResource("/img/logomess.png"));
		// Image imganh = iconlbanh.getImage().getScaledInstance(35, 35,
		// Image.SCALE_SMOOTH);
		// btnmess.setIcon(new ImageIcon(imganh));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.activeCaptionBorder);
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(-92, 28, 1557, 862);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(306, 18, 1045, 30);
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setForeground(new Color(248, 248, 255));
		panel_2.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2.setBounds(108, 52, 200, 339);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("6.7''");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 153, 51));
		lblNewLabel_2.setBounds(23, 182, 35, 14);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Super Retina XDR");
		lblNewLabel_3.setBounds(91, 182, 110, 14);
		panel_2.add(lblNewLabel_3);

		JLabel tenip15prm = new JLabel("Iphone 15 Pro Max");
		tenip15prm.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip15prm.setBounds(22, 157, 130, 14);
		panel_2.add(tenip15prm);

		JLabel giaip15prm = new JLabel("29.990.000đ");
		giaip15prm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip15prm.setForeground(new Color(255, 51, 0));
		giaip15prm.setBounds(23, 207, 178, 21);
		panel_2.add(giaip15prm);

		JLabel Sao15prm = new JLabel("New label");
		Sao15prm.setBounds(10, 239, 155, 21);
		panel_2.add(Sao15prm);
		Sao15prm.setIcon(new ImageIcon(getClass().getResource("/img/Sao Ip11.png")));

		ImageIcon icon = (ImageIcon) Sao15prm.getIcon();
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(Sao15prm.getWidth(), Sao15prm.getHeight(), Image.SCALE_SMOOTH);
		Sao15prm.setIcon(new ImageIcon(newImg));

		JLabel P15prm = new JLabel("");
		P15prm.setBounds(40, 11, 123, 135);
		panel_2.add(P15prm);
		P15prm.setIcon(new ImageIcon(getClass().getResource("/img/Ip15prm.png")));

		ImageIcon iconn = (ImageIcon) P15prm.getIcon();
		Image imgg = iconn.getImage();
		Image newImgg = imgg.getScaledInstance(P15prm.getWidth(), P15prm.getHeight(), Image.SCALE_SMOOTH);
		P15prm.setIcon(new ImageIcon(newImgg));

		JLabel lblNewLabel_6 = new JLabel("-Chip Apple A17 Pro 6 nhân");
		lblNewLabel_6.setBounds(23, 263, 155, 14);
		panel_2.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("-Ram: 8G");
		lblNewLabel_6_1.setBounds(23, 288, 155, 14);
		panel_2.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_1_1 = new JLabel("-Dung lượng: 256G");
		lblNewLabel_6_1_1.setBounds(23, 313, 155, 14);
		panel_2.add(lblNewLabel_6_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 186, 35, -2);
		panel_2.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaptionBorder);
		panel_4.setBounds(10, 182, 41, 14);
		panel_2.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaptionBorder);
		panel_5.setBounds(89, 182, 112, 14);
		panel_2.add(panel_5);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setForeground(new Color(248, 248, 255));
		panel_2_1.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_1.setBackground(SystemColor.window);
		panel_2_1.setBounds(319, 52, 200, 339);
		panel_1.add(panel_2_1);

		JLabel lblNewLabel_2_1 = new JLabel("6.1''");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_1.setBounds(23, 182, 35, 14);
		panel_2_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Super Retina XDR");
		lblNewLabel_3_1.setBounds(91, 182, 110, 14);
		panel_2_1.add(lblNewLabel_3_1);

		JLabel tenip15pr = new JLabel("Iphone 15 Pro");
		tenip15pr.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip15pr.setBounds(22, 157, 130, 14);
		panel_2_1.add(tenip15pr);

		JLabel giaip15pr = new JLabel("25.990.000đ");
		giaip15pr.setForeground(new Color(255, 51, 0));
		giaip15pr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip15pr.setBounds(23, 207, 178, 21);
		panel_2_1.add(giaip15pr);

		JLabel Sao15prm_1 = new JLabel("New label");
		Sao15prm_1.setIcon(new ImageIcon(getClass().getResource("/img/Sao Ip15pr.png")));
		Sao15prm_1.setBounds(29, 239, 123, 13);
		panel_2_1.add(Sao15prm_1);

		ImageIcon iconSao15prm_1 = (ImageIcon) Sao15prm_1.getIcon();

		Image imgSao15prm_1 = iconSao15prm_1.getImage();

		Image newImgSao15prm_1 = imgSao15prm_1.getScaledInstance(Sao15prm_1.getWidth(), Sao15prm_1.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_1.setIcon(new ImageIcon(newImgSao15prm_1));

		JLabel P15prm_1 = new JLabel("");
		P15prm_1.setIcon(new ImageIcon(getClass().getResource("/img/Ip15pr.png")));
		P15prm_1.setBounds(40, 11, 123, 135);
		panel_2_1.add(P15prm_1);

		ImageIcon iconP15prm_1 = (ImageIcon) P15prm_1.getIcon();

		Image imgP15prm_1 = iconP15prm_1.getImage();

		Image newImgP15prm_1 = imgP15prm_1.getScaledInstance(P15prm_1.getWidth(), P15prm_1.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_1.setIcon(new ImageIcon(newImgP15prm_1));

		JLabel lblNewLabel_6_2 = new JLabel("-Chip Apple A17 Pro 6 nhân");
		lblNewLabel_6_2.setBounds(23, 263, 155, 14);
		panel_2_1.add(lblNewLabel_6_2);

		JLabel lblNewLabel_6_1_2 = new JLabel("-Ram: 8G");
		lblNewLabel_6_1_2.setBounds(23, 288, 155, 14);
		panel_2_1.add(lblNewLabel_6_1_2);

		JLabel lblNewLabel_6_1_1_1 = new JLabel("-Dung lượng: 128G");
		lblNewLabel_6_1_1_1.setBounds(23, 313, 155, 14);
		panel_2_1.add(lblNewLabel_6_1_1_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.activeCaptionBorder);
		panel_6.setBounds(10, 182, 45, 14);
		panel_2_1.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.activeCaptionBorder);
		panel_7.setBounds(86, 182, 115, 14);
		panel_2_1.add(panel_7);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setForeground(new Color(248, 248, 255));
		panel_2_2.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_2.setBackground(SystemColor.window);
		panel_2_2.setBounds(533, 52, 200, 339);
		panel_1.add(panel_2_2);

		JLabel lblNewLabel_2_2 = new JLabel("6.7''");
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_2.setBounds(23, 182, 35, 14);
		panel_2_2.add(lblNewLabel_2_2);

		JLabel lblNewLabel_3_2 = new JLabel("Super Retina XDR");
		lblNewLabel_3_2.setBounds(91, 182, 110, 14);
		panel_2_2.add(lblNewLabel_3_2);

		JLabel tenip15pl = new JLabel("Iphone 15 Plus");
		tenip15pl.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip15pl.setBounds(22, 157, 130, 14);
		panel_2_2.add(tenip15pl);

		JLabel giaip15p = new JLabel("23.090.000đ");
		giaip15p.setForeground(new Color(255, 51, 0));
		giaip15p.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip15p.setBounds(23, 207, 178, 21);
		panel_2_2.add(giaip15p);

		JLabel Sao15prm_2 = new JLabel("New label");
		Sao15prm_2.setIcon(new ImageIcon(getClass().getResource("/img/Sao ip15pl.png")));
		Sao15prm_2.setBounds(23, 231, 155, 21);
		panel_2_2.add(Sao15prm_2);

		ImageIcon iconSao15prm_2 = (ImageIcon) Sao15prm_2.getIcon();

		Image imgSao15prm_2 = iconSao15prm_2.getImage();

		Image newImgSao15prm_2 = imgSao15prm_2.getScaledInstance(Sao15prm_2.getWidth(), Sao15prm_2.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_2.setIcon(new ImageIcon(newImgSao15prm_2));

		JLabel P15prm_2 = new JLabel("");
		P15prm_2.setIcon(new ImageIcon(getClass().getResource("/img/Ip15pl.png")));
		P15prm_2.setBounds(40, 11, 123, 135);
		panel_2_2.add(P15prm_2);

		ImageIcon iconP15prm_2 = (ImageIcon) P15prm_2.getIcon();

		Image imgP15prm_2 = iconP15prm_2.getImage();

		Image newImgP15prm_2 = imgP15prm_2.getScaledInstance(P15prm_2.getWidth(), P15prm_2.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_2.setIcon(new ImageIcon(newImgP15prm_2));

		JLabel lblNewLabel_6_3 = new JLabel("-Chip Apple A16 Bionic");
		lblNewLabel_6_3.setBounds(23, 263, 155, 14);
		panel_2_2.add(lblNewLabel_6_3);

		JLabel lblNewLabel_6_1_3 = new JLabel("-Ram: 6G");
		lblNewLabel_6_1_3.setBounds(23, 288, 155, 14);
		panel_2_2.add(lblNewLabel_6_1_3);

		JLabel lblNewLabel_6_1_1_2 = new JLabel("-Dung lượng: 128G");
		lblNewLabel_6_1_1_2.setBounds(23, 313, 155, 14);
		panel_2_2.add(lblNewLabel_6_1_1_2);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.activeCaptionBorder);
		panel_8.setBounds(10, 182, 42, 14);
		panel_2_2.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.activeCaptionBorder);
		panel_9.setBounds(82, 182, 119, 14);
		panel_2_2.add(panel_9);

		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setForeground(new Color(248, 248, 255));
		panel_2_3.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_3.setBackground(SystemColor.window);
		panel_2_3.setBounds(743, 52, 200, 339);
		panel_1.add(panel_2_3);

		JLabel lblNewLabel_2_3 = new JLabel("6.1''");
		lblNewLabel_2_3.setForeground(Color.BLACK);
		lblNewLabel_2_3.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_3.setBounds(23, 182, 35, 14);
		panel_2_3.add(lblNewLabel_2_3);

		JLabel lblNewLabel_3_3 = new JLabel("Super Retina XDR");
		lblNewLabel_3_3.setBounds(91, 182, 110, 14);
		panel_2_3.add(lblNewLabel_3_3);

		JLabel tenip15 = new JLabel("Iphone 15 ");
		tenip15.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip15.setBounds(22, 157, 130, 14);
		panel_2_3.add(tenip15);

		JLabel giaip15 = new JLabel("19.890.000đ");
		giaip15.setForeground(new Color(255, 51, 0));
		giaip15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip15.setBounds(23, 207, 178, 21);
		panel_2_3.add(giaip15);

		JLabel Sao15prm_3 = new JLabel("New label");
		Sao15prm_3.setIcon(new ImageIcon(getClass().getResource("/img/Sao ip15.png")));
		Sao15prm_3.setBounds(10, 239, 155, 21);
		panel_2_3.add(Sao15prm_3);

		ImageIcon iconSao15prm_3 = (ImageIcon) Sao15prm_3.getIcon();

		Image imgSao15prm_3 = iconSao15prm_3.getImage();

		Image newImgSao15prm_3 = imgSao15prm_3.getScaledInstance(Sao15prm_3.getWidth(), Sao15prm_3.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_3.setIcon(new ImageIcon(newImgSao15prm_3));

		JLabel P15prm_3 = new JLabel("");
		P15prm_3.setIcon(new ImageIcon(getClass().getResource("/img/Ip15.png")));
		P15prm_3.setBounds(40, 11, 123, 135);
		panel_2_3.add(P15prm_3);

		ImageIcon iconP15prm_3 = (ImageIcon) P15prm_3.getIcon();

		Image imgP15prm_3 = iconP15prm_3.getImage();

		Image newImgP15prm_3 = imgP15prm_3.getScaledInstance(P15prm_3.getWidth(), P15prm_3.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_3.setIcon(new ImageIcon(newImgP15prm_3));

		JLabel lblNewLabel_6_4 = new JLabel("-Chip Apple A16 Bionic");
		lblNewLabel_6_4.setBounds(23, 263, 155, 14);
		panel_2_3.add(lblNewLabel_6_4);

		JLabel lblNewLabel_6_1_4 = new JLabel("-Ram: 6G");
		lblNewLabel_6_1_4.setBounds(23, 288, 155, 14);
		panel_2_3.add(lblNewLabel_6_1_4);

		JLabel lblNewLabel_6_1_1_3 = new JLabel("-Dung lượng: 128G");
		lblNewLabel_6_1_1_3.setBounds(23, 313, 155, 14);
		panel_2_3.add(lblNewLabel_6_1_1_3);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.activeCaptionBorder);
		panel_10.setBounds(10, 182, 41, 14);
		panel_2_3.add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.activeCaptionBorder);
		panel_11.setBounds(85, 182, 116, 14);
		panel_2_3.add(panel_11);

		JPanel panel_2_4 = new JPanel();
		panel_2_4.setLayout(null);
		panel_2_4.setForeground(new Color(248, 248, 255));
		panel_2_4.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_4.setBackground(SystemColor.window);
		panel_2_4.setBounds(953, 52, 200, 339);
		panel_1.add(panel_2_4);

		JLabel lblNewLabel_2_4 = new JLabel("6.7''");
		lblNewLabel_2_4.setForeground(Color.BLACK);
		lblNewLabel_2_4.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_4.setBounds(23, 182, 35, 14);
		panel_2_4.add(lblNewLabel_2_4);

		JLabel lblNewLabel_3_4 = new JLabel("Super Retina XDR");
		lblNewLabel_3_4.setBounds(91, 182, 110, 14);
		panel_2_4.add(lblNewLabel_3_4);

		JLabel tenip14prm = new JLabel("Iphone 14 Pro Max");
		tenip14prm.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip14prm.setBounds(22, 157, 130, 14);
		panel_2_4.add(tenip14prm);

		JLabel giaip14prm = new JLabel("27.390.000đ");
		giaip14prm.setForeground(new Color(255, 51, 0));
		giaip14prm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip14prm.setBounds(23, 207, 178, 21);
		panel_2_4.add(giaip14prm);

		JLabel Sao15prm_4 = new JLabel("New label");
		Sao15prm_4.setIcon(new ImageIcon(getClass().getResource("/img/Sao Ip14Prm.png")));
		Sao15prm_4.setBounds(10, 239, 155, 21);
		panel_2_4.add(Sao15prm_4);

		ImageIcon iconSao15prm_4 = (ImageIcon) Sao15prm_4.getIcon();

		Image imgSao15prm_4 = iconSao15prm_4.getImage();

		Image newImgSao15prm_4 = imgSao15prm_4.getScaledInstance(Sao15prm_4.getWidth(), Sao15prm_4.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_4.setIcon(new ImageIcon(newImgSao15prm_4));

		JLabel P15prm_4 = new JLabel("");
		P15prm_4.setIcon(new ImageIcon(getClass().getResource("/img/Ip14Prm.png")));
		P15prm_4.setBounds(40, 11, 123, 135);
		panel_2_4.add(P15prm_4);

		ImageIcon iconP15prm_4 = (ImageIcon) P15prm_4.getIcon();

		Image imgP15prm_4 = iconP15prm_4.getImage();

		Image newImgP15prm_4 = imgP15prm_4.getScaledInstance(P15prm_4.getWidth(), P15prm_4.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_4.setIcon(new ImageIcon(newImgP15prm_4));

		JLabel lblNewLabel_6_5 = new JLabel("-Chip Apple A16 Bionic");
		lblNewLabel_6_5.setBounds(23, 263, 155, 14);
		panel_2_4.add(lblNewLabel_6_5);

		JLabel lblNewLabel_6_1_5 = new JLabel("-Ram: 6G");
		lblNewLabel_6_1_5.setBounds(23, 288, 155, 14);
		panel_2_4.add(lblNewLabel_6_1_5);

		JLabel lblNewLabel_6_1_1_4 = new JLabel("-Dung lượng: 256G");
		lblNewLabel_6_1_1_4.setBounds(23, 313, 155, 14);
		panel_2_4.add(lblNewLabel_6_1_1_4);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(SystemColor.activeCaptionBorder);
		panel_12.setBounds(10, 182, 41, 14);
		panel_2_4.add(panel_12);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(SystemColor.activeCaptionBorder);
		panel_13.setBounds(86, 182, 115, 14);
		panel_2_4.add(panel_13);

		JPanel panel_2_5 = new JPanel();
		panel_2_5.setLayout(null);
		panel_2_5.setForeground(new Color(248, 248, 255));
		panel_2_5.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_5.setBackground(SystemColor.window);
		panel_2_5.setBounds(108, 395, 200, 339);
		panel_1.add(panel_2_5);

		JLabel lblNewLabel_2_5 = new JLabel("6.1''");
		lblNewLabel_2_5.setForeground(Color.BLACK);
		lblNewLabel_2_5.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_5.setBounds(23, 182, 35, 14);
		panel_2_5.add(lblNewLabel_2_5);

		JLabel lblNewLabel_3_5 = new JLabel("Super Retina XDR");
		lblNewLabel_3_5.setBounds(91, 182, 110, 14);
		panel_2_5.add(lblNewLabel_3_5);

		JLabel tenip14pr = new JLabel("Iphone 14 Pro");
		tenip14pr.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip14pr.setBounds(22, 157, 130, 14);
		panel_2_5.add(tenip14pr);

		JLabel giaip14pr = new JLabel("27.490.000đ");
		giaip14pr.setForeground(new Color(255, 51, 0));
		giaip14pr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip14pr.setBounds(23, 207, 178, 21);
		panel_2_5.add(giaip14pr);

		JLabel Sao15prm_5 = new JLabel("New label");
		Sao15prm_5.setIcon(new ImageIcon(getClass().getResource("/img/Sao ip14Pr.png")));
		Sao15prm_5.setBounds(10, 239, 155, 21);
		panel_2_5.add(Sao15prm_5);

		ImageIcon iconSao15prm_5 = (ImageIcon) Sao15prm_5.getIcon();

		Image imgSao15prm_5 = iconSao15prm_5.getImage();

		Image newImgSao15prm_5 = imgSao15prm_5.getScaledInstance(Sao15prm_5.getWidth(), Sao15prm_5.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_5.setIcon(new ImageIcon(newImgSao15prm_5));

		JLabel P15prm_5 = new JLabel("");
		P15prm_5.setIcon(new ImageIcon(getClass().getResource("/img/Ip14Pr.png")));
		P15prm_5.setBounds(40, 11, 123, 135);
		panel_2_5.add(P15prm_5);

		ImageIcon iconP15prm_5 = (ImageIcon) P15prm_5.getIcon();

		Image imgP15prm_5 = iconP15prm_5.getImage();

		Image newImgP15prm_5 = imgP15prm_5.getScaledInstance(P15prm_5.getWidth(), P15prm_5.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_5.setIcon(new ImageIcon(newImgP15prm_5));

		JLabel lblNewLabel_6_6 = new JLabel("-Chip Apple A16 Bionic");
		lblNewLabel_6_6.setBounds(23, 263, 155, 14);
		panel_2_5.add(lblNewLabel_6_6);

		JLabel lblNewLabel_6_1_6 = new JLabel("-Ram: 6G");
		lblNewLabel_6_1_6.setBounds(23, 288, 155, 14);
		panel_2_5.add(lblNewLabel_6_1_6);

		JLabel lblNewLabel_6_1_1_5 = new JLabel("-Dung lượng: 256G");
		lblNewLabel_6_1_1_5.setBounds(23, 313, 155, 14);
		panel_2_5.add(lblNewLabel_6_1_1_5);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(SystemColor.activeCaptionBorder);
		panel_14.setBounds(10, 182, 43, 14);
		panel_2_5.add(panel_14);

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(SystemColor.activeCaptionBorder);
		panel_15.setBounds(85, 182, 116, 14);
		panel_2_5.add(panel_15);

		JPanel panel_2_6 = new JPanel();
		panel_2_6.setLayout(null);
		panel_2_6.setForeground(new Color(248, 248, 255));
		panel_2_6.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_6.setBackground(SystemColor.window);
		panel_2_6.setBounds(319, 395, 200, 339);
		panel_1.add(panel_2_6);

		JLabel lblNewLabel_2_6 = new JLabel("6.7''");
		lblNewLabel_2_6.setForeground(Color.BLACK);
		lblNewLabel_2_6.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_6.setBounds(23, 182, 35, 14);
		panel_2_6.add(lblNewLabel_2_6);

		JLabel lblNewLabel_3_6 = new JLabel("Super Retina XDR");
		lblNewLabel_3_6.setBounds(91, 182, 110, 14);
		panel_2_6.add(lblNewLabel_3_6);

		JLabel tenip14p = new JLabel("Iphone 14 Plus");
		tenip14p.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip14p.setBounds(22, 157, 130, 14);
		panel_2_6.add(tenip14p);

		JLabel giaip14p = new JLabel("19.990.000đ");
		giaip14p.setForeground(new Color(255, 51, 0));
		giaip14p.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip14p.setBounds(23, 207, 178, 21);
		panel_2_6.add(giaip14p);

		JLabel Sao15prm_6 = new JLabel("New label");
		Sao15prm_6.setIcon(new ImageIcon(getClass().getResource("/img/Sao Ip14Pl.png")));
		Sao15prm_6.setBounds(10, 239, 155, 21);
		panel_2_6.add(Sao15prm_6);

		ImageIcon iconSao15prm_6 = (ImageIcon) Sao15prm_6.getIcon();

		Image imgSao15prm_6 = iconSao15prm_6.getImage();

		Image newImgSao15prm_6 = imgSao15prm_6.getScaledInstance(Sao15prm_6.getWidth(), Sao15prm_6.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_6.setIcon(new ImageIcon(newImgSao15prm_6));

		JLabel P15prm_6 = new JLabel("");
		P15prm_6.setIcon(new ImageIcon(getClass().getResource("/img/Ip14Pl.png")));
		P15prm_6.setBounds(40, 11, 123, 135);
		panel_2_6.add(P15prm_6);

		ImageIcon iconP15prm_6 = (ImageIcon) P15prm_6.getIcon();

		Image imgP15prm_6 = iconP15prm_6.getImage();

		Image newImgP15prm_6 = imgP15prm_6.getScaledInstance(P15prm_6.getWidth(), P15prm_6.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_6.setIcon(new ImageIcon(newImgP15prm_6));

		JLabel lblNewLabel_6_7 = new JLabel("-Chip Apple A15 Bionic");
		lblNewLabel_6_7.setBounds(23, 263, 155, 14);
		panel_2_6.add(lblNewLabel_6_7);

		JLabel lblNewLabel_6_1_7 = new JLabel("-Ram: 6G");
		lblNewLabel_6_1_7.setBounds(23, 288, 155, 14);
		panel_2_6.add(lblNewLabel_6_1_7);

		JLabel lblNewLabel_6_1_1_6 = new JLabel("-Dung lượng: 128G");
		lblNewLabel_6_1_1_6.setBounds(23, 313, 155, 14);
		panel_2_6.add(lblNewLabel_6_1_1_6);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(SystemColor.activeCaptionBorder);
		panel_16.setBounds(3, 182, 55, 14);
		panel_2_6.add(panel_16);

		JPanel panel_17 = new JPanel();
		panel_17.setBackground(SystemColor.activeCaptionBorder);
		panel_17.setBounds(80, 182, 121, 14);
		panel_2_6.add(panel_17);

		JPanel panel_2_7 = new JPanel();
		panel_2_7.setLayout(null);
		panel_2_7.setForeground(new Color(248, 248, 255));
		panel_2_7.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_7.setBackground(SystemColor.window);
		panel_2_7.setBounds(533, 395, 200, 339);
		panel_1.add(panel_2_7);

		JLabel lblNewLabel_2_7 = new JLabel("6.1''");
		lblNewLabel_2_7.setForeground(Color.BLACK);
		lblNewLabel_2_7.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_7.setBounds(23, 182, 35, 14);
		panel_2_7.add(lblNewLabel_2_7);

		JLabel lblNewLabel_3_7 = new JLabel("Super Retina XDR");
		lblNewLabel_3_7.setBounds(91, 182, 110, 14);
		panel_2_7.add(lblNewLabel_3_7);

		JLabel tenip14 = new JLabel("Iphone 14");
		tenip14.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip14.setBounds(22, 157, 130, 14);
		panel_2_7.add(tenip14);

		JLabel giaip14 = new JLabel("17.490.000đ");
		giaip14.setForeground(new Color(255, 51, 0));
		giaip14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip14.setBounds(23, 207, 178, 21);
		panel_2_7.add(giaip14);

		JLabel Sao15prm_7 = new JLabel("New label");
		Sao15prm_7.setIcon(new ImageIcon(getClass().getResource("/img/Sao Ip14.png")));
		Sao15prm_7.setBounds(10, 239, 155, 21);
		panel_2_7.add(Sao15prm_7);

		ImageIcon iconSao15prm_7 = (ImageIcon) Sao15prm_7.getIcon();

		Image imgSao15prm_7 = iconSao15prm_7.getImage();

		Image newImgSao15prm_7 = imgSao15prm_7.getScaledInstance(Sao15prm_7.getWidth(), Sao15prm_7.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_7.setIcon(new ImageIcon(newImgSao15prm_7));

		JLabel P15prm_7 = new JLabel("");
		P15prm_7.setIcon(new ImageIcon(getClass().getResource("/img/Ip14.png")));
		P15prm_7.setBounds(40, 11, 123, 135);
		panel_2_7.add(P15prm_7);

		ImageIcon iconP15prm_7 = (ImageIcon) P15prm_7.getIcon();

		Image imgP15prm_7 = iconP15prm_7.getImage();

		Image newImgP15prm_7 = imgP15prm_7.getScaledInstance(P15prm_7.getWidth(), P15prm_7.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_7.setIcon(new ImageIcon(newImgP15prm_7));

		JLabel lblNewLabel_6_8 = new JLabel("-Chip Apple A15 Bionic");
		lblNewLabel_6_8.setBounds(23, 263, 155, 14);
		panel_2_7.add(lblNewLabel_6_8);

		JLabel lblNewLabel_6_1_8 = new JLabel("-Ram: 6G");
		lblNewLabel_6_1_8.setBounds(23, 288, 155, 14);
		panel_2_7.add(lblNewLabel_6_1_8);

		JLabel lblNewLabel_6_1_1_7 = new JLabel("-Dung lượng: 128G");
		lblNewLabel_6_1_1_7.setBounds(23, 313, 155, 14);
		panel_2_7.add(lblNewLabel_6_1_1_7);

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(SystemColor.activeCaptionBorder);
		panel_18.setBounds(10, 182, 44, 14);
		panel_2_7.add(panel_18);

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(SystemColor.activeCaptionBorder);
		panel_19.setBounds(80, 182, 121, 14);
		panel_2_7.add(panel_19);

		JPanel panel_2_8 = new JPanel();
		panel_2_8.setLayout(null);
		panel_2_8.setForeground(new Color(248, 248, 255));
		panel_2_8.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_8.setBackground(SystemColor.window);
		panel_2_8.setBounds(743, 395, 200, 339);
		panel_1.add(panel_2_8);

		JLabel lblNewLabel_2_8 = new JLabel("6.1''");
		lblNewLabel_2_8.setForeground(Color.BLACK);
		lblNewLabel_2_8.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_8.setBounds(23, 182, 35, 14);
		panel_2_8.add(lblNewLabel_2_8);

		JLabel lblNewLabel_3_8 = new JLabel("Super Retina XDR");
		lblNewLabel_3_8.setBackground(SystemColor.activeCaptionBorder);
		lblNewLabel_3_8.setBounds(98, 182, 118, 14);
		panel_2_8.add(lblNewLabel_3_8);

		JLabel tenip13 = new JLabel("Iphone 13");
		tenip13.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip13.setBounds(22, 157, 130, 14);
		panel_2_8.add(tenip13);

		JLabel giaip13 = new JLabel("14.090.000đ");
		giaip13.setForeground(new Color(255, 51, 0));
		giaip13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip13.setBounds(23, 207, 178, 21);
		panel_2_8.add(giaip13);

		JLabel Sao15prm_8 = new JLabel("New label");
		Sao15prm_8.setIcon(new ImageIcon(getClass().getResource("/img/Sao Ip12.png")));
		Sao15prm_8.setBounds(10, 239, 155, 21);
		panel_2_8.add(Sao15prm_8);

		ImageIcon iconSao15prm_8 = (ImageIcon) Sao15prm_8.getIcon();

		Image imgSao15prm_8 = iconSao15prm_8.getImage();

		Image newImgSao15prm_8 = imgSao15prm_8.getScaledInstance(Sao15prm_8.getWidth(), Sao15prm_8.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_8.setIcon(new ImageIcon(newImgSao15prm_8));

		JLabel P15prm_8 = new JLabel("");
		P15prm_8.setIcon(new ImageIcon(getClass().getResource("/img/Ip13.png")));
		P15prm_8.setBounds(40, 11, 123, 135);
		panel_2_8.add(P15prm_8);

		ImageIcon iconP15prm_8 = (ImageIcon) P15prm_8.getIcon();

		Image imgP15prm_8 = iconP15prm_8.getImage();

		Image newImgP15prm_8 = imgP15prm_8.getScaledInstance(P15prm_8.getWidth(), P15prm_8.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_8.setIcon(new ImageIcon(newImgP15prm_8));

		JLabel lblNewLabel_6_9 = new JLabel("-Chip Apple A15 Bionic");
		lblNewLabel_6_9.setBounds(23, 263, 155, 14);
		panel_2_8.add(lblNewLabel_6_9);

		JLabel lblNewLabel_6_1_9 = new JLabel("-Ram: 4G");
		lblNewLabel_6_1_9.setBounds(23, 288, 155, 14);
		panel_2_8.add(lblNewLabel_6_1_9);

		JLabel lblNewLabel_6_1_1_8 = new JLabel("-Dung lượng: 128G");
		lblNewLabel_6_1_1_8.setBounds(23, 313, 155, 14);
		panel_2_8.add(lblNewLabel_6_1_1_8);

		JPanel panel_20 = new JPanel();
		panel_20.setBackground(SystemColor.activeCaptionBorder);
		panel_20.setBounds(3, 182, 55, 14);
		panel_2_8.add(panel_20);

		JPanel panel_21 = new JPanel();
		panel_21.setBackground(SystemColor.activeCaptionBorder);
		panel_21.setBounds(91, 182, 110, 14);
		panel_2_8.add(panel_21);

		JPanel panel_2_9 = new JPanel();
		panel_2_9.setLayout(null);
		panel_2_9.setForeground(new Color(248, 248, 255));
		panel_2_9.setBorder(new LineBorder(new Color(204, 204, 204)));
		panel_2_9.setBackground(SystemColor.window);
		panel_2_9.setBounds(953, 395, 200, 339);
		panel_1.add(panel_2_9);

		JLabel lblNewLabel_2_9 = new JLabel("6.1''");
		lblNewLabel_2_9.setForeground(Color.BLACK);
		lblNewLabel_2_9.setBackground(new Color(255, 153, 51));
		lblNewLabel_2_9.setBounds(23, 182, 35, 14);
		panel_2_9.add(lblNewLabel_2_9);

		JLabel lblNewLabel_3_9 = new JLabel("Super Retina XDR");
		lblNewLabel_3_9.setBounds(91, 182, 110, 14);
		panel_2_9.add(lblNewLabel_3_9);

		JLabel tenip12 = new JLabel("Iphone 12");
		tenip12.setFont(new Font("Tahoma", Font.BOLD, 11));
		tenip12.setBounds(22, 157, 130, 14);
		panel_2_9.add(tenip12);

		JLabel giaip12 = new JLabel("12.090.000đ");
		giaip12.setForeground(new Color(255, 51, 0));
		giaip12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		giaip12.setBounds(23, 207, 178, 21);
		panel_2_9.add(giaip12);

		JLabel Sao15prm_9 = new JLabel("New label");
		Sao15prm_9.setIcon(new ImageIcon(getClass().getResource("/img/Sao Ip12.png")));
		Sao15prm_9.setBounds(10, 239, 155, 21);
		panel_2_9.add(Sao15prm_9);

		ImageIcon iconSao15prm_9 = (ImageIcon) Sao15prm_9.getIcon();

		Image imgSao15prm_9 = iconSao15prm_9.getImage();

		Image newImgSao15prm_9 = imgSao15prm_9.getScaledInstance(Sao15prm_9.getWidth(), Sao15prm_9.getHeight(),
				Image.SCALE_SMOOTH);

		Sao15prm_9.setIcon(new ImageIcon(newImgSao15prm_9));

		JLabel P15prm_9 = new JLabel("");
		P15prm_9.setIcon(new ImageIcon(getClass().getResource("/img/Ip12.png")));
		P15prm_9.setBounds(40, 11, 123, 135);
		panel_2_9.add(P15prm_9);

		ImageIcon iconP15prm_9 = (ImageIcon) P15prm_9.getIcon();

		Image imgP15prm_9 = iconP15prm_9.getImage();

		Image newImgP15prm_9 = imgP15prm_9.getScaledInstance(P15prm_9.getWidth(), P15prm_9.getHeight(),
				Image.SCALE_SMOOTH);

		P15prm_9.setIcon(new ImageIcon(newImgP15prm_9));

		JLabel lblNewLabel_6_10 = new JLabel("-Chip Apple A14 Bionic");
		lblNewLabel_6_10.setBounds(23, 263, 155, 14);
		panel_2_9.add(lblNewLabel_6_10);

		JLabel lblNewLabel_6_1_10 = new JLabel("-Ram: 4G");
		lblNewLabel_6_1_10.setBounds(23, 288, 155, 14);
		panel_2_9.add(lblNewLabel_6_1_10);

		JLabel lblNewLabel_6_1_1_9 = new JLabel("-Dung lượng: 64G");
		lblNewLabel_6_1_1_9.setBounds(23, 313, 155, 14);
		panel_2_9.add(lblNewLabel_6_1_1_9);

		JPanel panel_22 = new JPanel();
		panel_22.setBackground(SystemColor.activeCaptionBorder);
		panel_22.setBounds(10, 182, 35, 14);
		panel_2_9.add(panel_22);

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(SystemColor.activeCaptionBorder);
		panel_23.setBounds(89, 182, 110, 14);
		panel_2_9.add(panel_23);

		JLabel lblNewLabel_7 = new JLabel("");

		lblNewLabel_7.setIcon(new ImageIcon(getClass().getResource("/img/Taos.png")));
		lblNewLabel_7.setBounds(751, 11, 55, 42);
		panel_1.add(lblNewLabel_7);

		JPanel panel_24 = new JPanel();
		panel_24.setBounds(1163, 52, 318, 799);
		panel_1.add(panel_24);

		textArea = new JTextArea();
		textArea.setBounds(0, 0, 338, 611);
		panel_24.add(textArea);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(10, 622, 124, 42);
		panel_24.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				x = 0;
				total = 0;
				textAreatong.setText("Tổng: ");
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(186, 85, 211));

		textAreatong = new JTextArea();
		textAreatong.setBounds(171, 622, 157, 43);
		panel_24.add(textAreatong);
		tongTien();
		Thread tongTienThread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(100);
					textAreatong.setText("");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				tongTien();
			}

		});
		tongTienThread.start();
		panel_24.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(50, 375, 278, 384);
		panel_24.add(layeredPane);

		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new LineBorder(SystemColor.menu));
		panel_25.setBackground(SystemColor.inactiveCaptionBorder);
		panel_25.setBounds(106, 740, 1045, 64);
		panel_1.add(panel_25);
		panel_25.setLayout(null);

		lbdh = new JLabel("");
		lbdh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbdh.setBounds(966, 0, 69, 42);
		panel_25.add(lbdh);

		lbngay = new JLabel("");
		lbngay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbngay.setBounds(962, 22, 97, 42);
		panel_25.add(lbngay);

		updateTimeAndDate();
		Thread updateTimeThread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
					updateTimeAndDate();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		updateTimeThread.start();

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 29990000;
				textArea.append(royalIphone() + x + "." + "     " + tenip15prm.getText()
						+ "                            " + giaip15prm.getText() + "\n");
			}

		});
		btnNewButton_2.setBackground(new Color(248, 248, 255));
		btnNewButton_2.setIcon(new ImageIcon(Dash.class.getResource("/img/Xe.png")));

		ImageIcon iconBtnNewButton_2 = (ImageIcon) btnNewButton_2.getIcon();

		int desiredWidth = 20;
		int desiredHeight = 20;
		Image imgBtnNewButton_2 = iconBtnNewButton_2.getImage().getScaledInstance(desiredWidth, desiredHeight,
				Image.SCALE_SMOOTH);

		btnNewButton_2.setIcon(new ImageIcon(imgBtnNewButton_2));

		btnNewButton_2.setBounds(149, 313, 52, 26);
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 25990000;
				textArea.append(royalIphone() + x + "." + "     " + tenip15pr.getText()
						+ "                                   " + giaip15pr.getText() + "\n");
			}
		});
		btnNewButton_2_1.setBackground(new Color(248, 248, 255));

		btnNewButton_2_1.setIcon(new ImageIcon(Dash.class.getResource("/img/Xe.png")));
		ImageIcon iconBtnNewButton_2_1 = (ImageIcon) btnNewButton_2_1.getIcon();
		int desiredWidthbtnNewButton_2_1 = 20;
		int desiredHeightbtnNewButton_2_1 = 20;
		Image imgBtnNewButton_2_1 = iconBtnNewButton_2_1.getImage().getScaledInstance(desiredWidthbtnNewButton_2_1,
				desiredHeightbtnNewButton_2_1, Image.SCALE_SMOOTH);
		btnNewButton_2_1.setIcon(new ImageIcon(imgBtnNewButton_2_1));

		btnNewButton_2_1.setBounds(149, 313, 52, 26);
		panel_2_1.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 23090000;
				textArea.append(royalIphone() + x + "." + "     " + tenip15pl.getText()
						+ "                                  " + giaip15p.getText() + "\n");
			}
		});
		btnNewButton_2_2.setBackground(new Color(248, 248, 255));
		btnNewButton_2_2.setBounds(148, 313, 52, 26);

		ImageIcon iconBtnNewButton_2_2 = new ImageIcon(Dash.class.getResource("/img/Xe.png"));
		Image imgBtnNewButton_2_2 = iconBtnNewButton_2_2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnNewButton_2_2.setIcon(new ImageIcon(imgBtnNewButton_2_2));

		panel_2_2.add(btnNewButton_2_2);

		JButton btnNewButton_2_3 = new JButton("");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 19890000;
				textArea.append(royalIphone() + x + "." + "     " + tenip15.getText()
						+ "                                        " + giaip15.getText() + "\n");
			}
		});
		btnNewButton_2_3.setBackground(new Color(248, 248, 255));
		btnNewButton_2_3.setBounds(148, 313, 52, 26);

		// Điều chỉnh kích thước của biểu tượng trên JButton
		ImageIcon iconBtnNewButton_2_3 = new ImageIcon(Dash.class.getResource("/img/Xe.png"));
		Image imgBtnNewButton_2_3 = iconBtnNewButton_2_3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnNewButton_2_3.setIcon(new ImageIcon(imgBtnNewButton_2_3));

		panel_2_3.add(btnNewButton_2_3);

		JButton btnNewButton_2_4 = new JButton("");
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 27390000;
				textArea.append(royalIphone() + x + "." + "     " + tenip14prm.getText()
						+ "                            " + giaip14prm.getText() + "\n");
			}
		});
		btnNewButton_2_4.setBackground(new Color(248, 248, 255));
		btnNewButton_2_4.setBounds(148, 313, 52, 26);

		ImageIcon iconBtnNewButton_2_4 = new ImageIcon(Dash.class.getResource("/img/Xe.png"));
		Image imgBtnNewButton_2_4 = iconBtnNewButton_2_4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnNewButton_2_4.setIcon(new ImageIcon(imgBtnNewButton_2_4));

		panel_2_4.add(btnNewButton_2_4); // Thêm JButton vào JPanel

		JButton btnNewButton_2_5 = new JButton("");
		btnNewButton_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 27490000;
				textArea.append(royalIphone() + x + "." + "     " + tenip14pr.getText()
						+ "                                   " + giaip14pr.getText() + "\n");
			}
		});
		btnNewButton_2_5.setBackground(new Color(248, 248, 255));
		btnNewButton_2_5.setBounds(149, 309, 52, 26);

		ImageIcon iconBtnNewButton_2_5 = new ImageIcon(Dash.class.getResource("/img/Xe.png"));
		Image imgBtnNewButton_2_5 = iconBtnNewButton_2_5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

		panel_2_5.add(btnNewButton_2_5);

		JButton btnNewButton_2_6 = new JButton("");
		btnNewButton_2_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 19990000;
				textArea.append(royalIphone() + x + "." + "     " + tenip14p.getText()
						+ "                                 " + giaip14p.getText() + "\n");
			}
		});
		btnNewButton_2_6.setBackground(new Color(248, 248, 255));
		btnNewButton_2_6.setBounds(149, 313, 52, 26);

		ImageIcon iconBtnNewButton_2_6 = new ImageIcon(Dash.class.getResource("/img/Xe.png"));
		Image imgBtnNewButton_2_6 = iconBtnNewButton_2_6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnNewButton_2_6.setIcon(new ImageIcon(imgBtnNewButton_2_6));

		panel_2_6.add(btnNewButton_2_6);

		JButton btnNewButton_2_7 = new JButton("");
		btnNewButton_2_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 17490000;
				textArea.append(royalIphone() + x + "." + "     " + tenip14.getText()
						+ "                                         " + giaip14.getText() + "\n");
			}
		});
		btnNewButton_2_7.setBackground(new Color(248, 248, 255));
		btnNewButton_2_7.setBounds(149, 313, 52, 26);

		ImageIcon iconBtnNewButton_2_7 = new ImageIcon(Dash.class.getResource("/img/Xe.png"));
		Image imgBtnNewButton_2_7 = iconBtnNewButton_2_7.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

		panel_2_7.add(btnNewButton_2_7);

		JButton btnNewButton_2_8 = new JButton("");
		btnNewButton_2_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 14090000;
				textArea.append(royalIphone() + x + "." + "     " + tenip13.getText()
						+ "                                         " + giaip13.getText() + "\n");
			}
		});
		btnNewButton_2_8.setBackground(new Color(248, 248, 255));
		btnNewButton_2_8.setBounds(138, 313, 52, 26);

		ImageIcon iconBtnNewButton_2_8 = new ImageIcon(Dash.class.getResource("/img/Xe.png"));
		Image imgBtnNewButton_2_8 = iconBtnNewButton_2_8.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

		panel_2_8.add(btnNewButton_2_8);

		JButton btnNewButton_2_9 = new JButton("");
		btnNewButton_2_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++x;
				total += 12090000;
				textArea.append(royalIphone() + x + "." + "     " + tenip12.getText()
						+ "                                         " + giaip12.getText() + "\n");
			}
		});
		btnNewButton_2_9.setBackground(new Color(248, 248, 255));
		btnNewButton_2_9.setBounds(149, 313, 52, 26);

		ImageIcon iconBtnNewButton_2_9 = new ImageIcon(Dash.class.getResource("/img/Xe.png"));
		Image imgBtnNewButton_2_9 = iconBtnNewButton_2_9.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnNewButton_2_9.setIcon(new ImageIcon(imgBtnNewButton_2_9));

		panel_2_9.add(btnNewButton_2_9);
		JFrame thisFrame = this;

		// JLabel lbanh = new JLabel();
		// lbanh.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// Person p = new Person();
		// p.informationXML();
		// String staffName = p.getName();
		// try {
		// socket = new Socket("localhost", 12345);
		// if(socket !=null) {
		// ChatPanelKH cp = new ChatPanelKH(socket, staffName, "Manager");
		// thisFrame.getContentPane().add(cp);
		// cp.gettextareaMessage().append("Manager is running ");
		// cp.updateUI();
		//
		// bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// os = new DataOutputStream(socket.getOutputStream());
		//
		// os.writeBytes("Staff:" + staffName);
		// os.write(13); os.write(10);
		// os.flush();
		//
		// }
		// } catch (Exception e2) {
		// // TODO: handle exception
		// }
		//// showChatPanel(contentPane);
		//// chatPanel.setVisible(true);
		// }
		// });
		// lbanh.setBounds(1446, 11, 55, 37);
		// panel_1.add(lbanh);
		// ImageIcon iconlbanh = new
		// ImageIcon(Dash.class.getResource("/img/logomess.png"));
		// Image imganh = iconlbanh.getImage().getScaledInstance(35, 35,
		// Image.SCALE_SMOOTH);
		//
		// lbanh.setIcon(new ImageIcon(imganh));

		contentPane.add(chatPanel, BorderLayout.CENTER);
		contentPane.add(chatPanel, BorderLayout.PAGE_END);

		textAreaTKH = new JTextArea();
		textAreaTKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textAreaTKH.setBounds(108, 18, 164, 22);
		panel_1.add(textAreaTKH);

		Person p = new Person();
		p.informationKHXML();
		p.setNameToTextAreaTKH(textAreaTKH);

		JButton btnmess = new JButton("");
		btnmess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showChatPanel(contentPane);
				chatPanel.setVisible(true);
				Person p = new Person();
				p.informationKHXML();
				p.sendImformation(socket);
				// Person p = new Person();
				// p.informationXML();
				// String staffName = p.getName();
				// try {
				// socket = new Socket("localhost", 12345);
				// ChatPanelKH cp = new ChatPanelKH(socket, staffName, "Manager");
				// contentPane.add(cp);
				//
				// bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// os = new DataOutputStream(socket.getOutputStream());
				//
				// os.writeBytes("Staff:" + staffName);
				// os.write(13); os.write(10);
				// os.flush();
				// }
				// catch (IOException ex) {
				// ex.printStackTrace();
				// }
			}
		});

		btnmess.setBounds(1440, 11, 35, 35);
		panel_1.add(btnmess);

		ImageIcon iconlbanh = new ImageIcon(Dash.class.getResource("/img/logomess.png"));
		Image imganh = iconlbanh.getImage().getScaledInstance(35, 35,
				Image.SCALE_SMOOTH);
		btnmess.setIcon(new ImageIcon(imganh));
		btnmess.setBorderPainted(false);

	}

	public String royalIphone() {
		if (isRoyalIphoneCalled) {
			return "";
		}
		isRoyalIphoneCalled = true;
		String rI = ("                                 Danh sách sản phẩm                           \n\n");
		return rI;
	}

	private int tongTien() {
		int temp = total;
		String value = String.valueOf(temp);
		SwingUtilities.invokeLater(() -> {
			textAreatong.append("Tổng: " + value);
		});
		return temp;
	}

	private void updateTimeAndDate() {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		String timeStr = timeFormat.format(now);
		String dateStr = dateFormat.format(now);
		lbdh.setText(timeStr);
		lbngay.setText(dateStr);
	}

	// private void informationXML() {
	// try {
	// xmlFile = new File("imformation.xml");
	// dbFactory = DocumentBuilderFactory.newInstance();
	// dBuilder = dbFactory.newDocumentBuilder();
	// doc = dBuilder.parse(xmlFile);
	// doc.getDocumentElement().normalize();
	//
	// nodeList = doc.getElementsByTagName("name");
	// if (nodeList.getLength() > 0) {
	// Node node = nodeList.item(0);
	// if (node.getNodeType() == Node.ELEMENT_NODE) {
	// Element element = (Element) node;
	// String name = element.getTextContent();
	// textAreaTKH.append("Xin chào! " + name);
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public void showChatPanel(JPanel mainPanel) {
        JLayeredPane layeredPane = mainPanel.getRootPane().getLayeredPane();

        JPanel chatPanel = createChatPanel();
        chatPanel.setBounds(1120, 455, 278, 384);
        layeredPane.add(chatPanel, JLayeredPane.PALETTE_LAYER);

        chatPanel.setVisible(true);
    }

    private JPanel createChatPanel() {
        JPanel chatPanel = new JPanel();
        chatPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        chatPanel.setBounds(63, 10, 278, 384);
        chatPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel(" Tư vấn khách hàng");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(0, 0, 207, 28);
        chatPanel.add(lblNewLabel);

        JLabel dongchat = new JLabel("");
        dongchat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chatPanel.setVisible(false);
                closeSocket();
            }
        });
        dongchat.setIcon(new ImageIcon("C:\\Users\\sanh6\\Downloads\\close.png"));
        dongchat.setBounds(244, 2, 34, 26);
        chatPanel.add(dongchat);

        textAreachat = new JTextArea();
        textAreachat.setBounds(2, 32, 274, 320);
        chatPanel.add(textAreachat);

        tfchat = new JTextField();
        tfchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(tfchat.getText());
            }
        });
        tfchat.setBounds(0, 353, 207, 31);
        chatPanel.add(tfchat);
        tfchat.setColumns(10);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(tfchat.getText());
            }
        });
        btnSend.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnSend.setBounds(204, 353, 74, 31);
        chatPanel.add(btnSend);

        // Khởi tạo kết nối socket ở đây, nếu chưa được khởi tạo
        if (socket == null || socket.isClosed()) {
            initializeSocket();
        }

        return chatPanel;
    }

    private void initializeSocket() {
        try {
            socket = new Socket("localhost", 12344);
            Input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Output = new PrintWriter(socket.getOutputStream(), true);

            // Tạo luồng riêng để đọc tin nhắn từ server
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String inputLine;
                    try {
                        while ((inputLine = Input.readLine()) != null) {
                            Person p = new Person();
							p.informationNVXML();
							p.setNameToTextAreaChat(textAreachat, inputLine);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeSocket() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        Person p = new Person();
        p.informationKHXML();
        p.setNameToTextAreaChat(textAreachat, message);
        Output.println(message);
        tfchat.setText("");
    }

	public static void start() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'start'");
	}
}
