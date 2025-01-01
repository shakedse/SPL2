package bgu.spl.mics.application.services;

import bgu.spl.mics.MessageBusImpl;
import bgu.spl.mics.MicroService;
import bgu.spl.mics.application.messages.TerminatedBroadcast;
import bgu.spl.mics.application.messages.TickBroadcast;
import bgu.spl.mics.application.objects.StatisticalFolder;

/**
 * TimeService acts as the global timer for the system, broadcasting TickBroadcast messages
 * at regular intervals and controlling the simulation's duration.
 */
public class TimeService extends MicroService {

    /**
     * Constructor for TimeService.
     *
     * @param TickTime  The duration of each tick in milliseconds.
     * @param Duration  The total number of ticks before the service terminates.
     */
    private int tickTime;
    private int duration;

    public TimeService(int TickTime, int Duration) {
        super("TimeService");
        // TODO Implement this
        this.tickTime = TickTime;
        this.duration = Duration;
    }

    /**
     * Initializes the TimeService.
     * Starts broadcasting TickBroadcast messages and terminates after the specified duration.
     */
    @Override
    protected void initialize() 
    {
        int tickNum = 1;
        while (tickNum <= duration) 
        {
            System.out.println("tick: " + tickNum);
            sendBroadcast(new TickBroadcast (tickNum)); 
            try
            {
                //statistical runtime
                Thread.sleep(tickTime);
                tickNum++;
                StatisticalFolder.getInstance().incrementSystemRunTime();
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
        
        sendBroadcast(new TerminatedBroadcast("TimeService"));
        terminate();
    }
}
