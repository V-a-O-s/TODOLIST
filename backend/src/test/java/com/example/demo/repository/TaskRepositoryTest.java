package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Task;
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testFindTaskByDescription(){
        final String test_me = "test_me";
        Task firstResult = taskRepository.findByTaskdescription(test_me);
        assertTrue(null==firstResult,"no task should have the description yet");

        Task t = new Task();
        t.setTaskdescription(test_me);
        taskRepository.save(t);

        Task findMe = taskRepository.findByTaskdescription(test_me);
        assertNotNull(findMe,"Task should have been found.");
        assertEquals(test_me, findMe.getTaskdescription());
    }

    @Test
    void testFindById() {
        // Given
        Task task = new Task();
        task.setTaskdescription("Task 1");
        taskRepository.save(task);

        int taskId = task.getId();
        String expectedDescription = task.getTaskdescription();

        Optional<Task> optionalTask = taskRepository.findById(taskId);

        assertTrue(optionalTask.isPresent());
        Task foundTask = optionalTask.get();
        assertEquals(taskId, foundTask.getId());
        assertEquals(expectedDescription, foundTask.getTaskdescription());
    }
}
