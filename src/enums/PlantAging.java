package enums;

public enum PlantAging {
    NEWBORN(0, 9),
    GROWN(10, 39),
    FADING(40, 50);

    private final int min;
    private final int max;

    PlantAging(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
