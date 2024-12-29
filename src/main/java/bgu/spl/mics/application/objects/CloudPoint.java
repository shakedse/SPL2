package bgu.spl.mics.application.objects;

import java.util.LinkedList;

/**
 * CloudPoint represents a specific point in a 3D space as detected by the LiDAR.
 * These points are used to generate a point cloud representing objects in the environment.
 */
public class CloudPoint 
{

    // TODO: Define fields and methods.
    //FIELDS:

    private double x;
    private double y;

    public CloudPoint(double x, double y)
    {
        this.x=x;
        this.y=y;
        }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
