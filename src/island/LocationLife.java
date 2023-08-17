package island;

import interfaces.multipliable.AnimalMultiplication;
import interfaces.multipliable.PlantMultiplication;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LocationLife {
    public static void live10DaysAtLocation(CopyOnWriteArrayList<IslandOccupant> listOfOccupants) {
        for (int i = 0; i < 10; i++) {
            liveADayAtLocation(listOfOccupants);
        }
        listOfOccupants.stream()
                .filter(occupant -> occupant instanceof Animal)
                .map(occupant -> (Animal) occupant)
                .forEach(animal -> animal.setMoveCounter(0));
    }

    public static void liveADayAtLocation(CopyOnWriteArrayList<IslandOccupant> listOfOccupants) {
        List<IslandOccupant> temp = new ArrayList<>(listOfOccupants);
        Collections.shuffle(temp);
        listOfOccupants.clear();
        listOfOccupants.addAll(temp);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);
        for (AtomicInteger i = new AtomicInteger(); i.get() <= listOfOccupants.size(); i.getAndIncrement()) {
            completionService.submit(() -> {
                IslandOccupant occupant = listOfOccupants.get(i.get());
                if (occupant instanceof Plant plant) {
                    new PlantMultiplication(plant).actLikeMultipliablePlant();
                    plant.actLikePlant();
                } else if (occupant instanceof Animal animal) {
                    int dice =  ThreadLocalRandom.current().nextInt(100);
                    if (dice <= 40) {
                        int counter = 0;
                        while (true) {
                            int indexOfVictim =  ThreadLocalRandom.current().nextInt(listOfOccupants.size()+1);
                            if (indexOfVictim != i.get()) {
                                boolean didEat = animal.actLikeEatingAnimal(listOfOccupants.get(indexOfVictim));
                                if (didEat || counter > 4)
                                    break;
                            }
                            counter++;
                        }
                        animal.actLikeAnimal();
                    } else if (dice <= 75) {
                        int counter = 0;
                        while (true) {
                            int indexOfPartner;
                            do {
                                indexOfPartner = ThreadLocalRandom.current().nextInt(listOfOccupants.size()+1);
                            } while (indexOfPartner == i.get());
                            boolean didMultiply = new AnimalMultiplication(animal).actLikeMultipliableAnimal(
                                    (Animal) listOfOccupants.get(indexOfPartner));
                            if (didMultiply || counter > 6)
                                break;
                            counter++;
                        }
                        animal.actLikeAnimal();
                    } else {
                        animal.actLikeMovingAnimal(Island.getIsland().getListOfLocations());
                    }
                } else {
                    ((DeadAnimal) occupant).actLikeDeadAnimal();
                }

                return null;
            });
        }

        executor.shutdown();

    }
}
