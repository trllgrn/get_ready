package get_ready.data_structs.linked_lists;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ListUtilsTest {

    @Test
    public void ListUtilsSizeTest() {
        ListNode<Integer> a = new ListNode<Integer>(1);
        ListNode<Integer> b = new ListNode<Integer>(3);
        ListNode<Integer> c = new ListNode<Integer>(5);
        a.next = b;
        b.next = c;
        assertThat(ListUtils.size(a), is(3));
    }

    @Test
    public void ListUtilsToStringTest() {
        ListNode<Integer> a = new ListNode<Integer>(1);
        ListNode<Integer> b = new ListNode<Integer>(3);
        ListNode<Integer> c = new ListNode<Integer>(5);
        a.next = b;
        b.next = c;
        String listRep = "[1|*]->[3|*]->[5|~]";
        assertThat(ListUtils.toString(a),is(listRep));
    }

    @Test
    public void ListUtilsMergeTest() {
        ListNode<Integer> a = new ListNode<Integer>(1);
        ListNode<Integer> b = new ListNode<Integer>(3);
        ListNode<Integer> c = new ListNode<Integer>(5);
        a.next = b;
        b.next = c;
        ListNode<Integer> e = new ListNode<Integer>(2);
        ListNode<Integer> f = new ListNode<Integer>(4);
        ListNode<Integer> g = new ListNode<Integer>(6);
        e.next = f;
        f.next = g;
        assertThat(ListUtils.size(a), is(3));
        //mergeNow the lists
        ListNode<Integer> mergedList = ListUtils.mergeNew(a,e);
        //check the new size
        assertThat(ListUtils.size(mergedList), is(6));
        assertThat(ListUtils.elementAt(mergedList,0), is(1));
        assertThat(ListUtils.elementAt(mergedList,5), is(6));
    }

    @Test
    public void ListUtilsElementAtTest() {
        ListNode<Integer> a = new ListNode<Integer>(1);
        ListNode<Integer> b = new ListNode<Integer>(3);
        ListNode<Integer> c = new ListNode<Integer>(5);
        a.next = b;
        b.next = c;
        assertThat(ListUtils.elementAt(a,1), is(3));
        assertThat(ListUtils.elementAt(a,0), is(1));
        assertThat(ListUtils.elementAt(a,2), is(5));
    }
}