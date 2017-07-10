package model.transform;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestPixelateFacesTask {

    @Test
    public void testToString() {
        String correct = "pixelate_faces=faces:1,minsize:200,maxsize:300,buffer:50,amount:5,blur:10.0,type:oval";

        TransformTask pixelateFacesTask = new PixelateFacesTask.Builder()
                .faces(1)
                .minSize(200)
                .maxSize(300)
                .buffer(50)
                .amount(5)
                .blur(10)
                .type("oval")
                .build();

        String output = pixelateFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testToStringFacesArray() {
        String correct = "pixelate_faces=faces:[1,2,3,4]";

        TransformTask pixelateFacesTask = new PixelateFacesTask.Builder()
                .faces(1, 2, 3, 4)
                .build();

        String output = pixelateFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testToStringFacesAll() {
        String correct = "pixelate_faces=faces:all";

        TransformTask pixelateFacesTask = new PixelateFacesTask.Builder()
                .faces("all")
                .build();

        String output = pixelateFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testToStringSizeFloats() {
        String correct = "pixelate_faces=minsize:0.35,maxsize:0.35";

        TransformTask pixelateFacesTask = new PixelateFacesTask.Builder()
                .minSize(.35)
                .maxSize(.35)
                .build();

        String output = pixelateFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }
}
