package test5.chat;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date; //timestamp functionality

import javax.swing.*;

public class Client extends JFrame { //inherits from JFrame

    //1. Creating instance variables

    private JTextField userText; //where user inputs text
    private JTextArea chatWindow; //where messages are displayed
    private String fullTimeStamp = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    //fullTimeStamp - MM = months; mm = minutes; HH = 24-hour cloc
    private ObjectOutputStream output; //output from Client to Server
    private ObjectInputStream input; //messages received from Server
    private String message ="";
    private String serverIP;
    private Socket connection;

    //2. Constructor (GUI)
    public Client(String host){ //host=IP address of server
        super("Mick's Instant Messenger [CLIENT]");
        serverIP = host; //placed here to allow access to private String ServerIP
        userText = new JTextField();
        userText.setEditable(false);
        userText.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    sendMessage(event.getActionCommand()); //For this to work, must build sendData Method
                    userText.setText(""); //resets userText back to blank, after message has been sent to allow new message(s)
                }
            }

                );
        add(userText, BorderLayout.SOUTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow), BorderLayout.CENTER); //allows you to scroll up and down when text outgrows chatWindow
        chatWindow.setLineWrap(true); //wraps lines when they outgrow the panel width
        chatWindow.setWrapStyleWord(true); //ensures that above line wrap occurs at word end
        setSize(400,320);
        setVisible(true);
    }

    //3. startRunning method
    public void startRunning(){
        try{
            connectToServer(); //unlike Server, no need to wait for connections. This connects to one specific Server.
            setupStreams();
            whileChatting();
        }catch(EOFException eofException){


            //Display timestamp for disconnection
            showMessage("\n\n" + fullTimeStamp);
            showMessage("\nConnection terminated by CLIENT! ");


        }catch(IOException ioException){
            ioException.printStackTrace();
        }finally{
                closeCrap();
            }

    }

    //4. Connect to Server
    private void connectToServer() throws IOException{
        showMessage(" \n Attempting connection to SERVER... \n");
        connection = new Socket(InetAddress.getByName(serverIP), 6789);//Server IP can be added later
        showMessage(" Connected to: " +connection.getInetAddress().getHostName() ); //displays IP Address of Server
    }

    //5. Setup streams to send and receive messages
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        showMessage("\n Streams are now setup! \n");

    }

    //6. While chatting method
    private void whileChatting() throws IOException{


        //Display timestamp for connection
        showMessage("\n" + fullTimeStamp);

        ableToType(true);
        String timeStamp = new java.text.SimpleDateFormat("HH:mm:ss").format(new Date());//timestamp
        do{
            try{
                message = (String) input.readObject(); //read input, treat as String, store in message variable
                showMessage("\n" + message);
            }catch(ClassNotFoundException classNotfoundException){
                showMessage("\n I don't know that object type");
            }

        //***broken by timestamp?***    
        }while(!message.equalsIgnoreCase("SERVER " + "[" + timeStamp  + "]" + ": " + "END")); //Conversation happens until Server inputs 'End'

    }

    //7. Close the streams and sockets
    private void closeCrap(){
        showMessage("\n\nClosing streams and sockets...");
        ableToType(false);//disable typing feature when closing streams and sockets
        try{
            output.close();
            input.close();
            connection.close();
        }catch(IOException ioException){
            ioException.printStackTrace(); //show error messages or exceptions
        }
    }

    //8. Send Messages to Server
    private void sendMessage(String message){
        try{
        String timeStamp = new java.text.SimpleDateFormat("HH:mm:ss").format(new Date());//timestamp
        output.writeObject("CLIENT" + " [" + timeStamp + "]" + ": " + message);
        output.flush();
        showMessage("\nCLIENT" + " [" + timeStamp + "]" + ": " + message);
    }catch(IOException ioexception){
        chatWindow.append("\n Error: Message not sent!");
    }

    }

    //9.change/update chatWindow
    private void showMessage(final String m){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        chatWindow.setEditable(false); //disallows text editing in chatWindow
                        chatWindow.append(m); //appends text, which was passed in from above
                    }
                }

                );
    }

    //10. Lets user type
            private void ableToType(final boolean tof){
                SwingUtilities.invokeLater(
                        new Runnable(){
                            public void run(){
                                userText.setEditable(tof); //passes in 'true'
}
        }

                        );
            }
}