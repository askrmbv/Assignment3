import java.util.Arrays;
public class Experiment {

    private final Sorter sorter;
    private final Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();
        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else if (type.equals("advanced")) {
            sorter.advancedSort(copy);
        }
        long end = System.nanoTime();

        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();

        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};
        String[] sizeLabels = {"Small (10)", "Medium (100)", "Large (1000)"};

        System.out.println("=".repeat(65));
        System.out.println("SORTING & SEARCHING ALGORITHM PERFORMANCE ANALYSIS");
        System.out.println("=".repeat(65));

        for (int s = 0; s < sizes.length; s++) {
            int size = sizes[s];
            System.out.println("\n--- " + sizeLabels[s] + " ---");

            int[] randomArr = sorter.generateRandomArray(size);

            long bubbleRandom = measureSortTime(randomArr, "basic");
            long mergeRandom  = measureSortTime(randomArr, "advanced");

            System.out.println("\n[Random Array]");
            System.out.printf("  Bubble Sort : %,d ns%n", bubbleRandom);
            System.out.printf("  Merge Sort  : %,d ns%n", mergeRandom);
            System.out.printf("  Faster      : %s%n",
                    bubbleRandom <= mergeRandom ? "Bubble Sort" : "Merge Sort");

            int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
            Arrays.sort(sortedArr);

            long bubbleSorted = measureSortTime(sortedArr, "basic");
            long mergeSorted  = measureSortTime(sortedArr, "advanced");

            System.out.println("\n[Sorted Array]");
            System.out.printf("  Bubble Sort : %,d ns%n", bubbleSorted);
            System.out.printf("  Merge Sort  : %,d ns%n", mergeSorted);
            System.out.printf("  Faster      : %s%n",
                    bubbleSorted <= mergeSorted ? "Bubble Sort" : "Merge Sort");

            int target = sortedArr[size / 2];
            long searchTime = measureSearchTime(sortedArr, target);
            int  searchIdx  = searcher.search(sortedArr, target);

            System.out.println("\n[Binary Search on Sorted Array]");
            System.out.printf("  Target      : %d%n", target);
            System.out.printf("  Found at    : index %d%n", searchIdx);
            System.out.printf("  Time        : %,d ns%n", searchTime);
        }

        System.out.println("\n" + "=".repeat(65));
        System.out.println("DONE");
        System.out.println("=".repeat(65));
    }
}