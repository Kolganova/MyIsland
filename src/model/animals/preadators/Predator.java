package model.animals.preadators;

import enums.types.CreationType;
import enums.types.OccupantType;
import behavior.eatable.EatableAnimal;
import behavior.eatable.EatableDeadAnimal;
import island.Location;
import model.IslandOccupant;
import model.animals.Animal;
import model.animals.herbivorous.*;
import model.animals.omnivores.Boar;
import model.animals.omnivores.Duck;
import model.deadAnimals.DeadAnimal;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal implements EatableAnimal, EatableDeadAnimal {

    protected Predator(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public synchronized boolean eat(IslandOccupant occupant) {
        if (occupant instanceof DeadAnimal && ThreadLocalRandom.current().nextBoolean()) {
            eatDeadAnimal(this, (DeadAnimal) occupant);
            return true;
        } else if (occupant instanceof Animal) {
            return eatAnimal((Animal) occupant);
        }

        return false;
    }

    @Override
    public boolean eatAnimal(Animal victim) {
        int randomNum = ThreadLocalRandom.current().nextInt(100);
        if ((this instanceof Wolf && victim instanceof Horse) || (this instanceof Wolf && victim instanceof Buffalo) ||
                (this instanceof Boa && victim instanceof Duck) || (this instanceof Bear && victim instanceof Duck) ||
                (this instanceof Eagle && victim instanceof Fox)) {
            if (randomNum < 10) {
                this.nutritionProcess(victim);
                return true;
            }

        } else if ((this instanceof Boa && victim instanceof Fox) || (this instanceof Wolf && victim instanceof Deer) ||
                (this instanceof Wolf && victim instanceof Boar)) {
            if (randomNum < 15) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Boa && victim instanceof Rabbit ||
                (this instanceof Bear && victim instanceof Buffalo))) {
            if (randomNum < 20) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Wolf && victim instanceof Duck) || (this instanceof Boa && victim instanceof Mouse ||
                (this instanceof Fox && victim instanceof Caterpillar || (this instanceof Bear && victim instanceof Horse)))) {
            if (randomNum < 40) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if (this instanceof Bear && victim instanceof Boar) {
            if (randomNum < 50) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Wolf && victim instanceof Rabbit) || (this instanceof Wolf && victim instanceof Goat) ||
                (this instanceof Fox && victim instanceof Duck)) {
            if (randomNum < 60) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Wolf && victim instanceof Sheep) || (this instanceof Fox && victim instanceof Rabbit) ||
                (this instanceof Bear && victim instanceof Goat) || (this instanceof Bear && victim instanceof Sheep)) {
            if (randomNum < 70) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Wolf && victim instanceof Mouse) || (this instanceof Bear && victim instanceof Boa) ||
                (this instanceof Bear && victim instanceof Deer) || (this instanceof Bear && victim instanceof Rabbit) ||
                (this instanceof Eagle && victim instanceof Duck)) {
            if (randomNum < 80) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Fox && victim instanceof Mouse) || (this instanceof Bear && victim instanceof Mouse) ||
                (this instanceof Eagle && victim instanceof Rabbit || (this instanceof Eagle && victim instanceof Mouse))) {
            if (randomNum < 90) {
                this.nutritionProcess(victim);
                return true;
            }
        }

        return false;
    }

}
