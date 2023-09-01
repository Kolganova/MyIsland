package behavior.multipliable;

import enums.aging.AnimalAging;
import enums.types.CreationType;
import model.OccupantFactory;
import model.animals.Animal;

import java.util.concurrent.ThreadLocalRandom;

public class AnimalMultiplication implements Multipliable {
    private final Animal animal;

    public AnimalMultiplication(Animal occupant) {
        this.animal = occupant;
    }

    @Override
    public boolean isAbleToMultiply() {
        int currentAmountOfOccupants = animal.getLocation().getMapWithOccupantsOnLocation().get(animal.getType()).get();
        boolean isGrownEnough = animal.checkAgingPhase(AnimalAging.class) == AnimalAging.YOUNG;
        boolean isEnoughSpaceOnLocation = currentAmountOfOccupants < animal.getMaxAmountOfOccupants();

        return (isGrownEnough && isEnoughSpaceOnLocation);
    }

    @Override
    public synchronized void multiply() {
        int amountOfChildren = ThreadLocalRandom.current().nextInt(1, 4);
        for (int i = 0; i < amountOfChildren; i++) {
            OccupantFactory.createOccupant(animal.getLocation(), animal.getType(), CreationType.NEWBORN);
        }
    }

    public static boolean isCoupleAppropriate(Animal occupant1, Animal occupant2) {
        boolean isApproved = false;
        Animal partner1 = occupant1.getId() > occupant2.getId() ? occupant1 : occupant2;
        Animal partner2 = occupant1.getId() > occupant2.getId() ? occupant2 : occupant1;
        if ((partner1.isFemale() && !(partner2.isFemale())) || (partner2.isFemale() && !(partner1.isFemale()))) {
            if (new AnimalMultiplication(partner1).isAbleToMultiply() && new AnimalMultiplication(partner2).isAbleToMultiply()) {
                isApproved = true;
            }
        }

        return isApproved;
    }
    public boolean actLikeMultipliableAnimal(Animal partner) {
        boolean result = false;
        if (AnimalMultiplication.isCoupleAppropriate(this.animal, partner)) {
            this.multiply();
            result = true;
        }

        return result;
    }

}
