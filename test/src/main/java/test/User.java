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

       //Getter och Setter 
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
       
    public int daysSinceLastrun(){
        if (lastRunDate == null) {
            return 0;
        }
        return (int) ChronoUnit.DAYS.between(lastRunDate, LocalDate.now());

    }

    public LocalDate setLastRunDate(LocalDate lastRunDate) {
        TrailRunner trailRunner = new TrailRunner("Run1", 10, 1, 4, 0 , LocalDate.now());
        lastRunDate = trailRunner.getDate();
        return lastRunDate;

    }

    public double calFitness (double currentScore){
        TrailRunner run = new TrailRunner(null, currentScore, weight, height, age, lastRunDate);
        double score = currentScore + (run.getDistance() + run.calculateSpeed() / run.calculatePace()) - daysSinceLastrun() / 2;
        currentScore +=  Math.max(score, 0);
        return currentScore;

    }

   
public int calculateFitnessScore(double distance, double avgSpeed, double kilometerPace){
    double fitnessScore = (distance * avgSpeed) / kilometerPace;

return Math.max(0, (int) fitnessScore);

}


}

    
 






 
