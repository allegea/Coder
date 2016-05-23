
public class Heap {

    private static int MAX_SIZE = 100000;
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
        int top = values[0];
        rebaseTop();
        return top;
    }
    
    private void rebaseTop() {
        int last = values[--size];
        int currentPosition = 0;
        values[currentPosition] = last;
        while ()
    }
    
    public boolean insert(int x) {
        if (size == MAX_SIZE) return false;
        
        return true;
    }
}
