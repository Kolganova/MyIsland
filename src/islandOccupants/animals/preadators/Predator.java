package islandOccupants.animals.preadators;

import enums.CreationType;
import interfaces.EatableAnimal;
import interfaces.EatableDeadAnimal;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.animals.herbivorous.*;
import islandOccupants.animals.omnivores.Boar;
import islandOccupants.animals.omnivores.Duck;
import islandOccupants.deadAnimals.DeadAnimal;

public abstract class Predator extends Animal implements EatableAnimal, EatableDeadAnimal {

    public Predator(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public synchronized boolean eat(IslandOccupant occupant) {
        if (occupant instanceof DeadAnimal && getRandom().nextBoolean()) {
            eatDeadAnimal(this, (DeadAnimal) occupant);
            return true;
        } else if (occupant instanceof Animal) {
            return eatAnimal((Animal) occupant);
        }

        return false;
    }

    @Override
    public boolean eatAnimal(Animal victim) {
        if ((this instanceof Wolf && victim instanceof Horse) || (this instanceof Wolf && victim instanceof Buffalo) ||
                (this instanceof Boa && victim instanceof Duck) || (this instanceof Bear && victim instanceof Duck) ||
                (this instanceof Eagle && victim instanceof Fox)) {
            if (getRandom().nextInt(100) <= 10) {
                this.nutritionProcess(victim);
                return true;
            }

        } else if ((this instanceof Boa && victim instanceof Fox) || (this instanceof Wolf && victim instanceof Deer) ||
                (this instanceof Wolf && victim instanceof Boar)) {
            if (getRandom().nextInt(100) <= 15) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Boa && victim instanceof Rabbit ||
                (this instanceof Bear && victim instanceof Buffalo))) {
            if (getRandom().nextInt(100) <= 20) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Wolf && victim instanceof Duck) || (this instanceof Boa && victim instanceof Mouse ||
                (this instanceof Fox && victim instanceof Caterpillar || (this instanceof Bear && victim instanceof Horse)))) {
            if (getRandom().nextInt(100) <= 40) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if (this instanceof Bear && victim instanceof Boar) {
            if (getRandom().nextInt(100) <= 50) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Wolf && victim instanceof Rabbit) || (this instanceof Wolf && victim instanceof Goat) ||
                (this instanceof Fox && victim instanceof Duck)) {
            if (getRandom().nextInt(100) <= 60) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Wolf && victim instanceof Sheep) || (this instanceof Fox && victim instanceof Rabbit) ||
                (this instanceof Bear && victim instanceof Goat) || (this instanceof Bear && victim instanceof Sheep)) {
            if (getRandom().nextInt(100) <= 70) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Wolf && victim instanceof Mouse) || (this instanceof Bear && victim instanceof Boa) ||
                (this instanceof Bear && victim instanceof Deer) || (this instanceof Bear && victim instanceof Rabbit) ||
                (this instanceof Eagle && victim instanceof Duck)) {
            if (getRandom().nextInt(100) <= 80) {
                this.nutritionProcess(victim);
                return true;
            }
        } else if ((this instanceof Fox && victim instanceof Mouse) || (this instanceof Bear && victim instanceof Mouse) ||
                (this instanceof Eagle && victim instanceof Rabbit || (this instanceof Eagle && victim instanceof Mouse))) {
            if (getRandom().nextInt(100) <= 90) {
                this.nutritionProcess(victim);
                return true;
            }
        }

        return false;
    }

}
