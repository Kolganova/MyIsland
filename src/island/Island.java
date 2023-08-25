package island;


import lombok.Getter;

import java.util.concurrent.*;

public class Island {
    private static Island Island;
    @Getter
    private final String name;
    private final int width;
    private final int length;
    @Getter
    private final CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> listOfLocations
            = new CopyOnWriteArrayList<>();

    private Island(int width, int length, String name) {
        this.width = width;
        this.length = length;
        this.name = name;
        setListOfLocations();
    }

    private void setListOfLocations() {
        for (int i = 0; i < width; i++) {
            CopyOnWriteArrayList<Location> list = new CopyOnWriteArrayList<>();
            listOfLocations.add(list);
            setLocationToList(list, i);
        }
    }

    private void setLocationToList(CopyOnWriteArrayList<Location> list, int index) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<Void> completionService = getVoidCompletionService(list, index, executor);

        try {
            for (int i = 0; i < length; i++) {
                completionService.take().get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

    private CompletionService<Void> getVoidCompletionService(CopyOnWriteArrayList<Location> list, int index, ExecutorService executor) {
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < length; i++) {
            int finalI = i;
            completionService.submit(() -> {
                Location location = new Location();
                location.setIndexOfExternalList(index);
                location.setIndexOfInnerList(finalI);
                list.add(location);
                location.primaryAnimalsCreator();
                return null;
            });
        }
        return completionService;
    }


    public static Island getIsland() {
        if (Island == null) {
            Island = new Island(10, 10, "DangerousIsland");
        }

        return Island;
    }

}