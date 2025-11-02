import java.util.concurrent.atomic.AtomicInteger;

/**
 * Main class that coordinates Curry's training session.
 * Demonstrates both Thread and Runnable approaches to thread creation.
 * Tracks 3-point accuracy improvement as drills complete.
 */
public class CurryTrainingSimulator {
    // Thread-safe accuracy counter
    private static final AtomicInteger threePointAccuracy = new AtomicInteger(60);
    private static final int ACCURACY_BOOST_PER_DRILL = 2;
    
    public static void main(String[] args) {
        System.out.println("🏀 Starting Curry's Training Session...\n");
        System.out.println("Initial 3-Point Accuracy: " + threePointAccuracy.get() + "%\n");
        
        // Demonstrating Runnable approach
        Thread shootingThread = new Thread(new ShootingDrill());
        Thread cardioThread = new Thread(new CardioDrill());
        
        // Demonstrating Thread approach
        DribblingDrill dribblingThread = new DribblingDrill();
        RecoveryDrill recoveryThread = new RecoveryDrill();
        
        // Start all threads
        System.out.println("Starting all drills concurrently...\n");
        shootingThread.start();
        dribblingThread.start();
        cardioThread.start();
        recoveryThread.start();
        
        // Wait for all threads to complete
        try {
            shootingThread.join();
            dribblingThread.join();
            cardioThread.join();
            recoveryThread.join();
        } catch (InterruptedException e) {
            System.err.println("Training session interrupted!");
            Thread.currentThread().interrupt();
        }
        
        // Display final results
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎯 Training Session Complete!");
        System.out.println("Final 3-Point Accuracy: " + threePointAccuracy.get() + "%");
        System.out.println("Total Improvement: +" + (threePointAccuracy.get() - 60) + "%");
        System.out.println("=".repeat(50));
    }
    
    /**
     * Called when a drill completes.
     * Updates the 3-point accuracy in a thread-safe manner.
     * 
     * @param drillName Name of the completed drill
     */
    public static void onDrillComplete(String drillName) {
        int newAccuracy = threePointAccuracy.addAndGet(ACCURACY_BOOST_PER_DRILL);
        System.out.println("💪 " + drillName + " drill completed! 3-Point Accuracy: +" + 
                          ACCURACY_BOOST_PER_DRILL + "% → " + newAccuracy + "%");
    }
}
