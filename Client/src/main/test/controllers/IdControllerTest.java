package controllers;

import models.IdPojo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IdControllerTest {

    @Test
    void getIds() {
        IdController idc = new IdController();
        List<IdPojo> res = idc.getIds();
        System.out.println(res);
        assertNotNull(res);

    }

    @Test
    void postId() {
    }

    @Test
    void putId() {
    }
}