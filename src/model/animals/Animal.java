package model.animals;

import enums.types.OccupantType;
import enums.aging.AnimalAging;
import enums.types.CreationType;
import behavior.eatable.Eatable;
import behavior.initializable.InitializableAnimal;
import behavior.movable.Movable;
import island.Location;
import model.IslandOccupant;
import model.OccupantFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

import static enums.types.OccupantType.DEAD_ANIMAL;

@Getter
@Setter
public abstract class Animal extends IslandOccupant implements Movable, Eatable, InitializableAnimal {
    private int maxAmountOfMoves;
    private double satietyCostOnMove;
    private boolean isPoisonProtected;
    private final AtomicReference<Double> currentSatiety = new AtomicReference<>();
    private final AtomicReference<Double> bellySize = new AtomicReference<>();
    private boolean isFemale;
    private int moveCounter;

    protected Animal(Location location, OccupantType type, CreationType creationType) {
        super(location, type);
        switch (creationType) {
            case NEWBORN -> setNewbornAnimal();
            case START_OCCUPANT -> setStartAnimal();
        }
    }

    private void setNewbornAnimal() {
        setAge(1);
    }

    private void setStartAnimal() {
        setAge(ThreadLocalRandom.current().nextInt(1, 301));
    }

    @Override
    public void move(Location location) {
        location.addOccupantInLocation(this);
        this.die();
    }

    @Override
    public void nutritionProcess(IslandOccupant occupant) {
        double occupantWeight = occupant.getWeight();
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
                IslandOccupant deadAnimal = OccupantFactory.createOccupant(this.getLocation(), DEAD_ANIMAL, null);
                deadAnimal.setWeight(deadAnimalWeight);
            }
            occupant.die();
        }
    }

    public boolean actLikeEatingAnimal(IslandOccupant occupant) {

        return this.eat(occupant);
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
            if (ThreadLocalRandom.current().nextInt(100) < 20) {
                this.die();
            }
        }
        incrementAge();
    }

    @Override
    public void initAnimal(int maxAmountOfOccupants, boolean isPoisonProtected, double weight, double bellySize,
                           int maxAmountOfMoves) {
        setMaxAmountOfOccupants(maxAmountOfOccupants);
        setPoisonProtected(isPoisonProtected);
        setWeight(weight);
        setBellySize(bellySize);
        setCurrentSatiety(ThreadLocalRandom.current().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(bellySize / 5);
        setMaxAmountOfMoves(maxAmountOfMoves);
        setFemale();
    }

    protected void setBellySize(Double bellySize) {
        this.bellySize.set(bellySize);
    }

    public void setCurrentSatiety(Double currentSatiety) {
        this.currentSatiety.set(currentSatiety);
    }

    protected void incrementMoveCounter() {
        moveCounter++;
    }

    protected void setFemale() {
        isFemale = ThreadLocalRandom.current().nextBoolean();
    }

}