package bgu.spl.mics.application;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import bgu.spl.mics.MicroService;
import bgu.spl.mics.application.objects.Camera;
import bgu.spl.mics.application.services.CameraService;

/**
 * The main entry point for the GurionRock Pro Max Ultra Over 9000 simulation.
 * <p>
 * This class initializes the system and starts the simulation by setting up
 * services, objects, and configurations.
 * </p>
 */
public class GurionRockRunner {

    /**
     * The main method of the simulation.
     * This method sets up the necessary components, parses configuration files,
     * initializes services, and starts the simulation.
     *
     * @param args Command-line arguments. The first argument is expected to be the path to the configuration file.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkedBlockingQueue<MicroService> test = new LinkedBlockingQueue<MicroService>();
        Camera cam = new Camera(2,3 );
        MicroService cama = new CameraService(cam);
        test.add(cama);
        try
        {
            System.out.println(test.take().getClass());
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }

        System.out.println(test.poll());
        
        


        System.out.println(test.remainingCapacity());
        // TODO: Parse configuration file.
        // TODO: Initialize system components and services.
        // TODO: Start the simulation.
    }
}
