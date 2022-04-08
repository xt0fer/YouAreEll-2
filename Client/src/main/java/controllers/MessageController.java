package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.IdPojo;
import models.Message;
import models.MessagePojo;

public class MessageController {

    private HashSet<Message> messagesSeen;
    // why a HashSet??
    private List<MessagePojo> msglist;
    private MessagePojo[] msgs;
    private ServerController svr = ServerController.shared();

    public List<MessagePojo> getMessages() {
        if (this.msglist == null) {
            // get the list of ids from the server.
            String resultJSON = null;
            try {
                resultJSON = svr.getUrl("messages");
                final ObjectMapper objectMapper = new ObjectMapper();
                this.msgs = objectMapper.readValue(resultJSON, MessagePojo[].class);
                this.msglist = (List<MessagePojo>) Arrays.asList(this.msgs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.msglist;
    }

    public List<Message> getMessagesForId(Id Id) {
        return null;
    }

    public Message getMessageForSequence(String seq) {
        return null;
    }

    public List<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }

}