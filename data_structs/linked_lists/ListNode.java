package get_ready.data_structs.linked_lists;

public class ListNode<T> {
    //generic ListNode class
    T data;
    ListNode next;

    public ListNode(T d) {
        this.data = d;
        this.next = null;
    }
}
