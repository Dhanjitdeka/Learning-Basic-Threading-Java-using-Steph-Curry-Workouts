import java.util.Random;

/**
 * ShootingDrill demonstrates the Runnable approach to creating threads.
 * This drill simulates Curry's shooting practice.
 */
public class ShootingDrill extends TrainingDrill implements Runnable {
    private static final Random random = new Random();
    
    public ShootingDrill() {
        super("Shooting");
    }
    
    @Override
    public void run() {
        execute();
    }
    
    @Override
    public void execute() {
        System.out.println("Curry is shooting... Progress: 0%");
        
        for (int progress = 25; progress <= 100; progress += 25) {
            try {
                // Random delay between 1-3 seconds
                int delay = 1000 + random.nextInt(2000);
                Thread.sleep(delay);
                
                System.out.println("Curry is shooting... Progress: " + progress + "%");
            } catch (InterruptedException e) {
                System.out.println("Shooting drill interrupted!");
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        System.out.println("✅ Shooting drill completed!");
        CurryTrainingSimulator.onDrillComplete("Shooting");
    }
}
