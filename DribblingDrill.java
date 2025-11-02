import java.util.Random;

/**
 * DribblingDrill demonstrates the Thread approach to creating threads.
 * This drill simulates Curry's dribbling practice.
 */
public class DribblingDrill extends Thread {
    private static final Random random = new Random();
    
    public DribblingDrill() {
        super("DribblingDrill");
    }
    
    @Override
    public void run() {
        System.out.println("Curry is dribbling... Progress: 0%");
        
        for (int progress = 25; progress <= 100; progress += 25) {
            try {
                // Random delay between 1-3 seconds
                int delay = 1000 + random.nextInt(2000);
                Thread.sleep(delay);
                
                System.out.println("Curry is dribbling... Progress: " + progress + "%");
            } catch (InterruptedException e) {
                System.out.println("Dribbling drill interrupted!");
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        System.out.println("✅ Dribbling drill completed!");
        CurryTrainingSimulator.onDrillComplete("Dribbling");
    }
}
