package com.example.classm8;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ChatClient {
    private Socket socket;

    public void connect() {
        try {
            socket = IO.socket("http://localhost:3000");
            socket.connect();

            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Connected to server");
                }
            });

            socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Disconnected from server");
                }
            });

            socket.on("chat message", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    String message = (String) args[0];
                    String[] temp = message.split("[$]");
                    String posiljalac = temp[0];
                    String primalac = temp[1];
                    String poruka = temp[2];
                    GlobalUsername x = new GlobalUsername();
                    if (primalac.equals(x.getGlobalUsername())) {
                        System.out.println(posiljalac + ": " + poruka);
                    };
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        socket.emit("chat message", message);
    }
}

