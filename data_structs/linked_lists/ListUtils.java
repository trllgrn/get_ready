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

    public static ListNode mergeNew(ListNode<Integer> list1Head, ListNode<Integer> list2Head) {
        ListNode<Integer> mergedListHead = null;
        ListNode<Integer> mergedListPtr = null;
        ListNode<Integer> list1Ptr = list1Head;
        ListNode<Integer> list2Ptr = list2Head;

        while (list1Ptr != null && list2Ptr != null) {
            ListNode<Integer> toAdd = null;
            //compare the pointers and select the smaller node
            if (list1Ptr.data <= list2Ptr.data) {
                toAdd = new ListNode<Integer>(list1Ptr.data);
                list1Ptr = list1Ptr.next;
            } else if (list2Ptr.data < list1Ptr.data) {
                toAdd = new ListNode<Integer>(list2Ptr.data);
                list2Ptr = list2Ptr.next;
            }

            //add the new node to the merged list
            if (mergedListHead == null) {
                mergedListHead = toAdd;
                mergedListPtr = mergedListHead;
            } else {
                //append the new node to the list
                mergedListPtr.next = toAdd;
                mergedListPtr = toAdd;
            }
        }

        //if we have exited the loop one of three things has happened
        if (list1Ptr == null && list2Ptr != null) {
            //1. the 1st list is exhausted and some of the 2nd list remains
            //Set mergedListPtr to the remainder of list2
            mergedListPtr.next = list2Ptr;
        } else if (list2Ptr == null && list1Ptr != null) {
            //2. the 2nd list is exhausted and some of the 1st list remains
            mergedListPtr.next = list1Ptr;
        }

        //3. both lists are exhausted. No actions needed


        return mergedListHead;
    }

    public static int elementAt(ListNode<Integer> listHead, int index) {
        int count = 0;
        ListNode<Integer> nodePtr = listHead;

        if (index != 0) {
            while (count < index && nodePtr != null) {
                nodePtr = nodePtr.next;
                count++;
            }
        }

        return nodePtr.data;
    }
}
