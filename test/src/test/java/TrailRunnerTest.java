import org.junit.jupiter.api.Test;
import test.TrailRunner;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;



public class TrailRunnerTest {

    
    @Test
    void testSaveRunInvalidId() {

       assertThrows(IllegalArgumentException.class, () -> {
             new TrailRunner(null,5.0, 1,0, 30, LocalDate.now());
        });
    }
  

    @Test
    void testSaveRunNegativeHours() {

        assertThrows(IllegalArgumentException.class, () -> {
            new TrailRunner("Run1", 5.0, -1, 0, 0, LocalDate.now());
        
        });
        
    }
    @Test
    void testSaveRunNegativeMin() {

        assertThrows(IllegalArgumentException.class, () -> {
            new TrailRunner("Run2", 5.0, 1, -50, 0, LocalDate.now());
        
        });
        
    }
    @Test
    void testSaveRunNegativeSec() {

        assertThrows(IllegalArgumentException.class, () -> {
            new TrailRunner("Run3", 5.0, 1, 0, -3, LocalDate.now());
        
        });
        
    }

    @Test
    void testSaveRunNegativeDistance() {
        
         assertThrows(IllegalArgumentException.class, () -> {
            new TrailRunner("Run1", -5.0, 1, 0, 30, LocalDate.now());
        });
    }
    
    @Test
    void testIfAllTimesIsZero() {
        
         assertThrows(IllegalArgumentException.class, () -> {
            new TrailRunner("Run10", 10, 0, 0, 0, LocalDate.now());
        });
    }
    
    @Test
    void TrailRunTestDistance() {
       
        int distance = 5;
        TrailRunner run = new TrailRunner("Run 1", distance ,3 , 2, 5, LocalDate.now());

        assertEquals(distance, run.getDistance());
      
    }

    @Test
    void RunTesthours() {
        
        int hours = 1;
        TrailRunner run = new TrailRunner("run1" , 2, hours, 50, 3, LocalDate.now());

        assertEquals(hours, run.getHours());

    }

    @Test
    void RunTestSec() {
    
        
        int sec = 5;
        
        TrailRunner run = new TrailRunner("run",5,3, 5,sec,LocalDate.now());

     
        assertEquals(sec,run.getSec());

      
    }
    
    @Test
    void RunTestmin() {  
        int min = 6;
        
        TrailRunner run = new TrailRunner("run1" , 2, 4, min, 20, LocalDate.now());

        assertEquals(min, run.getMin());


    }

    @Test
    void RunTestdate() {
    
     LocalDate date = LocalDate.now();
     TrailRunner run = new TrailRunner("run", 1, 5, 3, 0, LocalDate.now());
    
     assertEquals(date,run.getDate());

    }

    @Test
    public void testCalculateSpeed(){
        TrailRunner run = new TrailRunner("Run", 7, 1, 0, 0, LocalDate.now());

        double expectedResult = 7.0 / 1.0;

        assertEquals(expectedResult, run.calculateSpeed());
    }

    @Test 
    public void testCalculatePace(){
        TrailRunner run = new TrailRunner("Run20", 4, 0, 30, 0, LocalDate.now());

        double expectedResult = 30.0 / 4.0;

        assertEquals(expectedResult, run.calculatePace());
    }


}

 


 


