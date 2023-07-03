package islandOccupants;

import island.Island;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class IslandOccupant {
    Island.Location location;
    private static int maxAmountOfEntitiesOnLocation;
    private static AtomicInteger currentAmountOfEntitiesOnLocation;
    private int age;
    private int id;
    private AtomicInteger weight;

    public IslandOccupant(Island.Location location) {
        this.location = location;
        location.addOccupantInLocation(this);
    }

    public abstract void checkPhase(int age);


    public static AtomicInteger getCurrentAmountOfEntitiesOnLocation() {
        return currentAmountOfEntitiesOnLocation;
    }

    public static void setCurrentAmountOfEntitiesOnLocation(int currentAmountOfEntitiesOnLocation) {
        IslandOccupant.currentAmountOfEntitiesOnLocation.getAndSet(currentAmountOfEntitiesOnLocation);
        // вроде тут логика правильная...
    }

    public Island.Location getLocation() {
        return location;
    }

}
