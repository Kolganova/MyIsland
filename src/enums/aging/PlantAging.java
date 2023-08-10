package enums.aging;

import enums.aging.Aging;

public enum PlantAging implements Aging {
    NEWBORN(0, 9),
    GROWN(10, 39),
    FADING(40, 50);

    private final int min;
    private final int max;

    PlantAging(int min, int max) {
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
