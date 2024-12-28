package bgu.spl.mics.application.objects;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an object tracked by the LiDAR.
 * This object includes information about the tracked object's ID, description, 
 * time of tracking, and coordinates in the environment.
 */
public class TrackedObject 
{
    // TODO: Define fields and methods.
    //fields:
    private String id;
    private int Time;
    private String descripton;
    private CloudPoint[] cloudPoints;

    public TrackedObject (String id,int time, String descripton, LinkedList<CloudPoint> cloudPoints)
    {
        this.id=id;
        this.descripton=descripton;
        this.Time = time;
        this.cloudPoints = new CloudPoint[cloudPoints.size()];// איזה גודל המערך צריך להיות?
        for(int i = 0; i < cloudPoints.size(); i++)
        {
            this.cloudPoints[i] = new CloudPoint(cloudPoints.get(i).getY(), cloudPoints.get(i).getX());
        }
    }

    public TrackedObject (String id,int time, String descripton, List<LinkedList<Double>> cloudPoints)
    {
        this.id=id;
        this.descripton=descripton;
        this.Time = time;
        for(int i = 0; i < cloudPoints.size(); i++)
        {
            this.cloudPoints[i] = new CloudPoint(cloudPoints.get(i).get(0), cloudPoints.get(i).get(1), cloudPoints.get(i)); 
        }
    }
}


