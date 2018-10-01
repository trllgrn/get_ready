package get_ready.data_structs.binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
    private BSTNode<Integer> root;

    public BinaryTree () {
        root = null;
    }

    public void insertRecursive(Integer value) {
        //inserts the value in the appropriate place and returns the node of the tree
        if (root == null) {
            root = new BSTNode<Integer>(value);
        } else {
            insertNode(root, value);
        }
    }

    public BSTNode<Integer> getRoot() {
        return root;
    }

    private void insertNode(BSTNode<Integer> node, Integer val) {
        //check to see if the node is null, if so add the new node here and return
        if (val < node.data) {
            //insertion on the left
            if (node.left == null) {
                node.left = new BSTNode<Integer>(val);
            } else {
                insertNode(node.left,val);
            }
        } else {
            //insertion on the right
            if (node.right == null) {
                node.right = new BSTNode<Integer>(val);
            } else {
                insertNode(node.right,val);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ArrayList<ArrayList<BSTNode>> nodeLists = new ArrayList<ArrayList<BSTNode>>();
        //
        LinkedList<BSTNode<Integer>> printQueue = new LinkedList<BSTNode<Integer>>();
        //add the root node as the first level
        printQueue.addFirst(root);
        while (!printQueue.isEmpty()) {
            //get the number of nodes in the currently in the queue.
            //these are all the nodes at this level.
            int levelNodes = printQueue.size();
            ArrayList<BSTNode> nodesAtCurrentLevel = new ArrayList<BSTNode>();
            //check to see how the nodes are added
            nodesAtCurrentLevel.addAll(printQueue);
            while (levelNodes > 0) {
                BSTNode<Integer> currentNode = printQueue.removeLast();
                if (currentNode.left != null) {
                    printQueue.addFirst(currentNode.left);
                }
                if (currentNode.right != null) {
                    printQueue.addFirst(currentNode.right);
                }
                levelNodes--;
            }
            nodeLists.add(nodesAtCurrentLevel);
        }

        for (ArrayList<BSTNode> levelList : nodeLists){
            builder.append(levelList.toString());
            builder.append("\n");
        }

        return builder.toString();
    }
}
