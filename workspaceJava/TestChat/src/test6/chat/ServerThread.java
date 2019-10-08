package test6.chat;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;


public class ServerThread extends Thread {

    private Socket s;
    private Server srv;

    public ServerThread(Socket s,Server srv){
        this.s = s;
        this.srv = srv;
    }

    @Override
    public void run() {

        String msg;
                DataInputStream dis;

        try {
            dis = new DataInputStream(s.getInputStream());

            while(true){

                msg = dis.readUTF();
                srv.send_to_All(msg, s);

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try {
                srv.remove_Connection(s);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}