package islandOccupants.animals.omnivores;

import enums.AnimalCreationType;
import island.Location;
import islandOccupants.animals.Animal;

public abstract class Omnivores extends Animal {

    public Omnivores(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public void move() {

    }
}
