/*
 * Robert Minkler
 * Sorting Algorithms
 * March 9, 2025
 */

public class Sort {
    public static void main(String[] args) {
        Integer[] nums = {110, 14, 32, 23, 9, 4, 10, 6, 7, 8, 9, 0};

        System.out.println("\nInsertion Sort:");
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));
        insertion(nums);
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));


        nums = new Integer[]{110, 14, 32, 23, 9, 4, 10, 6, 7, 8, 9, 0};

        System.out.println("\nSelection Sort:");
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));
        selection(nums);
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));


        nums = new Integer[]{110, 14, 32, 23, 9, 4, 10, 6, 7, 8, 9};
        System.out.println("\nBubble Sort:");
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));
        bubble(nums);
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));

        String[] alpha = {"a", "f", "bet", "bot", "s", "b", "z", "a"};
        System.out.println("\nBubble Sort:");
        System.out.println(isSorted(alpha));
        System.out.println(java.util.Arrays.toString(alpha));
        bubble(alpha);
        System.out.println(isSorted(alpha));
        System.out.println(java.util.Arrays.toString(alpha));

        nums = new Integer[]{110, 14, 32, 23, 9, 4, 10, 6, 7, 8, 9};
        System.out.println("\nShell Sort:");
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));
        shellSort(nums);
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));

        nums = new Integer[]{110, 14, 32, 23, 9, 4, 10, 6, 7, 8, 9};
        System.out.println("\nMerge Sort:");
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(isSorted(nums));
        System.out.println(java.util.Arrays.toString(nums));

    }

    public static <T extends Comparable<T>> void insertion(T[] a) {

        // Iterate through each element to insert it into the sorted array
        for (int i = 0; i < a.length; i++) {

            // Move the inserted element to the left until it is sorted
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubble(T[] a) {

        int k = a.length;

        boolean sorted = false;     // the list is sorted if no swaps are made during a pass.

        for (int j = 0; j < a.length && !sorted; j++) {

            sorted = true;      // switch sorted to true. It will flip to false if any swaps are made.

            for (int i = 1; i < k; i++) {

                if (less(a[i], a[i - 1])) {
                    swap(a, i, i - 1);
                    sorted = false;
                }
            }
            k--;    // track the sorted portion of the array
        }
    }

    public static <T extends Comparable<T>> void selection(T[] a) {

        // Iterate through each index
        for (int i = 0; i < a.length; i++) {

            // find minimum value to swap with i
            int min = i;
            for (int j = i + 1; j < a.length; j++)

                // Track min index
                if (less(a[j], a[min])) {
                    min = j;
                }

            // Swam min with i
            swap(a, i, min);
        }
    }


    /**
     * Sedgewick mergeSort
     */
    public static <T extends Comparable<T>> void mergeSort(T[] a, T[] aux, int lo, int hi) {

        // just return if nothing to do
        if (hi <= lo) return;

        // calculate midpoint
        int mid = lo + (hi - lo) / 2;

        // divide the array into sections to sort and merge
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);

        // merge sorted sections of the array
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Sedgewick begin mergeSort
     */
    public static <T extends Comparable<T>> void mergeSort(T[] a) {
        // create the aux array
        T[] aux = (T[]) new Comparable[a.length];

        // begin mergeSort
        mergeSort(a, aux, 0, a.length - 1);
    }


    /**
     * Sedgewick merge for merge sort
     */
    private static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid); // precondition: a[lo..mid] sorted
        assert isSorted(a, mid + 1, hi); // precondition: a[mid+1..hi] sorted

        // Copy array a to aux
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo;
        int j = mid + 1;

        // merge
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];       // if lo side complete, copy hi side
            else if (j > hi) a[k] = aux[i++];   // if hi side complete copy lo side
            else if (less(aux[j], aux[i])) a[k] = aux[j++];     // copy hi side if it is smaller
            else a[k] = aux[i++];               // copy lo side if it is smaller
        }

        assert isSorted(a, lo, hi); // postcondition: a[lo..hi] sorted
    }

    /**
     * Shell sort uses insertion sort, but instead of swapping one space back,
     * it makes larger swaps.
     * Sedgewick
     */
    public static <T extends Comparable<T>> void shellSort(T[] a) {

        int N = a.length;
        int h = 1;

        // increase h for larger steps
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...

        while (h >= 1) { // h-sort the array.

            // Insertion sort with h steps
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    swap(a, j, j - h);
            }
            h = h / 3;
        }

    }

    private static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<T>> boolean less(T q, T r) {
        return q.compareTo(r) < 0;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            if (less(a[i + 1], a[i])) return false;
        }
        return true;
    }
}
