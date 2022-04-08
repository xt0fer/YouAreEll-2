package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import models.Id;

public class IdController {
 
    private ArrayList<Id> idlist;

    public IdController() {}

    public ArrayList<Id> getIds() {
        if (this.idlist == null) {
            // get the list of ids from the server.
        }
        return this.idlist;
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}