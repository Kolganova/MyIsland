import enums.AnimalAging;
import enums.PlantAging;
import island.Island;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {

    public static void createIsland() {
        Island myIsland = new Island(2, 10);
    }

    public void liveADayAtIsland(Island island) {

    }

    public static void liveADayAtLocation(CopyOnWriteArrayList<IslandOccupant> listOfOccupants, Island island) {
        List<IslandOccupant> temp = new ArrayList<>(listOfOccupants);
        Collections.shuffle(temp);
        listOfOccupants.clear();
        listOfOccupants.addAll(temp);

        ExecutorService executor = Executors.newFixedThreadPool(25);
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);
        for (AtomicInteger i = new AtomicInteger(); i.get() <= listOfOccupants.size(); i.getAndIncrement()) {
            int finalI = i.get();
            completionService.submit(() -> {
                IslandOccupant occupant = listOfOccupants.get(finalI);
                if (occupant instanceof Plant) {
                    actLikePlant((Plant) occupant);
                } else if (occupant instanceof Animal) {
                    int dice = occupant.getRandom().nextInt(100);
                    if (dice <= 50 && i.get() != listOfOccupants.size()-1) {
                        actLikeEatingAnimal((Animal) occupant, listOfOccupants.get(i.getAndIncrement()));
                    }
                    if (dice <= 75 && i.get() != listOfOccupants.size()-1) {
                        actLikeMultipliableAnimal((Animal) occupant, (Animal) listOfOccupants.get(i.getAndIncrement()));
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
        animal.eat(occupant);
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
        if (animal.getMoveCounter() < animal.getMaxAmountOfMoves()) {
            if (animalLocation.getIndexOfExternalList() <
                    listOfLocations.get(animalLocation.getIndexOfExternalList()).size()) {
                animal.move(listOfLocations.get(animalLocation.getIndexOfExternalList()).get(animalLocation.getIndexOfInnerList() + 1));
            } else {
                animal.move(listOfLocations.get(animalLocation.getIndexOfExternalList()).get(animalLocation.getIndexOfInnerList() - 1));
            }
            animal.incrementMoveCounter();
        }
        actLikeAnimal(animal);
    }

    public static void actLikeAnimal(Animal animal) {
        animal.setCurrentSatiety(animal.getCurrentSatiety().get() - animal.getSatietyCostOnMove());
        if ((animal.checkAgingPhase(AnimalAging.class) == AnimalAging.OLD) ||
                animal.getCurrentSatiety().get() <= 0) {
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
