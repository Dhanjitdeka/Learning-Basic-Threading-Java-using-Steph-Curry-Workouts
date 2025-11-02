import java.util.Random;

/**
 * RecoveryDrill demonstrates the Thread approach to creating threads.
 * This drill simulates Curry's recovery routine.
 */
public class RecoveryDrill extends Thread {
    private static final Random random = new Random();
    
    public RecoveryDrill() {
        super("RecoveryDrill");
    }
    
    @Override
    public void run() {
        System.out.println("Curry is recovering... Progress: 0%");
        
        for (int progress = 25; progress <= 100; progress += 25) {
            try {
                // Random delay between 1-3 seconds
                int delay = 1000 + random.nextInt(2000);
                Thread.sleep(delay);
                
                System.out.println("Curry is recovering... Progress: " + progress + "%");
            } catch (InterruptedException e) {
                System.out.println("Recovery drill interrupted!");
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        System.out.println("✅ Recovery drill completed!");
        CurryTrainingSimulator.onDrillComplete("Recovery");
    }
}
