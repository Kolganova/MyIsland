package model;

import enums.types.OccupantType;
import enums.aging.Aging;
import island.Location;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class IslandOccupant {
    private int maxAmountOfOccupants;
    private Double weight;
    private final OccupantType type;
    private int age;
    private final int id;
    private final Location location;

    protected IslandOccupant(Location location, OccupantType type) {
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

    public synchronized void die() {
        location.decrementAmountOfOccupantsOnLocation(type);
        location.getListOfOccupants().remove(this);
    }

    public void incrementAge() {
        this.age++;
    }

}