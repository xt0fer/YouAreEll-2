package views;

import models.Message;

public class MessageTextView {

    public MessageTextView() {}

    public String display(Message m) {
        return m.toString();
    } 
}