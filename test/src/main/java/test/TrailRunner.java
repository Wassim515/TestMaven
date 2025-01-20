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

        public TrailRunner  (String id, double distance, int hours, int min, int sec, LocalDate date){
         if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID får inte vara null eller tomt.");
         }
         else if( hours < 0|| sec < 0 || min < 0) {
            throw new IllegalArgumentException("Tid måste vara positiv.");
         }
         
         else if (date == null) {
            date = LocalDate.now(); // Om inget datum anges, använd dagens datum
         }
         else if (distance <= 0) {
            throw new IllegalArgumentException("Distance måste vara positiv");

         } else if (hours == 0 && min == 0 && sec == 0) {
            throw new IllegalArgumentException("tiden kan inte vara noll");
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
        double totalTimeInHours = hours + min / 60.0 + sec / 3600.0;
        return distance / totalTimeInHours;  
    }


    public double calculatePace() {
        double totalTimeInMinutes = hours * 60 + min + sec / 60.0;
        return totalTimeInMinutes / distance;  
    }

    
    


}