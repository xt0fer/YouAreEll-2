package views;

import models.Message;
import models.MessagePojo;

public class MessageTextView {

    public MessageTextView() {}

    public String display(MessagePojo m) {
        return m.toString();
    } 
}