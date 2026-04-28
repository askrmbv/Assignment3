public class Main {

    public static void main(String[] args) {

        Sorter     sorter     = new Sorter();
        Searcher   searcher   = new Searcher();
        Experiment experiment = new Experiment(sorter, searcher);

        experiment.runAllExperiments();

        System.out.println("\n--- Quick Demo (10 elements) ---");

        int[] demo = sorter.generateRandomArray(10);

        System.out.print("Original : ");
        sorter.printArray(demo);

        int[] bubbleDemo = demo.clone();
        sorter.basicSort(bubbleDemo);
        System.out.print("Bubble   : ");
        sorter.printArray(bubbleDemo);

        int[] mergeDemo = demo.clone();
        sorter.advancedSort(mergeDemo);
        System.out.print("Merge    : ");
        sorter.printArray(mergeDemo);

        int target = mergeDemo[5];
        int idx = searcher.search(mergeDemo, target);
        System.out.printf("Binary Search for %d -> index %d%n", target, idx);
    }
}