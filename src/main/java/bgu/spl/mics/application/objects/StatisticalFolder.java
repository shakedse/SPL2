package bgu.spl.mics.application.objects;

import java.util.concurrent.atomic.AtomicInteger;

import bgu.spl.mics.MessageBusImpl;

/**
 * Holds statistical information about the system's operation.
 * This class aggregates metrics such as the runtime of the system,
 * the number of objects detected and tracked, and the number of landmarks identified.
 */
public class StatisticalFolder {
    private static final StatisticalFolder instance = new StatisticalFolder();
    private volatile AtomicInteger systemRunTime;
    private volatile AtomicInteger numDetectedObjects;
    private volatile AtomicInteger numTrackedObjects;
    private volatile AtomicInteger numLandmarks;

    public StatisticalFolder()
    {
        systemRunTime = new AtomicInteger(0);
        numDetectedObjects = new AtomicInteger(0);
        numTrackedObjects = new AtomicInteger(0);
        numLandmarks = new AtomicInteger(0);
    }
    public static StatisticalFolder getInstance() {
        return instance;
    }

    // Synchronized method to increment systemRunTime
    public void incrementSystemRunTime() {
        systemRunTime.incrementAndGet();
    }

    // Synchronized method to increment numDetectedObjects
    public void incrementNumDetectedObjects() {
        numDetectedObjects.incrementAndGet();
    }

    // Synchronized method to increment numTrackedObjects
    public void incrementNumTrackedObjects() {
        numTrackedObjects.incrementAndGet();
    }

    // Synchronized method to increment numLandmarks
    public void incrementNumLandmarks() {
        numLandmarks.incrementAndGet();
    }

    public AtomicInteger getSystemRunTime() {
        return systemRunTime;
    }

    public AtomicInteger getNumDetectedObjects() {
        return numDetectedObjects;
    }

    public AtomicInteger getNumTrackedObjects() {
        return numTrackedObjects;
    }

    public AtomicInteger getNumLandmarks() {
        return numLandmarks;
    }
}
