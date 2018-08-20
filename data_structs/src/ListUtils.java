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
}
