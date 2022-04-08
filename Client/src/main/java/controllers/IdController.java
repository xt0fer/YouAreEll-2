package controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {

    private List<Id> idlist;
    private Id[] ids;
    private ServerController svr = ServerController.shared();

    public IdController() {
    }

    public List<Id> getIds() {
        if (this.idlist == null) {
            // get the list of ids from the server.
            String resultJSON = null;
            try {
                resultJSON = svr.getUrl("ids");
                final ObjectMapper objectMapper = new ObjectMapper();
                this.ids = objectMapper.readValue(resultJSON, Id[].class);
                this.idlist = (List<Id>) Arrays.asList(this.ids);
            } catch (IOException e) {
                e.printStackTrace();
            }
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