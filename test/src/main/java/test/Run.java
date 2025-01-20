package test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class Run {

   public Map<String, TrailRunner> database = new HashMap<>();

    public void addRunToDataBase(TrailRunner run){
        if(database.containsKey(run.getId())){
            throw new IllegalArgumentException("ID finns redan!");
        }

     database.put(run.getId(), run);
        
    }


    public TrailRunner getRunById(String id) {
        if (database.containsKey(id)) {
            return database.get(id); 
        } else {
            throw new IllegalArgumentException("ID hittades inte");
        }
    }

    public double getTotalDistance() {
        return database.values().stream().mapToDouble(TrailRunner::getDistance)
                .sum();
    }

    public double getTotalAverageDistance(){
       if (database.isEmpty()){
         return 0.0;
       }

       return getTotalDistance() / database.size();
    }

    public void printRunInfo(String id) {

        TrailRunner run = getRunById(id);

        System.out.println("ID " + run.getId() );
        System.out.println("Distans " + run.getDistance() );
        System.out.println("Tid" + run.getHours() + "h" + run.getMin() + "min" +  run.getSec() + "sec");
        System.out.println("Datum" + run.getDate());
        System.out.println("Kilomtertid" + run.calculatePace() + "min/km");
        System.out.println("Medelhastighet" + run.calculateSpeed() + "km/h");
        
    }

    public void deleteTrailRunnerById(String id){
        if(!database.containsKey(id)){
            throw new NoSuchElementException("Löprundan hittades inte med detta ID");
        }

        database.remove(id);
    }


    public double calculateSpeed() {
        double totalDistance = getTotalDistance();
        double totalTimeInHours = 0;

        for (TrailRunner run : database.values()) {
            double timeInHours = run.getHours() + run.getMin() / 60.0 + run.getSec() / 3600.0;
            totalTimeInHours += timeInHours;
        }

        
        if (totalTimeInHours == 0) {
            return 0;
        }

        return totalDistance / totalTimeInHours; 
    }
    public double calculatePace() {
        double totalDistance = getTotalDistance();
        double totalTimeInMinutes = 0;

        for (TrailRunner run : database.values()) {
            double timeInMinutes = run.getHours() * 60 + run.getMin() + run.getSec() / 60.0;
            totalTimeInMinutes += timeInMinutes;
        }

      
        if (totalDistance == 0) {
            return 0;
        }

        return totalTimeInMinutes / totalDistance; 
    }

    


}

  






