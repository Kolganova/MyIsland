import enums.AnimalAging;
import enums.PlantAging;
import island.Island;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

import java.util.concurrent.*;

public class Menu {

    public static void createIsland() {
        Island myIsland = new Island(2, 10);
    }

    public static void liveADay(CopyOnWriteArrayList<IslandOccupant> listOfOccupants, Island island) {
        ExecutorService executor = Executors.newFixedThreadPool(25);
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);
        for (IslandOccupant occupant : listOfOccupants) {
            completionService.submit(() -> {
                if (occupant instanceof Plant) {
                    actLikePlant((Plant) occupant);
                } else if (occupant instanceof Animal) {
                    int dice = occupant.getRandom().nextInt(100);
                    if (dice <= 50) {
                        // нужно как-то во вложенном блоке синхронизации вызвать метод actLikeEatingAnimal
                        // при этом первый должен быть животным, а второй кто угодно. соответственно,
                        // ставить сначала instanceof Animal нельзя. Мб какие-то доп переменные нужны
                    }
                    if (dice <= 75) {
                        // здесь нужно понять как передать два разных объекта, потому что на данный момент
                        // он размножается сам с собой
                        Animal partner1 = (Animal) occupant;
                        synchronized (partner1) {
                            Animal partner2 = (Animal) occupant;
                            synchronized (partner2) {
                                actLikeMultipliableAnimal(partner1, partner2);
                            }
                        }
                    } else {
                        actLikeMovingAnimal((Animal) occupant, island.getListOfLocations());
                    }
                } else {
                    actLikeDeadAnimal((DeadAnimal) occupant);
                }

                return null;
            });
        }
    }

    public static void actLikePlant(Plant plant) {
        if (plant.isAbleToMultiply())
            plant.multiply();
        if (plant.checkAgingPhase(PlantAging.class) == PlantAging.FADING) {
            if (plant.getRandom().nextInt(100) <= 20) {
                plant.die();
            }
        }
        plant.incrementAge();
    }

    public static void actLikeEatingAnimal(Animal animal, IslandOccupant occupant) {
        boolean didEat = false;
        while (!didEat) {
            didEat = animal.eat(occupant);
        }
        actLikeAnimal(animal);
        if (occupant instanceof Animal) {
            actLikeAnimal((Animal) occupant);
        } else if (occupant instanceof DeadAnimal) {
            actLikeDeadAnimal((DeadAnimal) occupant);
        } else {
            actLikePlant((Plant) occupant);
        }
    }

    public synchronized static void actLikeMultipliableAnimal(Animal partner1, Animal partner2) {
        if (Animal.isCoupleAppropriate(partner1, partner2)) {
            partner1.multiply();
        }
        actLikeAnimal(partner1);
        actLikeAnimal(partner2);
    }

    public static void actLikeMovingAnimal(Animal animal,
                                           CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> listOfLocations) {
        Location animalLocation = animal.getLocation();

        if (animalLocation.getIndexOfExternalList() <
                listOfLocations.get(animalLocation.getIndexOfExternalList()).size()) {
            animal.move(listOfLocations.get(animalLocation.getIndexOfExternalList()).get(animalLocation.getIndexOfInnerList() + 1));
        } else {
            animal.move(listOfLocations.get(animalLocation.getIndexOfExternalList()).get(animalLocation.getIndexOfInnerList() - 1));
        }
        actLikeAnimal(animal);
        // добавить currentAmountOfMoves
    }

    public static void actLikeAnimal(Animal animal) {
        animal.setCurrentSatiety(animal.getCurrentSatiety().get() - animal.getSatietyCostOnMove());
        if ((animal.checkAgingPhase(AnimalAging.class) == AnimalAging.OLD) ||
                animal.getCurrentSatiety().get() <= 0) {
            // под небольшим вопросом не должно ли животное сразу умирать если оч голодное
            if (animal.getRandom().nextInt(100) <= 20) {
                animal.die();
            }
        }
        animal.incrementAge();
    }

    public static void actLikeDeadAnimal(DeadAnimal deadAnimal) {
        deadAnimal.incrementAge();
    }

}
