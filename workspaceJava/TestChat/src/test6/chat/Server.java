package test6.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Server {

    private ServerSocket ss;
    private Socket s;
    Map<Socket,DataOutputStream> list = new HashMap<Socket,DataOutputStream>();

    public Server(int port_number) throws IOException{

        create_Server(port_number);
    }

    public static void main(String[] args) throws IOException {

        int port_number=23;

        new Server(port_number);
    }

    private void create_Server(int port_number) throws IOException{

        ss = new ServerSocket(port_number);

        System.out.println("Server is ready!");

        while(true){

            s=ss.accept();

            System.out.println(s.getLocalAddress().getHostName() + " was connected!");

                        send_con_mes();

            list.put(s,new DataOutputStream(s.getOutputStream()) );

            new ServerThread(s,this).start();
        }

    }

        private void send_con_mes() throws IOException{

                Set<Socket> sckt_list = list.keySet();
        Iterator<Socket> itr = sckt_list.iterator();
                DataOutputStream daos;

                String str;
                Socket sckt;

                while(itr.hasNext()){

                    sckt=itr.next();
                    str = sckt.getLocalAddress().getHostName() + " was connected..." ;

                    daos = list.get(sckt);
                    daos.writeUTF(str);

                }

        }

    public void send_to_All(String msg, Socket socket) throws IOException{

        synchronized(list){

            Set<Socket> sckt_list = list.keySet();
            Iterator<Socket> itr = sckt_list.iterator();
            DataOutputStream daos;

            while(itr.hasNext()){

                Socket sck = itr.next();

                if(sck!=socket){

                    daos = list.get(sck);
                    daos.writeUTF(msg);

                }
            }
        }
    }

    public void remove_Connection(Socket s) throws IOException{

        synchronized(list){

            list.remove(s);
            System.out.println(s.getLocalAddress().getHostName() + " was disconnected!");
            s.close();
        }
    }

}


