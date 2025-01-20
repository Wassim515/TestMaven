import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import test.Run;
import test.TrailRunner;

public class RunTest {

    @Test
    public void testDatabaseContainsTrailRunId(){
        Run manager = new Run();
        TrailRunner run = new TrailRunner("Run90", 3, 2, 10, 05, LocalDate.now());

        manager.addRunToDataBase(run);

        assertTrue(manager.database.containsKey(run.getId()));
    } 



    @Test
    public void testAddDuplicateRunThrowsException() {
        Run run = new Run();
        TrailRunner runner = new TrailRunner("Run100", 10.0, 1, 0, 0, LocalDate.now());

        run.addRunToDataBase(runner);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            run.addRunToDataBase(runner);
        });

        assertEquals("ID finns redan!", exception.getMessage());
    }


    @Test
    public void testGetRunByIdSuccess() {
        Run run = new Run();
        TrailRunner runner = new TrailRunner("Run100", 10.0, 1, 0, 0, LocalDate.now());

        run.addRunToDataBase(runner); 

        TrailRunner retrievedRunner = run.getRunById(runner.getId());

        assertNotNull(retrievedRunner);
        assertEquals(runner, retrievedRunner);
    }

    @Test
    public void testGetRunByIdThrowsExceptionForNonExistentId() {
        Run run = new Run();

        assertThrows(IllegalArgumentException.class, () -> {
            run.getRunById("NonExistentID");
        });
    }

    @Test
    public void testGetTotalDistance() {
     Run manager = new Run();
     TrailRunner run1 = new TrailRunner("Runner20",5.0, 1, 0, 0, LocalDate.now());
     TrailRunner run2 = new TrailRunner("Runner15", 10.0, 1, 30, 0, LocalDate.now().minusDays(1));
    
     manager.addRunToDataBase(run1);
     manager.addRunToDataBase(run2);

     double expectedTotalDistance = 5.0 + 10.0;
    
     assertEquals(expectedTotalDistance, manager.getTotalDistance(), 0.01);
   }
   
   @Test
    public void testGetTotalAverage() {
     Run manager = new Run();
     TrailRunner run1 = new TrailRunner("Runner30",10.0, 1, 0, 0, LocalDate.now());
     TrailRunner run2 = new TrailRunner("Runner50", 15.0, 1, 30, 0, LocalDate.now().minusDays(1));
    
     manager.addRunToDataBase(run1);
     manager.addRunToDataBase(run2);

     double expectedTotalDistance = (15.0 + 10.0) / 2;
    
     assertEquals(expectedTotalDistance, manager.getTotalAverageDistance(), 0.01);
   }

    @Test
    public void testPrintTrailRunDetails(){

        Run manager = new Run();
        TrailRunner run = new TrailRunner("Run200", 5.0, 1, 20, 0, LocalDate.of(2025, 01, 17));

        manager.addRunToDataBase(run);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        manager.printRunInfo(run.getId());
    
        String output = outputStream.toString();
        assertTrue(output.contains("ID " + run.getId()));
        assertTrue(output.contains("Distans " + run.getDistance()));
        assertTrue(output.contains("Tid 1h 20min 0sec"));
        assertTrue(output.contains("Datum" + run.getDate()));
        assertTrue(output.contains("Kilomtertid " + run.calculatePace() + "min/km")); 
        assertTrue(output.contains("Medelhastighet " + run.calculateSpeed() + "km/h")); 
    } 

    @Test
    public void testDeleteTrailRunnerById() {
        Run manager = new Run();
        TrailRunner run = new TrailRunner("RUN1",5.0, 1, 0, 0, LocalDate.of(2025, 1, 14));
        manager.addRunToDataBase(run);

        assertNotNull(manager.getRunById(run.getId()));
        manager.deleteTrailRunnerById(run.getId());

        assertThrows(IllegalArgumentException.class, () -> {
            manager.getRunById(run.getId()); 
        });
    } 

    @Test
    public void testDeleteTrailRunnerByIdWhenNotFound() {
        
        Run manager = new Run();
        String nonExistingId = "non-existing-id";

        assertThrows(NoSuchElementException.class, () -> 
            manager.deleteTrailRunnerById(nonExistingId)
      );
    } 
   
   





}
