package behavior.multipliable;

import enums.aging.PlantAging;
import enums.types.CreationType;
import model.OccupantFactory;
import model.plants.Plant;

import java.util.concurrent.ThreadLocalRandom;

public class PlantMultiplication implements Multipliable {
    private final Plant plant;

    public PlantMultiplication(Plant plant) {
        this.plant = plant;
    }

    @Override
    public boolean isAbleToMultiply() {
        boolean isAble = false;
        int currentAmountOfPlants = plant.getLocation().getMapWithOccupantsOnLocation().get(plant.getType()).get();

        if (currentAmountOfPlants < plant.getMaxAmountOfOccupants() && plant.checkAgingPhase(PlantAging.class) == PlantAging.GROWN) {
            isAble = true;
        }

        return isAble;
    }

    @Override
    public synchronized void multiply() {
        if (new PlantMultiplication(plant).isAbleToMultiply()) {
            for (int i = 0; i < plant.getPropagationFrequency(); i++) {
                OccupantFactory.createOccupant(plant.getLocation(), plant.getType(), CreationType.NEWBORN);
            }
        }
    }
    public void actLikeMultipliablePlant() {
        if (this.isAbleToMultiply() && ThreadLocalRandom.current().nextInt(100) < 50)
            multiply();
    }

}
