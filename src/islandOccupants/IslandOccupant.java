package islandOccupants;

import enums.OccupantType;
import enums.aging.Aging;
import island.Location;

import java.util.Objects;
import java.util.Random;

public abstract class IslandOccupant {
    private int maxAmountOfOccupants;
    private Double weight;
    private final OccupantType type;
    private int age;
    private final int id;
    Location location;

    Random random = new Random();

    public IslandOccupant(Location location, OccupantType type) {
        this.location = location;
        this.type = type;
        id = this.hashCode();
    }

    public <T extends Aging> T checkAgingPhase(Class<T> enumClass) {
        for (T phase : enumClass.getEnumConstants()) {
            if (this.getAge() >= phase.getMin() && this.getAge() <= phase.getMax())
                return phase;
        }

        return null;
    }

    public int getMaxAmountOfOccupants() {
        return maxAmountOfOccupants;
    }

    public void setMaxAmountOfOccupants(int maxAmountOfEntitiesOnLocation) {
        this.maxAmountOfOccupants = maxAmountOfEntitiesOnLocation;
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

    public synchronized void die() {
        location.decrementAmountOfOccupantsOnLocation(type);
        location.getListOfOccupants().remove(this);
    }

    public OccupantType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IslandOccupant occupant = (IslandOccupant) o;
        return maxAmountOfOccupants == occupant.maxAmountOfOccupants && age == occupant.age && id == occupant.id && weight.equals(occupant.weight) && type.equals(occupant.type) && location.equals(occupant.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxAmountOfOccupants, weight, type, age, location);
    }

    public Random getRandom() {
        return random;
    }

    public void incrementAge() {
        this.age++;
    }

}