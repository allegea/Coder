import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * My own implementation of BinaryTree. This has two different methods to
 * insert values, one keep the property of creating a BinarySearchTree, the
 * other insert in a random fashion.
 */
public class BinaryTree {

    private final Random r = new Random();
    private Node root;
    
    public void addNodeToBST(Node r) {
        if (this.isEmpty()) {
            root = r;
        } else addNodeToBST(this.root, r);
    }
    
    private Node addNodeToBST(Node root, Node current) {
        if (root == null) return current;
        else if (root.key >= current.key) root.left = addNodeToBST(
                root.left, current);
        else root.right = addNodeToBST(root.right, current);
        return root;
    }
    
    public void inOrder() {
        inOrder(this.root, "");
    }
    public void inOrder(Node root, String path) {
        if (root != null) {
            inOrder(root.left, path + " ");
            System.out.println(path + root.key);
            inOrder(root.right, path + " ");
        }
    }
    
    public int findMin(Node root) {
        if (root != null) {
            return Math.min(root.key, Math.min(findMin(root.left), 
                    findMin(root.right)));
        } else return Integer.MAX_VALUE;
    }
    
    public int findMax(Node root) {
        if (root != null) {
            return Math.max(root.key, Math.max(findMax(root.left), 
                    findMax(root.right)));
        } else return Integer.MIN_VALUE;
    }
    
    public void addValueToBST(Integer r) {
        addNodeToBST(new Node(r));
    }
    
    public void addNode(Node r) {
        if (this.isEmpty()) {
            root = r;
        } else addNode(root, r);
    }
    
    public Node addNode(Node root, Node current) {
        if (root == null) return current;
        else if (this.getFlip()) root.left = addNode(root.left, current);
        else root.right = addNode(root.right, current);
        return root;
    }
    
    public void addValue(Integer r) {
        addNode(new Node(r));
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    boolean getFlip() {
        return Double.compare(r.nextDouble(), 0.5) <= 0;
    }
    private class Node {
        Integer key;
        Node left;
        Node right;
        Node(Integer key) {
            this.key = key;
            left = right = null;
        }
    }
    
    public int findMaxPath(Node r) {
        if (r != null) {
            return r.key + Math.max(findMaxPath(r.left), findMaxPath(r.right));
        } else return 0;
    }
    
    private int maxValue = 0;
    private String path;
    public void findMaxPathAndShow() {
        maxValue = Integer.MIN_VALUE;
        path = null;
        findMaxPath(this.root, "", 0);
        System.out.println("findMaxPathAndShow - " + path + " - " + maxValue);
    }
    public void findMaxPath(Node r, String path, int value) {
        if (r == null) {
            if (value > maxValue) {
                maxValue = value;
                this.path = path;
            }
        } else {
            String toPath = path + " - " + r.key;
            findMaxPath(r.left, toPath, value + r.key);
            findMaxPath(r.right, toPath, value + r.key);
        }
    }
    
    private List<String> paths;
    public void findAllMaxPathsAndShow() {
        maxValue = Integer.MIN_VALUE;
        findAllMaxPaths(this.root, "", 0);
        System.out.println("findAllMaxPathsAndShow - " + maxValue);
        for (String current : paths) System.out.println(current);
    }
    public void findAllMaxPaths(Node r, String path, int value) {
        if (r == null) return;
        String toPath = path + " - " + r.key;
        value+=r.key;
        if (r.left == null && r.right == null) {
            if (value > maxValue) {
                maxValue = value;
                paths = new LinkedList<>();
                paths.add(toPath);
            } else if (value == maxValue) 
                paths.add(toPath);
        } else {
            findAllMaxPaths(r.left, toPath, value);
            findAllMaxPaths(r.right, toPath, value);
        }
    }
    
    public int findHeight() {
        return findHeight(this.root);
    }
    private int findHeight(Node r) {
        if (r == null) return 0;
        else return Math.max(findHeight(r.left), findHeight(r.right)) + 1;
    }
    public boolean isBST() {
        return isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    /*
     * Check if the Binary Tree is a Binary Search Tree.
     * For this check, no repeated numbers are allowed.
     */
    private boolean isBST(Node r, int min, int max) {
        if (r == null) return true;
        if (min < r.key && r.key < max) {
            return isBST(r.left, min, r.key) && 
                    isBST(r.right, r.key, max);
        } else 
            return false;
    }
    private static void binarySearchTreeDebug() {
        System.out.println("*** binarySearchTreeDebug ***");
        //int[] array = {5, 3, 1, 9, 2, 8, 10, 7, 6};
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree bst = new BinaryTree();
        for (int x : array) bst.addValueToBST(x);
        bst.inOrder();
        System.out.println("Min - " + bst.findMin(bst.root));
        System.out.println("Max - " + bst.findMax(bst.root));
        bst.findMaxPathAndShow();
        bst.findAllMaxPathsAndShow();
        System.out.println("findMaxPath - " + bst.findMaxPath(bst.root));
        System.out.println("isBST - " + bst.isBST());
        System.out.println("findHeight - " + bst.findHeight());
    }
    
    private static void binaryTreeDebug() {
        System.out.println("*** binaryTreeDebug ***");
        int[] array = {5, 3, 1, 2, 8, 10, 9, 7, 6};
        BinaryTree bt = new BinaryTree();
        for (int x : array) bt.addValue(x);
        bt.inOrder();
        System.out.println("Min - " + bt.findMin(bt.root));
        System.out.println("Max - " + bt.findMax(bt.root));
        bt.findMaxPathAndShow();
        bt.findAllMaxPathsAndShow();
        System.out.println("findMaxPath - " + bt.findMaxPath(bt.root));
        System.out.println("isBST - " + bt.isBST());
        System.out.println("findHeight - " + bt.findHeight());
    }
    
    public static void main(String[] args) {
        binarySearchTreeDebug();
        binaryTreeDebug();
    }
}
