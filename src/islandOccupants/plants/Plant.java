package islandOccupants.plants;

import enums.types.CreationType;
import enums.types.OccupantType;
import enums.aging.PlantAging;
import interfaces.initializable.InitializablePlant;
import island.Location;
import islandOccupants.IslandOccupant;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Plant extends IslandOccupant implements InitializablePlant {
    private int propagationFrequency;
    private boolean isPoisonous;

    protected Plant(Location location, OccupantType type, CreationType creationType) {
        super(location, type);
        switch (creationType) {
            case NEWBORN -> setAge(1);
            case START_OCCUPANT -> setAge(ThreadLocalRandom.current().nextInt(1, 40));
        }
    }

    public void actLikePlant() {
        if (this.checkAgingPhase(PlantAging.class) == PlantAging.FADING) {
            if (ThreadLocalRandom.current().nextInt(100) < 30) {
                this.die();
            }
        }
        this.incrementAge();
    }

    @Override
    public void initPlant(int maxAmountOfOccupants, boolean isPoisonous, double weight, int propagationFrequency) {
        setMaxAmountOfOccupants(maxAmountOfOccupants);
        setIsPoisonous(isPoisonous);
        setWeight(weight);
        setPropagationFrequency(propagationFrequency);
    }

    private void setPropagationFrequency(int propagationFrequency) {
        this.propagationFrequency = propagationFrequency;
    }

    public boolean isIsPoisonous() {
        return isPoisonous;
    }

    public void setIsPoisonous(boolean isPoisonous) {
        this.isPoisonous = isPoisonous;
    }

    public int getPropagationFrequency() {
        return propagationFrequency;
    }
}
