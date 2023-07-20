package islandOccupants.plants;

import enums.CreationType;
import enums.PlantAging;
import island.Island;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;

public abstract class Plant extends IslandOccupant {
    private int propagationFrequency;
    private boolean isPoisonous;

    public Plant(Location location, String type, CreationType creationType) {
        super(location, type);
        Island.incrementAmountOfPlants();
        switch (creationType) {
            case NEWBORN -> setAge(1);
            case START_OCCUPANT -> setAge(getRandom().nextInt(1, 40));
        }
    }

    public boolean isAbleToMultiply() {
        boolean isAble = false;
        int currentAmountOfPlants = this.getLocation().getMapWithOccupantsOnLocation().get(this.getType()).get();

        if (currentAmountOfPlants < getMaxAmountOfOccupants() && checkAgingPhase(PlantAging.class) == PlantAging.GROWN) {
            isAble = true;
        }

        return isAble;
    }

    public synchronized void multiply() {
        if (this.isAbleToMultiply()) {
            for (int i = 0; i < propagationFrequency; i++) {
                OccupantFactory.createOccupant(this.getLocation(), this.getType(), CreationType.NEWBORN);
            }
        }
    }

    public void actLikePlant() {
        if (this.isAbleToMultiply() && getRandom().nextInt(100) <= 50)
            this.multiply();
        if (this.checkAgingPhase(PlantAging.class) == PlantAging.FADING) {
            if (getRandom().nextInt(100) <= 30) {
                this.die();
            }
        }
        this.incrementAge();
    }

    public void setPropagationFrequency(int propagationFrequency) {
        this.propagationFrequency = propagationFrequency;
    }

    public boolean isIsPoisonous() {
        return isPoisonous;
    }

    public void setIsPoisonous(boolean isPoisonous) {
        this.isPoisonous = isPoisonous;
    }
}
