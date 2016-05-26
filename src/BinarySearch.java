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
     * Find the position of a value inside the array
     */
    private static int findPosition(int[] array, int x) {
        int l = 0;
        int r = array.length - 1;
        int pos = -1;
        while (l < r) {
            int m = (l + r) >> 1;
            if (array[m] <= x) {
                pos = m;
                l = m + 1;
            } else r = m;
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
        int n = 5;
        int[] array = new int[n];
        for (int i = 0; i < n; array[i++] = r.nextInt(range));
        Arrays.sort(array);
        System.out.println(y + " - " + Arrays.toString(array));
        System.out.println(findPosition(array, y));
    }
}
