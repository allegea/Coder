import java.util.Arrays;
import java.util.Random;

public class Heap {

    private static int MAX_SIZE = 100000;
    private static int INF = Integer.MAX_VALUE;
    private int[] values;
    private int size;
    Heap() {
        values = new int[MAX_SIZE];
        size = 0;
    }
    
    public int getValue() {
        return values[0];
    }
    
    public int poll() {
        if (size == 0) return -1;
        int topIndex = 0;
        int top = values[topIndex];
        int last = values[--size];
        values[topIndex] = last;
        rebaseTop(topIndex);
        return top;
    }
    
    private void rebaseTop(int index) {
        while (index < size) {
            int current = values[index];
            int left = 2 * index + 1;
            int right = 2 * (index + 1);
            int vLeft = getValue(left);
            int vRight = getValue(right);
            if (vLeft < current && vLeft <= vRight) {
                swap (index, left);
                index = left;
            } else if (vRight < current ) {
                swap (index, right);
                index = right;
            } else break;
        }
    }
    
    private void swap(int i, int j) {
        int swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }
    
    private int getValue(int index) {
        return index >= size ? INF : values[index];
    }
    
    public boolean push(int x) {
        if (size == MAX_SIZE) return false;
        values[size] = x;
        pullUp(size++);
        return true;
    }
    
    public void pullUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (values[index] < values[parent]) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }
    
    @Override
    public String toString() {
        return size + " - " + Arrays.toString(Arrays.copyOf(values, size));
    }
    
    public static void main(String[] args) {
        Heap heap = new Heap();
        int n = 10;
        Random r = new Random();
        for (int i = 0; i < n; i++) 
            heap.push(r.nextInt());
        
        for(int i = 0; i < n; i++) {
            System.out.println(heap);
            System.out.println(heap.poll());
        }
        System.out.println(heap);
    }
}
