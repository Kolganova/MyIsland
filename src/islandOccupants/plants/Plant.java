package islandOccupants.plants;

import enums.PlantAging;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;

public abstract class Plant extends IslandOccupant {
    private int propagationFrequency;
    private boolean isPoisonous;

    public Plant(Location location, String type) {
        super(location, type);
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
                IslandOccupant currentOccupant = OccupantFactory.createOccupant(this.getLocation(), this.getType());
                this.getLocation().addOccupantInLocation(currentOccupant);
            }
        }
    }
    /* сделать многопоточным?
        должен вызываться в пуле потоков? для того что бы быстро обрабатывать все
        растения на локации
        в пуле "хода" можно просто понимать через instanceof что это за класс и исходя из этого
        выполнять определенные методы, которые этот класс должен делать в каждом ходу
        т.е. растение только распространяется и "стареет" (и мб меняет enums.PlantAging)
         */

    public int getPropagationFrequency() {
        return propagationFrequency;
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
