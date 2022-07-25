package views;

import models.Message;
import models.Result;

public class MessageTextView implements TextView {
    private String show;

    public MessageTextView() {}

    public MessageTextView(String s){
        this.show = s;
    }

    @Override
    public String toString() {
        return show;
    }

    public String display(Message m) {
        return m.toString();
    }

    @Override
    public String display(Result result) {
        // TODO Auto-generated method stub
        return null;
    }
}