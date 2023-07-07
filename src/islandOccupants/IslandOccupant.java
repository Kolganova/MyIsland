package islandOccupants;

import enums.Aging;
import island.Location;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public abstract class IslandOccupant {
    private int maxAmountOfOccupants;
    private final AtomicReference<Double> weight = new AtomicReference<>();
    private final String type;
    private int age;
    private final int id;
    Location location;

    public IslandOccupant(Location location, String type) {
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

    public void die(Location location) {
        this.getLocation().decrementAmountOfOccupantsOnLocation(type);
        location.getListOfOccupants().remove(this);
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public AtomicReference<Double> getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight.set(weight);
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
}
