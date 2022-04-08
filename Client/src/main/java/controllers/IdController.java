package controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.IdPojo;

public class IdController {

    private List<IdPojo> idlist;
    private IdPojo[] ids;
    private ServerController svr = ServerController.shared();

    public IdController() {
    }

    public List<IdPojo> getIds() {
        if (this.idlist == null) {
            // get the list of ids from the server.
            String resultJSON = null;
            try {
                resultJSON = svr.getUrl("ids");
                final ObjectMapper objectMapper = new ObjectMapper();
                this.ids = objectMapper.readValue(resultJSON, IdPojo[].class);
                this.idlist = (List<IdPojo>) Arrays.asList(this.ids);
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