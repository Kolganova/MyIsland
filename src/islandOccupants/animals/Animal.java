package islandOccupants.animals;

import enums.AnimalAging;
import interfaces.*;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;
import islandOccupants.animals.herbivorous.Herbivorous;
import islandOccupants.animals.preadators.Predator;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

import java.util.Random;

public abstract class Animal extends IslandOccupant implements Movable, Eatable {
    private static int maxAmountOfMoves;
    private static int satietyCostOnMove;
    private static boolean isPoisonProtected;
    private final boolean isFemale;
    private int moveCounter;
    private int bellySize;
    Random random = new Random();

    public Animal(Location location, String type) {
        super(location, type);
        setAge(random.nextInt(300));
        isFemale = random.nextBoolean();
        satietyCostOnMove = bellySize / 5;
    }

    @Override
    public synchronized void eat(IslandOccupant occupant) {
        if (!(occupant instanceof DeadAnimal || occupant instanceof Herbivorous)) {
            if (occupant instanceof Predator) {
                // то его едят скорее всего
            } else if (occupant instanceof Plant) {
                // то он его ест
            }
        }
    }

    @Override
    public AnimalAging checkAgingPhase(int age) {
        for (AnimalAging temp : AnimalAging.values()) {
            if (age >= temp.getMin() && age <= temp.getMax())
                return temp;
        }

        return null;
    }

    public boolean isReadyToMultiply() {

        return (checkAgingPhase(this.getAge()) == AnimalAging.YOUNG);
        // проверить зрелость и мб чота еще, надо карту посмотреть
    }

    public static boolean isCoupleAppropriate(Animal occupant1, Animal occupant2) {
        boolean isApproved = false;
        Animal partner1 = occupant1.getId() > occupant2.getId() ? occupant1 : occupant2;
        Animal partner2 = occupant1.getId() > occupant2.getId() ? occupant2 : occupant1;
        synchronized (partner1) {
            synchronized (partner2) {
                if ((partner1.isFemale && !(partner2.isFemale())) || (partner2.isFemale && !(partner1.isFemale()))) {
                    if (partner1.isReadyToMultiply() && partner2.isReadyToMultiply()) {
                        isApproved = true;
                    }
                }
            }
        }

        return isApproved;
    }
    // а вот для вызова этого метода нужно будет проверить есть ли место для нового животного на локации

    public synchronized void multiply() {
        OccupantFactory.setLocation(this.getLocation());
        OccupantFactory.createOccupant(this.getType());
        this.getLocation().incrementAmountOfOccupantsOnLocation(this.getType());
        // можем допускать до размножения после проверки! если он подходит, то пускаем его в метод
    }

    public boolean isFemale() {
        return isFemale;
    }

    public static boolean isIsPoisonProtected() {
        return isPoisonProtected;
    }

    public static void setIsPoisonProtected(boolean isPoisonProtected) {
        Animal.isPoisonProtected = isPoisonProtected;
    }
}
