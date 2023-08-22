package com.javafacedetection;
import org.opencv.core.*;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.highgui.HighGui;

public class FaceDetection {



        public static void main(String[] args) {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            String imgFile = "images/depositphotos_52455505-stock-photo-multi-ethnic-people.jpg";

            // Load the image
            Mat image = Imgcodecs.imread(imgFile);


            String xmlFile = "xml/lbpcascade_frontalface.xml";
            // Convert the image to grayscale
            Mat grayImage = new Mat();
            Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

            // Create a face detector
            CascadeClassifier faceDetector = new CascadeClassifier(xmlFile);

            // Detect faces
            MatOfRect faceDetections = new MatOfRect();
            faceDetector.detectMultiScale(grayImage, faceDetections);

            // Draw rectangles around the faces
            for (Rect rect : faceDetections.toArray()) {
                Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
            }

            // Display the result
            HighGui.imshow("Face Detection", image);
            HighGui.waitKey();
            System.out.println("Image Detection finished");

        }
    }
