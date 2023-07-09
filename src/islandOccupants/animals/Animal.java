package islandOccupants.animals;

import enums.AnimalAging;
import enums.CreationType;
import interfaces.*;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;
import islandOccupants.deadAnimals.DeadAnimal;

import java.util.concurrent.atomic.AtomicReference;

public abstract class Animal extends IslandOccupant implements Movable, Eatable {
    private int maxAmountOfMoves;
    private double satietyCostOnMove;
    private boolean isPoisonProtected;
    private final AtomicReference<Double> currentSatiety = new AtomicReference<>();
    private final AtomicReference<Double> bellySize = new AtomicReference<>();
    private boolean isFemale;
    private int moveCounter;

    public Animal(Location location, String type, CreationType creationType) {
        super(location, type);
        switch (creationType) {
            case NEWBORN -> setNewbornAnimal();
            case START_OCCUPANT -> setStartAnimal();
        }
    }

    private void setNewbornAnimal() {
        isFemale = getRandom().nextBoolean();
        setAge(1);
    }

    private void setStartAnimal() {
        isFemale = getRandom().nextBoolean();
        setAge(getRandom().nextInt(300));
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
            }
        }

        return isApproved;
    }

    public synchronized void multiply() {
        OccupantFactory.createOccupant(this.getLocation(), this.getType(), CreationType.NEWBORN);
    }

    @Override
    public void move(Location location) {
        location.addOccupantInLocation(this);
        this.die();
    }

    @Override
    public void nutritionProcess(Animal animal, IslandOccupant occupant) {
        double occupantWeight = occupant.getWeight().get();
        double eaterCurrentSatiety = animal.getCurrentSatiety().get();
        double eaterBellySize = animal.getBellySize().get();
        boolean willBellyFitOccupant = occupantWeight + eaterCurrentSatiety <= eaterBellySize;
        if (willBellyFitOccupant) {
            animal.setCurrentSatiety(eaterCurrentSatiety + occupantWeight);
            occupant.die();
        } else {
            animal.setCurrentSatiety(eaterBellySize);
            if (occupant instanceof Animal) {
                double deadAnimalWeight = occupantWeight - (eaterBellySize - eaterCurrentSatiety);
                new DeadAnimal(animal.getLocation(), "deadAnimal", deadAnimalWeight);
            }
            occupant.die();
        }
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

    public AtomicReference<Double> getCurrentSatiety() {
        return currentSatiety;
    }

    public void setCurrentSatiety(Double currentSatiety) {
        this.currentSatiety.set(currentSatiety);
    }

}
