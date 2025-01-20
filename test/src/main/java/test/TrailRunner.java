package test;

import java.time.LocalDate;
    
public class TrailRunner {

  private double distance;
  private int hours;
  private int min;
  private int sec;
  private LocalDate date;
  private String id;

        Run run = new Run();

        public TrailRunner  (String id, double distance, int hours,int sec, int min, LocalDate date){
         if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID får inte vara null eller tomt.");
        }
         if ( hours < 0|| sec < 0 || min < 0) {
            throw new IllegalArgumentException("Tid måste vara positiv.");
         }
          if (run.database.containsKey(id)) {
            throw new IllegalArgumentException("En löpning med samma ID finns redan.");
         }
         if (date == null) {
            date = LocalDate.now(); // Om inget datum anges, använd dagens datum
         }
         if (distance <= 0) {
            throw new IllegalArgumentException("Distance måste vara positiv");
         }

         this.id = id;
         this.distance = distance;
         this.hours = hours;
         this.min = min;
         this.sec = sec;
         this.date = LocalDate.now();
           
        }

    public String getId(){
        return id;
    }

    public double getDistance() {
        return distance;
    }
    public int getHours(){
        return hours;
    }
    public int getSec(){
        return sec;
    }
    public int getMin(){
        return min;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public double calculateSpeed() {
        
        if (hours == 0 && min == 0 && sec == 0) {
            throw new IllegalArgumentException("tiden kan inte vara noll");
        }

        double totalTimeInHours = hours + min / 60.0 + sec / 3600.0;
        return distance / totalTimeInHours;  
    }


    public double calculatePace() {
       
        if (distance == 0) {
            throw new IllegalArgumentException("Distance kan inte vara noll");
        }

        double totalTimeInMinutes = hours * 60 + min + sec / 60.0;
        return totalTimeInMinutes / distance;  
    }

    
    


}