import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    /*
     * Find the square root of the X value with and error of approximation
     */
    private static double getSqrt(double x) {
        double error = 0.000001;
        double l = 0;
        double r = x;
        while (Double.compare(l, r) <= 0) {
            double m = (r + l) / 2;
            double poss = m * m;
            if (Double.compare(Math.abs(poss - x), error) <= 0) return m;
            if (Double.compare(poss, x) <= 0) l = m;
            else r = m;
        }
        return l;
    }
    
    /*
     * Find the Square root of the integer or the floor value that is most
     * approximate it
     */
    private static int getSqrt(int x) {
        int l = 0;
        int r = x;
        int last = l;
        while (l < r) {
            int m = (l + r) >> 1;
            if (m * m <= x) {
                last = m;
                l = m + 1;
            } else r = m;
        }
        return last;
    }
    
    /*
     * Find the first position of a value inside the array
     */
    private static int findFirstPosition(int[] array, int x) {
        int l = 0;
        int r = array.length - 1;
        int pos = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (array[m] >= x) {
                pos = m;
                r = m - 1;
            } else l = m + 1;
        }
        return pos;
    }
    
    /*
     * Find the last position of a value inside the array
     */
    private static int findLastPosition(int[] array, int x) {
        int l = 0;
        int r = array.length - 1;
        int pos = 0;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (array[m] <= x) {
                pos = m;
                l = m + 1;
            } else r = m - 1;
        }
        return pos;
    }
    
    /*
     * Find the first position of a value inside of a rotated array
     */
    private static int findPositionInRotatedArray(int[] array, int x) {
        int l = 0;
        int r = array.length - 1;
        while(l <= r) {
            int m = (l + r) >> 1;
            if (array[m] == x) return m;
            else if(array[l] >= array[m]) {
                r = m;
            } else if (array[r] <= array[m]) {
                l = m + 1;
            }
        }
        return -(l + 1);
    }
    /*
     * Find the position of the minor element in the array, this means
     * the index in which the array is been rotated
     */
    private static int findRotatedIndex(int[] array) {
        int l = 0;
        int r = array.length - 1;
        int pos = -1;
        while (l <= r) {
            int m = pos = (l + r) >> 1;
            if (array[l] > array[m]) {
                r = m;
            } else if (array[r] < array[m]) {
                l = m + 1;
            } else return l;
        }
        return pos;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int range = 50;
        double x = 10 + r.nextDouble() * range;
        int y = r.nextInt(range);
        System.out.println(x + " - " + getSqrt(x));
        System.out.println(y + " - " + getSqrt(y));
        int n = 10;
        int[] array = new int[n];
        int start = r.nextInt(range);
        int copies = 0;
        int pos = r.nextInt(n);
        for (int i = 0; i < n; i++) {
            if (i >= pos && i < pos + copies) array[i] = start;
            else array[i] = start++;
        }
        int toFind = array[pos];
        //for (int i = 0; i < n; array[i++] = r.nextInt(range));
        System.out.println(toFind + " - " + Arrays.toString(array));
        System.out.println("findFirstPosition - " + findFirstPosition(array, toFind));
        System.out.println("findLastPosition - " + findLastPosition(array, toFind));
        Utilities.rotateArray(array, 2 - n);
        System.out.println("******************************");
        System.out.println("findRotatedIndex - " + findRotatedIndex(array));
        System.out.println(toFind + " - " + Arrays.toString(array));
        System.out.println("findPositionInRotatedArray - " + findPositionInRotatedArray(array, toFind));
    }
}
