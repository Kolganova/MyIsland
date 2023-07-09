package islandOccupants.animals.herbivorous;

import enums.CreationType;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.plants.Plant;

public abstract class Herbivorous extends Animal {

    public Herbivorous(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public void eat(IslandOccupant occupant) {
        if (occupant instanceof Plant) {
            if (this.isIsPoisonProtected()) {
                nutritionProcess(this, occupant);
            } else {
                this.die();
                occupant.die();
            }
        }

    }

}
