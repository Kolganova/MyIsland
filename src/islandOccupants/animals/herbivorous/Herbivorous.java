package islandOccupants.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import interfaces.eatable.EatablePlant;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.plants.Plant;

public abstract class Herbivorous extends Animal implements EatablePlant {

    protected Herbivorous(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public synchronized boolean eat(IslandOccupant occupant) {
        if (occupant instanceof Plant) {
            eatPlant(this, (Plant) occupant);
            return true;
        }

        return false;
    }

}
