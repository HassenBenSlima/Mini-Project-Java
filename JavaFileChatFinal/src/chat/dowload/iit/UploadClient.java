package chat.dowload.iit;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import chat.zoom.frame.gui.ChatFrame;

public class UploadClient implements Runnable {

	public String addr;
	public int port;
	public Socket socket;
	public FileInputStream in;
	public OutputStream out;
	public File file;
	public ChatFrame ui;

	public UploadClient(String addr, int port, File filepath, ChatFrame frame) {
		super();
		try {
			file = filepath;
			ui = frame;
			socket = new Socket(InetAddress.getByName(addr), port);
			out = socket.getOutputStream();
			in = new FileInputStream(filepath);
		} catch (Exception ex) {
			System.out.println("Exception [Upload : Upload(...)]");
		}
	}

	@Override
	public void run() {
		try {
			byte[] buffer = new byte[1024];
			int count;

			while ((count = in.read(buffer)) >= 0) {
				out.write(buffer, 0, count);
			}
			out.flush();

			ui.jtextArea1.append("[Applcation > Me] : File upload complete\n");

			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (Exception ex) {
			System.out.println("Exception [Upload : run()]");
			ex.printStackTrace();
		}
	}

}