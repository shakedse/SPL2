package bgu.spl.mics.application.objects;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * LiDarDataBase is a singleton class responsible for managing LiDAR data.
 * It provides access to cloud point data and other relevant information for tracked objects.
 */
public class LiDarDataBase 
{
    private static LiDarDataBase instance;
    private List<StampedCloudPoints> cloudPoints;
    /**
     * Returns the singleton instance of LiDarDataBase.
     *
     * @param filePath The path to the LiDAR data file.
     * @return The singleton instance of LiDarDataBase.
     */
      //".\\example_input_2\\lidar_data.json"  

    private LiDarDataBase(String filepath) 
    {
        Gson gson = new Gson(); 
        try (FileReader reader = new FileReader(filepath)) 
        {
            // Convert JSON File to Java Object
            this.cloudPoints = gson.fromJson(reader, new TypeToken<List<StampedCloudPoints>>(){}.getType());
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
   /*  private LiDarDataBase(String filepath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filepath)) {
            // Convert JSON File to Java Object
            this.cloudPoints = gson.fromJson(reader, new TypeToken<LinkedBlockingQueue<StampedCloudPoints>>() {}.getType());
            if (this.cloudPoints == null) {
                this.cloudPoints = new LinkedBlockingQueue<>(); // Default empty queue if JSON is empty
            }
        } catch (IOException e) {
            System.err.println("Error reading LiDAR data file: " + e.getMessage());
            this.cloudPoints = new LinkedBlockingQueue<>(); // Default to empty queue in case of error
        }
    }*/

    

    public static LiDarDataBase getInstance(String filePath)
    {   
        if (instance == null) 
            instance = new LiDarDataBase(filePath);
        return instance;
    }

    public List<StampedCloudPoints> getCloudPoints() 
    {
        return cloudPoints;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 3 ; i++) {
            System.out.print(getInstance(".\\example_input_2\\lidar_data.json").getCloudPoints().get(i).getID());
            System.out.print("     ");
            System.out.print(getInstance(".\\example_input_2\\lidar_data.json").getCloudPoints().get(i).getTime());
            System.out.print("     "); // not getting the right time!!!
            //System.out.print(getInstance(".\\example_input_2\\lidar_data.json").getCloudPoints().get(i).getCloudPoints().toString());
            System.out.println("     ");
        }
    }
}
