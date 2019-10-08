package test5.chat;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Date;//timestamp functionality


public class Server extends JFrame{ //inherits from JFrame

    //1. Instance Variables

    private JTextField userText; //where messages are typed
    private JTextArea chatWindow; //where messages are displayed
    private String fullTimeStamp = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    //fullTimeStamp - MM = months; mm = minutes; HH = 24-hour clock

    //setting up the streams
    private ObjectOutputStream output; //messages being sent by user
    private ObjectInputStream input; //messages being received by user;

    private ServerSocket server;

    private Socket connection; //Socket = sets up connection between one computer and another.

    //2. Constructor (GUI)
    public Server(){
    super("Mick's Instant Messenger [SERVER]"); //window title
    userText = new JTextField();
    userText.setEditable(false); //you cannot type anything, unless you are connected to someone else
    userText.addActionListener( 
        new ActionListener(){
        public void actionPerformed(ActionEvent event){
            sendMessage(event.getActionCommand());
            userText.setText(""); //Resets editable text field after you send message
        }
        }
    );
    add(userText, BorderLayout.SOUTH);//places user text input (JTextArea) field at bottom
    chatWindow = new JTextArea(15,30); //displays conversation
    add(new JScrollPane(chatWindow));
    chatWindow.setLineWrap(true); //wraps lines when they outgrow the panel width
    chatWindow.setWrapStyleWord(true); //ensures that above line wrap occurs at word end
    setSize(400,320);
    setVisible(true); //set visible on screen
    }

    //3.Setup and Run the Server
    public void StartRunning(){
        try{
            server = new ServerSocket(6789, 100);
            //Client connects at Port # 6789
            //100 = QueueLength - the backlog of clients who can wait at port #6789 to connect to the Server

            //while(true) ... means this while loop is going to run forever
            while(true){
                try{
                    waitForConnection();
                    setupStreams();
                    whileChatting(); //allows messages to pass back and forth through streams
                }catch(EOFException eofException){

                    //connect and have conversation
                    //Display timestamp for disconnection
                    showMessage("\n\n" + fullTimeStamp);
                    showMessage("\nConnection terminated by SERVER! "); //displays end of stream/connection


                }finally{
                    closeCrap();
                }
            }
        }catch(IOException ioException){
            ioException.printStackTrace(); //Displays info where there's an error!
    }
    }

        //4. wait for connection method, then display connection info
        private void waitForConnection() throws IOException{
            showMessage("\n SERVER : Waiting for user(s) to connect... \n "); //tells user Server is waiting for a connection
            connection = server.accept();
            //socket "connection" will accept connections. Creates a socket for each new connection.
            showMessage("Connected with " +connection.getInetAddress().getHostName()); //displays IP address and hostname

        }

        //5. setup streams method.. get streams to send and receive data
        private void setupStreams() throws IOException{
            output = new ObjectOutputStream(connection.getOutputStream());
            //creates pathway to allow connection to whichever computer the 'connnection' socket created.
            output.flush(); //clears data that gets left over in buffer when you try to connect to someone else. Flushes it over to the other person.
            input = new ObjectInputStream(connection.getInputStream());
            //no flush here, because you cannot flush someone else's stream
            showMessage("\n Streams are now setup! \n");

        }

        //6. during conversation method

        private void whileChatting() throws IOException{

            //Display timestamp for connection
            showMessage("\n" + fullTimeStamp);

            String message = "You are now connected! \n ";
            sendMessage(message);
            ableToType(true); //will allow user to type into text box after a connection
            String timeStamp = new java.text.SimpleDateFormat("HH:mm:ss").format(new Date());//timestamp

            do{
                try{
                    message = (String) input.readObject(); //read incoming message as a String and store in 'message' variable.
                    showMessage("\n" + message);//displays each message you receive on a new line
                }catch(ClassNotFoundException classNotFoundException){
                    showMessage("/n I don't know what object the user has sent!");
                }

            //***broken by timestamp?***    
            }while(!message.equalsIgnoreCase("CLIENT " + "[" + timeStamp  + "]" + ": " + "END")); //allows conversation until Client enters "END"

        }

        //7. Close Crap method - close streams and sockets after you are finished chatting
        private void closeCrap(){
            showMessage("\n\n Closing connections... \n");
            ableToType(false);
            try{
                output.close(); //close your stream to other users
                input.close(); //close incoming streams
                connection.close(); //close the socket

            }catch(IOException ioException){
                ioException.printStackTrace();
            }
}
        //8. send message method - send message to client
        private void sendMessage(String message){
            try{

                //writeObject method is built into Java.

                String timeStamp = new java.text.SimpleDateFormat("HH:mm:ss").format(new Date());//timestamp
                output.writeObject("SERVER" + " [" + timeStamp + "]" + ": " + message);
                showMessage("\nSERVER" + " [" + timeStamp + "]" + ": " + message); //shows the ouput message in our conversation window
                output.flush();
            }catch(IOException ioException){
                chatWindow.append("ERROR: Unable to send message!");
            }
        }

        //9. updates chatWindow - instead of creating entirely new GUI each time
        private void showMessage(final String text){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        chatWindow.setEditable(false); //disallows text editing in chatWindow
                        chatWindow.append(text); //appends text, which was passed in from above
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