package islandOccupants;

import island.Island;
import islandOccupants.animals.herbivorous.*;
import islandOccupants.animals.omnivores.Caterpillar;
import islandOccupants.animals.preadators.*;
import islandOccupants.plants.*;

public class OccupantFactory {

    private static Island.Location location;

    public static IslandOccupant createOccupant(String type) {
        switch (type) {
            case "wolf" -> {
                return new Wolf(location);
            }
            case "boa" -> {
                return new Boa(location);
            }
            case "fox" -> {
                return new Fox(location);
            }
            case "bear" -> {
                return new Bear(location);
            }
            case "eagle" -> {
                return new Eagle(location);
            }
            case "horse" -> {
                return new Horse(location);
            }
            case "deer" -> {
                return new Deer(location);
            }
            case "rabbit" -> {
                return new Rabbit(location);
            }
            case "mouse" -> {
                return new Mouse(location);
            }
            case "goat" -> {
                return new Goat(location);
            }
            case "sheep" -> {
                return new Sheep(location);
            }
            case "boar" -> {
                return new Boar(location);
            }
            case "buffalo" -> {
                return new Buffalo(location);
            }
            case "duck" -> {
                new Duck(location);
            }
            case "caterpillar" -> {
                return new Caterpillar(location);
            }
            case "flower" -> {
                return new Flower(location);
            }
            case "poisonFlower" -> {
                return new PoisonFlower(location);
            }
            case "bush" -> {
                return new Bush(location);
            }
            case "grass" -> {
                return new Grass(location);
            }
        }
        return null;
    }

    public static Island.Location getLocation() {
        return location;
    }

    public static void setLocation(Island.Location location) {
        OccupantFactory.location = location;
    }
}
