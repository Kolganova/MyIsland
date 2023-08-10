package islandOccupants.deadAnimals;

import enums.OccupantType;
import enums.aging.DeadAnimalAging;
import island.Location;
import islandOccupants.IslandOccupant;

public class DeadAnimal extends IslandOccupant {

    public DeadAnimal(Location location, OccupantType type, double weight) {
        super(location, type);
        setAge(1);
        setWeight(weight);
        setMaxAmountOfOccupants(100);
        location.addOccupantInLocation(this);
    }

    public void actLikeDeadAnimal() {
        if (this.checkAgingPhase(DeadAnimalAging.class) == DeadAnimalAging.NOT_FRESH &&
                getRandom().nextInt(100) <= 33)
            this.die();
        this.incrementAge();
    }

}
