package views;

import models.Id;
import models.IdPojo;

public class IdTextView {

    public IdTextView() {
    }

    public String display(IdPojo m) {
        return m.toString();
    } 
}