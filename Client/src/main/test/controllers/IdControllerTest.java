package controllers;

import models.Id;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IdControllerTest {

    @Test
    void getIds() {
        IdController idc = new IdController();
        List<Id> res = idc.getIds();
        System.out.println(res.get(0));
        assertNotNull(res);

    }

    @Test
    void postId() {
    }

    @Test
    void putId() {
    }
}