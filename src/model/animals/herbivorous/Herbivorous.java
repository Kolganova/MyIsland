package model.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import behavior.eatable.EatablePlant;
import island.Location;
import model.IslandOccupant;
import model.animals.Animal;
import model.plants.Plant;

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
