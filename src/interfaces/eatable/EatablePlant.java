package interfaces.eatable;

import islandOccupants.animals.Animal;
import islandOccupants.plants.Plant;

public interface EatablePlant {

    default void eatPlant(Animal animal, Plant plant) {
        if (!plant.isPoisonous()) {
            animal.nutritionProcess(plant);
        } else if (animal.isPoisonProtected()) {
            animal.nutritionProcess(plant);
        } else {
            animal.die();
            plant.die();
        }
    }
}
