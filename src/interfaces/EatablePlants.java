package interfaces;

import islandOccupants.animals.Animal;
import islandOccupants.plants.Plant;

public interface EatablePlants extends Eatable {

    default void eatPlant(Animal animal, Plant plant) {
        double plantWeight = plant.getWeight().get();
        double currentSatiety = animal.getCurrentSatiety().get();
        double bellySize = animal.getBellySize().get();
        boolean willBellyFitPlant = plantWeight + currentSatiety <= bellySize;
        if (willBellyFitPlant) {
            animal.setCurrentSatiety(currentSatiety + plantWeight);
        } else {
            animal.setCurrentSatiety(bellySize);
        }
        plant.die();
    }
}
