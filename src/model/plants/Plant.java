package model.plants;

import enums.types.CreationType;
import enums.types.OccupantType;
import enums.aging.PlantAging;
import behavior.initializable.InitializablePlant;
import island.Location;
import model.IslandOccupant;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public abstract class Plant extends IslandOccupant implements InitializablePlant {
    private int propagationFrequency;
    private boolean isPoisonous;

    protected Plant(Location location, OccupantType type, CreationType creationType) {
        super(location, type);
        switch (creationType) {
            case NEWBORN -> setAge(1);
            case START_OCCUPANT -> setAge(ThreadLocalRandom.current().nextInt(1, 40));
        }
    }

    public void actLikePlant() {
        if (this.checkAgingPhase(PlantAging.class) == PlantAging.FADING) {
            if (ThreadLocalRandom.current().nextInt(100) < 30) {
                this.die();
            }
        }
        this.incrementAge();
    }

    @Override
    public void initPlant(int maxAmountOfOccupants, boolean isPoisonous, double weight, int propagationFrequency) {
        setMaxAmountOfOccupants(maxAmountOfOccupants);
        setPoisonous(isPoisonous);
        setWeight(weight);
        setPropagationFrequency(propagationFrequency);
    }

}
