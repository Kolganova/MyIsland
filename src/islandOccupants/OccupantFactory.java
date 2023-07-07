package islandOccupants;

import enums.AnimalCreationType;
import island.Location;
import islandOccupants.animals.herbivorous.*;
import islandOccupants.animals.omnivores.*;
import islandOccupants.animals.preadators.*;
import islandOccupants.plants.*;

public class OccupantFactory {
    private static AnimalCreationType creationType;

    public static IslandOccupant createOccupant(Location location, String type) {
        switch (type) {
            case "wolf" -> {
                return new Wolf(location, type, creationType);
            }
            case "boa" -> {
                return new Boa(location, type, creationType);
            }
            case "fox" -> {
                return new Fox(location, type, creationType);
            }
            case "bear" -> {
                return new Bear(location, type, creationType);
            }
            case "eagle" -> {
                return new Eagle(location, type, creationType);
            }
            case "horse" -> {
                return new Horse(location, type, creationType);
            }
            case "deer" -> {
                return new Deer(location, type, creationType);
            }
            case "rabbit" -> {
                return new Rabbit(location, type, creationType);
            }
            case "mouse" -> {
                return new Mouse(location, type, creationType);
            }
            case "goat" -> {
                return new Goat(location, type, creationType);
            }
            case "sheep" -> {
                return new Sheep(location, type, creationType);
            }
            case "boar" -> {
                return new Boar(location, type, creationType);
            }
            case "buffalo" -> {
                return new Buffalo(location, type, creationType);
            }
            case "duck" -> {
                return new Duck(location, type, creationType);
            }
            case "caterpillar" -> {
                return new Caterpillar(location, type, creationType);
            }
            case "flower" -> {
                return new Flower(location, type);
            }
            case "poisonFlower" -> {
                return new PoisonFlower(location, type);
            }
            case "bush" -> {
                return new Bush(location, type);
            }
            case "grass" -> {
                return new Grass(location, type);
            }
        }
        return null;
    }

    public static AnimalCreationType getCreationType() {
        return creationType;
    }

    public static void setCreationType(AnimalCreationType creationType) {
        OccupantFactory.creationType = creationType;
    }
}
