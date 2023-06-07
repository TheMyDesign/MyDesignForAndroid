package com.example.mydesign.controler;
import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URISyntaxException;

public class SocketHandler {
    private static Socket mSocket;

    public static synchronized void setSocket() {
        try {
            // "http://10.0.2.2:3000" is the network your Android emulator must use to join the localhost network on your computer
            // "http://localhost:3000/" will not work
            // If you want to use your physical phone you could use your ip address plus :3000
            // This will allow your Android Emulator and physical device at your home to connect to the server
            mSocket = IO.socket("http://10.0.2.2:8080");
        } catch (URISyntaxException e) {

        }
    }

    public static synchronized Socket getSocket() {
        return mSocket;
    }

    public static synchronized void establishConnection() {
        mSocket.connect();
    }

    public static synchronized void closeConnection() {
        mSocket.disconnect();
    }
}
