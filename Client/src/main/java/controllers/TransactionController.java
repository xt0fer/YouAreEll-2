package controllers;

import models.Id;
import models.Message;
import views.IdTextView;
import views.MessageTextView;
import views.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";

    private MessageController msgCtrl;
    private IdController idCtrl;
    private HashMap<String, Message> messageCache = new HashMap<>();

    public TransactionController(MessageController m, IdController j) {
        this.msgCtrl = m;
        this.idCtrl = j;
    }

    /**
     * I've decided to make TransactionController the main
     * "do it here" class, rather than go into MessageController
     * 
     * As I'm thinking this thru, I might NOT use the MessageController
     * of the IDController, and just put all the functionality here in 
     * TransactionController. I can do that, I'm the coder on this version.
     * 
     */
    public TextView getNewMessages() {
        List<Message> newMsgs = this.filterOutSeenMsgs(msgCtrl.getMessages());
        return new MessageTextView(this.collapseMsgsToString(newMsgs));
    }

    /**
     * 
     * ALL PRIVATE METHODS DOWN HERE.
     * 
     */
    private List<Message> filterOutSeenMsgs(List<Message> currentMessages) {
        // this uses a HashMap to create a cache of already seen messages.
        List<Message> newlist = new ArrayList<Message>();
        for (Message m: currentMessages) {
            if (!messageCache.containsKey(m.getSequence())){
                messageCache.put(m.getSequence(), m);
                newlist.add(m);
            }
        }
        return newlist;
    }

    private String collapseMsgsToString(List<Message> now) {
        StringBuilder s = new StringBuilder();
        for (Message m: now) {
            s.append(m.toString());
        }
        return s.toString();
    }

    //not used
    public List<Id> getIds() {
        return null;
    }

    // not used
    public String postId(String idtoRegister, String githubName) {
//        Id tid = new Id(idtoRegister, githubName);
//        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }

    // public MessageController messageController() {
    //     return this.msgCtrl;
    // }

}
