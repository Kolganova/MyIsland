package islandOccupants.animals.preadators;

import enums.CreationType;
import interfaces.EatableAnimals;
import interfaces.EatableDeadAnimals;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.animals.herbivorous.*;
import islandOccupants.animals.omnivores.Boar;
import islandOccupants.animals.omnivores.Duck;
import islandOccupants.deadAnimals.DeadAnimal;

public abstract class Predator extends Animal implements EatableAnimals, EatableDeadAnimals {

    public Predator(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public void eat(IslandOccupant occupant) {
        if (occupant instanceof DeadAnimal) {
            eatDeadAnimal(this, (DeadAnimal) occupant);
        } else if (occupant instanceof Animal) {
            eatAnimal((Animal) occupant);
        }

    }

    @Override
    public void eatAnimal(Animal victim) {
        if ((this instanceof Wolf && victim instanceof Horse) || (this instanceof Wolf && victim instanceof Buffalo) ||
                (this instanceof Boa && victim instanceof Duck) || (this instanceof Bear && victim instanceof Duck) ||
                (this instanceof Eagle && victim instanceof Fox)) {
            if (getRandom().nextInt(100) <= 10) {
                nutritionProcess(this, victim);
            }

        } else if ((this instanceof Boa && victim instanceof Fox) || (this instanceof Wolf && victim instanceof Deer) ||
                (this instanceof Wolf && victim instanceof Boar)) {
            if (getRandom().nextInt(100) <= 15) {
                nutritionProcess(this, victim);
            }
        } else if ((this instanceof Boa && victim instanceof Rabbit ||
                (this instanceof Bear && victim instanceof Buffalo))) {
            if (getRandom().nextInt(100) <= 20) {
                nutritionProcess(this, victim);
            }
        } else if ((this instanceof Wolf && victim instanceof Duck) || (this instanceof Boa && victim instanceof Mouse ||
                (this instanceof Fox && victim instanceof Caterpillar || (this instanceof Bear && victim instanceof Horse)))) {
            if (getRandom().nextInt(100) <= 40) {
                nutritionProcess(this, victim);
            }
        } else if (this instanceof Bear && victim instanceof Boar) {
            if (getRandom().nextInt(100) <= 50) {
                nutritionProcess(this, victim);
            }
        } else if ((this instanceof Wolf && victim instanceof Rabbit) || (this instanceof Wolf && victim instanceof Goat) ||
                (this instanceof Fox && victim instanceof Duck)) {
            if (getRandom().nextInt(100) <= 60) {
                nutritionProcess(this, victim);
            }
        } else if ((this instanceof Wolf && victim instanceof Sheep) || (this instanceof Fox && victim instanceof Rabbit) ||
                (this instanceof Bear && victim instanceof Goat) || (this instanceof Bear && victim instanceof Sheep)) {
            if (getRandom().nextInt(100) <= 70) {
                nutritionProcess(this, victim);
            }
        } else if ((this instanceof Wolf && victim instanceof Mouse) || (this instanceof Bear && victim instanceof Boa) ||
                (this instanceof Bear && victim instanceof Deer) || (this instanceof Bear && victim instanceof Rabbit) ||
                (this instanceof Eagle && victim instanceof Duck)) {
            if (getRandom().nextInt(100) <= 80) {
                nutritionProcess(this, victim);
            }
        } else if ((this instanceof Fox && victim instanceof Mouse) || (this instanceof Bear && victim instanceof Mouse) ||
                (this instanceof Eagle && victim instanceof Rabbit || (this instanceof Eagle && victim instanceof Mouse))) {
            if (getRandom().nextInt(100) <= 90) {
                nutritionProcess(this, victim);
            }
        }
    }

}
