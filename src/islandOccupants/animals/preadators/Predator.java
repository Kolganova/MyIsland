package islandOccupants.animals.preadators;

import enums.CreationType;
import interfaces.EatableAnimals;
import interfaces.EatableDeadAnimals;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;

public abstract class Predator extends Animal implements EatableAnimals, EatableDeadAnimals {

    public Predator(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public synchronized boolean eat(IslandOccupant occupant) {

        // и в конце каждого варианта сделать что он поел
        // мб переименовать boolean. смысл в том что бы он хотя бы попробовал поесть
        // т.е. если хищнику попадется растение, то ему нужно попробовать еще раз
        return false;
    }

}
