package enums.aging;

import enums.aging.Aging;

public enum DeadAnimalAging implements Aging {
    FRESH(1, 19),
    NOT_FRESH(20, 50);
    private final int min;
    private final int max;

    DeadAnimalAging(int min, int max) {
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
