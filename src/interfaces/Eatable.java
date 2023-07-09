package interfaces;

import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;

public interface Eatable {
    void eat(IslandOccupant occupant);

    void nutritionProcess(Animal animal, IslandOccupant occupant);
}
