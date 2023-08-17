package islandOccupants.deadAnimals;

import enums.types.OccupantType;
import enums.aging.DeadAnimalAging;
import interfaces.initializable.InitializableDeadAnimal;
import island.Location;
import islandOccupants.IslandOccupant;

import java.util.concurrent.ThreadLocalRandom;

public class DeadAnimal extends IslandOccupant implements InitializableDeadAnimal {

    public DeadAnimal(Location location, OccupantType type) {
        super(location, type);
        initDeadAnimal(1, 100);
        location.addOccupantInLocation(this);
    }

    public void actLikeDeadAnimal() {
        if (this.checkAgingPhase(DeadAnimalAging.class) == DeadAnimalAging.NOT_FRESH &&
                ThreadLocalRandom.current().nextInt(100) < 33)
            this.die();
        this.incrementAge();
    }

    @Override
    public void initDeadAnimal(int age, int maxAmountOfOccupants) {
        setAge(age);
        setMaxAmountOfOccupants(maxAmountOfOccupants);
    }
}
