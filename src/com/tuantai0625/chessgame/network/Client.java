package com.tuantai0625.chessgame.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Lionheart on 19-Jun-17.
 */
public class Client {
    private String ip;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Client(String ip) {
        this.ip = ip;
        try {
            socket = new Socket(ip, 5000);
            InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isReader);
            writer = new PrintWriter(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
        writer.flush();
    }

    public String receiveMessage() {
        String result = null;
        try {
            result = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeConnection() {
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ConnectionHandler implements Runnable {
        Socket socket;
        BufferedReader reader;
        String info;

        public ConnectionHandler(Socket socket, BufferedReader reader) {
            this.socket = socket;
            this.reader = reader;
        }

        @Override
        public void run() {
            try {
                info = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
