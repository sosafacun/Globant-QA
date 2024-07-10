package entities;

public class Routine {
    private int idRoutine;
    private String routineName;
    private double duration;
    private int difficultyLevel;
    private String description;
    private boolean isActive;

    public Routine(int idRoutine, String routineName, double duration, int difficultyLevel, String description, boolean isActive) {
        this.idRoutine = idRoutine;
        this.routineName = routineName;
        this.duration = duration;
        this.difficultyLevel = difficultyLevel;
        this.description = description;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Routine() {
    }

    public int getIdRoutine() {
        return idRoutine;
    }

    public void setIdRoutine(int idRoutine) {
        this.idRoutine = idRoutine;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
