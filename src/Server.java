import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket clientSocket;

    public void connect() {
        try {
            try (ServerSocket socket = new ServerSocket(30333)) {

                System.out.println("Сервер запущен!");
                clientSocket = socket.accept();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                    String word = in.readLine();
                    System.out.println(word);

                    out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
                    out.flush();

                }
            } finally {
                System.out.println("Сервер закрыт!");
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
