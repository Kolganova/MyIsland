package islandOccupants.animals;

import enums.AnimalAging;
import enums.CreationType;
import interfaces.*;
import island.Island;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;
import islandOccupants.deadAnimals.DeadAnimal;

import java.util.concurrent.CopyOnWriteArrayList;
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
        Island.incrementAmountOfAnimals();
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
        setAge(getRandom().nextInt(1, 300));
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
        if ((partner1.isFemale && !(partner2.isFemale())) || (partner2.isFemale && !(partner1.isFemale()))) {
            if (partner1.isAbleToMultiply() && partner2.isAbleToMultiply()) {
                isApproved = true;
            }
        }

        return isApproved;
    }

    public synchronized void multiply() {
        int amountOfChildren = getRandom().nextInt(10);
        for (int i = 0; i < amountOfChildren; i++) {
            OccupantFactory.createOccupant(this.getLocation(), this.getType(), CreationType.NEWBORN);
        }
    }

    @Override
    public void move(Location location) {
        location.addOccupantInLocation(this);
        this.die();
    }

    @Override
    public void nutritionProcess(IslandOccupant occupant) {
        double occupantWeight = occupant.getWeight().get();
        double eaterCurrentSatiety = this.getCurrentSatiety().get();
        double eaterBellySize = this.getBellySize().get();
        boolean willBellyFitOccupant = occupantWeight + eaterCurrentSatiety <= eaterBellySize;
        if (willBellyFitOccupant) {
            this.setCurrentSatiety(eaterCurrentSatiety + occupantWeight);
            occupant.die();
        } else {
            this.setCurrentSatiety(eaterBellySize);
            if (occupant instanceof Animal) {
                double deadAnimalWeight = occupantWeight - (eaterBellySize - eaterCurrentSatiety);
                new DeadAnimal(this.getLocation(), "deadAnimal", deadAnimalWeight);
            }
            occupant.die();
        }
    }

    public boolean actLikeEatingAnimal(IslandOccupant occupant) {

        return this.eat(occupant);
    }

    public boolean actLikeMultipliableAnimal(Animal partner) {
        boolean result = false;
        if (Animal.isCoupleAppropriate(this, partner)) {
            this.multiply();
            result = true;
        }

        return result;
    }

    public void actLikeMovingAnimal(CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> listOfLocations) {
        Location animalLocation = this.getLocation();
        if (moveCounter < maxAmountOfMoves) {
            if (animalLocation.getIndexOfExternalList() <
                    listOfLocations.get(animalLocation.getIndexOfExternalList()).size()) {
                this.move(listOfLocations.get(animalLocation.getIndexOfExternalList()).
                        get(animalLocation.getIndexOfInnerList() + 1));
            } else {
                this.move(listOfLocations.get(animalLocation.getIndexOfExternalList()).
                        get(animalLocation.getIndexOfInnerList() - 1));
            }
            incrementMoveCounter();
        }
        actLikeAnimal();
    }

    public void actLikeAnimal() {
        this.setCurrentSatiety(currentSatiety.get() - satietyCostOnMove);
        if ((this.checkAgingPhase(AnimalAging.class) == AnimalAging.OLD) ||
                currentSatiety.get() <= 0) {
            if (getRandom().nextInt(100) <= 20) {
                this.die();
            }
        }
        incrementAge();
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

    public void setMaxAmountOfMoves(int maxAmountOfMoves) {
        this.maxAmountOfMoves = maxAmountOfMoves;
    }

    public AtomicReference<Double> getBellySize() {
        return bellySize;
    }

    public void setBellySize(Double bellySize) {
        this.bellySize.set(bellySize);
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

    public void incrementMoveCounter() {
        moveCounter++;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

}