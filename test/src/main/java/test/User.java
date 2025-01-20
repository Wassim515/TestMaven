package test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User {
    private int weight; 
    private int height; 
    private int age;    
    private double currentScore; 
    

    private LocalDate lastRunDate;

    public User(int weight, int height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.currentScore = 0;
        this.lastRunDate = null;
    }

       
    public int getHeight() {
      return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCurrentScore() {
        return currentScore;
    }
    
    public void setCurrentScore(double currentScore) {
        this.currentScore = currentScore;
    }   
    public long daysSinceLastrun(){
         if (lastRunDate == null) {
         return 0;
        }
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(lastRunDate, today);
    }

    public LocalDate setLastRunDate(LocalDate lastRunDate) {
        TrailRunner trailRunner = new TrailRunner("Run1", 10, 1, 4, 0 , LocalDate.now());
        lastRunDate = trailRunner.getDate();
        return lastRunDate;

    }

    public double calculateFitnessScore(Run run, TrailRunner runner) {
   
      if (run.database.isEmpty()) {
        return 0;
       }

       double fitnessScore = currentScore + 
      (runner.getDistance() + (runner.calculateSpeed() / runner.calculatePace())) - (daysSinceLastrun() / 2.0);

      currentScore = Math.max(fitnessScore, 0);
      return currentScore; 

    }



}

    
 






 
