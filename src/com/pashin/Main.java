package com.pashin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket;
            DataInputStream dataInputStream;
            DataOutputStream dataOutputStream;
            System.out.println("Сервер развернут на порту 5000\nОжидание клиентов...");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Клиент подключен");

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                dataOutputStream.writeDouble(dataInputStream.readDouble() * dataInputStream.readDouble());
                dataOutputStream.flush();
                System.out.println("Операция выполнена");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
