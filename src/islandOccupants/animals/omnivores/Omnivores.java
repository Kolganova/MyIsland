package islandOccupants.animals.omnivores;

import island.Location;
import islandOccupants.animals.Animal;

public abstract class Omnivores extends Animal {

    public Omnivores(Location location, String type) {
        super(location, type);
    }

    @Override
    public void move() {

    }
}
