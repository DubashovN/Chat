package client;

import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientSocket implements ClientInt, Runnable{
    private Server server;
    private Client client;
    private static final int PORT = 3443;
    private static final String ADDRESS = "localhost";


    public ClientSocket(Server server, Client client) {
        this.server = server;
        this.client = client;
    }


    @Override
    public void connect() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter your name: ");
            String name = reader.readLine();
            System.out.println("Enter your password: ");
            String password = reader.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void run() {

    }
}
