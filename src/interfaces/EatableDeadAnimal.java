package interfaces;

import enums.DeadAnimalAging;
import islandOccupants.animals.Animal;
import islandOccupants.deadAnimals.DeadAnimal;

public interface EatableDeadAnimal extends Eatable {
    default void eatDeadAnimal(Animal animal, DeadAnimal deadAnimal) {
        double deadAnimalWeight = deadAnimal.getWeight().get();
        double animalCurrentSatiety = animal.getCurrentSatiety().get();
        double animalBellySize = animal.getBellySize().get();
        boolean willBellyFitDeadAnimal = deadAnimalWeight + animalCurrentSatiety <= animalBellySize;
        if (deadAnimal.checkAgingPhase(DeadAnimalAging.class) == DeadAnimalAging.NOT_FRESH &&
                !animal.isIsPoisonProtected()) {
            animal.die();
            deadAnimal.setWeight(deadAnimalWeight - (animalBellySize - animalCurrentSatiety));
        } else {
            if (willBellyFitDeadAnimal) {
                animal.setCurrentSatiety(animalCurrentSatiety + deadAnimalWeight);
                deadAnimal.die();
            } else {
                animal.setCurrentSatiety(animalBellySize);
                deadAnimal.setWeight(deadAnimalWeight - (animalBellySize - animalCurrentSatiety));
            }
        }

    }

}
