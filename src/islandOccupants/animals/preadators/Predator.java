package islandOccupants.animals.preadators;

import enums.CreationType;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.animals.herbivorous.Herbivorous;
import islandOccupants.animals.omnivores.Omnivores;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

public abstract class Predator extends Animal {

    public Predator(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public synchronized void eat(IslandOccupant occupant) {
        if (!(occupant instanceof Plant)) {
            if (occupant instanceof DeadAnimal) {

            } else if (occupant instanceof Predator) {

            } else if (occupant instanceof Herbivorous) {

            } else if (occupant instanceof Omnivores) {

            }
        }
        // и в конце каждого варианта сделать что он поел
        // мб переименовать boolean. смысл в том что бы он хотя бы попробовал поесть
        // т.е. если хищнику попадется растение, то ему нужно попробовать еще раз
    }

}
