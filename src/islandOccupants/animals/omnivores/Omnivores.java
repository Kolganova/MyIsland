package islandOccupants.animals.omnivores;

import enums.CreationType;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;

public abstract class Omnivores extends Animal {

    public Omnivores(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public void eat(IslandOccupant occupant) {

    }

}
