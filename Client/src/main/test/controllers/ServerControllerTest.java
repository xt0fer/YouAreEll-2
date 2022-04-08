package controllers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ServerControllerTest {

    @org.junit.jupiter.api.Test
    void shared() {
    }

    @org.junit.jupiter.api.Test
    void getUrl() {
        ServerController svr = ServerController.shared();
        String idu = "ids";
        try {
            String result = svr.getUrl(idu);
            System.out.println(result);
            assertNotEquals("",result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void postUrl() {
    }

    @org.junit.jupiter.api.Test
    void putUrl() {
    }
}