package enums.aging;

public enum AnimalAging implements Aging {
    KID(1, 49),
    YOUNG(50, 249),
    OLD(250, 320);
    private final int min;
    private final int max;

    AnimalAging(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }

}
