import java.util.Random;

/**
 * CardioDrill demonstrates the Runnable approach to creating threads.
 * This drill simulates Curry's cardio workout.
 */
public class CardioDrill extends TrainingDrill implements Runnable {
    private static final Random random = new Random();
    
    public CardioDrill() {
        super("Cardio");
    }
    
    @Override
    public void run() {
        execute();
    }
    
    @Override
    public void execute() {
        System.out.println("Curry is doing cardio... Progress: 0%");
        
        for (int progress = 25; progress <= 100; progress += 25) {
            try {
                // Random delay between 1-3 seconds
                int delay = 1000 + random.nextInt(2000);
                Thread.sleep(delay);
                
                System.out.println("Curry is doing cardio... Progress: " + progress + "%");
            } catch (InterruptedException e) {
                System.out.println("Cardio drill interrupted!");
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        System.out.println("✅ Cardio drill completed!");
        CurryTrainingSimulator.onDrillComplete("Cardio");
    }
}
