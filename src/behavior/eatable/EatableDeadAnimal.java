package behavior.eatable;

import enums.aging.DeadAnimalAging;
import model.animals.Animal;
import model.deadAnimals.DeadAnimal;

public interface EatableDeadAnimal extends Eatable {
    default void eatDeadAnimal(Animal animal, DeadAnimal deadAnimal) {
        double deadAnimalWeight = deadAnimal.getWeight();
        double animalCurrentSatiety = animal.getCurrentSatiety().get();
        double animalBellySize = animal.getBellySize().get();
        boolean willBellyFitDeadAnimal = deadAnimalWeight + animalCurrentSatiety <= animalBellySize;
        if (deadAnimal.checkAgingPhase(DeadAnimalAging.class) == DeadAnimalAging.NOT_FRESH &&
                !animal.isPoisonProtected()) {
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
