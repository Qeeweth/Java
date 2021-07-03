package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<Socket> clientSockets = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188); // Создаем серверный сокет
            System.out.println("Сервер запущен");
            while (true) { // Бесконечный цикл ожидающий подключения клиентов
                System.out.println("Ожидаю подключения клиентов...");
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                clientSockets.add(socket);
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        String clientName = null;
                        try {
                            out.writeUTF("Введите ваше имя:");
                            clientName = in.readUTF(); // Ввод имени клиента
                            out.writeUTF("Добро пожаловать " + clientName + " в сетевой чат");
                            System.out.println("Имя подключившегося клиента: " + clientName);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        while (true) {
                            try {
                                request = in.readUTF(); // Принимает сообщение от клиента
                                System.out.println(clientName + " прислал: " + request);
                                for (Socket clientSocket : clientSockets) { // Перебираем клиентов которые подключены в настоящий момент
                                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                                    if (clientSocket != socket) { // Условие при котором клиент не будет видеть свои отправленные сообщения
                                        out.writeUTF(clientName + ": " + request); // Рассылает принятое сообщения всем клиентам
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                clientSockets.remove(socket); // Удаление сокета, когда клиент отключился
                                break;
                            }
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


