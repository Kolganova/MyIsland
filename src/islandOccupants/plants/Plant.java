package islandOccupants.plants;

import enums.types.CreationType;
import enums.types.OccupantType;
import enums.aging.PlantAging;
import interfaces.initializable.InitializablePlant;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;

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

    private boolean isAbleToMultiply() {
        boolean isAble = false;
        int currentAmountOfPlants = this.getLocation().getMapWithOccupantsOnLocation().get(this.getType()).get();

        if (currentAmountOfPlants < getMaxAmountOfOccupants() && checkAgingPhase(PlantAging.class) == PlantAging.GROWN) {
            isAble = true;
        }

        return isAble;
    }

    private synchronized void multiply() {
        if (this.isAbleToMultiply()) {
            for (int i = 0; i < propagationFrequency; i++) {
                OccupantFactory.createOccupant(this.getLocation(), this.getType(), CreationType.NEWBORN);
            }
        }
    }

    public void actLikePlant() {
        if (this.isAbleToMultiply() && ThreadLocalRandom.current().nextInt(100) < 50)
            this.multiply();
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
}
