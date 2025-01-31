package bgu.spl.mics.application.objects;

import java.util.LinkedList;

/**
 * Represents objects detected by the camera at a specific timestamp.
 * Includes the time of detection and a list of detected objects.
 */
public class StampedDetectedObjects 
{
    //fields:
    private int time;
    private LinkedList<DetectedObject> detectedObjects;
    
    public StampedDetectedObjects (int time, LinkedList<DetectedObject> detectedObjects)
    {
        this.time=time; 
        this.detectedObjects = detectedObjects;
    }

    public int getTime()
    {
        return time;
    }

    public LinkedList<DetectedObject> getList()
    {
        return detectedObjects;
    }
}
