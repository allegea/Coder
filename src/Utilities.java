import java.util.Arrays;

public class Utilities {

    /*
     * Rotate all of the elements inside an array.
     * This ensure that the complexity of the method is O(n).
     * The positions parameters can be positive or negative.
     */
    public static void rotateArray(int[] array, int positions) {
        if (array == null || positions == 0) return;
        int size = array.length;
        int rotations = positions % size;
        if (Math.abs(rotations) * 2 > size) {
            if (rotations > 0) rotations = rotations - size;
            else rotations = size + rotations;
        }
        int[] copy = Arrays.copyOf(array, size);
        for (int i = 0; i < size; i++) {
            int pos = (i + rotations + size) % size;
            array[i] = copy[pos];
        }
    }
    public static void main(String[] args) {
        int n = 100;
        int[] array = new int[n];
        for (int i = 0; i < n; array[i] = ++i);
        System.out.println(Arrays.toString(array));
        rotateArray(array, -99);
        System.out.println(Arrays.toString(array));
    }
}
