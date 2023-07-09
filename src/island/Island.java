package island;

import java.util.concurrent.*;

public class Island {
    private final int width;
    private final int length;
    private final CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> listOfLocations
            = new CopyOnWriteArrayList<>();

    public Island(int width, int length) {
        this.width = width;
        this.length = length;
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
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < length; i++) {
            int finalI = i;
            completionService.submit(() -> {
                Location location = new Location();
                location.setIndexOfExternalList(index);
                location.setIndexOfInnerList(finalI);
                list.add(location);
                location.startAnimalAmountCreator();
                return null;
            });
        }

        try {
            for (int i = 0; i < length; i++) {
                completionService.take().get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }


    public CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> getListOfLocations() {
        return listOfLocations;
    }

}
