package interfaces;

import enums.DeadAnimalAging;
import islandOccupants.animals.Animal;
import islandOccupants.deadAnimals.DeadAnimal;

public interface EatableDeadAnimals extends Eatable {
    default void eatDeadAnimal(Animal animal, DeadAnimal deadAnimal) {
        double occupantWeight = deadAnimal.getWeight().get();
        double animalCurrentSatiety = animal.getCurrentSatiety().get();
        double animalBellySize = animal.getBellySize().get();
        boolean willBellyFitDeadAnimal = occupantWeight + animalCurrentSatiety <= animalBellySize;
        if (deadAnimal.checkAgingPhase(DeadAnimalAging.class) == DeadAnimalAging.NOT_FRESH &&
                !animal.isIsPoisonProtected()) {
            animal.die();
            deadAnimal.setWeight(occupantWeight - (animalBellySize - animalCurrentSatiety));
        } else {
            if (willBellyFitDeadAnimal) {
                deadAnimal.setWeight(occupantWeight - (animalBellySize - animalCurrentSatiety));
                animal.setCurrentSatiety(animalBellySize);
            } else {
                animal.setCurrentSatiety(animalCurrentSatiety + occupantWeight);
                deadAnimal.die();
            }
            if (deadAnimal.getWeight().get() <= 0)
                deadAnimal.die();
        }
    }
}
