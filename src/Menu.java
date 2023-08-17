import island.Island;

import java.util.Scanner;

import static island.IslandLife.live10DaysAtIsland;

public class Menu {

    protected static void playInSimulation() {
        printIntroduction();
        Scanner sc = new Scanner(System.in);

        System.out.println("\nПервичная статистика:");
        Statistics.showStatistics();

        while (true) {
            String command = sc.nextLine();
            if ("play".equals(command)) {
                live10DaysAtIsland();
                if (isThereNoAliveAnimal()) {
                    System.out.println("______________________________");
                    System.out.println("Эх, все животные умерли :(");
                    break;
                }
                Statistics.showStatistics();
            } else if ("stop".equals(command)) {
                break;
            }
        }
        sc.close();
    }

    private static void printIntroduction() {
        System.out.println("Добрый день!\nВы открыли симуляцию очень реалистичного острова \"" +
                Island.getIsland().getName() + "\"." +
                "\nВводите \"play\" для того, что бы наш островок прожил свой" +
                "очередной жалкий цикл (10 дней) или введите \"stop\" для уничтожения несчастного островка.\n" +
                "Если все животные умрут, то симуляция так же закончится.");
    }

    private static boolean isThereNoAliveAnimal() {
        return Statistics.getCurrentAmountOfOccupantsOnIsland() <= 0;
    }

}