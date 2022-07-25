package controllers;

import models.Id;
import models.Message;
import views.IdTextView;
import views.MessageTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";

    private MessageController msgCtrl;
    private IdController idCtrl;
    private IdTextView idView;
    private MessageTextView msgView;
    private HashMap<String, Message> messageCache = new HashMap<>();

    public TransactionController(MessageController m, IdController j) {
        this.msgCtrl = m;
        this.idCtrl = j;
        this.idView = new IdTextView();
        this.msgView = new MessageTextView();

    }

    public List<Id> getIds() {
        return null;
    }

    public String postId(String idtoRegister, String githubName) {
//        Id tid = new Id(idtoRegister, githubName);
//        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }

    public MessageController messageController() {
        return this.msgCtrl;
    }

    public List<Message> getNewMessages() {
        List<Message> now = msgCtrl.getMessages();
        List<Message> newlist = new ArrayList<Message>();

        for (Message m: now) {
            if (!messageCache.containsKey(m.getSequence())){
                messageCache.put(m.getSequence(), m);
                newlist.add(m);
            }
        }

        return newlist;
    }
}
