import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket socket;
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

    public void connect() {
        try {
            try {
                socket = new ServerSocket(30333);
                System.out.println("Сервер запущен!");
                clientSocket = socket.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine();
                    System.out.println(word);

                    out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
                    out.flush();

                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                socket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
