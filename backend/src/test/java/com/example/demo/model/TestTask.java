package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestTask {
    @Test
    public void testSetTaskDescription(){
        String desc = "TestDescription";
        Task task = new Task();
        task.setTaskdescription(desc);

        assertEquals(desc,task.getTaskdescription());
    }

    @Test
    public void testSetId(){
        int id = 9;
        Task task = new Task();
        task.setId(id);

        assertEquals(id, task.getId());
    }
}
