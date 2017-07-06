package model.transform;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestImageTransformTasks {

    @Test
    public void testStoreOptionsToString() {
        String correct = "store=filename:some_file.txt,location:S3,path:/some/path/,container:some_bucket,"
                + "region:us-east-1,access:private,base64decode:false";

        TransformTask storeOptions = new StoreOptions.Builder()
                .filename("some_file.txt")
                .location("S3")
                .path("/some/path/")
                .container("some_bucket")
                .region("us-east-1")
                .access("private")
                .base64Decode(false)
                .build();

        String output = storeOptions.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testResizeTaskToString() {
        String correct = "resize=width:100,height:100,fit:clip,align:center";

        TransformTask resizeTask = new ResizeTask.Builder()
                .width(100)
                .height(100)
                .fit("clip")
                .align("center")
                .build();

        String output = resizeTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testResizeTaskAlignPairToString() {
        String correct = "resize=width:100,height:100,fit:clip,align:[top,left]";

        TransformTask resizeTask = new ResizeTask.Builder()
                .width(100)
                .height(100)
                .fit("clip")
                .align("top", "left")
                .build();

        String output = resizeTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testCropTaskToString() {
        String correct = "crop=dim:[0,0,100,100]";

        TransformTask cropTask = new CropTask(0,0,100,100);

        String output = cropTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testRotateTaskToString() {
        String correct = "rotate=deg:90,exif:false,background:white";

        TransformTask rotateTask = new RotateTask.Builder()
                .deg(90)
                .exif(false)
                .background("white")
                .build();

        String output = rotateTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testRotateTaskDegExifToString() {
        String correct = "rotate=deg:exif,exif:false,background:white";

        TransformTask rotateTask = new RotateTask.Builder()
                .deg("exif")
                .exif(false)
                .background("white")
                .build();

        String output = rotateTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testFlipTaskToString() {
        String correct = "flip";

        TransformTask flipTask = new FlipTask();

        String output = flipTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testFlopTaskToString() {
        String correct = "flop";

        TransformTask flopTask = new FlopTask();

        String output = flopTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testWatermarkTaskToString() {
        String correct = "watermark=file:VsXhJVWReSrYU7UoFyfw,size:75,position:top";

        TransformTask watermarkTask = new WatermarkTask.Builder()
                .file("VsXhJVWReSrYU7UoFyfw")
                .size(75)
                .position("top")
                .build();

        String output = watermarkTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testWatermarkTaskPositionPairToString() {
        String correct = "watermark=file:VsXhJVWReSrYU7UoFyfw,size:75,position:[top,right]";

        TransformTask watermarkTask = new WatermarkTask.Builder()
                .file("VsXhJVWReSrYU7UoFyfw")
                .size(75)
                .position("top", "right")
                .build();

        String output = watermarkTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testDetectFacesTaskIntsToString() {
        String correct = "detect_faces=minsize:100,maxsize:100,color:white,export:false";

        TransformTask detectFacesTask = new DetectFacesTask.Builder()
                .minSize(100)
                .maxSize(100)
                .color("white")
                .export(false)
                .build();

        String output = detectFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testDetectFacesTaskFloatsToString() {
        String correct = "detect_faces=minsize:0.25,maxsize:0.75,color:white,export:false";

        TransformTask detectFacesTask = new DetectFacesTask.Builder()
                .minSize(.25)
                .maxSize(.75)
                .color("white")
                .export(false)
                .build();

        String output = detectFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testCropFacesTaskToString() {
        String correct = "crop_faces=mode:thumb,width:100,height:100,faces:1,buffer:200";

        TransformTask cropFacesTask = new CropFacesTask.Builder()
                .mode("thumb")
                .width(100)
                .height(100)
                .faces(1)
                .buffer(200)
                .build();

        String output = cropFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testCropFacesTaskArrayToString() {
        String correct = "crop_faces=mode:thumb,width:100,height:100,faces:[1,2,3,4],buffer:200";

        TransformTask cropFacesTask = new CropFacesTask.Builder()
                .mode("thumb")
                .width(100)
                .height(100)
                .faces(1, 2, 3, 4)
                .buffer(200)
                .build();

        String output = cropFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }

    @Test
    public void testCropFacesTaskStringToString() {
        String correct = "crop_faces=mode:thumb,width:100,height:100,faces:all,buffer:200";

        TransformTask cropFacesTask = new CropFacesTask.Builder()
                .mode("thumb")
                .width(100)
                .height(100)
                .faces("all")
                .buffer(200)
                .build();

        String output = cropFacesTask.toString();

        String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s", correct, output);
        assertTrue(message, output.equals(correct));
    }
}