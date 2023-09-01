package model.animals.omnivores;

import enums.types.CreationType;
import enums.types.OccupantType;
import behavior.eatable.EatableAnimal;
import behavior.eatable.EatableDeadAnimal;
import behavior.eatable.EatablePlant;
import island.Location;
import model.IslandOccupant;
import model.animals.Animal;
import model.animals.herbivorous.Caterpillar;
import model.animals.herbivorous.Mouse;
import model.deadAnimals.DeadAnimal;
import model.plants.Plant;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Omnivores extends Animal implements EatableAnimal, EatableDeadAnimal, EatablePlant {

    protected Omnivores(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public synchronized boolean eat(IslandOccupant occupant) {
        if (occupant instanceof Plant) {
            eatPlant(this, (Plant) occupant);
            return true;
        } else if (occupant instanceof DeadAnimal && ThreadLocalRandom.current().nextBoolean()) {
            eatDeadAnimal(this, (DeadAnimal) occupant);
            return true;
        } else if (occupant instanceof Animal) {
            return eatAnimal((Animal) occupant);
        }

        return false;
    }

    @Override
    public boolean eatAnimal(Animal victim) {
        if (victim instanceof Caterpillar || (victim instanceof Mouse && this instanceof Boar)) {
            if (ThreadLocalRandom.current().nextInt(100) < 60) {
                this.nutritionProcess(victim);
                return true;
            }
        }

        return false;
    }

}