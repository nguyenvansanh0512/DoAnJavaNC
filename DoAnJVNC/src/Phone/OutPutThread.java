package Phone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class OutPutThread extends Thread {
    private Socket socket;
    private JTextArea txt;
    private BufferedReader bf;
    private String sender;
    private String receiver;

    public OutPutThread(Socket socket, JTextArea txt, String sender, String receiver) {
        this.socket = socket;
        this.txt = txt;
        this.sender = sender;
        this.receiver = receiver;
        try {
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                String msg = "";
                if (socket != null && !socket.isClosed()) {
                    if ((msg = bf.readLine()) != null && !msg.isEmpty()) {
                        txt.append("\n" + receiver + ": " + msg);
                    }
                } else {
             
                    break;
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Đóng BufferedReader và socket khi không cần thiết nữa
                if (bf != null) {
                    bf.close();
                }
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
