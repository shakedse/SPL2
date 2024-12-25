package bgu.spl.mics;

import java.util.concurrent.TimeUnit;

/**
 * A Future object represents a promised result - an object that will
 * eventually be resolved to hold a result of some operation. The class allows
 * Retrieving the result once it is available.
 * 
 * Only private methods may be added to this class.
 * No public constructor is allowed except for the empty constructor.
 */
public class Future<T> 
{
	private T result;
	private volatile boolean isDone;

	/**
	 * This should be the the only public constructor in this class.
	 */
	public Future() 
	{
		//TODO: implement this
		isDone=false;
		result=null;

	}
	
	/**
     * retrieves the result the Future object holds if it has been resolved.
     * This is a blocking method! It waits for the computation in case it has
     * not been completed.
     * <p>
     * @return return the result of type T if it is available, if not wait until it is available.
     * 	       
     */
	public synchronized T get() //this method is synchronized because we dont want 2 theards trying to get at the same time
	{
		//TODO: implement this.
		while (!isDone) //waiting for a result
		{
			try 
			{
				this.wait();// waits till gets notify that we found a result
			} 
			catch (InterruptedException e) 
			{
				Thread.currentThread().interrupt();
			}
		}
		return result;
	}
	
	/**
     * Resolves the result of this Future object.
     */
	public synchronized void resolve (T result) //this method is synchronized because we dont want 2 theards trying to put a value in result at the same time
	{
		//TODO: implement this.
		this.result = result;
		isDone = true;
		notifyAll();
	}
	
	/**
     * @return true if this object has been resolved, false otherwise
     */
	public boolean isDone() 
	{
		//TODO: implement this.
		return isDone;
	}
	
	/**
     * retrieves the result the Future object holds if it has been resolved,
     * This method is non-blocking, it has a limited amount of time determined
     * by {@code timeout}
     * <p>
     * @param timout 	the maximal amount of time units to wait for the result.
     * @param unit		the {@link TimeUnit} time units to wait.
     * @return return the result of type T if it is available, if not, 
     * 	       wait for {@code timeout} TimeUnits {@code unit}. If time has
     *         elapsed, return null.
     */
	public synchronized T get(long timeout, TimeUnit unit) 
	{
		//TODO: implement this.
		long waitingTime = unit.toMillis(timeout);//converting long to milis
		long endTime = System.currentTimeMillis() + waitingTime;
	
		while (!isDone) 
		{
			long remainTime = endTime - System.currentTimeMillis();//Time left
			if(remainTime <= 0)//Time out
				return null;
			try
			{
				this.wait(remainTime);//waiting the time
			}
			catch(InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
		return result;
	}
}
