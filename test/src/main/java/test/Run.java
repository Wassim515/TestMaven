package test;
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
        System.out.println("Distans " + run.getDistance());
        System.out.println("Tid " + run.getHours() + "h " + run.getMin() + "min " +  run.getSec() + "sec");
        System.out.println("Datum" + run.getDate());
        System.out.println("Kilomtertid " + run.calculatePace() + "min/km");
        System.out.println("Medelhastighet " + run.calculateSpeed() + "km/h");
        
    }

    public void deleteTrailRunnerById(String id){
        if(!database.containsKey(id)){
            throw new NoSuchElementException("Löprundan hittades inte med detta ID");
        }

        database.remove(id);
    }



}

  






