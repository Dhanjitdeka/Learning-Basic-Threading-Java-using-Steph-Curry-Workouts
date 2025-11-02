# Curry's Training Drill Simulator

A Java project demonstrating thread creation using both **Thread** and **Runnable** approaches. This simulator runs Stephen Curry's daily training routine with multiple drills (shooting, dribbling, cardio, recovery) executing concurrently as separate threads.

## 🎯 Learning Objectives

- Understanding the difference between extending `Thread` vs implementing `Runnable`
- Creating and managing multiple threads concurrently
- Thread-safe operations using `AtomicInteger`
- Synchronizing thread execution with `join()`

## 🏀 Features

- **Multiple Drill Types**: Shooting, Dribbling, Cardio, and Recovery drills
- **Concurrent Execution**: All drills run simultaneously as separate threads
- **Progress Tracking**: Each drill displays progress updates (0%, 25%, 50%, 75%, 100%)
- **Thread-Safe Accuracy**: Uses `AtomicInteger` for thread-safe 3-point accuracy updates
- **Accuracy Improvement**: Each completed drill increases Curry's 3-point accuracy by 2%

## 📁 Project Structure

```
├── TrainingDrill.java              # Abstract base class for drills
├── ShootingDrill.java              # Implements Runnable (demonstrates Runnable approach)
├── CardioDrill.java                # Implements Runnable
├── DribblingDrill.java             # Extends Thread (demonstrates Thread approach)
├── RecoveryDrill.java              # Extends Thread
└── CurryTrainingSimulator.java     # Main class coordinating all drills
```

## 🔧 Thread vs Runnable Demonstration

### Runnable Approach
- `ShootingDrill` and `CardioDrill` implement `Runnable`
- Thread created by: `new Thread(new ShootingDrill())`
- **Advantage**: More flexible - class can extend another class

### Thread Approach
- `DribblingDrill` and `RecoveryDrill` extend `Thread`
- Thread created by: `new DribblingDrill()`
- **Advantage**: Simpler when you only need thread functionality

## 🚀 How to Run

1. **Compile the Java files:**
   ```bash
   javac *.java
   ```

2. **Run the simulator:**
   ```bash
   java CurryTrainingSimulator
   ```

## 📊 Example Output

```
🏀 Starting Curry's Training Session...

Initial 3-Point Accuracy: 60%

Starting all drills concurrently...

Curry is shooting... Progress: 0%
Curry is dribbling... Progress: 0%
Curry is doing cardio... Progress: 0%
Curry is recovering... Progress: 0%
Curry is shooting... Progress: 25%
...
✅ Cardio drill completed!
💪 Cardio drill completed! 3-Point Accuracy: +2% → 62%
...

==================================================
🎯 Training Session Complete!
Final 3-Point Accuracy: 68%
Total Improvement: +8%
==================================================
```

## 🧵 Thread Safety

The project uses `AtomicInteger` to ensure thread-safe updates to Curry's 3-point accuracy counter. This prevents race conditions when multiple threads attempt to update the accuracy simultaneously.

## 📝 License

This project is for educational purposes.
