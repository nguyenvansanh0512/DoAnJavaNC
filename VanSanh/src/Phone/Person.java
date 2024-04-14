package Phone;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Person {
	private String name;
	private int sdt;

	private DataOutputStream os;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void informationKHXML() {
		File xmlFile;
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;
		Document doc;
		NodeList nodeList;
		try {
			xmlFile = new File("imformation.xml");
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			nodeList = doc.getElementsByTagName("name");
			if (nodeList.getLength() > 0) {
				Node node = nodeList.item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					this.name = element.getTextContent(); // Gán giá trị cho biến cấp độ lớp
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void informationNVXML() {
		File xmlFile;
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;
		Document doc;
		NodeList nodeList;
		try {
			xmlFile = new File("imformationNV.xml");
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			nodeList = doc.getElementsByTagName("name");
			if (nodeList.getLength() > 0) {
				Node node = nodeList.item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					this.name = element.getTextContent(); // Gán giá trị cho biến cấp độ lớp
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setNameToTextAreaTKH(JTextArea textArea) {
		textArea.append("Xin chào! " + name);
	}

	public void setNameToTextAreaTNV(JLabel label) {
		label.setText("NV." + name);
	}
	public void setNameToTextAreaChat(JTextArea textarea, String messages) {
		textarea.append(name + ": " + messages + "\n");
	}

	public void sendImformation(Socket socket) {
		// TODO Auto-generated method stub
		try {
			os = new DataOutputStream(socket.getOutputStream());
			os.writeBytes("Staff:" + name);
			os.write(13);
			os.write(10);
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
