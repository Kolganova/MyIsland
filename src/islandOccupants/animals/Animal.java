package islandOccupants.animals;

import enums.AnimalAging;
import enums.AnimalCreationType;
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
    private double satietyCostOnMove;
    private boolean isPoisonProtected;
    private final AtomicReference<Double> currentSatiety = new AtomicReference<>();
    private final AtomicReference<Double> bellySize = new AtomicReference<>();
    private boolean isFemale;
    private int moveCounter;
    Random random = new Random();

    public Animal(Location location, String type, AnimalCreationType creationType) {
        super(location, type);
        switch (creationType) {
            case NEWBORN -> setNewbornAnimal();
            case START_ANIMAL -> setStartAnimal();
        }
    }

    private void setNewbornAnimal() {
        isFemale = random.nextBoolean();
        setAge(1);
    }

    private void setStartAnimal() {
        isFemale = random.nextBoolean();
        setAge(random.nextInt(300));
    }

    private void setMovingAnimal() {

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

    public boolean isAbleToMultiply() {
        int currentAmountOfOccupants = this.getLocation().getMapWithOccupantsOnLocation().get(getType()).get();
        boolean isGrownEnough = checkAgingPhase(AnimalAging.class) == AnimalAging.YOUNG;
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
                // мб поменять местами if'ы
            }
        }

        return isApproved;
    }



    // а вот для вызова этого метода нужно будет проверить есть ли место для нового животного на локации
    // проверка простая - если в нашем листе значение по ключу меньше, чем maxAmount, то размножаемся

    public synchronized void multiply() {
        OccupantFactory.createOccupant(this.getLocation(), this.getType());
        this.getLocation().incrementAmountOfOccupantsOnLocation(this.getType());
    }

    private void setFieldsToMovingAnimal(IslandOccupant occupant) {
        // метод для того, что бы после создания животного передать ему все
        // его старые параметры
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

    public double getSatietyCostOnMove() {
        return satietyCostOnMove;
    }

    public void setSatietyCostOnMove(double satietyCostOnMove) {
        this.satietyCostOnMove = satietyCostOnMove;
    }
}
