package get_ready.data_structs.linked_lists;


import java.util.LinkedList;

public class ListUtils {
    public static int size(ListNode<Integer> list) {
        int count = 0;
        ListNode<Integer> nodePtr = list;
        while (nodePtr != null) {
            count++;
            nodePtr = nodePtr.next;
        }
        return count;
    }

    public static String toString(ListNode<Integer> head) {
        //print out every node in the list
        //Approach: set a temp pointer node to the head,
        // while the head pointer node is not null
        // print out that node
        StringBuilder builder = new StringBuilder();
        ListNode<Integer> nodePtr = head;
        while (nodePtr != null) {
            builder.append("[" + nodePtr.data + "|");
            if (nodePtr.next != null) {
                builder.append("*]->");
            } else {
                builder.append("~]");
            }
            nodePtr = nodePtr.next;
        }

        return builder.toString();
    }

    public static ListNode merge(ListNode<Integer> list1Head, ListNode<Integer> list2Head) {
        ListNode<Integer> mergedListHead = null;

        return mergedListHead;
    }
}
