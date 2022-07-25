package controllers;

import models.Message;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageControllerTest {

    @Test
    void getMessages() {
        MessageController idc = new MessageController();
        List<Message> res = idc.getMessages();
        //System.out.println(res);
        Message lastmsg = res.get(0);
        System.out.println(lastmsg);
        assertNotNull(res);
    }

    @Test
    void getMessagesForId() {
    }

    @Test
    void getMessageForSequence() {
    }

    @Test
    void getMessagesFromFriend() {
    }

    @Test
    void postMessage() {
    }
}