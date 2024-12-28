package bgu.spl.mics.application;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.concurrent.LinkedBlockingQueue;
import bgu.spl.mics.*;
import bgu.spl.mics.application.objects.*;
import bgu.spl.mics.application.services.*;

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
        Thread TrCm = new Thread(cama);
        test.add(cama);
        TrCm.start();
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
