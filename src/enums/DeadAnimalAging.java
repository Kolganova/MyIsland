package enums;

public enum DeadAnimalAging {
    FRESH(1, 19),
    NOT_FRESH(20, 50);
    private final int min;
    private final int max;

    DeadAnimalAging(int min, int max) {
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
