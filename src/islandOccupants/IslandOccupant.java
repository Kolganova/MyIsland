package islandOccupants;

import island.Location;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class IslandOccupant {
    Location location;
    private static int maxAmountOfOccupantsOnLocation;
    private int age;
    private final int id;
    private AtomicInteger weight;
    private final String type;

    public IslandOccupant(Location location, String type) {
        this.location = location;
        this.type = type;
        location.addOccupantInLocation(this);
        id = this.hashCode();
    }

    public abstract Object checkAgingPhase(int age);

    public static int getMaxAmountOfOccupantsOnLocation() {
        return maxAmountOfOccupantsOnLocation;
    }

    public static void setMaxAmountOfOccupantsOnLocation(int maxAmountOfEntitiesOnLocation) {
        IslandOccupant.maxAmountOfOccupantsOnLocation = maxAmountOfEntitiesOnLocation;
    }

    public Location getLocation() {
        return location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void die(Location location) {
        this.getLocation().decrementAmountOfOccupantsOnLocation(this.type);
        location.getListOfOccupants().remove(this);
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
