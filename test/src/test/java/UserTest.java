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

        TrailRunner lastrun = new TrailRunner("Run1", 10, 1, 3, 10, LocalDate.of(2025, 01, 16));
        Run run = new Run();
        run.addRunToDataBase(lastrun);    
    


        LocalDate today = LocalDate.now();
        User user = new User(70,170,20);

        long expectedDaysSinceLastRun = ChronoUnit.DAYS.between(lastrun.getDate(), today);

        assertEquals(expectedDaysSinceLastRun, user.daysSinceLastrun());
        
    }

    @Test
    public void testCalculateFitnessScoreValidRun() {
        // Skapa en löpare med specifika värden
        TrailRunner runner = new TrailRunner("Run50", 10.0, 2, 0, 0, LocalDate.now().minusDays(3));
        Run run = new Run();
        User user = new User(2, 1, 4); 

        // Sätt initialt fitness score
        double currentScore = 20.0;
        user.setCurrentScore(currentScore);

        // Lägg till löprundan i databasen
        run.addRunToDataBase(runner);

        // Förväntad beräkning
        double expectedScore = currentScore + (runner.getDistance() + (runner.calculateSpeed() / runner.calculatePace())) - (3 / 2.0);

        // Kör metoden
        double actualScore = user.calculateFitnessScore(run, runner);

        // Kontrollera att beräkningen är korrekt
        assertEquals(expectedScore, actualScore, 0.01);
    }

    


}

    

    




