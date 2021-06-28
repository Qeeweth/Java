package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public class Server {
    public static void main(String[] args) throws IOException {
        ArrayList <Socket> clientSockets = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188); // Создаем серверный сокет
            System.out.println("Сервер запущен");
            while (true) { // бесконечный цикл для ожидания подключения клиентов
                System.out.println("Ожидаю подключения клиентов...");
                Socket socket = serverSocket.accept(); // Ожидаем подключение клиента
                clientSockets.add(socket);
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        while (true) {
                            try {
                                request = in.readUTF(); // Принимает сообщения от клиента
                                for (Socket clientSocket : clientSockets){ // Перебираем клиентов,которые подключены в настоящий момент
                                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                                    out.writeUTF(request.toUpperCase(Locale.ROOT)); // Рассылает принятое сообщение всем клиентам
                                }
                                System.out.println("Клиент прислал: " + request);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                clientSockets.remove(socket); // Удаление сокета,когда клиент отключился
                                break;
                            }
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}



