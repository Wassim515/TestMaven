import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import test.Run;
import test.TrailRunner;
import test.User;

public class UserTest {

    @Test

    void UserTestWeight() {


        int weight = 2;
        int height = 0;
        int age = 0;

        User user = new User(weight,height,age);

        assertEquals(weight,user.getWeight());
        
    }
    @Test

    void UserTestHeight() {

        int weight = 20;
        int height = 134;
        int age = 7;
        
        User user = new User (weight,height,age);

        assertEquals(height, user.getHeight());
    }
    @Test

    void UserTestAge() {


        int weight = 40;
        int height = 170;
        int age = 23;
        
        User user = new User(weight,height,age);

        assertEquals(age,user.getAge());
        
    }

    @Test

    void UserTestCurrentScore() {
        
        int weight = 2;
        int height = 0;
        int age = 0;
        int currentScore = 0; 

        User user = new User(weight,height,age);

        assertEquals(currentScore,user.getCurrentScore());
        
    }

    @Test

    public void testDaysSinceLastRun() {

        int weight = 2;
        int height = 0;
        int age = 0;

        TrailRunner lastrun = new TrailRunner("Run1", 10, 1, 3, 10, LocalDate.of(2025, 01, 16));
        Run run = new Run();
        run.addRunToDataBase(lastrun);    
    


        LocalDate today = LocalDate.now();
        User user = new User(weight,height,age);

        long expectedDaysSinceLastRun = ChronoUnit.DAYS.between(lastrun.getDate(), today);

        assertEquals(expectedDaysSinceLastRun, user.daysSinceLastrun());
        
    }


    @Test
    void testCalculateFitnessScore_firstRun() {
        
        Run run = new Run();
        User user = new User(100, 170, 20);
        
    
        double avgSpeed = run.calculateSpeed();
        double kilometerPace = run.calculatePace();

        int score = user.calculateFitnessScore (run.getTotalDistance(), avgSpeed, kilometerPace);

         assertEquals(0, score, "The fitness score should be greater than 0 on the first run.");
    }
    
    @Test
    void testCalculateFitnessScore_noNegativeScore() {
        Run run = new Run();
    
        User user = new User(100, 190, 25);
       

        double avgSpeed = run.calculateSpeed();
        double kilometerPace = run.calculatePace();

        int score = user.calculateFitnessScore(run.getTotalDistance(), avgSpeed, kilometerPace);

        assertEquals(0, score, "The fitness score should not go below 0.");
    }
    }

    

    




