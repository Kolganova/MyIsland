package enums;

public enum AnimalAging {
    KID(1, 49),
    YOUNG(50, 249),
    OLD(250, 320);
    private final int min;
    private final int max;

    AnimalAging(int min, int max) {
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
