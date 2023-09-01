package behavior.eatable;

import model.animals.Animal;

public interface EatableAnimal extends Eatable {

    boolean eatAnimal(Animal victim);
}
