package islandOccupants;

import island.Island;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class IslandOccupant {
    Island.Location location;
    private static int maxAmountOfOccupantsOnLocation;
    private static AtomicInteger currentAmountOfOccupantsOnLocation;
    private int age;
    private int id;
    private AtomicInteger weight;

    public IslandOccupant(Island.Location location) {
        this.location = location;
        location.addOccupantInLocation(this);
    }

    public abstract void checkPhase(int age);


    public AtomicInteger getCurrentAmountOfOccupantsOnLocation() {
        return currentAmountOfOccupantsOnLocation;
    }

    public void setCurrentAmountOfOccupantsOnLocation(int currentAmountOfEntitiesOnLocation) {
        IslandOccupant.currentAmountOfOccupantsOnLocation.getAndSet(currentAmountOfEntitiesOnLocation);
    }

    public static int getMaxAmountOfOccupantsOnLocation() {
        return maxAmountOfOccupantsOnLocation;
    }

    public static void setMaxAmountOfOccupantsOnLocation(int maxAmountOfEntitiesOnLocation) {
        IslandOccupant.maxAmountOfOccupantsOnLocation = maxAmountOfEntitiesOnLocation;
    }

    public Island.Location getLocation() {
        return location;
    }

    public void die(Island.Location location) {
        setCurrentAmountOfOccupantsOnLocation(currentAmountOfOccupantsOnLocation.getAndDecrement());
        location.getListOfOccupants().remove(this);
    }

}
