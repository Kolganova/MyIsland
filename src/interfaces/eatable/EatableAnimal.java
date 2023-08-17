package interfaces.eatable;

import islandOccupants.animals.Animal;

public interface EatableAnimal extends Eatable {

    boolean eatAnimal(Animal victim);
}
