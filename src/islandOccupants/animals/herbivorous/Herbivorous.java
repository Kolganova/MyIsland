package islandOccupants.animals.herbivorous;

import island.Location;
import islandOccupants.animals.Animal;

public abstract class Herbivorous extends Animal {

    public Herbivorous(Location location, String type) {
        super(location, type);
    }

    @Override
    public void move() {
        // разве он не общий у всех животных?
    }

}
