package Phone;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.AccountDAO;
import DataBase.AccountKHDAO;

public class chat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Socket socket = null;
	private BufferedReader bf = null;
	private DataOutputStream os = null;

	private String host = "localhost";
	private int port = 12345;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat frame = new chat();
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
	public chat() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		String name = AccountKHDAO.getInstance().GetAccountKH().getUsername();
		try {
			socket = new Socket(host, port);

			if (socket != null) {
				ChatPanel p = new ChatPanel(socket, name, "Nhân viên tư vấn");
				contentPane.add(p, BorderLayout.CENTER);
				p.updateUI();

				bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				os = new DataOutputStream(socket.getOutputStream());

				os.writeBytes("Staff:" + name);
				os.write(13);
				os.write(10);
				os.flush();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
