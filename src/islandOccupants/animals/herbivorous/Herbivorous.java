package islandOccupants.animals.herbivorous;

import enums.CreationType;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.deadAnimals.DeadAnimal;

public abstract class Herbivorous extends Animal {

    public Herbivorous(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public synchronized void eat(IslandOccupant occupant) {
        if (!(occupant instanceof DeadAnimal || occupant instanceof Animal)) {
            this.getCurrentSatiety().getAndUpdate(value -> value + occupant.getWeight().get());
        }
    }

}
