package data_structs.linked_lists;


import java.util.HashMap;

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

    public static ListNode mergeInPlace(ListNode<Integer> list1Head, ListNode<Integer> list2Head) {
        ListNode<Integer> mergedListHead = null;
        ListNode<Integer> mergedListCurrent = null;
        ListNode<Integer> mergedListPrevious = null;
        ListNode<Integer> list1Ptr = list1Head;
        ListNode<Integer> list2Ptr = list2Head;
        while (list1Ptr != null && list2Ptr != null) {
            if (list1Ptr.data <= list2Ptr.data) {
                mergedListCurrent = list1Ptr;
                list1Ptr = list1Ptr.next;
            } else if (list2Ptr.data < list1Ptr.data) {
                mergedListCurrent = list2Ptr;
                list2Ptr = list2Ptr.next;
            }

            if (mergedListPrevious == null) {
                //need to set the head
                mergedListHead = mergedListCurrent;
                mergedListPrevious = mergedListCurrent;
            } else {
                mergedListPrevious.next = mergedListCurrent;
                mergedListPrevious = mergedListCurrent;
            }
        }

        //if we have exited the loop one of three things has happened
        if (list1Ptr == null && list2Ptr != null) {
            //1. the 1st list is exhausted and some of the 2nd list remains
            //Set mergedListPrevious.next to the remainder of list2
            mergedListPrevious.next = list2Ptr;

        } else if (list2Ptr == null && list1Ptr != null) {
            //2. the 2nd list is exhausted and some of the 1st list remains
            //Set mergedListPrevious.next to the remainder of list1
            mergedListPrevious.next = list1Ptr;
        }

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

    public static ListNode oddEvenList(ListNode head) {
        int listCount = 1;
        ListNode oddHead = head;
        ListNode oddPtr = oddHead;
        ListNode evenHead = null;
        ListNode evenPtr = null;
        ListNode nodePtr = head;
        while (nodePtr != null) {
            if (listCount % 2 != 0) {
                //odd node
                if (listCount != 1) {
                    oddPtr.next = nodePtr;
                    oddPtr = nodePtr;
                }
            } else {
                //even node
                if (evenHead == null) {
                    evenHead = nodePtr;
                    evenPtr = evenHead;
                } else {
                    evenPtr.next = nodePtr;
                    evenPtr = nodePtr;
                }

            }
            nodePtr = nodePtr.next;
            listCount++;
        }
        //stitch even list to the end of the odd list
        oddPtr.next = evenHead;
        return head;
    }

    //problem 2.1 Remove Dups
    // Write code to remove duplicates from an unsorted Linked List
    // How would you solve this if a temporary buffer is not allowed
    public static void removeDups(ListNode<Integer> list) {
        HashMap<Integer,Integer> nodeMap = new HashMap<Integer,Integer>();
        ListNode<Integer> current = list;
        ListNode<Integer> previous = null;
        while (current != null) {
            //have we seen this node before
            if (nodeMap.get(current.data) == null) {
                //This is a new value, add it to the map
                nodeMap.put(current.data,1);
                previous = current;
            }
            else {
                //we've seen this value before, need to skip it.
                previous.next = current.next;
                //[prev| ] -> [curr| ] -> [next| ]
            }
            current = current.next;
        }
    }


    //problem 2.2 Kth to Last
    //Write code to find the Kth to last element of a singly linked list


    //problem 2.3 Delete Middle Node
    //Implement an algorithm to delete the middle node of a linked list, given access to only that node

    //problem 2.4 Partition
    //Write code to partition a linked list around a value x, such that all nodes less than x come before
    //all the nodes greater than or equal to x. If x is contained within the list, the values of x, only
    //need to be after the elements less than x. The partition element x can appear anywhere in the "right partition"
    //it does not need to appear between the left and right partitions


    //problem 2.5 Sum Lists
    //Write a method which returns the sum of two numbers represented by linked lists
    // 7->1->6 = 617 5->9->2 = 295
    // 617 + 295 = 912


    //problem 2.6 Palindrome
    //Implement a function to check if a Linked List is a palindrome



    //problem 2.7 Intersection
    //Given two singly linked lists, determine if the two lists intersect.  Return the intersecting node.  Intersection
    //is defined by reference, not value


    //problem 2.8 Loop Detection
    //Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop

}
