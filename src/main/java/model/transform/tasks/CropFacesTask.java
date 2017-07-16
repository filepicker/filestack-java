package model.transform.tasks;

import model.transform.base.ImageTransformTask;

public class CropFacesTask extends ImageTransformTask {

    // Constructor made private because this task cannot be used with default options
    private CropFacesTask() {
        super("crop_faces");
    }
    
    public static class Builder {
        private CropFacesTask cropFacesTask;
        
        public Builder() {
            this.cropFacesTask = new CropFacesTask();
        }

        public Builder mode(String mode) {
            cropFacesTask.addOption("mode", mode);
            return this;
        }

        public Builder width(int width) {
            cropFacesTask.addOption("width", width);
            return this;
        }

        public Builder height(int height) {
            cropFacesTask.addOption("height", height);
            return this;
        }

        public Builder faces(int... faces) {
            if (faces.length == 1) {
                cropFacesTask.addOption("faces", faces[0]);
                return this;
            }

            Integer[] objectArray = new Integer[faces.length];
            for (int i = 0; i < faces.length; i++)
                objectArray[i] = faces[i];
            cropFacesTask.addOption("faces", objectArray);
            return this;
        }

        // For "all" value
        public Builder faces(String faces) {
            cropFacesTask.addOption("faces", faces);
            return this;
        }

        public Builder buffer(int buffer) {
            cropFacesTask.addOption("buffer", buffer);
            return this;
        }

        public CropFacesTask build() {
            return cropFacesTask;
        }
    }
}