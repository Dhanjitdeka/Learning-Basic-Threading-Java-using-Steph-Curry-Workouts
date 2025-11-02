/**
 * Abstract base class for training drills.
 * Defines the common structure for all drills in Curry's training routine.
 */
public abstract class TrainingDrill {
    protected String drillName;
    
    public TrainingDrill(String drillName) {
        this.drillName = drillName;
    }
    
    public String getDrillName() {
        return drillName;
    }
    
    /**
     * Abstract method that each drill must implement.
     * This will contain the drill's execution logic.
     */
    public abstract void execute();
}
