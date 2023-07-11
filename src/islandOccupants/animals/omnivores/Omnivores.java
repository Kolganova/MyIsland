package islandOccupants.animals.omnivores;

import enums.CreationType;
import interfaces.EatableAnimal;
import interfaces.EatableDeadAnimal;
import interfaces.EatablePlant;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.animals.herbivorous.Caterpillar;
import islandOccupants.animals.herbivorous.Mouse;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

public abstract class Omnivores extends Animal implements EatableAnimal, EatableDeadAnimal, EatablePlant {

    public Omnivores(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public boolean eat(IslandOccupant occupant) {
        if (occupant instanceof Plant) {
            eatPlant(this, (Plant) occupant);
            return true;
        } else if (occupant instanceof DeadAnimal && getRandom().nextBoolean()) {
            eatDeadAnimal(this, (DeadAnimal) occupant);
            return true;
        } else if (occupant instanceof Animal){
            return eatAnimal((Animal) occupant);
        }

        return false;
    }

    @Override
    public boolean eatAnimal(Animal victim) {
        if (victim instanceof Caterpillar || (victim instanceof Mouse && this instanceof Boar)) {
            if (getRandom().nextInt(100) <= 60) {
                this.nutritionProcess(victim);
                return true;
            }
        }

        return false;

    }

}
