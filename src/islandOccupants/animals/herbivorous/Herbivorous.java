package islandOccupants.animals.herbivorous;

import enums.CreationType;
import interfaces.EatablePlant;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.plants.Plant;

public abstract class Herbivorous extends Animal implements EatablePlant {

    public Herbivorous(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public boolean eat(IslandOccupant occupant) {
        if (occupant instanceof Plant) {
            eatPlant(this, (Plant) occupant);
            return true;
        }

        return false;
    }

}
