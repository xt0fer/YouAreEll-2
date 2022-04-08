package views;

import models.Id;

public class IdTextView {
    private Id id;

    public IdTextView() {
    }
    
    @Override public String toString() {
        return this.id.toString();
    } 
}