import java.util.Arrays;
import java.util.Random;

public class Sort {

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int middle = (right + left) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }
    
    private static void merge(int[] array, int left, int middle, int right) {
        int n = (middle - left) + 1;
        int m = (right - middle);
        int[] l = new int[n + 1];
        int[] r = new int[m + 1];
        for (int i = 0; i < n; i++)
            l[i] = array[left + i];
        for (int i = 0; i < m; i++)
            r[i] = array[middle + i + 1];
        l[n] = r[m] = Integer.MAX_VALUE;
        
        for (int h = left, j = 0, i = 0; h <= right; h++) {
            if (l[i] <= r[j]) array[h] = l[i++];
            else array[h] = r[j++];
        }
    }
    
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int middle = pivot(array, left, right);
        quickSort(array, left, middle);
        quickSort(array, middle + 1, right);
    }
    private static int pivot(int[] array, int left, int right) {
        int first = (right + left) >> 1;
        int pivot = left;
        swap(array, first, left);
        for (int i = left + 1; i <= right; i++) {
            if (array[left] > array[i]) {
                swap(array, ++pivot, i);
            }
        }
        swap(array, left, pivot);
        return pivot;
    }
    
    private static void swap(int[] array, int x, int y) {
        int swap = array[x];
        array[x] = array[y];
        array[y] = swap;
    }
    /*
     * Call merge and quickSort with the same array.
     */
    public static void sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + " - MergeSort");
        quickSort(copy, 0, copy.length - 1);
        System.out.println(Arrays.toString(copy) + " - QuickSort");
    }
    public static void main(String[] args) {
        int n = 5;
        int[] array = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++)
            array[i] = r.nextInt(n * n);
        System.out.println(Arrays.toString(array));
        sort(array);
    }
}
