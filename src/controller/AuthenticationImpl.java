package controller;

import client.Client;

public class AuthenticationImpl implements Authentication{
    private Client client;

    @Override
    public boolean auth(String pass) {
        return client.getPassword().equals(pass);
    }
}
