package islandOccupants.animals.omnivores;

import island.Location;
import islandOccupants.animals.Animal;

public abstract class Omnivores extends Animal {

    public Omnivores(Location location) {
        super(location);
    }

    @Override
    public void multiply(String type) {
    // каждому типу нужен свой или нет?
    }

}
