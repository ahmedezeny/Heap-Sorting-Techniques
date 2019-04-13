package eg.edu.alexu.csd.filestructure.sort;


import java.util.ArrayList;

public class Sort<T extends Comparable<T>> implements ISort {
    @Override
    public IHeap heapSort(ArrayList unordered) {
        Heap heap = new Heap();
        ArrayList<Comparable> ans = new ArrayList<>();
        if (unordered != null) {
            int n = unordered.size();
            heap.build(unordered);
            heap.sort();
        }
        return heap;
    }

    @Override
    public void sortSlow(ArrayList unordered) {
        //BubbleSort
        if (unordered != null) {
            int n = unordered.size();
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (((Comparable) unordered.get(j)).compareTo(unordered.get(j + 1)) > 0) {
                        // swap arr[j+1] and arr[i]
                        Object temp = unordered.get(j);
                        unordered.set(j, unordered.get(j + 1));
                        unordered.set(j + 1, temp);
                    }
        }
    }

    @Override
    public void sortFast(ArrayList unordered) {
        if (unordered != null)
            sort(unordered, 0, unordered.size() - 1);
    }

    private void merge(ArrayList unordered, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList L = new ArrayList();
        ArrayList R = new ArrayList();

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L.add(i, unordered.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(j, unordered.get(m + 1 + j));


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (((Comparable) L.get(i)).compareTo(R.get(j)) <= 0) {
                unordered.set(k, L.get(i));
                i++;
            } else {
                unordered.set(k, R.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            unordered.set(k, L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            unordered.set(k, R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private void sort(ArrayList unordered, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(unordered, l, m);
            sort(unordered, m + 1, r);

            // Merge the sorted halves
            merge(unordered, l, m, r);
        }
    }

}
