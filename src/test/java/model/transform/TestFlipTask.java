package model.transform;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestFlipTask {

    @Test
    public void testToString() {
        String correct = "flip";

        TransformTask flipTask = new FlipTask();

        String output = flipTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }
}
