package islandOccupants;

import island.Location;
import islandOccupants.animals.herbivorous.*;
import islandOccupants.animals.omnivores.Boar;
import islandOccupants.animals.omnivores.Caterpillar;
import islandOccupants.animals.preadators.*;
import islandOccupants.plants.*;

public class OccupantFactory {

    private static Location location;

    public static IslandOccupant createOccupant(String type) {
        switch (type) {
            case "wolf" -> {
                return new Wolf(location, type);
            }
            case "boa" -> {
                return new Boa(location, type);
            }
            case "fox" -> {
                return new Fox(location, type);
            }
            case "bear" -> {
                return new Bear(location, type);
            }
            case "eagle" -> {
                return new Eagle(location, type);
            }
            case "horse" -> {
                return new Horse(location, type);
            }
            case "deer" -> {
                return new Deer(location, type);
            }
            case "rabbit" -> {
                return new Rabbit(location, type);
            }
            case "mouse" -> {
                return new Mouse(location, type);
            }
            case "goat" -> {
                return new Goat(location, type);
            }
            case "sheep" -> {
                return new Sheep(location, type);
            }
            case "boar" -> {
                return new Boar(location, type);
            }
            case "buffalo" -> {
                return new Buffalo(location, type);
            }
            case "duck" -> {
                return new Duck(location, type);
            }
            case "caterpillar" -> {
                return new Caterpillar(location, type);
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

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(Location location) {
        OccupantFactory.location = location;
    }

}
