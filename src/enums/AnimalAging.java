package enums;

public enum AnimalAging {
    BABY(1, 19),
    KID(20, 49),
    YOUNG(50, 109),
    ADULT(110, 249),
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
