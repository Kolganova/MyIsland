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
import java.util.concurrent.atomic.AtomicReference;

public abstract class Animal extends IslandOccupant implements Movable, Eatable {
    private int maxAmountOfMoves;
    private int satietyCostOnMove;
    private boolean isPoisonProtected;
    private final AtomicReference<Double> currentSatiety = new AtomicReference<>();
    private final AtomicReference<Double> bellySize = new AtomicReference<>();
    private final boolean isFemale;
    private int moveCounter;
    Random random = new Random();

    {
        isFemale = random.nextBoolean();
    }

    public Animal(Location location, String type) {
        super(location, type);
        setAge(random.nextInt(300));
//        satietyCostOnMove = (int) (bellySize.get() / 5);
//        вот с этим полем надо разобраться, мб устанавливать его в {} не статическом?

//         а еще нужен второй конструктор? или короче что-то для тех случаев,
//        когда животное появляется из multiply
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
    public AnimalAging checkAgingPhase() {
        for (AnimalAging temp : AnimalAging.values()) {
            if (this.getAge() >= temp.getMin() && this.getAge() <= temp.getMax())
                return temp;
        }

        return null;
    }

    public boolean isAbleToMultiply() {
        int currentAmountOfOccupants = this.getLocation().getMapWithOccupantsOnLocation().get(getType()).get();
        boolean isGrownEnough = checkAgingPhase() == AnimalAging.YOUNG;
        boolean isEnoughSpaceOnLocation = currentAmountOfOccupants < getMaxAmountOfOccupants();

        return (isGrownEnough && isEnoughSpaceOnLocation);
    }

    public static boolean isCoupleAppropriate(Animal occupant1, Animal occupant2) {
        boolean isApproved = false;
        Animal partner1 = occupant1.getId() > occupant2.getId() ? occupant1 : occupant2;
        Animal partner2 = occupant1.getId() > occupant2.getId() ? occupant2 : occupant1;
        synchronized (partner1) {
            synchronized (partner2) {
                if ((partner1.isFemale && !(partner2.isFemale())) || (partner2.isFemale && !(partner1.isFemale()))) {
                    if (partner1.isAbleToMultiply() && partner2.isAbleToMultiply()) {
                        isApproved = true;
                    }
                }
            }
        }

        return isApproved;
    }
    // а вот для вызова этого метода нужно будет проверить есть ли место для нового животного на локации
    // проверка простая - если в нашем листе значение по ключу меньше, чем maxAmount, то размножаемся

    public synchronized void multiply() {
        OccupantFactory.setLocation(this.getLocation());
        OccupantFactory.createOccupant(this.getType());
        this.getLocation().incrementAmountOfOccupantsOnLocation(this.getType());
        // можем допускать до размножения после проверки! если он подходит, то пускаем его в метод
    }

    public boolean isFemale() {
        return isFemale;
    }

    public boolean isIsPoisonProtected() {
        return isPoisonProtected;
    }

    public void setIsPoisonProtected(boolean isPoisonProtected) {
        this.isPoisonProtected = isPoisonProtected;
    }

    public int getMaxAmountOfMoves() {
        return maxAmountOfMoves;
    }

    public void setMaxAmountOfMoves(int maxAmountOfMoves) {
        this.maxAmountOfMoves = maxAmountOfMoves;
    }

    public AtomicReference<Double> getBellySize() {
        return bellySize;
    }

    public void setBellySize(Double bellySize) {
        this.bellySize.set(bellySize);
    }
}
