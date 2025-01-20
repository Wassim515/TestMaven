package test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Run run = new Run();

        TrailRunner runner = new TrailRunner("20", 2, 3, 0, 0, null);
        TrailRunner runner1 = new TrailRunner("21", 2, 3, 0, 0, null);

        run.addRunToDataBase(runner);
        run.addRunToDataBase(runner1);
        

        System.out.println(run.database.size());
    }
}