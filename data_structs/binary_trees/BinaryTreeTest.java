package get_ready.data_structs.binary_trees;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BinaryTreeTest {

    @Test
    public void insertRecursiveTest() {
        BinaryTree myBSTie = new BinaryTree();
        myBSTie.insertRecursive(7);
        myBSTie.insertRecursive(5);
        myBSTie.insertRecursive(12);
        myBSTie.insertRecursive(14);
        BSTNode<Integer> theRoot = myBSTie.getRoot();
        assertThat(theRoot.data, is(7));
        assertThat(theRoot.left.data, is(5));
        assertThat(theRoot.right.data, is(12));
    }

    @Test
    public void toStringTest() {
    }
}