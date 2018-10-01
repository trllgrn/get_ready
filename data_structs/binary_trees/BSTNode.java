package get_ready.data_structs.binary_trees;

public class BSTNode<T> {
    T data;
    BSTNode<T> left;
    BSTNode<T> right;
    public BSTNode(T initialValue) {
        data = initialValue;
        left = null;
        right = null;
    }

    public String toString() {
        return "[" + data.toString() + "]";
    }
}
