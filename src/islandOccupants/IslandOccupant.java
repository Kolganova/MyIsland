package islandOccupants;

import island.Location;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class IslandOccupant {
    Location location;
    private static int maxAmountOfOccupantsOnLocation;
    private static AtomicInteger currentAmountOfOccupantsOnLocation;
    private int age;
    private int id;
    private AtomicInteger weight;

    public IslandOccupant(Location location) {
        this.location = location;
        location.addOccupantInLocation(this);
    }

    public abstract Object checkAgingPhase(int age);
    // оставить object или все таки всем enum сделать свой класс родитель?
    // у enum'ов они бывают?


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
        setCurrentAmountOfOccupantsOnLocation(currentAmountOfOccupantsOnLocation.getAndDecrement());
        location.getListOfOccupants().remove(this);
    }

}
