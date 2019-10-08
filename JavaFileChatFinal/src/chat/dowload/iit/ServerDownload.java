package chat.dowload.iit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import chat.zoom.frame.gui.ChatFrame;

public class ServerDownload implements Runnable {

	public ServerSocket server;
	public Socket socket;
	public int port;
	public String saveTo = "";
	public InputStream in;
	public FileOutputStream out;
	public ChatFrame ui;

	public ServerDownload(String saveTo, ChatFrame ui) {
		try {
			server = new ServerSocket(0);
			port = server.getLocalPort();
			this.saveTo = saveTo;
			this.ui = ui;
		} catch (IOException ex) {
			System.out.println("Exception [Download : Download(...)]");
		}
	}

	@Override
	public void run() {
		try {
			socket = server.accept();
			System.out.println("Download : " + socket.getRemoteSocketAddress());

			in = socket.getInputStream();
			out = new FileOutputStream(saveTo);

			byte[] buffer = new byte[1024];
			int count;

			while ((count = in.read(buffer)) >= 0) {
				out.write(buffer, 0, count);
			}

			out.flush();

			ui.jtextArea1.append("[Application > Me] : Download complete\n");

			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (Exception ex) {
			System.out.println("Exception [Download : run(...)]");
		}
	}
}