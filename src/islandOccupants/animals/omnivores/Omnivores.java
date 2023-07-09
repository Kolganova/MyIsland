package islandOccupants.animals.omnivores;

import enums.CreationType;
import interfaces.EatableAnimals;
import interfaces.EatableDeadAnimals;
import interfaces.EatablePlants;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.animals.herbivorous.Caterpillar;
import islandOccupants.animals.herbivorous.Mouse;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

public abstract class Omnivores extends Animal implements EatablePlants, EatableAnimals, EatableDeadAnimals {

    public Omnivores(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public synchronized boolean eat(IslandOccupant occupant) {
        if (occupant instanceof Plant) {
            eatPlant(this, (Plant) occupant);
        } else if (occupant instanceof DeadAnimal && getRandom().nextBoolean()) {
            eatDeadAnimal(this, (DeadAnimal) occupant);
        } else {
            return eatAnimal((Animal) occupant);
        }

        return true;
    }

    @Override
    public boolean eatAnimal(Animal victim) {
        double victimWeight = victim.getWeight().get();
        double eaterCurrentSatiety = this.getCurrentSatiety().get();
        double eaterBellySize = this.getBellySize().get();
        boolean willBellyFitVictim = victimWeight + eaterCurrentSatiety <= eaterBellySize;
        if (victim instanceof Caterpillar || (victim instanceof Mouse && this instanceof Boar)) {
            if (getRandom().nextInt(100) <= 60) {
                if (willBellyFitVictim) {
                    this.setCurrentSatiety(eaterCurrentSatiety + victimWeight);
                } else {
                    this.setCurrentSatiety(eaterBellySize);
                    new DeadAnimal(this.getLocation(), "deadAnimal");
                }
                return true;
            }
        }

        return false;
    }

}
