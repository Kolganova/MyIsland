package islandOccupants;

import enums.CreationType;
import enums.OccupantType;
import island.Location;
import islandOccupants.animals.herbivorous.*;
import islandOccupants.animals.omnivores.*;
import islandOccupants.animals.preadators.*;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.*;

public class OccupantFactory {

    public static IslandOccupant createOccupant(Location location, OccupantType type, CreationType creationType) {
        IslandOccupant toReturn;
        switch (type) {
            case WOLF -> toReturn = new Wolf(location, type, creationType);
            case BOA -> toReturn = new Boa(location, type, creationType);
            case FOX -> toReturn = new Fox(location, type, creationType);
            case BEAR -> toReturn = new Bear(location, type, creationType);
            case EAGLE -> toReturn = new Eagle(location, type, creationType);
            case HORSE -> toReturn = new Horse(location, type, creationType);
            case DEER -> toReturn = new Deer(location, type, creationType);
            case RABBIT -> toReturn = new Rabbit(location, type, creationType);
            case MOUSE -> toReturn = new Mouse(location, type, creationType);
            case GOAT -> toReturn = new Goat(location, type, creationType);
            case SHEEP -> toReturn = new Sheep(location, type, creationType);
            case BOAR -> toReturn = new Boar(location, type, creationType);
            case BUFFALO -> toReturn = new Buffalo(location, type, creationType);
            case DUCK -> toReturn = new Duck(location, type, creationType);
            case CATERPILLAR -> toReturn = new Caterpillar(location, type, creationType);
            case FLOWER -> toReturn = new Flower(location, type, creationType);
            case POISON_FLOWER -> toReturn = new PoisonFlower(location, type, creationType);
            case BUSH -> toReturn = new Bush(location, type, creationType);
            case GRASS -> toReturn = new Grass(location, type, creationType);
            case DEAD_ANIMAL -> toReturn = new DeadAnimal(location, type);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        return toReturn;
    }

}
