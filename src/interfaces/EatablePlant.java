package interfaces;

import islandOccupants.animals.Animal;
import islandOccupants.plants.Plant;

public interface EatablePlant {

    default void eatPlant(Animal animal, Plant plant) {
        if (!plant.isIsPoisonous()) {
            animal.nutritionProcess(plant);
        } else if (animal.isIsPoisonProtected() && plant.isIsPoisonous()) {
            animal.nutritionProcess(plant);
        } else {
            animal.die();
            plant.die();
        }
    }
}
