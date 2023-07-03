package islandOccupants.animals.preadators;

import enums.AnimalAging;
import island.Island.Location;


public class Fox extends Predator {
    private int id;

    public Fox(Location location) {
        super(location);
    }

    @Override
    public void checkPhase(int age) {
        if (age < 10)
            setAgingPhase(AnimalAging.BABY);
        else if (age < 30)
            setAgingPhase(AnimalAging.KID);
        else if (age < 60)
            setAgingPhase(AnimalAging.ADULT);
        else if (age < 100)
            setAgingPhase(AnimalAging.OLD);
        else
            this.die();
    }

}
