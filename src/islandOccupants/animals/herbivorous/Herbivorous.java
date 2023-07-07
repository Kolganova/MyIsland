package islandOccupants.animals.herbivorous;

import enums.AnimalCreationType;
import island.Location;
import islandOccupants.animals.Animal;

public abstract class Herbivorous extends Animal {

    public Herbivorous(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public void move() {
        // разве он не общий у всех животных?
    }

}
